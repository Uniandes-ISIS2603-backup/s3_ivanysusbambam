/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
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

    /**
     * Constante para el Logger
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionCarroLogic.class.getName());

    /**
     * Atributo para la persistencia de calificacionCarro
     */
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
     * @return Instancia de CalificacionCarroEntity con los datos de la
     * calificacion consultada.
     */
    public CalificacionCarroEntity getCalificacionCarro(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion carro con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Se encarga de crear una CalificacionCarro en la base de datos.
     *
     * @param cc Objeto de CalificacionCarroEntity con los datos nuevos
     * @return Objeto de CalificacionCarroEntity con los datos nuevos y su ID.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public CalificacionCarroEntity createCalificacionCarro(CalificacionCarroEntity cc) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una calificacion de carro ");

        if (cc.getPuntaje() < 1.0 || cc.getPuntaje() > 5.0) {
            throw new BusinessLogicException("La calificacion registrada no es valida");
        }
        return persistence.create(cc);
    }

    /**
     * Actualiza la información de una instancia de CalificacionCarro.
     *
     * @param cc Instancia de CalificacionCarroEntity con los nuevos datos.
     * @return Instancia de CalificacionCarroEntity con los datos actualizados.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public CalificacionCarroEntity updateCalificacionCarro(CalificacionCarroEntity cc) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion de carro ");
        if (cc == null) {
            throw new BusinessLogicException("La calificación a actualizar no puede ser null");
        }

        CalificacionCarroEntity ccb = persistence.find(cc.getId());
        if (ccb == null) {
            throw new BusinessLogicException("No se puede actualizar una calificacion no registrada");
        }

        if (cc.getPuntaje() < 1 || cc.getPuntaje() > 5) {
            throw new BusinessLogicException("La calificacion registrada no es valida");
        }

        return persistence.update(cc);
    }

    /**
     * Elimina una instancia de CalificacionCarro de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public void deleteCalificacionCarro(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion de carro ");
        if (id == null) {
            throw new BusinessLogicException("El id no puede ser null");
        }
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No existe una calificacion con el id dado");
        }
        persistence.delete(id);
    }
}
