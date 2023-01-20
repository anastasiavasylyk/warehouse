package org.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.example.mapper.DtoRequestMapper;
import org.example.mapper.DtoResponseMapper;
import org.example.model.Unit;
import org.example.model.dto.request.UnitCreateRequestDto;
import org.example.model.dto.request.UnitUpdateRequestDto;
import org.example.model.dto.response.UnitResponseDto;
import org.example.service.UnitService;
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
@RequestMapping("/api/v1/warehouses/unit")
public class UnitController {
    private final UnitService unitService;
    private final DtoRequestMapper<UnitCreateRequestDto, Unit> unitCreateRequestMapper;
    private final DtoRequestMapper<UnitUpdateRequestDto, Unit> unitUpdateRequestMapper;
    private final DtoResponseMapper<UnitResponseDto, Unit> unitResponseMapper;

    public UnitController(UnitService unitService,
                          DtoRequestMapper<UnitCreateRequestDto, Unit> unitCreateRequestMapper,
                          DtoRequestMapper<UnitUpdateRequestDto, Unit> unitUpdateRequestMapper,
                          DtoResponseMapper<UnitResponseDto, Unit> unitResponseMapper) {
        this.unitService = unitService;
        this.unitCreateRequestMapper = unitCreateRequestMapper;
        this.unitUpdateRequestMapper = unitUpdateRequestMapper;
        this.unitResponseMapper = unitResponseMapper;
    }

    @GetMapping
    public List<UnitResponseDto> getAllUnits() {
        return unitService.getAll().stream()
                .map(unitResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UnitResponseDto createNewUnit(@RequestBody UnitCreateRequestDto requestDto) {
        Unit unit = unitService.add(unitCreateRequestMapper.fromDto(requestDto));
        return unitResponseMapper.toDto(unit);
    }

    @PutMapping
    public UnitResponseDto updateUnit(@RequestBody UnitUpdateRequestDto requestDto) {
        Unit unit = unitService.update(unitUpdateRequestMapper.fromDto(requestDto));
        return unitResponseMapper.toDto(unit);
    }

    @GetMapping("/{id}")
    public UnitResponseDto getUnitById(@PathVariable Long id) {
        Unit unit = unitService.get(id);
        return unitResponseMapper.toDto(unit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUnitById(@PathVariable Long id) {
        unitService.remove(id);
    }
}
