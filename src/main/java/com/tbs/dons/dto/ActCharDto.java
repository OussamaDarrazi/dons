package com.tbs.dons.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.tbs.dons.types.ActCharStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActCharDto {
    private Long id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private Double target;
    private ActCharStatus status;
    private OrganisationDto organisation;
    private List<DonationDto> donations;
}
