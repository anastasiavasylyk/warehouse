package org.example.dao.impl;

import java.util.Optional;
import org.example.dao.AbstractDao;
import org.example.dao.UnitDao;
import org.example.exception.DataProcessingException;
import org.example.model.Unit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UnitDaoImpl extends AbstractDao<Unit> implements UnitDao {
    public UnitDaoImpl(SessionFactory factory) {
        super(factory, Unit.class);
    }

    @Override
    public Optional<Unit> findByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Unit> query = session.createQuery(
                    "SELECT u FROM Unit u "
                            + "WHERE  u.name = :name", Unit.class);
            query.setParameter("name", name);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get unit by name " + name, e);
        }
    }
}
