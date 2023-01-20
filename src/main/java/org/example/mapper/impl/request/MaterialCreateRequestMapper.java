package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Material;
import org.example.model.dto.request.MaterialCreateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MaterialCreateRequestMapper implements
        DtoRequestMapper<MaterialCreateRequestDto, Material> {
    private static final Boolean DEFAULT_STATUS = true;

    @Override
    public Material fromDto(MaterialCreateRequestDto dto) {
        Material material = new Material();
        material.setName(dto.getName());
        material.setStatus(DEFAULT_STATUS);
        material.setAmount(dto.getAmount());
        material.setNomenclatureId(dto.getNomenclatureId());
        material.setUnitId(dto.getUnitId());
        return material;
    }
}
