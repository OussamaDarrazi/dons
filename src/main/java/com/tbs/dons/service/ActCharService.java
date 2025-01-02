package com.tbs.dons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tbs.dons.dto.ActCharDto;
import com.tbs.dons.dto.DonationDto;

@Service
public interface ActCharService {
    public ActCharDto addActChar(ActCharDto actCharDto);

    public List<DonationDto> getDonationsByActCharId(Long actionId);

    public List<ActCharDto> getAllActChars();

    public ActCharDto getActCharById(Long actionId);

    public Boolean deleteActCharById(Long actionId);

}
