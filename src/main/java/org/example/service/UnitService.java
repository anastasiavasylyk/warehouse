package org.example.service;

import java.util.List;
import org.example.model.Unit;

public interface UnitService {
    Unit add(Unit entity);

    Unit get(Long id);

    List<Unit> getAll();

    Unit update(Unit entity);

    void remove(Long id);

    Unit findByName(String name);
}
