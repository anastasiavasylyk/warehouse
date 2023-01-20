package org.example.service;

import java.util.List;
import org.example.model.Material;

public interface MaterialService {
    Material add(Material entity);

    Material get(Long id);

    List<Material> getAll();

    Material update(Material entity);

    void remove(Long id);

    List<Material> findAllByUnit(Long warehouseId, Long unitId);

    List<Material> findAllByNomenclature(Long warehouseId, Long nomenclatureId);
}
