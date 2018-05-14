/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
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
public class CalificacionCarroPersistence {

    /**
     * Constante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionCarroPersistence.class.getName());

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     * Persiste un CalificacionCarroEntity
     *
     * @param ce CalificacionCarroEntity que se desea persistir.
     * @return el CalificacionCarroEntity que se persistió.
     */
    public CalificacionCarroEntity create(CalificacionCarroEntity ce) {
        LOGGER.info("Creando una nueva calificacion de carro");
        em.persist(ce);
        LOGGER.info("Creada una nueva calificacion de carro");
        return ce;
    }

    /**
     * Encuentra todos los CalificacionCarroEntity persistidos.
     *
     * @return lista con todos los CalificacionCarroEntity persistidos.
     */
    public List<CalificacionCarroEntity> findAll() {
        LOGGER.info("Consultando todas las calificaciones de carro");
        TypedQuery tq = em.createQuery("select v from CalificacionCarroEntity v", CalificacionCarroEntity.class);
        return tq.getResultList();
    }

    /**
     * Actualiza un CalificacionCarroEntity dado.
     *
     * @param ce CalificacionCarroEntity con la información actualizada.
     * @return CalificacionCarroEntity actualizado.
     */
    public CalificacionCarroEntity update(CalificacionCarroEntity ce) {
        LOGGER.log(Level.INFO, "Actualizando calificacion de carro con id: ", ce.getId());
        return em.merge(ce);
    }

    /**
     * Elimina un CalificacionCarroEntity pasado por parámetro.
     *
     * @param id del CalificacionCarroEntity que se desea eliminar.
     * @return CalificacionCarroEntity recién eliminado.
     */
    public CalificacionCarroEntity delete(Long id) {
        LOGGER.log(Level.INFO, "Eliminando calificacion de carro con identificacion: ", id);
        CalificacionCarroEntity ce = find(id);
        em.remove(ce);
        return ce;
    }

    /**
     * Encuentra un CalificacionCarroEntity según el id de la calificacion.
     *
     * @param id de la calificacion de carro que se busca.
     * @return CalificacionCarroEntity con el id dado o null si no existe un
     * CalificacionCarroEntity con este id.
     */
    public CalificacionCarroEntity find(Long id) {
        LOGGER.log(Level.INFO, "Buscando calificacion de carro con id: ", id);
        return em.find(CalificacionCarroEntity.class, id);
    }

}
