package org.example.service.impl;

import java.util.List;
import org.example.dao.WarehouseDao;
import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.service.MaterialService;
import org.example.service.WarehouseService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseDao warehouseDao;
    private final MaterialService materialService;

    public WarehouseServiceImpl(WarehouseDao warehouseDao, MaterialService materialService) {
        this.warehouseDao = warehouseDao;
        this.materialService = materialService;
    }

    @Override
    public Warehouse add(Warehouse warehouse) {
        return warehouseDao.add(warehouse);
    }

    @Override
    public Warehouse get(Long id) {
        return warehouseDao.get(id).get();
    }

    @Override
    public List<Warehouse> getAll() {
        return warehouseDao.getAll();
    }

    @Override
    public Warehouse update(Warehouse warehouse) {
        return warehouseDao.update(warehouse);
    }

    @Override
    public void remove(Long id) {
        warehouseDao.remove(id);
    }

    @Override
    public Material addNewMaterial(Warehouse warehouse, Material material) {
        Material createdMaterial = materialService.add(material);
        warehouse.getMaterials().add(createdMaterial);
        warehouseDao.update(warehouse);
        return createdMaterial;
    }

    @Override
    public Material getMaterialById(Long warehouseId, Long materialId) {
        return warehouseDao.getMaterialById(warehouseId, materialId);
    }

    @Override
    public List<Material> getAllMaterials(Long warehouseId) {
        return warehouseDao.getAllMaterials(warehouseId);
    }

    @Override
    public Material updateMaterial(Warehouse warehouse, Material material) {
        warehouse.getMaterials().remove(material);
        Material updatedMaterial = materialService.update(material);
        warehouse.getMaterials().add(updatedMaterial);
        warehouseDao.update(warehouse);
        return updatedMaterial;
    }

    @Override
    public void removeMaterialById(Warehouse warehouse, Long materialId) {
        Material material = materialService.get(materialId);
        warehouse.getMaterials().remove(material);
        materialService.remove(materialId);
        warehouseDao.update(warehouse);
    }
}
