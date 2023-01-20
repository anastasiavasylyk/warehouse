package org.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.example.mapper.DtoRequestMapper;
import org.example.mapper.DtoResponseMapper;
import org.example.model.Material;
import org.example.model.Nomenclature;
import org.example.model.Unit;
import org.example.model.Warehouse;
import org.example.model.dto.request.MaterialCreateRequestDto;
import org.example.model.dto.request.MaterialUpdateRequestDto;
import org.example.model.dto.response.MaterialResponseDto;
import org.example.service.MaterialService;
import org.example.service.NomenclatureService;
import org.example.service.UnitService;
import org.example.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warehouses")
public class MaterialController {
    private final WarehouseService warehouseService;
    private final MaterialService materialService;
    private final UnitService unitService;
    private final NomenclatureService nomenclatureService;
    private final DtoRequestMapper<MaterialCreateRequestDto, Material>
            materialCreateRequestMapper;
    private final DtoRequestMapper<MaterialUpdateRequestDto, Material>
            materialUpdateRequestMapper;
    private final DtoResponseMapper<MaterialResponseDto, Material>
            materialResponseMapper;

    public MaterialController(WarehouseService warehouseService,
                              MaterialService materialService,
                              UnitService unitService,
                              NomenclatureService nomenclatureService,
                              DtoRequestMapper<MaterialCreateRequestDto, Material>
                                      materialCreateRequestMapper,
                              DtoRequestMapper<MaterialUpdateRequestDto, Material>
                                      materialUpdateRequestMapper,
                              DtoResponseMapper<MaterialResponseDto, Material>
                                      materialResponseMapper) {
        this.warehouseService = warehouseService;
        this.materialService = materialService;
        this.unitService = unitService;
        this.nomenclatureService = nomenclatureService;
        this.materialCreateRequestMapper = materialCreateRequestMapper;
        this.materialUpdateRequestMapper = materialUpdateRequestMapper;
        this.materialResponseMapper = materialResponseMapper;
    }

    @GetMapping("/{id}/materials")
    public List<MaterialResponseDto> getAllMaterials(@PathVariable Long id) {
        return warehouseService.getAllMaterials(id).stream()
                .map(materialResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/material")
    public MaterialResponseDto addNewMaterial(@PathVariable Long id,
                                              @RequestBody MaterialCreateRequestDto requestDto) {
        Warehouse warehouse = warehouseService.get(id);
        Material material = warehouseService.addNewMaterial(warehouse,
                materialCreateRequestMapper.fromDto(requestDto));
        return materialResponseMapper.toDto(material);
    }

    @PutMapping("/{id}/material")
    public MaterialResponseDto updateMaterial(@PathVariable Long id,
                                              @RequestBody MaterialUpdateRequestDto requestDto) {
        Warehouse warehouse = warehouseService.get(id);
        Material material = warehouseService.updateMaterial(
                warehouse, materialUpdateRequestMapper.fromDto(requestDto));
        return materialResponseMapper.toDto(material);
    }

    @GetMapping("/{id}/material")
    public MaterialResponseDto getMaterialById(@PathVariable Long id,
                                               @RequestParam String materialId) {
        Material material = warehouseService.getMaterialById(id, Long.parseLong(materialId));
        return materialResponseMapper.toDto(material);
    }

    @DeleteMapping("/{id}/material")
    @ResponseStatus(HttpStatus.OK)
    public void removeMaterialById(@PathVariable Long id,
                                   @RequestParam String materialId) {
        Warehouse warehouse = warehouseService.get(id);
        warehouseService.removeMaterialById(warehouse, Long.parseLong(materialId));
    }

    @GetMapping("/{id}/material/find-by-unit")
    public List<MaterialResponseDto> findAllByUnit(@PathVariable Long id,
                                                     @RequestParam String name) {
        Unit unit = unitService.findByName(name);
        return materialService.findAllByUnit(id, unit.getId()).stream()
                .map(materialResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/material/find-by-nomenclature")
    public List<MaterialResponseDto> findAllByNomenclature(@PathVariable Long id,
                                                   @RequestParam String name) {
        Nomenclature nomenclature = nomenclatureService.findByName(name);
        return materialService.findAllByNomenclature(id, nomenclature.getId()).stream()
                .map(materialResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
