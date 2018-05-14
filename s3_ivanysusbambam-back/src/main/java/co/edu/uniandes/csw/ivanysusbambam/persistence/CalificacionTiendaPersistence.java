/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author if.garcia
 */
@Stateless
public class CalificacionTiendaPersistence {

    /**
     * Constante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionTiendaPersistence.class.getName());

    /**
     * Atributo para entity manager
     */
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     * Persiste un CalificacionTiendaEntity
     *
     * @param ce CalificacionTiendaEntity que se desea persistir.
     * @return el CalificacionTiendaEntity que se persistió.
     */
    public CalificacionTiendaEntity create(CalificacionTiendaEntity ce) {
        LOGGER.info("Creando una nueva calificacion de tienda");
        em.persist(ce);
        LOGGER.info("Creada una nueva calificacion de tienda");
        return ce;
    }

    /**
     * Encuentra todos los CalificacionTiendaEntity persistidos.
     *
     * @return lista con todos los CalificacionTiendaEntity persistidos.
     */
    public List<CalificacionTiendaEntity> findAll() {
        LOGGER.info("Consultando todas las calificaciones de tienda");
        TypedQuery tq = em.createQuery("select v from CalificacionTiendaEntity v", CalificacionTiendaEntity.class);
        return tq.getResultList();
    }

    /**
     * Actualiza un CalificacionTiendaEntity dado.
     *
     * @param ce CalificacionTiendaEntity con la información actualizada.
     * @return CalificacionTiendaEntity actualizado.
     */
    public CalificacionTiendaEntity update(CalificacionTiendaEntity ce) {
        LOGGER.log(Level.INFO, "Actualizando calificacion de tienda con id: ", ce.getId());
        return em.merge(ce);
    }

    /**
     * Elimina un CalificacionTiendaEntity pasado por parámetro.
     *
     * @param id del CalificacionTiendaEntity que se desea eliminar.
     * @return CalificacionTiendaEntity recién eliminado.
     */
    public CalificacionTiendaEntity delete(Long id) {
        LOGGER.log(Level.INFO, "Eliminando calificacion de tienda con id: ", id);
        CalificacionTiendaEntity ce = find(id);
        em.remove(ce);
        return ce;
    }

    /**
     * Encuentra un CalificacionTiendaEntity según el id de la calificacion.
     *
     * @param id de la calificacion de Tienda que se busca.
     * @return CalificacionTiendaEntity con el id dado o null si no existe un
     * CalificacionTiendaEntity con este id.
     */
    public CalificacionTiendaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Buscando calificacion de tienda con id: ", id);
        return em.find(CalificacionTiendaEntity.class, id);
    }

}
