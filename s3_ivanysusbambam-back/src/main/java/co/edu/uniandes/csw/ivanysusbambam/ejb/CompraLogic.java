/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CompraPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VendedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juliana
 */
@Stateless
public class CompraLogic {

    @Inject
    private CompraPersistence compraPersistence;

    @Inject
    private ClientePersistence clientePersistence;

    @Inject
    private VendedorPersistence vendedorPersistence;
    
    @Inject
    private PuntoDeVentaPersistence puntoDeVentaPersistence;

    public CompraEntity crearCompra(CompraEntity compra) throws BusinessLogicException {

        if (compraPersistence.find(compra.getIdCompra()) != null) {
            throw new BusinessLogicException("Ya existe una compra con ese id");
        }
        if (compra.getCliente() == null) {
            throw new BusinessLogicException("El cliente no puede ser null");
        }
        if (compra.getCliente().getCedula() == null) {
            throw new BusinessLogicException("La cédula del cliente no puede ser null");
        }
        if (clientePersistence.find(compra.getCliente().getCedula()) == null) {
            throw new BusinessLogicException("El cliente no esta registrado en el sistema");
        }
        if (compra.getVendedorEncargado() == null) {
            throw new BusinessLogicException("El vendedoer no puede ser null");
        }
        if (compra.getVendedorEncargado().getCarnetVendedor() == null) {
            throw new BusinessLogicException("El carnet del vendedor no puede ser null");
        }
        if (vendedorPersistence.find(compra.getVendedorEncargado().getCarnetVendedor()) == null) {
            throw new BusinessLogicException("El vendedor encargado no es valido");
        }
        if(compra.getPuntoDeVenta() == null){
             throw new BusinessLogicException("El punto de venta no puede ser null");
        }
        if(compra.getPuntoDeVenta().getId() == null){
             throw new BusinessLogicException("El id del punto de venta no puede ser null");
        }
        if(puntoDeVentaPersistence.find(compra.getPuntoDeVenta().getId())==null)
       {
             throw new BusinessLogicException("El punto de venta no es valido"); 
       }

        compraPersistence.create(compra);
        return compra;
    }

    public void deleteCompra(Integer idCompra) throws BusinessLogicException {
        
        
        if (idCompra == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }
        if (compraPersistence.find(idCompra) == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }

        compraPersistence.delete(idCompra);
    }

    public CompraEntity findCompra(Integer id) throws BusinessLogicException {
       CompraEntity compra = compraPersistence.find(id);
        if(compra == null){
            throw new BusinessLogicException("la compra no puede ser null");
        }
        
   return compra;
    }

    public List<CompraEntity> findAll() {
        return compraPersistence.findAll();
    }

    public CompraEntity updateCompra(CompraEntity compra) throws BusinessLogicException {
        if (compra == null) {
            throw new BusinessLogicException("No se pueden actualizar valores nulos");
        }
        if (compraPersistence.find(compra.getIdCompra()) == null) {
            throw new BusinessLogicException("La compra no existe en la base de datos");
        }

        return compraPersistence.update(compra);
    }

}
