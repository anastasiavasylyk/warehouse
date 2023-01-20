package org.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.example.mapper.DtoRequestMapper;
import org.example.mapper.DtoResponseMapper;
import org.example.model.Nomenclature;
import org.example.model.dto.request.NomenclatureCreateRequestDto;
import org.example.model.dto.request.NomenclatureUpdateRequestDto;
import org.example.model.dto.response.NomenclatureResponseDto;
import org.example.service.NomenclatureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warehouse/nomenclature")
public class NomenclatureController {
    private final NomenclatureService nomenclatureService;
    private final DtoRequestMapper<NomenclatureCreateRequestDto, Nomenclature>
            nomenclatureCreateRequestMapper;
    private final DtoRequestMapper<NomenclatureUpdateRequestDto, Nomenclature>
            nomenclatureUpdateRequestMapper;
    private final DtoResponseMapper<NomenclatureResponseDto, Nomenclature>
            nomenclatureResponseMapper;

    public NomenclatureController(NomenclatureService nomenclatureService,
                                  DtoRequestMapper<NomenclatureCreateRequestDto, Nomenclature>
                                          nomenclatureCreateRequestMapper,
                                  DtoRequestMapper<NomenclatureUpdateRequestDto, Nomenclature>
                                          nomenclatureUpdateRequestMapper,
                                  DtoResponseMapper<NomenclatureResponseDto, Nomenclature>
                                          nomenclatureResponseMapper) {
        this.nomenclatureService = nomenclatureService;
        this.nomenclatureCreateRequestMapper = nomenclatureCreateRequestMapper;
        this.nomenclatureUpdateRequestMapper = nomenclatureUpdateRequestMapper;
        this.nomenclatureResponseMapper = nomenclatureResponseMapper;
    }

    @GetMapping
    public List<NomenclatureResponseDto> getAllNomenclatures() {
        return nomenclatureService.getAll().stream()
                .map(nomenclatureResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public NomenclatureResponseDto createNewNomenclature(
            @RequestBody NomenclatureCreateRequestDto requestDto) {
        Nomenclature nomenclature = nomenclatureService.add(
                nomenclatureCreateRequestMapper.fromDto(requestDto));
        return nomenclatureResponseMapper.toDto(nomenclature);
    }

    @PutMapping
    public NomenclatureResponseDto updateNomenclature(
            @RequestBody NomenclatureUpdateRequestDto requestDto) {
        Nomenclature nomenclature = nomenclatureService.update(
                nomenclatureUpdateRequestMapper.fromDto(requestDto));
        return nomenclatureResponseMapper.toDto(nomenclature);
    }

    @GetMapping("/{id}")
    public NomenclatureResponseDto getNomenclatureById(@PathVariable Long id) {
        Nomenclature nomenclature = nomenclatureService.get(id);
        return nomenclatureResponseMapper.toDto(nomenclature);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeNomenclatureById(@PathVariable Long id) {
        nomenclatureService.remove(id);
    }
}
