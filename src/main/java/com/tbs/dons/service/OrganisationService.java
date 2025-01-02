package com.tbs.dons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tbs.dons.dto.OrganisationDto;

@Service
public interface OrganisationService {
    public List<OrganisationDto> getAllOrganisations();

}
