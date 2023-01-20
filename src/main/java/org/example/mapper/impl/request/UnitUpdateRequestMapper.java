package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Unit;
import org.example.model.dto.request.UnitUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UnitUpdateRequestMapper implements DtoRequestMapper<UnitUpdateRequestDto, Unit> {
    @Override
    public Unit fromDto(UnitUpdateRequestDto dto) {
        Unit unit = new Unit();
        unit.setId(dto.getId());
        unit.setName(dto.getName());
        return unit;
    }
}
