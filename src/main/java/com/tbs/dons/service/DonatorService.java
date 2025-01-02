package com.tbs.dons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tbs.dons.dto.DonatorDto;

@Service
public interface DonatorService {
    public List<DonatorDto> getAllDonators();
}
