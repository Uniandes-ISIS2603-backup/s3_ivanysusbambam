/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.integration.handler.LoggingHandler;

/**
 *
 * @author if.garcia
 */

@Stateless
public class PuntoDeVentaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoDeVentaPersistence.class.getName());
    
    
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto PuntoDeVenta que se creará en la base de datos 
     * @return Entidad creada con un id asignado por la base de datos
     */
    public PuntoDeVentaEntity create(PuntoDeVentaEntity entity){
        LOGGER.info("Creando un nuevo punto de venta ");
        em.persist(entity);
        LOGGER.info("Se ha creado un nuevo punto de venta");
        return entity;
    }
    
    
    /**
     * @return devuelve toda la lista de entidades puntoDeVenta en la base de datos  
     */ 
    public List<PuntoDeVentaEntity> findAll() {
        LOGGER.info("Consultando todas los puntos de venta");
         TypedQuery query = em.createQuery("select u from PuntoDeVentaEntity u", PuntoDeVentaEntity.class);
        return query.getResultList();
    }
    
     /**
     * busca y retorna el punto de venta con el id dado por parametro
     *
     * @param id id de la punto de venta  que se desea buscar
     * @return el punto de venta con el id dado por parametro
     */
    public PuntoDeVentaEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando punto de venta con id={0}",id);
        return em.find(PuntoDeVentaEntity.class, id);
    }
    
    public List<PuntoDeVentaEntity> findByName(String name){
        LOGGER.log(Level.INFO, "Buscando clientes con nombre: ", name);
        TypedQuery tq = em.createQuery("select v from PuntoDeVentaEntity v where v.nombre = :nombre", PuntoDeVentaEntity.class);
        tq.setParameter("nombre", name);
        if(tq.getResultList().isEmpty()) return null;
        else return tq.getResultList();
    }
    
    /**
     * Actualiza un PuntoDeVentaEntity dado.
     * @param puntoDeVenta PuntoDeVentaEntity con la información actualizada.
     * @return PuntoDeVentaEntityactualizado.
     */
    public PuntoDeVentaEntity update(PuntoDeVentaEntity puntoDeVenta){
        LOGGER.log(Level.INFO, "Actualizando punto de venta con id: ", puntoDeVenta.getId());
        return em.merge(puntoDeVenta);
    }
    
     /**
     * Elimina un PuntoDeVentaEntity pasado por parámetro.
     * @param id del PuntoDeVentaEntity que se desea eliminar.
     * @return PuntoDeVentaEntity recién eliminado.
     */
    public PuntoDeVentaEntity delete(Long id){
        LOGGER.log(Level.INFO, "Eliminando punto de venta con id: ", id);
        PuntoDeVentaEntity pv = find(id);
        em.remove(pv);
        return pv;
    }
}
