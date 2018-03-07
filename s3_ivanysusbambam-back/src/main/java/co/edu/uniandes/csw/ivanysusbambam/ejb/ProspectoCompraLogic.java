/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ProspectoCompraPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VendedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author f.velasquez
 */
@Stateless
public class ProspectoCompraLogic {
    
    @Inject
    private ProspectoCompraPersistence persistence;
    
    @Inject
    private VendedorPersistence vendedorPersistence;
    
    @Inject
    private ClientePersistence clientePersistence;
    
    @Inject
    private AutomovilPersistence automovilPersistence;
   
    /**
     * Crea un prospecto de compra.
     * @param pc prospecto de compra que se quiere añadir 
     * @return el prospecto de compra recién añadido.
     * @throws BusinessLogicException si el id, cliente, vendedor, o automóvil del cliente no existe o es inválido.
     */
    public ProspectoCompraEntity createProspectoCompra(ProspectoCompraEntity pc) throws BusinessLogicException{
        if(pc == null) throw new BusinessLogicException("El prospecto de compra no debe ser null");
        if(pc.getId() == null || pc.getVendedor() == null || pc.getCliente() == null || pc.getAutomovil() == null) throw new BusinessLogicException("Ninguno de los atributos del prospecto de compra puede ser null"); 

        
        if(pc.getId()<=0) throw new BusinessLogicException("EL id no debería ser <= 0");
        if(persistence.find(pc.getId()) != null) throw new BusinessLogicException("El prospecto de compra ya existe en la base de datos");
        if(pc.getVendedor().getCarnetVendedor() == null||vendedorPersistence.find(pc.getVendedor().getCarnetVendedor()) == null) throw new BusinessLogicException("El vendedor del prospecto de compra no esta registrado en la base de datos o es null"); 
        
        if(pc.getCliente().getCedula() == null || clientePersistence.find(pc.getCliente().getCedula()) == null) throw new BusinessLogicException("El cliente del prospecto de compra no está registrado en la base de datos o es null");
        if(pc.getAutomovil().getId() == null || automovilPersistence.find(pc.getAutomovil().getId()) == null) throw new BusinessLogicException("El automóvil del prospecto de compra no existe o es null");
        return persistence.create(pc);
    }
    
    /**
     * Obtiene todos los prospectos de compra.
     * @return listado con todos los prospectos de compra registrados en la bd.
     */
    public List<ProspectoCompraEntity> findAllProspectosCompra(){
        return persistence.findAll();
    } 
    
    /**
     * Actualiza un prospecto de compra.
     * @param pc prospecto de compra con la información actualizada.
     * @return prospecto de compra actualizado.
     * @throws BusinessLogicException si pc == null o no existe el prospecto de compra buscado en la BD o se intentó modificar algo distinto al texto del prospecto de compra.
     */
    public ProspectoCompraEntity updateProspectoCompra(ProspectoCompraEntity pc) throws BusinessLogicException{
        if(pc == null) throw new BusinessLogicException("El prospecto de compra no debe ser null");
        if(pc.getId() == null || pc.getId()<=0) throw new BusinessLogicException("El id del prospecto de compra ");
        ProspectoCompraEntity pco = persistence.find(pc.getId());
        
        if(pco == null) throw new BusinessLogicException("El prospecto de compra no existe");
        if(pc.getAutomovil() == null || !pco.getAutomovil().equals(pc.getAutomovil())) throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
        if(pc.getCliente() == null || !pco.getCliente().equals(pc.getCliente())) throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
        if(pc.getVendedor() == null || !pco.getVendedor().equals(pc.getVendedor())) throw new BusinessLogicException("Sólo se puede cambiar el texto del prospecto");
       
        return persistence.update(pc);
    }
    
    /**
     * Elimina un prospecto de compra. 
     * @param pc el prospecto de compra que se busca eliminar de la BD.
     * @return el prospecto de compra eliminado.
     * @throws BusinessLogicException si pc == null o si el prospecto de compra no existe en la BD.
     */
    public ProspectoCompraEntity deleteProspectoCompra(Long  pc) throws BusinessLogicException{
        
        if(pc == null) throw new BusinessLogicException("El prospecto de compra que se quiere eliminar no debe ser null");
       
        if(persistence.find(pc)==null) throw new BusinessLogicException("El prospecto que se busca eliminar no existe");
        return persistence.delete(pc);
    }

    /**
     * Busca un prospecto de compra según su PK.
     * @param id el id del prospecto de compra que se busca.
     * @return el prospecto de compra buscado o null si no se encuentra en la BD.
     * @throws BusinessLogicException si el id pasado por parámetro es null o <= 0
     */
    public ProspectoCompraEntity findProspectoCompra(Long id) throws BusinessLogicException{
        if(id == null || id<= 0)throw new BusinessLogicException("El id pasado por parámetro es inválido");
        
        return persistence.find(id);
    }
    
    /**
     * Busca todos los prospectos de compra relacionados al vendedor dado por parámetro.
     * @param ve vendedor del que se quieren consultar los prospectos de compra.
     * @return lista con todos los prospectos de compra relacionados al vendedor o null si no hay ninguno.
     * @throws BusinessLogicException si el ve == null o ve no se encuentra registrado en la BD.
     */
    public List<ProspectoCompraEntity> findProspectoCompraByVendedor(VendedorEntity ve) throws BusinessLogicException{
        
        if(ve == null || vendedorPersistence.find(ve.getCarnetVendedor()) == null) throw new BusinessLogicException("El vendedor con el que está buscando no se encuentra registrado en la BD.");
        
        return persistence.findByVendedor(ve);
    }
    
    /**
     * Busca todos los prospectos de compra relacionados a un cliente
     * @param ce cliente del que se quieren condultar los prospectos de compra.
     * @return lista con todos los prospectos de compra relacionados al cliente o null si no hay ninguno.
     * @throws BusinessLogicException si ce == null o no se encuentra registrado en le BD.
     */
    public List<ProspectoCompraEntity> findProspectoCompraByCliente(ClienteEntity ce) throws BusinessLogicException{
        if(ce == null || clientePersistence.find(ce.getCedula()) == null) throw new BusinessLogicException("El cliente que se busca no esta en la BD)");
        return persistence.findByCliente(ce);
    }
    
    public List<ProspectoCompraEntity> findProspectoCompraByAutomovil(AutomovilEntity ae) throws BusinessLogicException{
        if(ae == null || automovilPersistence.find(ae.getId())==null) throw new BusinessLogicException("El automóvil que se busca no se encuentra en la BD.");
        return persistence.findByAutomovil(ae);
    }
}
