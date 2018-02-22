/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.bravo
 */
@Stateless
public class AutomovilPersistence {
    private static final Logger LOGGER = Logger.getLogger(AutomovilPersistence.class.getName());

    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    
    public AutomovilEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando automovil con id={0}", id);
        return em.find(AutomovilEntity.class, id);
    }

    public AutomovilEntity findByName(String placa) {
        LOGGER.log(Level.INFO, "Consultando automovil con placa= ", placa);
        TypedQuery<AutomovilEntity> q
                = em.createQuery("select u from AutomovilEntity u where u.placa = :placa", AutomovilEntity.class);
        q = q.setParameter("placa", placa);
        return q.getSingleResult();
    }

    public List<AutomovilEntity> findAll() {
        LOGGER.info("Consultando todos los automoviles");
        Query q = em.createQuery("select u from AutomovilEntity u");
        return q.getResultList();
    }

    public AutomovilEntity create(AutomovilEntity entity) {
        LOGGER.info("Creando un automovil nuevo");
        em.persist(entity);
        LOGGER.info("Automovil creado");
        return entity;
    }

    public AutomovilEntity update(AutomovilEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando automovil con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando automovil con id={0}", id);
        AutomovilEntity entity = em.find(AutomovilEntity.class, id);
        em.remove(entity);
    }
}
