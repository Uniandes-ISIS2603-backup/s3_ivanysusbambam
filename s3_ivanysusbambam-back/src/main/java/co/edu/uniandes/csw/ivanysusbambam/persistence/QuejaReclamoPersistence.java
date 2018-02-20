/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
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
public class QuejaReclamoPersistence {
 
    private static final Logger LOGGER = Logger.getLogger(QuejaReclamoPersistence.class.getName());

    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto queja o reclamo  que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public QuejaReclamoEntity create(QuejaReclamoEntity entity) {
        LOGGER.info("Creando una queja o reclamo  nueva");
        em.persist(entity);
        LOGGER.info("Creando una queja o reclamo  nueva");
        return entity;
    }
    
    /**
     * @return devuelve toda la lista de entidades quejaReclamo en la base de datos  
     */ 
    public List<QuejaReclamoEntity> findAll() {
        LOGGER.info("Consultando todas las quejas y reclamos");
         TypedQuery query = em.createQuery("select u from QuejaReclamoEntity u", QuejaReclamoEntity.class);
        return query.getResultList();
    }

    
    /**
     * busca y retorna la queja o reclamo con el id dado por parametro
     *
     * @param id id de la queja o reclamo  que se desea buscar
     * @return la queja o reclamo  con el id dado por parametro
     */
    public QuejaReclamoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando queja o reclamo con id={0}", id);
        return em.find(QuejaReclamoEntity.class, id);
    }

       /**
     * Encuentra una serie de QuejaReclamoEntity según el tipo de QuejaReclamo.
     * @param tipo  el tipo que se busca
     * @return lista de QuejaReclamoEntity con el tipo dado por parámetro.
     */
    public List<QuejaReclamoEntity> findByType(String tipo){
        LOGGER.log(Level.INFO, "Buscando QuejasReclamos con tipo: ", tipo);
        TypedQuery tq  = em.createQuery("select u from QuejaReclamoEntity u where u.tipo = :tipo", QuejaReclamoEntity.class);
        if(tq.getResultList().isEmpty()) return null;
        else return tq.getResultList();
    }
    
    /**
     * busca y actualiza la entidad de la queja o reclamo  dada por parametro 
     * @param entity queja o reclamo  con la informacion que se desea actualizar
     * @return la queja o reclamo  actualizada
     */ 
    public QuejaReclamoEntity update(QuejaReclamoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Queja o reclamo  con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * busca y elimina de la base de datos la entidad de la queja o reclamo 
     * con el id dado por parametro
     * @param id id de la queja o reclamo  que se desea eliminar 
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando queja o reclamo  con id={0}", id);
        QuejaReclamoEntity entity = em.find(QuejaReclamoEntity.class, id);
        em.remove(entity);
    }
    
}
