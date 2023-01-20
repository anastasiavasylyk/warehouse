package org.example.service.impl;

import java.util.List;
import org.example.dao.UnitDao;
import org.example.model.Unit;
import org.example.service.UnitService;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitDao unitDao;

    public UnitServiceImpl(UnitDao unitDao) {
        this.unitDao = unitDao;
    }

    @Override
    public Unit add(Unit unit) {
        return unitDao.add(unit);
    }

    @Override
    public Unit get(Long id) {
        return unitDao.get(id).get();
    }

    @Override
    public List<Unit> getAll() {
        return unitDao.getAll();
    }

    @Override
    public Unit update(Unit unit) {
        return unitDao.update(unit);
    }

    @Override
    public void remove(Long id) {
        unitDao.remove(id);
    }

    @Override
    public Unit findByName(String name) {
        return unitDao.findByName(name).get();
    }
}
