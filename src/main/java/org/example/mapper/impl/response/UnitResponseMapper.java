package org.example.mapper.impl.response;

import org.example.mapper.DtoResponseMapper;
import org.example.model.Unit;
import org.example.model.dto.response.UnitResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UnitResponseMapper implements DtoResponseMapper<UnitResponseDto, Unit> {
    @Override
    public UnitResponseDto toDto(Unit unit) {
        UnitResponseDto dto = new UnitResponseDto();
        dto.setId(unit.getId());
        dto.setName(unit.getName());
        return dto;
    }
}
