/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MarcaPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ModelPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hd.castellanos
 */
@Stateless
public class AutomovilLogic {

    private static final Logger LOGGER = Logger.getLogger(AutomovilLogic.class.getName());

    @Inject
    private AutomovilPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private ModelPersistence modeloPersistence;

    @Inject
    private MarcaPersistence marcaPersistence;

    @Inject
    private PuntoDeVentaPersistence puntoPersistence;

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public AutomovilEntity createAutomovil(AutomovilEntity AE) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de automovil");
        if (AE == null) {
            throw new BusinessLogicException("El Automovil no debe ser null");
        }
        if (AE.getId() == null || AE.getPuntoDeVenta() == null || AE.getMarca() == null || AE.getModel() == null) {
            throw new BusinessLogicException("Ninguno de los atributos delautomovil puede ser null");
        }
        // VERIFICA QUE EL FORMATO DE LA PLACA SEA EL ADECUADO, PARA NO VIOLAR LA REGLA DE NEGOCIO
        if (verificarPlaca(AE.getPlaca())==false) {
            throw new BusinessLogicException("El formato de la placa no es el correcto");
        }

        if (AE.getId() <= 0) {
            throw new BusinessLogicException("El id no debería ser <= 0");
        }
        if (persistence.find(AE.getId()) != null) {
            throw new BusinessLogicException("El Automovil ya existe en la base de datos");
        }
        if (puntoPersistence.find(AE.getPuntoDeVenta().getId()) == null) {
            throw new BusinessLogicException("El Punto de venta del automovil no esta registrado en la base de datos");
        }
        if (modeloPersistence.find(AE.getModel().getId()) == null) {
            throw new BusinessLogicException("El Modelo del automovil no está registrado en la base de datos");
        }
        if (marcaPersistence.findByNombre(AE.getMarca().getNombre()) == null) {
            throw new BusinessLogicException("la Marca del automovil no existe");
        }

        // Verifica la regla de negocio que dice que no puede haber dos automoviles con la misma placa ni con el mismo chasis
   
        if (persistence.findByPlate(AE.getPlaca()) != null) {
            throw new BusinessLogicException("Ya existe un automovil con placas \"" + AE.getPlaca() + "\"");
        }

        if (persistence.findBychasis(AE.getChasis()) != null) {
            throw new BusinessLogicException("Ya existe un automovil con chasis \"" + AE.getChasis() + "\"");

        }

        // Invoca la persistencia para crear el automovil 
        persistence.create(AE);
        LOGGER.info("Termina proceso de creación de automovil");
        return AE;
    }

    /**
     *
     * @return
     */
    public List<AutomovilEntity> getAutomoviles() {

        return persistence.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public AutomovilEntity getAutomovil(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("Id no es valido");
        }
        return persistence.find(id);
    }

    /**
     *
     * @param AE
     * @return
     * @throws BusinessLogicException
     */
    public AutomovilEntity updateAutomovil(AutomovilEntity AE) throws BusinessLogicException {
        if (AE == null) {
            throw new BusinessLogicException("El prospecto de compra no debe ser null");
        }
        if (AE.getId() == null || AE.getId() <= 0) {
            throw new BusinessLogicException("El id del prospecto de compra ");
        }
        AutomovilEntity AEO = persistence.find(AE.getId());
        
        //VERIFICA QUE EL FORMATO DE LA PLACA SEA VÁLIDO
        
        if (verificarPlaca(AE.getPlaca()) == false) {
            throw new BusinessLogicException("El formato de la placa es inválido");
        }
        if (AEO == null) {
            throw new BusinessLogicException("El prospecto de compra no existe");
        }

        if (AE.getModel() == null || !AEO.getModel().equals(AE.getModel())) {
            throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
        }
        if (AE.getMarca() == null || !AEO.getMarca().equals(AE.getMarca())) {
            throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
        }
        if (AE.getPuntoDeVenta() == null || !AEO.getPuntoDeVenta().equals(AE.getPuntoDeVenta())) {
            throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
        }

        if (persistence.findByPlate(AE.getPlaca()) != null) {
            throw new BusinessLogicException("Ya existe un automovil con placas \"" + AE.getPlaca() + "\"");
        }
        if (persistence.findBychasis(AE.getChasis()) != null) {
            throw new BusinessLogicException("Ya existe un automovil con chasis \"" + AE.getChasis() + "\"");
        }
        return persistence.update(AE);
    }

    /**
     *
     * @param entity
     * @throws BusinessLogicException
     */
    public void deleteAutomovil(AutomovilEntity entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("el automovil no puede ser nulo");
        }
        LOGGER.log(Level.INFO, "Inicia proceso de borrar automovil con id={0}", entity.getId());
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar automovil con id={0}", entity.getId());
    }

    /**
     * Busca un Automovil según su id.
     *
     * @param id del automovil que se busca.
     * @return el automovil buscado, null si no existe.
     * @throws BusinessLogicException si id == null o id no está en un formato
     * válido.
     */
    public AutomovilEntity findAutomovil(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("id no valido");
        }
        return persistence.find(id);
    }

    /**
     * Busca todos los automoviles con un color dado.
     *
     * @param color color que se busca.
     * @return todos los cutomoviles con el color dado.
     * @throws BusinessLogicException Si color == null .
     */
    public List<AutomovilEntity> findAutomovilByColor(String color) throws BusinessLogicException {
        if (color == null) {
            throw new BusinessLogicException("El color no puede ser null");
        }

        return persistence.findByColor(color);
    }

    /**
     * Busca un automovil con la placa dada.
     *
     * @param placa placa que se busca.
     * @return el automovil con la placa dado.
     * @throws BusinessLogicException Si placa == null
     */
    public AutomovilEntity findAutomovilByPlate(String placa) throws BusinessLogicException {
        if (placa == null) {
            throw new BusinessLogicException("la placa no puede ser null");
        }

        return persistence.findByPlate(placa);
    }

    /**
     * Busca un automovil con el chasis dada.
     *
     * @param chasis chasis que se busca.
     * @return el automovil con el chasis dado.
     * @throws BusinessLogicException Si chasis == null
     */
    public AutomovilEntity findAutomovilByChasis(Integer chasis) throws BusinessLogicException {
        if (chasis == null) {
            throw new BusinessLogicException("el chasis no puede ser null");
        }

        return persistence.findBychasis(chasis);
    }

    /**
     * Verifica que la placa contenga el formato valido - Tres letras iniciales,
     * tres números al final-
     *
     * @param pla Placa a la que se le quiere verificar el formato
     * @return True si la placa es válida
     */
    public boolean verificarPlaca(String pla) {

        Boolean rta = false;
        if (pla.contains("[a-zA-Z]+") && pla.contains("[0-9]+")) {
            rta = true;
        }
        return rta;
    }

}
