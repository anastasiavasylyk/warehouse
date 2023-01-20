package org.example.service.impl;

import java.util.List;
import org.example.dao.NomenclatureDao;
import org.example.model.Nomenclature;
import org.example.service.NomenclatureService;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureServiceImpl implements NomenclatureService {
    private final NomenclatureDao nomenclatureDao;

    public NomenclatureServiceImpl(NomenclatureDao nomenclatureDao) {
        this.nomenclatureDao = nomenclatureDao;
    }

    @Override
    public Nomenclature add(Nomenclature nomenclature) {
        return nomenclatureDao.add(nomenclature);
    }

    @Override
    public Nomenclature get(Long id) {
        return nomenclatureDao.get(id).get();
    }

    @Override
    public List<Nomenclature> getAll() {
        return nomenclatureDao.getAll();
    }

    @Override
    public Nomenclature update(Nomenclature nomenclature) {
        return nomenclatureDao.update(nomenclature);
    }

    @Override
    public void remove(Long id) {
        nomenclatureDao.remove(id);
    }

    @Override
    public Nomenclature findByName(String name) {
        return nomenclatureDao.findByName(name).get();
    }
}
