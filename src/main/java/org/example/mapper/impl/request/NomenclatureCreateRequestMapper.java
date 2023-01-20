package org.example.mapper.impl.request;

import org.example.mapper.DtoRequestMapper;
import org.example.model.Nomenclature;
import org.example.model.dto.request.NomenclatureCreateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class NomenclatureCreateRequestMapper implements
        DtoRequestMapper<NomenclatureCreateRequestDto, Nomenclature> {
    @Override
    public Nomenclature fromDto(NomenclatureCreateRequestDto dto) {
        Nomenclature nomenclature = new Nomenclature();
        nomenclature.setName(dto.getName());
        return nomenclature;
    }
}
