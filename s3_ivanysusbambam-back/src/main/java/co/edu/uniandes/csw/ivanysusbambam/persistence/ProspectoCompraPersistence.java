/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felipe Velásquez Montoya
 * <pre>
 *  Versiones:
 *      -19/02/2018
 *          -Creada clase y métodos find, create, update y delete básicos.
 * </pre>
 */
@Stateless
public class ProspectoCompraPersistence {
    
    private static final Logger LOGGER =  Logger.getLogger(ProspectoCompraPersistence.class.getName());
    
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    
    /**
     * Persiste un ProspectoCompraEntity dado por parámetro.
     * @param pe ProspectoCompraEntity que se desea persistir.
     * @return ProspectoCompraEntity que se desea persistir.
     */
    public ProspectoCompraEntity create(ProspectoCompraEntity pe){
        LOGGER.info("Creando prospecto");
        em.persist(pe);
        LOGGER.info("Creado prospecto");
        return pe;
    }
    
    /**
     * Encuentra todos los ProspectoCompraEntity persistidos.
     * @return una lista con los ProspectoCompraEntity persistidos.
     */
    public List<ProspectoCompraEntity> findAll(){
        LOGGER.info("Consultando todos los prospectos de compra");
        TypedQuery tq = em.createQuery("select v from ProspectoCompraEntity v", ProspectoCompraEntity.class);
        return tq.getResultList();
    }
    
    /**
     * Actualiza un ProspectoCompraEntity dado por parámetro.
     * @param pe ProspectoCompraEntity con la información actualizada.
     * @return ProspectoCompraEntity actualizado.
     */
    public ProspectoCompraEntity update(ProspectoCompraEntity pe){
        LOGGER.log(Level.INFO, "Actualizando prospectoCompra con id: ", pe.getId());
        return em.merge(pe);
    }
    
    /**
     * Elimina un ProspectoCompraEntity pasado por parámetro.
     * @param id  id del ProspectoCompraEntity que se desea eliminar.
     * @return ProspectoCompraEntity recién eliminado.
     */
    public ProspectoCompraEntity delete (Long id){
        LOGGER.log(Level.INFO, "Eliminando prospectoCompra con id: ", id);
        ProspectoCompraEntity pe = find(id);
        em.remove(pe);
        return pe;
    }
    
    /**
     * Encuentra un ProspectoCompraEntity según su id.
     * @param id del ProspectoCompraEntity que se busca.
     * @return ProspectoCompraEntity encontrado.
     */
    public ProspectoCompraEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando prospectoCompra con id: ", id);
        return em.find(ProspectoCompraEntity.class, id);
    }
    
    /**
     * Encuentra una serie de ProspectoCompraEntity según el vendedor que los creó.
     * @param ve VendedorEntity al que pertenece ProspectoCompraEntity
     * @return lista con los ProspectoCompraEntity pertenecientes al VendedorEntity dado por parámetro.
     */
    public List<ProspectoCompraEntity> findByVendedor(VendedorEntity ve){
        LOGGER.log(Level.INFO, "Buscando Prospectos de compra relacionados con el vendedor: ", ve.getCarnetVendedor());
        
        TypedQuery tq = em.createQuery("select v from ProspectoCompraEntity v where v.vendedor = :ve", ProspectoCompraEntity.class);
        tq.setParameter("ve",ve);
        if(tq.getResultList().isEmpty()){
            return new ArrayList<>();
        }
        else return tq.getResultList();
    }
    
    /**
     * Encuentra una serie de ProspectoCompraEntity pertenecientes a un cliente dado por parámetro.
     * @param ce ClienteEntity a quien pertenecen los ProspectoCompraEntity buscados.
     * @return Lista con los ProspectoCompraEntity pertenecientes al ClienteEntity dado por parámetro.
     */
    public List<ProspectoCompraEntity> findByCliente(ClienteEntity ce){
        LOGGER.log(Level.INFO, "Buscando prospectos de compra relacionados con el cliente: ", ce.getCedula());
        
        TypedQuery tq = em.createQuery("select v from ProspectoCompraEntity v where v.cliente = :ce", ProspectoCompraEntity.class);
        tq.setParameter("ce",ce);
        if(tq.getResultList().isEmpty()){
            return new ArrayList<>();
        }
        else return tq.getResultList();
    }
    
    /**
     * Encuentra los ProspectosCompraEntity pertenecientes a un automóvil
     * @param ae automóvil del que se busc
     * @return 
     */
    public List<ProspectoCompraEntity> findByAutomovil(AutomovilEntity ae){
        
        LOGGER.log(Level.INFO, "Buscando prospectos de compra relacionados con el cliente: ", ae.getPlaca());
        
        TypedQuery tq = em.createQuery("select v from ProspectoCompraEntity v where v.automovil=:ae", ProspectoCompraEntity.class);
        tq.setParameter("ae",ae);
        if(tq.getResultList().isEmpty()){
            return new ArrayList<>();
        }
        else return tq.getResultList();
    }
}
