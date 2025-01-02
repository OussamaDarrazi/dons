package com.tbs.dons.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDto {
    private Long id;
    private String name;
    private String email;
    private List<ActCharDto> actsOfCharity;
}
