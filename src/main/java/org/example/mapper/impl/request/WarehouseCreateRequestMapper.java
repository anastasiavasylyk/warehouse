package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Warehouse;
import org.example.model.dto.request.WarehouseCreateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class WarehouseCreateRequestMapper implements
        DtoRequestMapper<WarehouseCreateRequestDto, Warehouse> {
    @Override
    public Warehouse fromDto(WarehouseCreateRequestDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(dto.getName());
        return warehouse;
    }
}
