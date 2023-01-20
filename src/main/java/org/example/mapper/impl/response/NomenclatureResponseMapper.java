package org.example.mapper.impl.response;

import org.example.mapper.DtoResponseMapper;
import org.example.model.Nomenclature;
import org.example.model.dto.response.NomenclatureResponseDto;
import org.springframework.stereotype.Component;

@Component
public class NomenclatureResponseMapper implements
        DtoResponseMapper<NomenclatureResponseDto, Nomenclature> {
    @Override
    public NomenclatureResponseDto toDto(Nomenclature nomenclature) {
        NomenclatureResponseDto dto = new NomenclatureResponseDto();
        dto.setId(nomenclature.getId());
        dto.setName(nomenclature.getName());
        return dto;
    }
}
