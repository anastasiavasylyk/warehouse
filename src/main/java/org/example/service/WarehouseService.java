package org.example.service;

import java.util.List;
import org.example.model.Material;
import org.example.model.Warehouse;

public interface WarehouseService {
    Warehouse add(Warehouse entity);

    Warehouse get(Long id);

    List<Warehouse> getAll();

    Warehouse update(Warehouse entity);

    void remove(Long id);

    Material addNewMaterial(Warehouse warehouse, Material material);

    Material getMaterialById(Long warehouseId, Long materialId);

    List<Material> getAllMaterials(Long warehouseId);

    Material updateMaterial(Warehouse warehouse, Material material);

    void removeMaterialById(Warehouse warehouse, Long materialId);
}
