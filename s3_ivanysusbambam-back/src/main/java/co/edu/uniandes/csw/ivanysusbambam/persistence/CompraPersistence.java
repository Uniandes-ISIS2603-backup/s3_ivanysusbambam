/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CityEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author j.sierrac
 */
@Stateless
public class CompraPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(CityPersistence.class.getName());

    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;
    /**
     *
     * @param entity objeto city que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
//    public CompraEntity create(CityEntity entity) {
//        LOGGER.info("Creando una city nueva");
//        em.persist(entity);
//        LOGGER.info("Creando una city nueva");
//        return entity;
//    }
}
