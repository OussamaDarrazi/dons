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

import com.tbs.dons.dto.DonationDto;
import com.tbs.dons.dto.DonatorDto;
import com.tbs.dons.dto.ActCharDto;
import com.tbs.dons.service.DonationService;
import com.tbs.dons.service.DonatorService;
import com.tbs.dons.service.ActCharService;

@Controller
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonatorService donatorService;

    @Autowired
    private ActCharService actCharService;

    @GetMapping("/add")
    public String displayAddDonationForm(Model model) {
        model.addAttribute("donation", new DonationDto());
        List<DonatorDto> donators = donatorService.getAllDonators();
        model.addAttribute("donators", donators);
        List<ActCharDto> actsOfCharity = actCharService.getAllActChars();
        model.addAttribute("actsOfCharity", actsOfCharity);
        return "donation_form";
    }

    @PostMapping("/add")
    public String addDonation(@ModelAttribute DonationDto donationDto) {
        donationService.addDonation(donationDto);
        return "redirect:/donations";
    }

    @GetMapping
    public String displayDonations(Model model) {
        List<DonationDto> donations = donationService.getAllDonations();
        model.addAttribute("donations", donations);
        return "donations";
    }

    @GetMapping("/delete/{donationId}")
    public String deleteDonation(@PathVariable Long donationId) {
        donationService.deleteDonationById(donationId);
        return "redirect:/donations";
    }

}