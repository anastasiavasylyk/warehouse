package org.example.mapper.impl.response;

import org.example.mapper.DtoResponseMapper;
import org.example.model.Material;
import org.example.model.dto.response.MaterialResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MaterialResponseMapper implements DtoResponseMapper<MaterialResponseDto, Material> {
    @Override
    public MaterialResponseDto toDto(Material material) {
        MaterialResponseDto dto = new MaterialResponseDto();
        dto.setId(material.getId());
        dto.setName(material.getName());
        dto.setStatus(material.getStatus());
        dto.setAmount(material.getAmount());
        dto.setNomenclatureId(material.getNomenclatureId());
        dto.setUnitId(material.getUnitId());
        return dto;
    }
}
