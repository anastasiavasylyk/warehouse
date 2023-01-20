package org.example.dao.impl;

import java.util.List;
import org.example.dao.AbstractDao;
import org.example.dao.WarehouseDao;
import org.example.exception.DataProcessingException;
import org.example.model.Material;
import org.example.model.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseDaoImpl extends AbstractDao<Warehouse> implements WarehouseDao {
    public WarehouseDaoImpl(SessionFactory factory) {
        super(factory, Warehouse.class);
    }

    @Override
    public Material getMaterialById(Long warehouseId, Long materialId) {
        try (Session session = factory.openSession()) {
            Query<Material> query = session.createQuery(
                    "SELECT m FROM Material m "
                            + "WHERE m.warehouseId = :warehouseId "
                            + "AND m.id = :materialId", Material.class);
            query.setParameter("warehouseId", warehouseId);
            query.setParameter("materialId", materialId);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get material by warehouse id "
                    + warehouseId + " and material id " + materialId, e);
        }
    }

    @Override
    public List<Material> getAllMaterials(Long warehouseId) {
        try (Session session = factory.openSession()) {
            Query<Material> query = session.createQuery(
                    "SELECT m FROM Material m "
                            + "WHERE m.warehouseId = :id", Material.class);
            query.setParameter("id", warehouseId);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all materials by warehouse id "
                    + warehouseId, e);
        }
    }
}
