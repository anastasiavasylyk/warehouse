package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.Unit;

public interface UnitDao {
    Unit add(Unit unit);

    Optional<Unit> get(Long id);

    List<Unit> getAll();

    Unit update(Unit unit);

    void remove(Long id);

    Optional<Unit> findByName(String name);
}
