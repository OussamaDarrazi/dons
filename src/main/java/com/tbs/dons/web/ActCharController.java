package com.tbs.dons.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tbs.dons.dto.ActCharDto;
import com.tbs.dons.dto.DonationDto;
import com.tbs.dons.dto.OrganisationDto;
import com.tbs.dons.service.ActCharService;
import com.tbs.dons.service.OrganisationService;

@Controller
@RequestMapping("/actions")
public class ActCharController {

    @Autowired
    private ActCharService actCharService;

    @Autowired
    private OrganisationService organisationService;

    @GetMapping("/add")
    public String displayAddActionForm(Model model) {
        model.addAttribute("actChar", new ActCharDto());
        List<OrganisationDto> organisations = organisationService.getAllOrganisations();
        model.addAttribute("organisations", organisations);
        return "action_form";
    }

    @PostMapping
    public String addAction(@ModelAttribute ActCharDto actCharDto) {
        actCharDto = actCharService.addActChar(actCharDto);
        return "redirect:/actions/" + actCharDto.getId() + "/donations";
    }

    @GetMapping("/{actionId}/donations")
    public String getDonationsByAction(@PathVariable Long actionId, Model model) {
        List<DonationDto> donations = actCharService.getDonationsByActCharId(actionId);
        ActCharDto actChar = actCharService.getActCharById(actionId);
        double totalDonations = donations.stream().mapToDouble(DonationDto::getAmount).sum();
        model.addAttribute("donations", donations);
        model.addAttribute("actChar", actChar);
        model.addAttribute("totalDonations", totalDonations);
        return "action_donations";
    }

    @GetMapping
    public String displayActions(Model model) {
        List<ActCharDto> actions = actCharService.getAllActChars();
        model.addAttribute("actions", actions);
        return "actions";
    }

    @GetMapping("/delete/{actionId}")
    public String deleteAction(@PathVariable Long actionId) {
        actCharService.deleteActCharById(actionId);
        return "redirect:/actions";
    }
}
