package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.Material;

public interface MaterialDao {
    Material add(Material material);

    Optional<Material> get(Long id);

    List<Material> getAll();

    Material update(Material material);

    void remove(Long id);

    List<Material> findAllByUnit(Long warehouseId, Long unitId);

    List<Material> findAllByNomenclature(Long warehouseId, Long nomenclatureId);
}
