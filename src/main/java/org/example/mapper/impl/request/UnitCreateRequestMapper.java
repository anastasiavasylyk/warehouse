package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Unit;
import org.example.model.dto.request.UnitCreateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UnitCreateRequestMapper implements DtoRequestMapper<UnitCreateRequestDto, Unit> {
    @Override
    public Unit fromDto(UnitCreateRequestDto dto) {
        Unit unit = new Unit();
        unit.setName(dto.getName());
        return unit;
    }
}
