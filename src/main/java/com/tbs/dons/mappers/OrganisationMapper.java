package com.tbs.dons.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tbs.dons.dao.entities.Organisation;
import com.tbs.dons.dto.OrganisationDto;

@Component
public class OrganisationMapper {
    ModelMapper mapper = new ModelMapper();

    public Organisation fromOrganisationDtoToOrganisation(OrganisationDto organisationDto) {
        return mapper.map(organisationDto, Organisation.class);
    }

    public OrganisationDto fromOrganisationToOrganisationDto(Organisation organisation) {
        return mapper.map(organisation, OrganisationDto.class);
    }

}
