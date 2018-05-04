/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.QuejaReclamoPersistence;
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
public class QuejaReclamoLogic 
{
    
    
      private static final Logger LOGGER = Logger.getLogger(QuejaReclamoLogic.class.getName());

    @Inject
    private QuejaReclamoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject ClientePersistence clientePersistence;
    
    /**
     * Crea un prospecto de compra.
     * @param QR prospecto de compra que se quiere añadir 
     * @return el prospecto de compra recién añadido.
     * @throws BusinessLogicException si el id, cliente, vendedor, o automóvil del cliente no existe o es inválido.
     */
    public QuejaReclamoEntity createQuejaReclamo(QuejaReclamoEntity QR) throws BusinessLogicException{
        if(QR == null) throw new BusinessLogicException("La quejaReclamo no debe ser null");
        
         //TODO: no hay que revisar el id porque es la PK y no se ha creado
        
        
        if(QR.getId()<=0) throw new BusinessLogicException("EL id no debería ser <= 0");
        if(persistence.find(QR.getId()) != null) throw new BusinessLogicException("la QuejaReclamo ya existe en la base de datos");
        if(clientePersistence.find(QR.getCliente().getCedula()) == null) throw new BusinessLogicException("El cliente de la quejaReclamo no está registrado en la base de datos");
        return persistence.create(QR);
    }
    
    /**
     * Obtiene todos los prospectos de compra.
     * @return listado con todos los prospectos de compra registrados en la bd.
     */
    public List<QuejaReclamoEntity> findAllQuejasReclamos(){
        return persistence.findAll();
    } 
    
    /**
     * Actualiza un prospecto de compra.
     * @param QR prospecto de compra con la información actualizada.
     * @return prospecto de compra actualizado.
     * @throws BusinessLogicException si pc == null o no existe el prospecto de compra buscado en la BD o se intentó modificar algo distinto al texto del prospecto de compra.
     */
    public QuejaReclamoEntity updateQuejaReclamo(QuejaReclamoEntity QR) throws BusinessLogicException{
        if(QR == null) throw new BusinessLogicException("La quejaReclamo no debe ser null");
        if(QR.getId() == null || QR.getId()<=0) throw new BusinessLogicException("El id de la quejaREclamo no es valido ");
        QuejaReclamoEntity QRO = persistence.find(QR.getId());
        
        if(QRO == null) throw new BusinessLogicException("La quejaReclamo no existe");
        if(QR.getCliente() == null || !QRO.getCliente().equals(QR.getCliente())) throw new BusinessLogicException("Sólo se puede cambiar el texto de la quejaReclamo");
        
        return persistence.update(QR);
    }
    
    /**
     * Elimina un prospecto de compra. 
     * @param id el prospecto de compra que se busca eliminar de la BD.
     * @throws BusinessLogicException si pc == null o si el prospecto de compra no existe en la BD.
     */
    public void deleteQuejaReclamo(Long  id) throws BusinessLogicException{
        
           LOGGER.log(Level.INFO, "Intentando eliminar quejaReclamo con id: {0}", id);
        if (id == null) {
            throw new BusinessLogicException("el id no puede ser null");
        }
        QuejaReclamoEntity QRE = persistence.find(id);
        if (QRE == null) {
            throw new BusinessLogicException("No existe una quejaReclamo el id dado.");
        }
        persistence.delete(id);
    }

    /**
     * Busca un prospecto de compra según su PK.
     * @param id el id del prospecto de compra que se busca.
     * @return el prospecto de compra buscado o null si no se encuentra en la BD.
     * @throws BusinessLogicException si el id pasado por parámetro es null o <= 0
     */
    public QuejaReclamoEntity findQuejaReclamo(Long id) throws BusinessLogicException{
        if(id == null || id<= 0)throw new BusinessLogicException("El id pasado por parámetro es inválido");
        
        return persistence.find(id);
    }
    
    
    
    
    
}
