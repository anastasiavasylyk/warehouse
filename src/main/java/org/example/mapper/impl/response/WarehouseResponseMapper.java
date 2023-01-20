package org.example.mapper.impl.response;

import org.example.mapper.DtoResponseMapper;
import org.example.model.Warehouse;
import org.example.model.dto.response.WarehouseResponseDto;
import org.springframework.stereotype.Component;

@Component
public class WarehouseResponseMapper implements DtoResponseMapper<WarehouseResponseDto, Warehouse> {
    @Override
    public WarehouseResponseDto toDto(Warehouse warehouse) {
        WarehouseResponseDto dto = new WarehouseResponseDto();
        dto.setId(warehouse.getId());
        dto.setName(warehouse.getName());
        return dto;
    }
}
