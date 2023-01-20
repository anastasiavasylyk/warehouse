package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Warehouse;
import org.example.model.dto.request.WarehouseUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class WarehouseUpdateRequestMapper implements
        DtoRequestMapper<WarehouseUpdateRequestDto, Warehouse> {
    @Override
    public Warehouse fromDto(WarehouseUpdateRequestDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(dto.getId());
        warehouse.setName(dto.getName());
        return warehouse;
    }
}
