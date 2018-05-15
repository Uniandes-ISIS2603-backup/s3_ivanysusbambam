/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import java.util.ArrayList;
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
     * Busca una marca por su id
     *
     * @param id id de la marca a buscar
     * @return marca con el id dado por parametro
     */
    public MarcaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Buscando marca");
        return em.find(MarcaEntity.class, id);
    }

    /**
     * @return Todas las marcas en la base de datos
     */
    public List<MarcaEntity> findAll() {
        LOGGER.info("Consultando todas las marcas");
        Query q = em.createQuery("select u from MarcaEntity u");
        return q.getResultList();
    }

    /**
     * Busca una marca con el nombre dado
     *
     * @param name nombre de la marca a buscar
     * @return la entidad de la marca con el nombre dado
     */
    public List<MarcaEntity> findByName(String name) {
        LOGGER.log(Level.INFO, "Buscando marca con nombre", name);
        TypedQuery<MarcaEntity> q = em.createQuery("select u from MarcaEntity u where u.name = :name", MarcaEntity.class);
        q = q.setParameter("name", name);
        return q.getResultList();
    }

    /**
     * Crea una marca con la informacion de la entidad
     *
     * @param entity entidad a crear
     * @return la entidad persistida
     */
    public MarcaEntity create(MarcaEntity entity) {
        LOGGER.info("Creando una nueva marca");
        em.persist(entity);
        LOGGER.info("Marca creada");
        return entity;
    }

    /**
     * Actualiza la informacion de una marca con la inforamcion de la entidad
     * dada por parametro
     *
     * @param entity entidad con la nueva informacion
     * @return la entidad dada por parametro
     */
    public MarcaEntity update(MarcaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando marca con nombre=", entity.getName());
        return em.merge(entity);
    }

    /**
     * Elimina una marca con el id dado por parametro
     *
     * @param id id de la marca a eliminar
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando marca con id=", id);
        MarcaEntity entity = em.find(MarcaEntity.class, id);
        em.remove(entity);
    }
}
