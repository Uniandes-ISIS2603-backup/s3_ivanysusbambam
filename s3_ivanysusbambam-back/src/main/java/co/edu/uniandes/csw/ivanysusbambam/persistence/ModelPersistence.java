/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Joseph Ortíz Moreno
 */
@Stateless
public class ModelPersistence {
    
        private static final Logger LOGGER = Logger.getLogger(ModelPersistence.class.getName());
        
        @PersistenceContext(unitName = "IvanysusbambamPU")
        protected EntityManager em;

        public ModelEntity find(Long id){
            LOGGER.log(Level.INFO, "Buscando modelo con id={0}", id);
            return em.find(ModelEntity.class, id);
        }
        
        public List<ModelEntity> findByPuertas(Integer numPuer){
            LOGGER.log(Level.INFO, "Buscando modelo con número de puertas={0}", numPuer);
                 TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.numeroPuertas = :numPuer", ModelEntity.class);
                 q = q.setParameter("numPuer", numPuer);
                  return q.getResultList();
        }
        
         public List<ModelEntity> findByTransm(String trans){
            LOGGER.log(Level.INFO, "Buscando modelo con transmisión=", trans);
              TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.transmision = :trans", ModelEntity.class);
                 q = q.setParameter("trans", trans);
                  return q.getResultList();
        } 
         
         
         public List<ModelEntity> findByCilindraje(Integer cil){
            LOGGER.log(Level.INFO, "Buscando modelo con cilindraje=", cil);
              TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.cilindraje = :cil", ModelEntity.class);
                 q = q.setParameter("cil", cil);
                  return q.getResultList();
         }
         
        public List<ModelEntity> findAll() {
        LOGGER.info("Consultando todos los modelos");
        Query q = em.createQuery("select u from ModelEntity u");
        return q.getResultList();
    }
        public ModelEntity create(ModelEntity entity) {
        LOGGER.info("Creando un nuevo modelo");
        em.persist(entity);
        LOGGER.info("Modelo creado");
        return entity;
    }
        public ModelEntity update(ModelEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando modelo con id{0}", entity.getId());
        return em.merge(entity);
    }
        public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando modelo con id ={0}", id);
        ModelEntity entity = em.find(ModelEntity.class, id);
        em.remove(entity);
    }
        
    
}
