/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;


import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
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
 * @author Joseph Ortíz Moreno
 */
@Stateless
public class MarcaPersistence {
    private static final Logger LOGGER = Logger.getLogger(ModelPersistence.class.getName());
        
        @PersistenceContext(unitName = "IvanysusbambamPU")
        protected EntityManager em;
      
        
        
       public MarcaEntity find(Long id){
            LOGGER.log(Level.INFO, "Buscando marca");
            return em.find(MarcaEntity.class, id);
        }
       
     public MarcaEntity findByNombre(String nom){
            LOGGER.log(Level.INFO, "Buscando marca con nombre ={0}", nom);
                 TypedQuery<MarcaEntity> q = em.createQuery("select u from MarcaEntity u where u.nombre = :nom", MarcaEntity.class);
                 q = q.setParameter("nombre", nom);
                 if (q.getResultList().isEmpty()){
                     return null;
                 }
                 else
                  return q.getSingleResult();
        }
       
       public List<MarcaEntity> findAll(){
        LOGGER.info("Consultando todas las marcas");
        Query q = em.createQuery("select u from MarcaEntity u");
        return q.getResultList();
       }
       
       public MarcaEntity create(MarcaEntity entity) {
        LOGGER.info("Creando una nueva marca");
        em.persist(entity);
        LOGGER.info("Marca creada");
        return entity;
    }
        public MarcaEntity update(MarcaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando marca con nombre=", entity.getName());
        return em.merge(entity);
    }
        public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando marca con id=", id);
        MarcaEntity entity = em.find(MarcaEntity.class, id);
        em.remove(entity);
    }
}
