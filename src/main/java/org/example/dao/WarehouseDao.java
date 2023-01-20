package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.Material;
import org.example.model.Warehouse;

public interface WarehouseDao {
    Warehouse add(Warehouse warehouse);

    Optional<Warehouse> get(Long id);

    List<Warehouse> getAll();

    Warehouse update(Warehouse warehouse);

    void remove(Long id);

    Material getMaterialById(Long warehouseId, Long materialId);

    List<Material> getAllMaterials(Long warehouseId);
}
