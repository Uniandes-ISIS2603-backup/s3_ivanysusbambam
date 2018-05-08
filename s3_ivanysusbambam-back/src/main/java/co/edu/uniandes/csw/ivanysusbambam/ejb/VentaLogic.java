/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MedioDePagoPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VendedorPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VentaPersistence;
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
public class VentaLogic {

    private static final Logger LOGGER = Logger.getLogger(VentaLogic.class.getName());

    @Inject
    private VentaPersistence persistence;

    @Inject
    private VendedorPersistence vendedorPersistence;

    @Inject
    private ClientePersistence clientePersistence;

    @Inject
    private AutomovilPersistence automovilPersistence;

    @Inject
    private PuntoDeVentaPersistence puntoPersistence;

    @Inject
    private MedioDePagoPersistence medioPersistence;

    /**
     * Crea un prospecto de compra.
     *
     * @param entity prospecto de compra que se quiere añadir
     * @return el prospecto de compra recién añadido.
     * @throws BusinessLogicException si el id, cliente, vendedor, o automóvil
     * del cliente no existe o es inválido.
     */
    public VentaEntity createVenta(VentaEntity entity) throws BusinessLogicException {
       
          
        

        if (entity.getCliente().getCedula() == null) {
            throw new BusinessLogicException("La cédula del cliente no puede ser null");
        }

        if (entity.getPuntoDeVenta().getId() == null) {
            throw new BusinessLogicException("El id del punto de venta no puede ser null");
        }

        if (clientePersistence.find(entity.getCliente().getCedula()) == null) {
            throw new BusinessLogicException("El cliente de la venta no está registrado en la base de datos");
        }
        if (automovilPersistence.find(entity.getAutomovil().getId()) == null) {
            throw new BusinessLogicException("El automóvil de la venta no existe");
        }
        if (puntoPersistence.find(entity.getPuntoDeVenta().getId()) == null) {
            throw new BusinessLogicException("El punto de venta de la venta no existe");
        }

        if (medioPersistence.find(entity.getMedioDePago().getNumero()) == null) {
            throw new BusinessLogicException("El medio de pago de esta venta no existe ");
        }
        return persistence.create(entity);
    }

    /**
     * Obtiene todos los prospectos de compra.
     *
     * @return listado con todos los prospectos de compra registrados en la bd.
     */
    public List<VentaEntity> findAllVentas() {
        return persistence.findAll();
    }

    /**
     * Actualiza un prospecto de compra.
     *
     * @param entity prospecto de compra con la información actualizada.
     * @return prospecto de compra actualizado.
     * @throws BusinessLogicException si pc == null o no existe el prospecto de
     * compra buscado en la BD o se intentó modificar algo distinto al texto del
     * prospecto de compra.
     */
    public VentaEntity updateVenta(VentaEntity entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("La venta no debe ser null");
        }
        if (entity.getId() == null || entity.getId() <= 0) {
            throw new BusinessLogicException("El id de la venta no es valido ");
        }
        VentaEntity newEntity = persistence.find(entity.getId());

        if (newEntity == null) {
            throw new BusinessLogicException("La venta no existe");
        }
        if (entity.getAutomovil() == null || !newEntity.getAutomovil().equals(entity.getAutomovil())) {
            throw new BusinessLogicException("No se puede modificar el automovil asociado a la venta");
        }
        if (entity.getCliente() == null || !newEntity.getCliente().equals(entity.getCliente())) {
            throw new BusinessLogicException("No se puede modificar el cliente asociado a la venta");
        }
        if (entity.getVendedorEncargado() == null || !newEntity.getVendedorEncargado().equals(entity.getVendedorEncargado())) {
            throw new BusinessLogicException("No se puede modificar el vendedor adociado a la  venta");
        }
        if (entity.getPuntoDeVenta() == null || !newEntity.getPuntoDeVenta().equals(entity.getPuntoDeVenta())) {
            throw new BusinessLogicException("No se puede modificar el punto de venta asociado a la  venta");
        }        
    //    if (entity.getMedioDePago() == null || !newEntity.getMedioDePago().equals(entity.getMedioDePago())) {
      //      throw new BusinessLogicException("No se puede modificar el medio de pago asociado a la  venta");
        //}

        return persistence.update(entity);
    }

    /**
     * Elimina una venta.
     *
     * @param id la venta que se busca eliminar de la BD.
     * @throws BusinessLogicException si pc == null o si el prospecto de compra
     * no existe en la BD.
     */
    public void deleteVenta(Long id) throws BusinessLogicException {

        LOGGER.log(Level.INFO, "Intentando aeliminar venta con id: {0}", id);
        if (id == null) {
            throw new BusinessLogicException("el id no puede ser null");
        }
        VentaEntity entity = persistence.find(id);
        if (entity == null) {
            throw new BusinessLogicException("No existe una venta el id dado.");
        }
        persistence.delete(id);
    }

    /**
     * Busca un prospecto de compra según su PK.
     *
     * @param id el id del prospecto de compra que se busca.
     * @return el prospecto de compra buscado o null si no se encuentra en la
     * BD.
     * @throws BusinessLogicException si el id pasado por parámetro es null o <=
     * 0
     */
    public VentaEntity findVenta(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("El id pasado por parámetro es inválido");
        }

        return persistence.find(id);
    }

}
