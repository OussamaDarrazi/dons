package com.tbs.dons.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.dons.dao.repositories.OrganisationRepository;
import com.tbs.dons.dto.OrganisationDto;
import com.tbs.dons.mappers.OrganisationMapper;

@Service
public class OrganisationManager implements OrganisationService {
    @Autowired
    private OrganisationMapper organisationMapper;
    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public List<OrganisationDto> getAllOrganisations() {
        return organisationRepository.findAll()
                .stream()
                .map(organisationMapper::fromOrganisationToOrganisationDto)
                .collect(Collectors.toList());
    }

}
