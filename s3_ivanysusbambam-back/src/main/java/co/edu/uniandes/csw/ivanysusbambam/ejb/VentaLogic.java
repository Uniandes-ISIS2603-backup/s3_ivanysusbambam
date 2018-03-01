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
    

    

    @Inject
    private CalificacionCarroPersistence calificacionPersistence;

    /**
     * Crea un prospecto de compra.
     *
     * @param VE prospecto de compra que se quiere añadir
     * @return el prospecto de compra recién añadido.
     * @throws BusinessLogicException si el id, cliente, vendedor, o automóvil
     * del cliente no existe o es inválido.
     */
    public VentaEntity createVenta(VentaEntity VE) throws BusinessLogicException {
        if (VE == null) {
            throw new BusinessLogicException("La venta no debe ser null");
        }
        if (VE.getId() == null || VE.getVendedorEncargado()== null || VE.getCliente() == null || VE.getAutomovil() == null || VE.getCalificacionCarro()== null ) {
            throw new BusinessLogicException("Ninguno de los atributos de la venta puede ser null");
        }

        if (VE.getId() <= 0) {
            throw new BusinessLogicException("EL id no debería ser <= 0");
        }
        if (persistence.find(VE.getId()) != null) {
            throw new BusinessLogicException("la venta ya existe en la base de datos");
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
        if (calificacionPersistence.find(VE.getCalificacionCarro().getId()) == null) {
            throw new BusinessLogicException("la clificacionCarro de la venta no existe");
        }
        
        if (puntoPersistence.find(VE.getPuntoDeVenta().getId()) == null){
       throw new BusinessLogicException("El punto de venta de la venta no existe");
            
        }
        
        if (medioPersistence.find(VE.getMedioDePago().getNumero()) == null){
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
        if (VE.getVendedorEncargado()== null || !VEO.getVendedorEncargado().equals(VE.getVendedorEncargado())) {
            throw new BusinessLogicException("Sólo se puede cambiar La calificacionCarro de la venta");
        }
        if (VE.getPuntoDeVenta() == null || !VEO.getPuntoDeVenta().equals(VE.getPuntoDeVenta())){
            throw new BusinessLogicException("no se puede actualizar el punto de venta  de la venta");
        }
//         if (VE.getMedioDePago()== null || !VEO.getMedioDePago().equals(VE.getMedioDePago())){
//            throw new BusinessLogicException("no se puede actualizar el medio de pago  de la venta");
//        }
        

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

        if (VE == null) {
            throw new BusinessLogicException("La venta que se quiere eliminar no debe ser null");
        }

        if (persistence.find(VE) == null) {
            throw new BusinessLogicException("La venta que se busca eliminar no existe");
        }
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
        if (id == null || id <= 0) {
            throw new BusinessLogicException("El id pasado por parámetro es inválido");
        }

        return persistence.find(id);
    }

}
