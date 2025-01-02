package com.tbs.dons.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbs.dons.dao.repositories.DonatorRepository;
import com.tbs.dons.dto.DonatorDto;
import com.tbs.dons.mappers.DonatorMapper;

@Service
public class DonatorManager implements DonatorService {
    @Autowired
    private DonatorRepository donatorRepository;
    @Autowired
    private DonatorMapper donatorMapper;

    @Override
    public List<DonatorDto> getAllDonators() {
        return donatorRepository.findAll()
                .stream()
                .map(donatorMapper::fromDonatorToDonatorDto)
                .collect(Collectors.toList());
    }
}