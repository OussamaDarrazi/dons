package com.tbs.dons.dto;

import com.tbs.dons.types.DonationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {
    private Long id;
    private String title;
    private Double amount;
    private DonationType type;
    private DonatorDto donator;
    private ActCharDto actChar;
}
