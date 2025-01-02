package com.tbs.dons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tbs.dons.dto.DonationDto;

@Service
public interface DonationService {
    public DonationDto addDonation(DonationDto donationDto);

    public List<DonationDto> getAllDonations();

    public void deleteDonationById(Long donationId);
}