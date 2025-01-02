package com.tbs.dons.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.dons.dao.repositories.ActCharRepository;
import com.tbs.dons.dao.repositories.DonationRepository;
import com.tbs.dons.dto.ActCharDto;
import com.tbs.dons.dto.DonationDto;
import com.tbs.dons.mappers.ActCharMapper;
import com.tbs.dons.mappers.DonationMapper;

@Service
public class ActCharManager implements ActCharService {
    @Autowired
    private ActCharRepository actCharRepository;
    @Autowired
    private ActCharMapper actCharMapper;
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    DonationMapper donationMapper;

    @Override
    public ActCharDto addActChar(ActCharDto actCharDto) {
        return actCharMapper.fromActCharToActCharDto(
                actCharRepository.save(actCharMapper.fromActCharDtoToActChar(actCharDto)));
    }

    @Override
    public List<DonationDto> getDonationsByActCharId(Long actionId) {
        return donationRepository.findByActCharId(actionId)
                .stream()
                .map(donationMapper::fromDonationToDonationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActCharDto> getAllActChars() {
        return actCharRepository.findAll()
                .stream()
                .map(actCharMapper::fromActCharToActCharDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActCharDto getActCharById(Long actionId) {
        return actCharMapper.fromActCharToActCharDto(
                actCharRepository.findById(actionId).orElseThrow(() -> new RuntimeException("Action not found")));
    }

    @Override
    public Boolean deleteActCharById(Long actionId) {
        if (!actCharRepository.existsById(actionId)) {
            return false;
        }
        actCharRepository.deleteById(actionId);
        return true;
    }
}
