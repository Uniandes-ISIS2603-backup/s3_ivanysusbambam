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
    
     /**
     * Persiste un AutomovilEntity
     * @param auto AutomovilEntity que se desea persistir.
     * @return  el AutomovilEntity que se persistió.
     */
    public AutomovilEntity create(AutomovilEntity auto){
        LOGGER.info("Creando Automovil");
        em.persist(auto);
        LOGGER.info("Creado Automovil");
        return auto;
    }

    /**
     * Encuentra todos los AutomovilEntity persistidos.
     * @return lista con todos los AutomovilEntity persistidos.
     */
    public List<AutomovilEntity> findAll(){
        LOGGER.info("Consultando todos los automoviles");
        TypedQuery tq = em.createQuery("select v from AutomovilEntity v", AutomovilEntity.class);
        return tq.getResultList();
    }


   /**
     * Actualiza un AutomovilEntity dado.
     * @param auto AutomovilEntity con la información actualizada.
     * @return AutomovilEntity actualizado.
     */
    public AutomovilEntity update(AutomovilEntity auto){
        LOGGER.log(Level.INFO, "Actualizando automovil con placa: ", auto.getPlaca());
        return em.merge(auto);
    }

    /**
     * Elimina un AutomovilEntity pasado por parámetro.
     * @param id del AutomovilEntity que se desea eliminar.
     * @return AutomovilEntity recién eliminado.
     */
    public AutomovilEntity delete(Long id){
        LOGGER.log(Level.INFO, "Eliminando automovil con id: ", id);
        AutomovilEntity auto = find(id);
        em.remove(auto);
        return auto;
    }
    
      /**
     * Encuentra un AutomovilEntity según el id del automovil.
     * @param id  del automovil que se busca.
     * @return AutomovilEntity dueño del dada o null si no existe un AutomovilEntity con ese id.
     */
    public AutomovilEntity find(Long id){
       LOGGER.log(Level.INFO, "Consultando automovil con id={0}", id);
        return em.find(AutomovilEntity.class, id);
    }
    
     /**
     * Encuentra una serie de AutomovilEntity según el color del cliente.
     * @param color  el color que se busca
     * @return lista de AutomovilEntity con el color dado por parámetro.
     */
    public List<AutomovilEntity> findByColor(String color){
        LOGGER.log(Level.INFO, "Buscando automoviles con color: ", color);
        TypedQuery tq  = em.createQuery("select v from AutomovilEntity v where v.color = :color", AutomovilEntity.class);
        tq.setParameter("color",color);
        if(tq.getResultList().isEmpty()) return null;
        else return tq.getResultList();
    }
    
   /**
    * Busca un automovil con la placa dada por parametro
    * @param placa del automovil que se desea buscar 
    * @return un autimovil si ya existe con la placa dada por parametro 
    */
    public AutomovilEntity findByPlate (String placa){
        LOGGER.log(Level.INFO, "Buscando automovil con placa: ", placa);
        return em.find(AutomovilEntity.class, placa);
    }
    
    /**
    * Busca un automovil con el chasisa dada por parametro
    * @param chasis del automovil que se desea buscar 
    * @return un autimovil si ya existe con la placa dada por parametro 
    */
    public AutomovilEntity findBychasis (Integer chasis){
        LOGGER.log(Level.INFO, "Buscando automovil con chasis: ", chasis);
        return em.find(AutomovilEntity.class, chasis);
    }
    
    /**
     * Retorna todos los automóviles de una marca dada
     * @param marca marca que se busca
     * @return lista con todos los automóviles de esa marca o null si no hay ninguno.
     */
    public List<AutomovilEntity> findByMarca(String marca){
       
        LOGGER.log(Level.INFO, "buscando automóviles de la marca: ", marca);
        TypedQuery tq = em.createQuery("select a from AutomovilEntity a  JOIN a.marca m where m.name = :marca", AutomovilEntity.class);
        tq.setParameter("marca", marca);
        List autos = tq.getResultList();
        
        if(autos.isEmpty()) 
            return null;
        else
            return autos;
    }
    
    /**
     * Retorna todos los automóviles de un modelo dado.
     * @param modelo modelo que se busca 
     * @return lista con los autos de ese modelo o null si no hay ninguno.
     */
    public List<AutomovilEntity> findByModelo(String modelo){
        LOGGER.log(Level.INFO, "buscando automóviles modelo: ", modelo);      
        TypedQuery tq = em.createQuery("select a from AutomovilEntity a JOIN a.model m where m.name = :modelo",AutomovilEntity.class);
        tq.setParameter("modelo", modelo);
        List autos = tq.getResultList();
        
        if(autos.isEmpty())
            return null;
        else 
            return autos;
    }
    
    /**
     * Retorna todos los autos cuyo año se encuentra entre el rango de fechas.<br>
     * <b>Pre: </b> anioIni <= anioFin
     * @param anioIni rango inferior de la búsqueda
     * @param anioFin rango superior de la búsqueda
     * @return  todos los automóviles cuyo año se encuentra en el rango de fechas, null si no hay ninguno.
     */
    public List<AutomovilEntity> findRangoAnios(Integer anioIni, Integer anioFin){
        LOGGER.log(Level.INFO, "buscando automoviles entre los a\u00f1os {0} y {1}", new Object[]{anioIni, anioFin});
        TypedQuery tq = em.createQuery("select a from AutomovilEntity a where a.anio >= :anioI and a.anio <= :anioF", AutomovilEntity.class);
        tq.setParameter("anioI", anioIni);
        tq.setParameter("anioF", anioFin);
        
        List autos = tq.getResultList();
        
        if(autos.isEmpty())
            return null;
        else 
            return autos;
    }
}
