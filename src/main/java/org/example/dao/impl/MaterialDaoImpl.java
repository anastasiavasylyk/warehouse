package org.example.dao.impl;

import java.util.List;
import org.example.dao.AbstractDao;
import org.example.dao.MaterialDao;
import org.example.exception.DataProcessingException;
import org.example.model.Material;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialDaoImpl extends AbstractDao<Material> implements MaterialDao {
    public MaterialDaoImpl(SessionFactory factory) {
        super(factory, Material.class);
    }

    @Override
    public List<Material> findAllByUnit(Long warehouseId, Long unitId) {
        try (Session session = factory.openSession()) {
            Query<Material> query = session.createQuery(
                    "SELECT m FROM Material m "
                            + "WHERE m.warehouseId = :warehouseId "
                            + "AND m.unitId = :unitId", Material.class);
            query.setParameter("warehouseId", warehouseId);
            query.setParameter("unitId", unitId);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all materials by warehouse id "
                    + warehouseId + " and unit id " + unitId, e);
        }
    }

    @Override
    public List<Material> findAllByNomenclature(Long warehouseId, Long nomenclatureId) {
        try (Session session = factory.openSession()) {
            Query<Material> query = session.createQuery(
                    "SELECT m FROM Material m "
                            + "WHERE m.warehouseId = :warehouseId "
                            + "AND m.nomenclatureId = :nomenclatureId", Material.class);
            query.setParameter("warehouseId", warehouseId);
            query.setParameter("nomenclatureId", nomenclatureId);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all materials by warehouse id "
                    + warehouseId + " and nomenclature id " + nomenclatureId, e);
        }
    }
}
