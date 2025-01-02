package com.tbs.dons.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tbs.dons.dao.entities.Donator;
import com.tbs.dons.dto.DonatorDto;

@Component
public class DonatorMapper {
    ModelMapper mapper = new ModelMapper();

    public Donator fromDonatorDtoToDonator(DonatorDto donatorDto) {
        return mapper.map(donatorDto, Donator.class);
    }

    public DonatorDto fromDonatorToDonatorDto(Donator donator) {
        return mapper.map(donator, DonatorDto.class);
    }

}
