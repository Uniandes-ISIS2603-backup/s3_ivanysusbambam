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

    /**
     * Constante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(ModelPersistence.class.getName());

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     * Busca el modelo con el id dado por parametro
     *
     * @param id del modelo a buscar
     * @return el modelo con el id dado por parametro
     */
    public ModelEntity find(Long id) {
        LOGGER.log(Level.INFO, "Buscando modelo con id={0}", id);
        return em.find(ModelEntity.class, id);
    }

    /**
     * Busca todos los modelos con el numero de puertas dado por parametro
     *
     * @param numPuer numero de puertas de los modelos a buscar
     * @return la lista de modelos con el numero de puertas dado por parametro
     */
    public List<ModelEntity> findByPuertas(Integer numPuer) {
        LOGGER.log(Level.INFO, "Buscando modelo con número de puertas={0}", numPuer);
        TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.numeroPuertas = :numPuer", ModelEntity.class);
        q = q.setParameter("numPuer", numPuer);
        return q.getResultList();
    }

    /**
     * Busca la lista de modelos con la transmision dada por parametro
     *
     * @param trans transmision de los modelos a buscar
     * @return la lista de modelos con la transmision dada por parametro
     */
    public List<ModelEntity> findByTransm(String trans) {
        LOGGER.log(Level.INFO, "Buscando modelo con transmisión=", trans);
        TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.transmision = :trans", ModelEntity.class);
        q = q.setParameter("trans", trans);
        return q.getResultList();
    }

    /**
     * busca la lista de modelos con el clilindraje dado por parametro
     *
     * @param cil clilindajre de los modelos a buscar
     * @return la lista de modelos con el clindraje dado por parametro
     */
    public List<ModelEntity> findByCilindraje(Integer cil) {
        LOGGER.log(Level.INFO, "Buscando modelo con cilindraje=", cil);
        TypedQuery<ModelEntity> q = em.createQuery("select u from ModelEntity u where u.cilindraje = :cil", ModelEntity.class);
        q = q.setParameter("cil", cil);
        return q.getResultList();
    }

    /**
     * @return la lista de todos los modelos en la base de datos
     */
    public List<ModelEntity> findAll() {
        LOGGER.info("Consultando todos los modelos");
        Query q = em.createQuery("select u from ModelEntity u");
        return q.getResultList();
    }

    /**
     * Crea un nuevomodelo con la informacion de la emtidad dada por parametro
     *
     * @param entity entidad con la informacion del modelo
     * @return la entidad persistida
     */
    public ModelEntity create(ModelEntity entity) {
        LOGGER.info("Creando un nuevo modelo");
        em.persist(entity);
        LOGGER.info("Modelo creado");
        return entity;
    }

    /**
     * Actualiza la informacion del modelo con la informacion de la entidad dada
     * por parametro
     *
     * @param entity entidad con la nueva informacion
     * @return la entidad con la informacion actualizada
     */
    public ModelEntity update(ModelEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando modelo con cilindraje={0}", entity.getCilindraje());
        return em.merge(entity);
    }

    /**
     * Busca y borra un modelo con el id dado por parametro
     *
     * @param id id del modelo a ser borrado
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando modelo con id ={0}", id);
        ModelEntity entity = em.find(ModelEntity.class, id);
        em.remove(entity);
    }

}
