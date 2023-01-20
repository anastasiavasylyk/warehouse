package org.example.dao.impl;

import java.util.Optional;
import org.example.dao.AbstractDao;
import org.example.dao.NomenclatureDao;
import org.example.exception.DataProcessingException;
import org.example.model.Nomenclature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class NomenclatureDaoImpl extends AbstractDao<Nomenclature> implements NomenclatureDao {
    public NomenclatureDaoImpl(SessionFactory factory) {
        super(factory, Nomenclature.class);
    }

    @Override
    public Optional<Nomenclature> findByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Nomenclature> query = session.createQuery(
                    "SELECT n FROM Nomenclature n "
                            + "WHERE  n.name = :name", Nomenclature.class);
            query.setParameter("name", name);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get nomenclature by name " + name, e);
        }
    }
}
