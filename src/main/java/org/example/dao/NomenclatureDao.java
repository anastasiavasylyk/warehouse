package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.Nomenclature;

public interface NomenclatureDao {
    Nomenclature add(Nomenclature nomenclature);

    Optional<Nomenclature> get(Long id);

    List<Nomenclature> getAll();

    Nomenclature update(Nomenclature nomenclature);

    void remove(Long id);

    Optional<Nomenclature> findByName(String name);
}
