package org.example.service.impl;

import java.util.List;
import org.example.dao.MaterialDao;
import org.example.model.Material;
import org.example.service.MaterialService;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {
    private final MaterialDao materialDao;

    public MaterialServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    @Override
    public Material add(Material material) {
        return materialDao.add(material);
    }

    @Override
    public Material get(Long id) {
        return materialDao.get(id).get();
    }

    @Override
    public List<Material> getAll() {
        return materialDao.getAll();
    }

    @Override
    public Material update(Material material) {
        return materialDao.update(material);
    }

    @Override
    public void remove(Long id) {
        materialDao.remove(id);
    }

    @Override
    public List<Material> findAllByUnit(Long warehouseId, Long unitId) {
        return materialDao.findAllByUnit(warehouseId, unitId);
    }

    @Override
    public List<Material> findAllByNomenclature(Long warehouseId, Long nomenclatureId) {
        return materialDao.findAllByNomenclature(warehouseId, nomenclatureId);
    }
}
