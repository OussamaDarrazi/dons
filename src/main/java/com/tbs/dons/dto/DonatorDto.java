package com.tbs.dons.dto;

import java.util.List;

import com.tbs.dons.types.DonatorEvaluation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonatorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private DonatorEvaluation evaluation;
    private List<DonationDto> donations;
}
