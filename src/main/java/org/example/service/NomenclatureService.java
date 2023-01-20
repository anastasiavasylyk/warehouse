package org.example.service;

import java.util.List;
import org.example.model.Nomenclature;

public interface NomenclatureService {
    Nomenclature add(Nomenclature entity);

    Nomenclature get(Long id);

    List<Nomenclature> getAll();

    Nomenclature update(Nomenclature entity);

    void remove(Long id);

    Nomenclature findByName(String name);
}
