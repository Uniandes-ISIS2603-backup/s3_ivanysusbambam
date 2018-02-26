/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionCarroPersistence;
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
public class CalificacionCarroLogic {

    private static final Logger LOGGER = Logger.getLogger(CalificacionTiendaLogic.class.getName());

    @Inject
    CalificacionCarroPersistence persistence;

    /**
     * Obtiene la lista de las calificaciones de los autos.
     *
     * @return Colección de objetos de CalificacionCarroEntity.
     */
    public List<CalificacionCarroEntity> getCalificacionesCarro() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las calificaciones de carros");
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de CalificacionCarro a partir de su
     * ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CalificacionCarroEntity con los datos de la calificacion
     * consultada.
     */
    public CalificacionCarroEntity getCalificacionCarro(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion carro con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Se encarga de crear una CalificacionCarro en la base de datos.
     *
     * @param entity Objeto de CalificacionCarroEntity con los datos nuevos
     * @return Objeto de CalificacionCarroEntity con los datos nuevos y su ID.
     */
    public CalificacionCarroEntity createCalificacionCarro(CalificacionCarroEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una calificacion de carro ");

        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de CalificacionCarro.
     *
     * @param entity Instancia de CalificacionCarroEntity con los nuevos datos.
     * @return Instancia de CalificacionCarroEntity con los datos actualizados.
     */
    public CalificacionCarroEntity updateCalificacionCarro(CalificacionCarroEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion de carro ");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de CalificacionTienda de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteCalificacionTienda(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion de carro ");
        persistence.delete(id);
    }
    
    public VentaEntity getVenta(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la venta de la calificacion de carro con id = {0}", id);
        return getCalificacionCarro(id).getVenta();
    }
}
