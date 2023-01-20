package org.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.example.mapper.DtoRequestMapper;
import org.example.mapper.DtoResponseMapper;
import org.example.model.Warehouse;
import org.example.model.dto.request.WarehouseCreateRequestDto;
import org.example.model.dto.request.WarehouseUpdateRequestDto;
import org.example.model.dto.response.WarehouseResponseDto;
import org.example.service.WarehouseService;
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
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;
    private final DtoRequestMapper<WarehouseCreateRequestDto, Warehouse>
            warehouseCreateRequestMapper;
    private final DtoRequestMapper<WarehouseUpdateRequestDto, Warehouse>
            warehouseUpdateRequestMapper;
    private final DtoResponseMapper<WarehouseResponseDto, Warehouse> warehouseResponseMapper;

    public WarehouseController(WarehouseService warehouseService,
                               DtoRequestMapper<WarehouseCreateRequestDto, Warehouse>
                                       warehouseCreateRequestMapper,
                               DtoRequestMapper<WarehouseUpdateRequestDto, Warehouse>
                                       warehouseUpdateRequestMapper,
                               DtoResponseMapper<WarehouseResponseDto, Warehouse>
                                       warehouseResponseMapper) {
        this.warehouseService = warehouseService;
        this.warehouseCreateRequestMapper = warehouseCreateRequestMapper;
        this.warehouseUpdateRequestMapper = warehouseUpdateRequestMapper;
        this.warehouseResponseMapper = warehouseResponseMapper;
    }

    @GetMapping
    public List<WarehouseResponseDto> getAllWarehouses() {
        return warehouseService.getAll().stream()
                .map(warehouseResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public WarehouseResponseDto createNewWarehouse(
            @RequestBody WarehouseCreateRequestDto requestDto) {
        Warehouse warehouse = warehouseService.add(
                warehouseCreateRequestMapper.fromDto(requestDto));
        return warehouseResponseMapper.toDto(warehouse);
    }

    @PutMapping
    public WarehouseResponseDto updateWarehouse(@RequestBody WarehouseUpdateRequestDto requestDto) {
        Warehouse warehouse = warehouseService.update(
                warehouseUpdateRequestMapper.fromDto(requestDto));
        return warehouseResponseMapper.toDto(warehouse);
    }

    @GetMapping("/{id}")
    public WarehouseResponseDto getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.get(id);
        return warehouseResponseMapper.toDto(warehouse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeWarehouseById(@PathVariable Long id) {
        warehouseService.remove(id);
    }
}
