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

    /**
     * Atributo para la persistencia de la compra
     */
    @Inject
    private CompraPersistence compraPersistence;

    /**
     * Atributo para la persistencia del cliente
     */
    @Inject
    private ClientePersistence clientePersistence;

    /**
     * Atributo para la persistencia del vendedor
     */
    @Inject
    private VendedorPersistence vendedorPersistence;

    /**
     * Atributo para la persistencia del punto de venta
     */
    @Inject
    private PuntoDeVentaPersistence puntoDeVentaPersistence;

    /**
     * Crean una nueva compra
     *
     * @param compra entidad de la compra a crear
     * @return retorna la compra creada
     * @throws BusinessLogicException si la compra no cumple con las reglas de
     * negocio
     */
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
        if (compra.getPuntoDeVenta() == null) {
            throw new BusinessLogicException("El punto de venta no puede ser null");
        }
        if (compra.getPuntoDeVenta().getId() == null) {
            throw new BusinessLogicException("El id del punto de venta no puede ser null");
        }
        if (puntoDeVentaPersistence.find(compra.getPuntoDeVenta().getId()) == null) {
            throw new BusinessLogicException("El punto de venta no es valido");
        }

        compraPersistence.create(compra);
        return compra;
    }

    /**
     * Elimina la compra con el id dado por parametro
     *
     * @param idCompra id de la compra a eliminar
     * @throws BusinessLogicException si la compra no existe en la base de datos
     */
    public void deleteCompra(Integer idCompra) throws BusinessLogicException {

        if (idCompra == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }
        if (compraPersistence.find(idCompra) == null) {
            throw new BusinessLogicException("No exixte una compra con ese numero");
        }

        compraPersistence.delete(idCompra);
    }

    /**
     * Busca una compra por el id dado por parametro
     *
     * @param id id de la compra a buscar
     * @return la compra con el id dado por parametro
     * @throws BusinessLogicException si la compra no esta en la base de datos
     */
    public CompraEntity findCompra(Integer id) throws BusinessLogicException {
        CompraEntity compra = compraPersistence.find(id);
        if (compra == null) {
            throw new BusinessLogicException("la compra no puede ser null");
        }

        return compra;
    }

    /**
     * @return todas las compras en la base de datos
     */
    public List<CompraEntity> findAll() {
        return compraPersistence.findAll();
    }

    /**
     * Actualiza la informacion de una compra en la base de datos
     *
     * @param compra entidad con la nueva informacion de la comrpa
     * @return la compra con la informacion actualizada
     * @throws BusinessLogicException si la compra no exite o no cumple las
     * reglas de negocio
     */
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
