/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author j.sierrac
 */
@Stateless
public class CompraPersistence {

    /**
     * Constante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CompraPersistence.class.getName());

    /**
     * Atrubuto para el entity manager
     */
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto compra que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CompraEntity create(CompraEntity entity) {
        LOGGER.info("Creando una compra nueva");
        em.persist(entity);
        LOGGER.info("Creando una compra nueva");
        return entity;
    }

    /**
     * Encuentra todas las compras en la base de datos
     *
     * @return una lista con todas las compras en la base de datos
     */
    public List<CompraEntity> findAll() {
        LOGGER.info("Consultando todas las compras");
        TypedQuery query = em.createQuery("select u from CompraEntity u", CompraEntity.class);
        return query.getResultList();
    }

    /**
     *
     * @param id El id del objeto que se quiere encontrar en la base de datos
     * @return La compra con el id que entra por parametro
     */
    public CompraEntity find(Integer id) {
        return em.find(CompraEntity.class, id);
    }

    /**
     * Actualiza la entidad que entra por parametro
     *
     * @param entity La entidad a actualizar
     * @return El objeto que se actualizo en la base de datos
     */
    public CompraEntity update(CompraEntity entity) {
        return em.merge(entity);
    }

    /**
     * Borra el objeto que entra por parametro de la base de datos
     *
     * @param id id de la entidad a borrar
     */
    public void delete(Integer id) {
        CompraEntity entity = em.find(CompraEntity.class, id);
        em.remove(entity);

    }
}
