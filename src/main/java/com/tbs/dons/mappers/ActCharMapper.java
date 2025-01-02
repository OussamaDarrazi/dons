package com.tbs.dons.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tbs.dons.dao.entities.ActChar;
import com.tbs.dons.dto.ActCharDto;

@Component
public class ActCharMapper {
    ModelMapper mapper = new ModelMapper();

    public ActChar fromActCharDtoToActChar(ActCharDto actCharDto) {
        return mapper.map(actCharDto, ActChar.class);
    }

    public ActCharDto fromActCharToActCharDto(ActChar actChar) {
        return mapper.map(actChar, ActCharDto.class);
    }

}
