package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Material;
import org.example.model.dto.request.MaterialUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MaterialUpdateRequestMapper implements
        DtoRequestMapper<MaterialUpdateRequestDto, Material> {
    @Override
    public Material fromDto(MaterialUpdateRequestDto dto) {
        Material material = new Material();
        material.setId(dto.getId());
        material.setName(dto.getName());
        material.setStatus(dto.getStatus());
        material.setAmount(dto.getAmount());
        material.setNomenclatureId(dto.getNomenclatureId());
        material.setUnitId(dto.getUnitId());
        return material;
    }
}
