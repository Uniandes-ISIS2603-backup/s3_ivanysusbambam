/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionCarroPersistence;
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

    private static final Logger LOG = Logger.getLogger(VentaLogic.class.getName());

    @Inject
    private CalificacionCarroPersistence calificacionPersistence;

    /**
     * Crea un prospecto de venta.
     *
     * @param VE prospecto de venta que se quiere añadir
     * @return el prospecto de venta recién añadido.
     * @throws BusinessLogicException si el id, cliente, vendedor, o automóvil
     * del cliente no existe o es inválido.
     */
    public VentaEntity createVenta(VentaEntity VE) throws BusinessLogicException {
        LOG.log(Level.INFO, "inicia proceso de creacion de venta",VE.getId());
        LOG.log(Level.INFO, "cliente de venta", VE.getCliente());
        LOG.log(Level.INFO, "automovil de venta", VE.getAutomovil());
        LOG.log(Level.INFO, "medio de pago de venta", VE.getMedioDePago());
        LOG.log(Level.INFO, "vendedor de venta", VE.getVendedorEncargado());
        LOG.log(Level.INFO, "punto de venta de venta ", VE.getPuntoDeVenta());
        if (VE == null) {
            throw new BusinessLogicException("La venta no debe ser null");
        }
        if (VE.getVendedorEncargado() == null || VE.getCliente() == null || VE.getAutomovil() == null || VE.getMedioDePago() == null || VE.getPuntoDeVenta() == null) {
            throw new BusinessLogicException("Ninguno de los atributos de la venta puede ser null");
        }

        if (vendedorPersistence.find(VE.getVendedorEncargado().getCarnetVendedor()) == null) {
            throw new BusinessLogicException("El vendedor de la venta no esta registrado en la base de datos");
        }
        if (clientePersistence.find(VE.getCliente().getCedula()) == null) {
            throw new BusinessLogicException("El cliente de la venta no está registrado en la base de datos");
        }
        if (automovilPersistence.find(VE.getAutomovil().getId()) == null) {
            throw new BusinessLogicException("El automóvil de la venta no existe");
        }

        if (puntoPersistence.find(VE.getPuntoDeVenta().getId()) == null) {
            throw new BusinessLogicException("El punto de venta de la venta no existe");

        }

        if (medioPersistence.find(VE.getMedioDePago().getNumero()) == null) {
            throw new BusinessLogicException("El medio de pago de esta venta no existe ");
        }

        return persistence.create(VE);
    }

    /**
     * Obtiene todos los prospectos de compra.
     *
     * @return listado con todos los prospectos de compra registrados en la bd.
     */
    public List<VentaEntity> findAllVentas() {
        LOG.log(Level.INFO, "consultando todas las ventas");

        return persistence.findAll();
    }

    /**
     * Actualiza un prospecto de compra.
     *
     * @param VE prospecto de compra con la información actualizada.
     * @return prospecto de compra actualizado.
     * @throws BusinessLogicException si pc == null o no existe el prospecto de
     * compra buscado en la BD o se intentó modificar algo distinto al texto del
     * prospecto de compra.
     */
    public VentaEntity updateVenta(VentaEntity VE) throws BusinessLogicException {
        LOG.log(Level.INFO, "inicia proceso de actualizacion de venta de venta con id", VE.getId());

        if (VE == null) {
            throw new BusinessLogicException("La venta no debe ser null");
        }
        if (VE.getId() == null || VE.getId() <= 0) {
            throw new BusinessLogicException("El id de la venta no es valido ");
        }
        VentaEntity VEO = persistence.find(VE.getId());

        if (VEO == null) {
            throw new BusinessLogicException("La venta no existe");
        }
        if (VE.getAutomovil() == null || !VEO.getAutomovil().equals(VE.getAutomovil())) {
            throw new BusinessLogicException("Sólo se puede cambiar La calificacionCarro de la venta");
        }
        if (VE.getCliente() == null || !VEO.getCliente().equals(VE.getCliente())) {
            throw new BusinessLogicException("Sólo se puede cambiar La calificacionCarro de la venta");
        }
        if (VE.getVendedorEncargado() == null || !VEO.getVendedorEncargado().equals(VE.getVendedorEncargado())) {
            throw new BusinessLogicException("Sólo se puede cambiar La calificacionCarro de la venta");
        }
        if (VE.getPuntoDeVenta() == null || !VEO.getPuntoDeVenta().equals(VE.getPuntoDeVenta())) {
            throw new BusinessLogicException("no se puede actualizar el punto de venta  de la venta");
        }
        if (VE.getMedioDePago() == null || !VEO.getMedioDePago().equals(VE.getMedioDePago())) {
            throw new BusinessLogicException("no se puede actualizar el medio de pago  de la venta");
        }

        return persistence.update(VE);
    }

    /**
     * Elimina un prospecto de compra.
     *
     * @param VE el prospecto de compra que se busca eliminar de la BD.
     * @return el prospecto de compra eliminado.
     * @throws BusinessLogicException si pc == null o si el prospecto de compra
     * no existe en la BD.
     */
    public void deleteVenta(Long VE) throws BusinessLogicException {
        LOG.log(Level.INFO, "inicia proceso de creacion de  eliminacion venta", VE);

        if (VE == null) {
            throw new BusinessLogicException("La venta que se quiere eliminar no debe ser null");
        }

        if (persistence.find(VE) == null) {
            throw new BusinessLogicException("La venta que se busca eliminar no existe");
        }
        LOG.log(Level.INFO, "Termina proceso de creacion de venta", VE);
        
        persistence.delete(VE);
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
        LOG.log(Level.INFO, "Buscando venta con id ", id);
        
        if (id == null || id <= 0) {
            throw new BusinessLogicException("El id pasado por parámetro es inválido");
        }

        return persistence.find(id);
    }

}
