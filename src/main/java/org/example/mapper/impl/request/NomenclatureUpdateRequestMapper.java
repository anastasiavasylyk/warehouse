package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Nomenclature;
import org.example.model.dto.request.NomenclatureUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class NomenclatureUpdateRequestMapper implements
        DtoRequestMapper<NomenclatureUpdateRequestDto, Nomenclature> {
    @Override
    public Nomenclature fromDto(NomenclatureUpdateRequestDto dto) {
        Nomenclature nomenclature = new Nomenclature();
        nomenclature.setId(dto.getId());
        nomenclature.setName(dto.getName());
        return nomenclature;
    }
}
