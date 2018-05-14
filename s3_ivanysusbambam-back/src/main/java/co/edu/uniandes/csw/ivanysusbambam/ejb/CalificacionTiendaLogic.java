/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionTiendaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author if.garcia
 */
@Stateless
public class CalificacionTiendaLogic {

    /**
     * Constante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionTiendaLogic.class.getName());

    /**
     * Atributi para la persistencia de CalificacionTienda
     */
    @Inject
    CalificacionTiendaPersistence persistence;

    /**
     * Obtiene la lista de las calificaciones de las tiendas.
     *
     * @return Colección de objetos de CalificacionTiendaEntity.
     */
    public List<CalificacionTiendaEntity> getCalificacionesTienda() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las calificaciones de tienda");
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de CalificacionTienda a partir de su
     * ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CalificacionTiendaEntity con los datos de la
     * calificacion consultada.
     */
    public CalificacionTiendaEntity getCalificacionTienda(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion tienda con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Se encarga de crear una CalificacionTienda en la base de datos.
     *
     * @param entity Objeto de CalificacionTiendaEntity con los datos nuevos
     * @return Objeto de CalificacionTiendaEntity con los datos nuevos y su ID.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public CalificacionTiendaEntity createCalificacionTienda(CalificacionTiendaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una calificacion de tienda ");

        if (entity.getPuntaje() < 1.0 || entity.getPuntaje() > 5.0) {
            throw new BusinessLogicException("La calificacion registrada no es valida");
        }
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de CalificacionTienda.
     *
     * @param ct Instancia de CalificacionTiendaEntity con los nuevos datos.
     * @return Instancia de CalificacionTiendaEntity con los datos actualizados.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public CalificacionTiendaEntity updateCalificacionTienda(CalificacionTiendaEntity ct) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion de tienda ");
        if (ct == null) {
            throw new BusinessLogicException("La calificación a actualizar no puede ser null");
        }
        CalificacionTiendaEntity ccb = persistence.find(ct.getId());
        if (ccb == null) {
            throw new BusinessLogicException("No se puede actualizar una calificacion no registrada");
        }

        if (ct.getPuntaje() < 1 || ct.getPuntaje() > 5) {
            throw new BusinessLogicException("La calificacion registrada no es valida");
        }
        return persistence.update(ct);
    }

    /**
     * Elimina una instancia de CalificacionTienda de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public void deleteCalificacionTienda(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion tienda ");
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe una calificacion con el id dado");
        }
        persistence.delete(id);
    }
        
    /**
     * Retorna el cliente de la califiacion tienda
     *
     * @param calificacionTiendaId id de la calificacion tienda
     * @return cliente de la calificacion tienda con el id dado por parametro
     */
    public ClienteEntity getCliente(Long calificacionTiendaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente de la calificacion de tienda con id = {0}", calificacionTiendaId);
        return getCalificacionTienda(calificacionTiendaId).getCliente();
    }
    
    /**
     * Retorna el punto de venta de la califiacion tienda
     *
     * @param calificacionTiendaId id de la calificacion tienda
     * @return punto de venta de la calificacion tienda con el id dado por parametro
     */
    public PuntoDeVentaEntity getPuntoVenta(Long calificacionTiendaId){
        LOGGER.log(Level.INFO, "Inicia el proceso de consultar el punto de venta de la calificacion tienda con id = {0}", calificacionTiendaId);
        return getCalificacionTienda(calificacionTiendaId).getPuntoDeVenta();
    }
    
}
