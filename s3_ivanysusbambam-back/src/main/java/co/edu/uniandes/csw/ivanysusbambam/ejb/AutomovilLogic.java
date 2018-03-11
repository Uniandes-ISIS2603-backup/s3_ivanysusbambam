/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CompraPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MarcaPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ModelPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
/**
 * Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
*/
    @Inject
    private AutomovilPersistence persistence; 
   /**
    * variable para la persistencia del modelo del automovil
    */
    @Inject
    private ModelPersistence modeloPersistence;
    
/**
 * variable para la persistencia de la marca del automovil
 */
    @Inject
    private MarcaPersistence marcaPersistence;

    /**
     * variable para el punto de venta del automovil
     */
    @Inject
    private PuntoDeVentaPersistence puntoPersistence;
    
    /**
     * variable para la compra del automovil
     */
    @Inject
    private CompraPersistence compraPersistence;

    /**
     * Crea una nueva entidad del automovil y verifica las reglas de negocio
     * @param AE entidad de automovil que se quiere crear
     * @return la entidad del automovil que se creo
     * @throws BusinessLogicException si no se cumple las reglas de negocio necesarias para crear el automovil
     */
    public AutomovilEntity createAutomovil(AutomovilEntity AE) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de automovil");
        if (AE == null) {
            throw new BusinessLogicException("El Automovil no debe ser null");
        }
        if (AE.getId() == null )throw new BusinessLogicException("Ninguno de los atributos delautomovil puede ser null");
        
             if (AE.getPuntoDeVenta() == null || AE.getMarca() == null || AE.getModel() == null || AE.getCompra() == null) {
            throw new BusinessLogicException("Ninguno de los atributos delautomovil puede ser null");
        }
    

        if (AE.getId() <= 0) {
            throw new BusinessLogicException("El id no debería ser <= 0");
        }
        if (persistence.find(AE.getId()) != null) {
            throw new BusinessLogicException("El Automovil ya existe en la base de datos");
        }
        
        if (AE.getPuntoDeVenta().getId() == null){
            throw new BusinessLogicException("el id del punto de venta es null ");
        }
        if (AE.getPuntoDeVenta()== null){
            throw new BusinessLogicException("el punto de venta es nulo");
        }
        if (puntoPersistence.find(AE.getPuntoDeVenta().getId()) == null ) {
            throw new BusinessLogicException("El Punto de venta del automovil no esta registrado en la base de datos");
        }
        if (modeloPersistence.find(AE.getModel().getId()) == null) {
            throw new BusinessLogicException("El Modelo del automovil no está registrado en la base de datos");
        }
        
        if (marcaPersistence.find(AE.getMarca().getId()) == null) {
            throw new BusinessLogicException("la Marca del automovil no existe");
        }

        if (compraPersistence.find(AE.getCompra().getIdCompra())== null){
            throw new BusinessLogicException ("la compra asociada a este automovil no existe ");
        }

        
       //PREGUNTARLE A RUBBY COMO MANEJAR LA INFORMACION DE LAS PLACAS
        // Verifica la regla de negocio que dice que no puede haber dos automoviles con la misma placa ni con el mismo chasis
//        if (persistence.findByPlate(AE.getPlaca()) != null) {
//            throw new BusinessLogicException("Ya existe un automovil con placas \"" + AE.getPlaca() + "\"");
//        }
//
//        if (persistence.findBychasis(AE.getChasis()) != null) {
//            throw new BusinessLogicException("Ya existe un automovil con chasis \"" + AE.getChasis() + "\"");
//
//        }

        // Invoca la persistencia para crear el automovil 
        persistence.create(AE);
        LOGGER.info("Termina proceso de creación de automovil");
        return AE;
    }

    /**
     * retorna todos los automoviles en la persistencia 
     * @return
     */
    public List<AutomovilEntity> getAutomoviles() {

        return persistence.findAll();

    }

    /**
     * busca un automovil por su id
     * @param id del automovil que se quiere buscar
     * @return el automovil asociado al id dado por parametro
     * @throws BusinessLogicException si el id no es valido
     * 
     */
    public AutomovilEntity getAutomovil(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("Id no es valido");
        }
        return persistence.find(id);
    }

    /**
     * Actualiza un automovil que ya existe en la persistencia de automovil, y verifica que se sigan cumpliendo las reglas de negocio
     * @param AE entidad con la informacion para actualizar
     * @return la entidad del automovil actualizada 
     * @throws BusinessLogicException si se incumple alguna regla de negocio 
     */
    public AutomovilEntity updateAutomovil(AutomovilEntity AE) throws BusinessLogicException {

       if(AE == null) throw new BusinessLogicException("El Automovil no debe ser null");

        AutomovilEntity AEO = persistence.find(AE.getId());

        
        if(AEO == null) throw new BusinessLogicException("El automovil no existe");
        if(AE.getModel()== null || !AEO.getModel().equals(AE.getModel())) throw new BusinessLogicException("No se puede modificar el modelo");
        if(AE.getMarca() == null || !AEO.getMarca().equals(AE.getMarca())) throw new BusinessLogicException("No se puede verificar la marca");
        if(AE.getPuntoDeVenta()== null || !AEO.getPuntoDeVenta().equals(AE.getPuntoDeVenta())) throw new BusinessLogicException("No se puede modificar el punto de venta ");
               
        
        if(AE.getCompra() == null ||AEO.compararCompra(AE.getCompra()) != 0 ) throw new BusinessLogicException ("no se puede cambiar la compra ");

        

        //VERIFICA QUE EL FORMATO DE LA PLACA SEA VÁLIDO

        
//        if (verificarPlaca(AE.getPlaca()) == false) {
//            throw new BusinessLogicException("El formato de la placa es inválido");
//        }

        

        


//        if (persistence.findByPlate(AE.getPlaca()) != null) {
//            throw new BusinessLogicException("Ya existe un automovil con placas \"" + AE.getPlaca() + "\"");
//        }
//        if (persistence.findBychasis(AE.getChasis()) != null) {
//            throw new BusinessLogicException("Ya existe un automovil con chasis \"" + AE.getChasis() + "\"");
//        }
        return persistence.update(AE);
    }

    /**
     * Elimina un automovil de la persistencia
     * @param id entidad que se quiere eliminar
     * @throws BusinessLogicException si la entidad no es valida
     */
    public void deleteAutomovil(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Intentando aeliminar automovil con id: {0}",id);
        if(id == null) throw new BusinessLogicException("el id no puede ser null");
        AutomovilEntity AE = persistence.find(id);
        if(AE == null) throw new BusinessLogicException("No existe un automovil con la cédula dada.");
         persistence.delete(id);
    }

    /**
     * Busca un Automovil según su id.
     *
     * @param id del automovil que se busca.
     * @return el automovil buscado, null si no existe.
     * @throws BusinessLogicException si id == null o id no está en un formato
     * válido.
     */
    public  AutomovilEntity findAutomovil(Long id) throws BusinessLogicException {
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

//    /**
//     * Verifica que la placa contenga el formato valido - Tres letras iniciales,
//     * tres números al final-
//     *
//     * @param pla Placa a la que se le quiere verificar el formato
//     * @return True si la placa es válida
//     */
//    public boolean verificarPlaca(String pla) {
//
//        Boolean rta = false;
//        
//        if (pla.contains("[a-zA-Z]+") && pla.contains("[0-9]+")) {
//            rta = true;
//        }
//        return rta;
//    }

}
