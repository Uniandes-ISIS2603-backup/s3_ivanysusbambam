/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ModelPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Joseph ortiz
 *
 */
@Stateless
public class ModelLogic {

    @Inject
    private ModelPersistence persistence;

    @Inject
    private AutomovilLogic automovilLogic;

    private static final Logger LOG = Logger.getLogger(ModelLogic.class.getName());

    /**
     * Persiste un modelo en la base de datos.
     *
     * @param mdl el model entity que se busca persistir
     * @return el modelo ya persistido
     * @throws BusinessLogicException Si el modelo tiene datos null o el número
     * de puertas es inferior a 2.
     */
    public ModelEntity createModel(ModelEntity mdl) throws BusinessLogicException {
      if (persistence.find(mdl.getId()) != null) {
            throw new BusinessLogicException("Ya existe un modelo igual al que se quiere agregar");
        }
        if (mdl.getTransmision() == null) {
            throw new BusinessLogicException("La transimisión no puede ser null");
        }
        if (mdl.getCentCubicos() == null) {
            throw new BusinessLogicException("Los centimetros cúbicos no pueden ser null");
        }
        if (mdl.getNumeroPuertas() == null) {
            throw new BusinessLogicException("El número de puertas no puede ser null");
        }
        if (mdl.getNumeroPuertas() < 2) {
            throw new BusinessLogicException("El número de puertas no puede ser inferior a 2");
        }
        return persistence.create(mdl);
    }

    /**
     * Consulta todos los modelos registrados en la base de datos.
     *
     * @return lista con todos los modelos registrados en la base de datos, null
     * si no hay ninguno.
     */
    public List<ModelEntity> findAllModels() {
        LOG.info("consultando todos los modelos");
        return persistence.findAll();
    }

    /**
     * Actualiza el modelo que se pasa por parámetro.
     *
     * @param mdl modelo con la información actualizada.
     * @return el modelo que se acaba de actualizar.
     * @throws BusinessLogicException si el modelo a actualizar no existe o si
     * el cilindraje es cero.
     */
    public ModelEntity updateModel(ModelEntity mdl) throws BusinessLogicException {
        LOG.log(Level.INFO, "Actualizando el carro con cilindraje: {0}", mdl.getCilindraje());
        ModelEntity md = persistence.find(mdl.getId());

        if (md == null) {
            throw new BusinessLogicException("El modelo que se quiere actualizar no existe en la base de datos");
        }
        return persistence.update(mdl);
    }

    /**
     * Elimina el modelo con cilindraje dado por parametro
     *
     * @param id id del modelo que se quiere eliminar.
     * @throws BusinessLogicException si el modelo que se busca eliminar no
     * existe o si el cilindraje dado == null.
     */
    public void deleteModel(Long id) throws BusinessLogicException {
        LOG.log(Level.INFO, "Intentando eliminar modelo con cédula: {0}", id);
        ModelEntity mdlo = persistence.find(id);
        if (mdlo == null) {
            throw new BusinessLogicException("No existe un modelo con el cilindraje dado.");
        }
        persistence.delete(id);
    }

    /**
     * Busca un modelo por cilindraje
     *
     * @param id cilindraje del modelo que se busca.
     * @return el modelo buscado, null si no existe.
     * @throws BusinessLogicException si cil == null.
     */
    public ModelEntity findModel(Long id) throws BusinessLogicException {
        if (id == null) {
            throw new BusinessLogicException("El id no puede ser null");
        }
        return persistence.find(id);
    }

    /**
     * Busca todos los modelos según cierto tipo de transmisión
     *
     * @param transm tipo de transmisión que se busca.
     * @return todos los modelos con la transmision dada.
     * @throws BusinessLogicException Si transmi == null
     */
    public List<ModelEntity> findModelByTransm(String transm) throws BusinessLogicException {
        if (transm == null) {
            throw new BusinessLogicException("La transmisión no puede ser null");
        }
        return persistence.findByTransm(transm);
    }

    /**
     * Busca todos los modelos con cierto numero de puertas.
     *
     * @param puertas numero de puertas.
     * @return todos los modelos con el numero de puertas.
     * @throws BusinessLogicException Si puertas == 0 o menor que 2
     */
    public List<ModelEntity> findModelByPuertas(Integer puertas) throws BusinessLogicException {
        if (puertas < 2) {
            throw new BusinessLogicException("El numero de puertas no puede ser inferior a dos");
        }
        return persistence.findByPuertas(puertas);
    }

}
