package com.tbs.dons.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.dons.dao.repositories.DonationRepository;
import com.tbs.dons.dto.DonationDto;
import com.tbs.dons.mappers.DonationMapper;

@Service
public class DonationManager implements DonationService {
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private DonationMapper donationMapper;

    @Override
    public DonationDto addDonation(DonationDto donationDto) {
        return donationMapper.fromDonationToDonationDto(
                donationRepository.save(donationMapper.fromDonationDtoToDonation(donationDto)));
    }

    @Override
    public List<DonationDto> getAllDonations() {
        return donationRepository.findAll()
                .stream()
                .map(donationMapper::fromDonationToDonationDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDonationById(Long donationId) {
        donationRepository.deleteById(donationId);
    }
}