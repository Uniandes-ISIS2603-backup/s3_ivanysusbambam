/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
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
    
    private static final Logger LOGGER = Logger.getLogger(CalificacionTiendaLogic.class.getName());
        
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
     * Obtiene los datos de una instancia de CalificacionTienda a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CalificacionTiendaEntity con los datos de la calificacion consultada.
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
     */
    public CalificacionTiendaEntity createCalificacionTienda(CalificacionTiendaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una calificacion de tienda ");
        
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de CalificacionTienda.
     *
     * @param entity Instancia de CalificacionTiendaEntity con los nuevos datos.
     * @return Instancia de CalificacionTiendaEntity con los datos actualizados.
     */
    public CalificacionTiendaEntity updateCalificacionTienda(CalificacionTiendaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion de tienda ");
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de CalificacionTienda de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteCalificacionTienda(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion tienda ");
        persistence.delete(id);
    }
    
    public ClienteEntity getCliente(Long calificacionTiendaId){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente de la calificacion de tienda con id = {0}", calificacionTiendaId);
        return getCalificacionTienda(calificacionTiendaId).getCliente();
    }
    
}
