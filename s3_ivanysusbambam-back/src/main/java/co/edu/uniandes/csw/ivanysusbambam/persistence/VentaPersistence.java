/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *  
 * @author hd.castellanos
 */
@Stateless
public class VentaPersistence {

    private static final Logger LOGGER = Logger.getLogger(VentaPersistence.class.getName());

    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto venta que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public VentaEntity create(VentaEntity entity) {
        LOGGER.info("Creando una venta nueva");
        em.persist(entity);
        LOGGER.info("Creando una venta nueva");
        return entity;
    }

    /**
     * @return una lista con todas las entidades de venta en la base de datos
     */
    public List<VentaEntity> findAll() {
        LOGGER.info("Consultando todas las ventas");
        TypedQuery query = em.createQuery("select u from VentaEntity u", VentaEntity.class);
        return query.getResultList();
    }

    /**
     * busca y retorna la venta con el id dado por parametro
     *
     * @param id id de la venta que se desea buscar
     * @return la venta con el id dado por parametro
     */
    public VentaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando venta con id={0}", id);
        return em.find(VentaEntity.class, id);
    }

    /**
     * busca y actualiza la entidad de la venta dada por parametro 
     * @param entity venta con la informacion que se desea actualizar
     * @return la venta actualizada
     */ 
    public VentaEntity update(VentaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando venta con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * busca y elimina la entidad de la venta con el id dado por parametro
     * dado por parametro
     * @param id id de la venta que se desea eliminar 
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando venta con id={0}", id);
        VentaEntity entity = em.find(VentaEntity.class, id);
        em.remove(entity);
    }

}
