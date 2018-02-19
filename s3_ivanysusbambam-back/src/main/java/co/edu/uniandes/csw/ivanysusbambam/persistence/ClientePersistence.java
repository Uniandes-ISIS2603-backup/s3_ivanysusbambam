/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import java.util.logging.Logger;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felipe Velásquez Montoya
 * <pre>
 *  Versiones: 
 *      19/02/2018
 *          -Creación de la clase y métodos de busqueda, creación, actualización y eliminación´básicos.
 * </pre>
 */
public class ClientePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());
    
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    
    /**
     * Persiste un ClienteEntity
     * @param ce ClienteEntity que se desea persistir.
     * @return  el ClienteEntity que se persistió.
     */
    public ClienteEntity create(ClienteEntity ce){
        LOGGER.info("Creando cliente");
        em.persist(ce);
        LOGGER.info("Creado clliente");
        return ce;
    }
    
    /**
     * Encuentra todos los ClienteEntity persistidos.
     * @return lista con todos los ClienteEntity persistidos.
     */
    public List<ClienteEntity> findAll(){
        LOGGER.info("Consultando todos los clientes");
        TypedQuery tq = em.createQuery("select v from ClienteEntity v", ClienteEntity.class);
        return tq.getResultList();
    }
    
    /**
     * Actualiza un ClienteEntity dado.
     * @param ce ClienteEntity con la información actualizada.
     * @return ClienteEntity actualizado.
     */
    public ClienteEntity update(ClienteEntity ce){
        LOGGER.log(Level.INFO, "Actualizando cliente con cédula: ", ce.getId());
        return em.merge(ce);
    }
    
    /**
     * Elimina un ClienteEntity pasado por parámetro.
     * @param ce ClienteEntity que se desea eliminar.
     * @return ClienteEntity recién eliminado.
     */
    public ClienteEntity delete(ClienteEntity ce){
        LOGGER.log(Level.INFO, "Eliminando cliente con cédula: ", ce.getId());
        em.remove(ce);
        return ce;
    }
    
    /**
     * Encuentra un ClienteEntity según la cédula del cliente.
     * @param id cédula del cliente que se busca.
     * @return ClienteEntity dueño de la cédula dada o null si no existe un ClienteEntity con esa cédula.
     */
    public ClienteEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando cliente con cedula: ", id);
        return em.find(ClienteEntity.class, id);
    }
    
    /**
     * Encuentra una serie de ClienteEntity según el nombre del cliente.
     * @param name  el nombre que se busca
     * @return lista de ClienteEntity con el nombre dado por parámetro.
     */
    public List<ClienteEntity> findByName(String name){
        LOGGER.log(Level.INFO, "Buscando clientes con nombre: ", name);
        TypedQuery tq  = em.createQuery("select v from ClienteEntity v where v.name = :name", ClienteEntity.class);
        if(tq.getResultList().isEmpty()) return null;
        else return tq.getResultList();
    }
    
}
