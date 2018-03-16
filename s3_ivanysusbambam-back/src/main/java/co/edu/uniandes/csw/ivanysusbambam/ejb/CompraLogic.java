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

    //TODO: Esta variable no se usa. Borrarla
    @Inject
    private ClientePersistence clientePersistence;

    @Inject   //TODO: Esta variable no se usa. Borrarla
    private VendedorPersistence vendedorPersistence;
    //TODO: Esta variable no se usa. Borrarla   
    @Inject
    private PuntoDeVentaPersistence puntoDeVentaPersistence;

    public CompraEntity crearCompra(CompraEntity compra) throws BusinessLogicException {
//        if (compraPersistence.find(compra.getIdCompra())!=null)
//        {
//            throw new BusinessLogicException("Ya existe una compra con ese id");
//        }
//        if(clientePersistence.find(compra.getCliente().getCedula())==null)
//        {
//            throw new BusinessLogicException("El cliente no esta registrado en el sistema");
//        }
//        if(vendedorPersistence.find(compra.getVendedorEncargado().getCarnetVendedor())==null)
//        {
//            throw new BusinessLogicException("El vendedor encargado no es valido"); 
//        }
//        if(puntoDeVentaPersistence.find(compra.getPuntoDeVenta().getId())==null)
//        {
//             throw new BusinessLogicException("El punto de venta no es valido"); 
//        }
// TODO: No hay reglas de negocio sobre lso atributos básicos?
        compraPersistence.create(compra);
        return compra;
    }

    public void deleteCompra(Integer idCompra) throws BusinessLogicException {
        if (compraPersistence.find(idCompra) == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }
        if (idCompra == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }

        compraPersistence.delete(idCompra);
    }

    public CompraEntity findCompra(Integer id) throws BusinessLogicException {
        CompraEntity compra = compraPersistence.find(id);
        if (compra == null) {
            throw new BusinessLogicException("No exixte una compra con ese id");
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
