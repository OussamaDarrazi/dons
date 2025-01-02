package com.tbs.dons.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tbs.dons.dao.entities.Donation;
import com.tbs.dons.dto.DonationDto;

@Component
public class DonationMapper {
    ModelMapper mapper = new ModelMapper();

    public Donation fromDonationDtoToDonation(DonationDto donationDto) {
        return mapper.map(donationDto, Donation.class);
    }

    public DonationDto fromDonationToDonationDto(Donation donation) {
        return mapper.map(donation, DonationDto.class);
    }

}
