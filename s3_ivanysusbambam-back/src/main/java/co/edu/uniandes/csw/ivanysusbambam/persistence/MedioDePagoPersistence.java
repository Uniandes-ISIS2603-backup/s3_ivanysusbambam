/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author j.sierrac
 */
@Stateless
public class MedioDePagoPersistence {

    private static final Logger LOGGER = Logger.getLogger(MedioDePagoPersistence.class.getName());

    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto MedioDePago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MedioDePagoEntity create(MedioDePagoEntity entity) {
        LOGGER.info("Creando un medio de pago nuevo");
        em.persist(entity);
        LOGGER.info("Creando un medio de pago nuevo");
        return entity;
    }

    /**
     * Encuentra todas los medios de pagos en la base de datos
     *
     * @return una lista con todos los medios de pagos en la base de datos
     */
    public List<MedioDePagoEntity> findAll() {
        LOGGER.info("Consultando todas los medios de pagos");
        TypedQuery query = em.createQuery("select u from MedioDePagoEntity u", MedioDePagoEntity.class);
         LOGGER.info(""+query.getResultList().size());
          LOGGER.info(""+query.getResultList().size());
           LOGGER.info(""+query.getResultList().size());
            LOGGER.info(""+query.getResultList().size());
             LOGGER.info(""+query.getResultList().size());
         LOGGER.info(""+query.getResultList().size());
        LOGGER.info(""+query.getResultList().size());
        return query.getResultList();
    }

    /**
     *
     * @param numero El numero del objeto que se quiere encontrar en la base de
     * datos
     * @return El medio de pago con el numero que entra por parametro
     */
    public MedioDePagoEntity find(Long numero) {
        return em.find(MedioDePagoEntity.class, numero);
    }

    /**
     * Actualiza la entidad que entra por parametro
     *
     * @param entity La entidad a actualizar
     * @return El objeto que se actualizo en la base de datos
     */
    public MedioDePagoEntity update(MedioDePagoEntity entity) {
        return em.merge(entity);
    }

    /**
     * Borra el objeto que entra por parametro de la base de datos
     *
     * @param entity La entidad a borrar
     */
    public void delete(Long id) {
        MedioDePagoEntity entity = em.find(MedioDePagoEntity.class, id);
        em.remove(entity);
    }
    
}
