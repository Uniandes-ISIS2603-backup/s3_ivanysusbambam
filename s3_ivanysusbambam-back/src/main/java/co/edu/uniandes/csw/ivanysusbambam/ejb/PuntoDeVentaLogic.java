/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author if.garcia
 */

@Stateless
public class PuntoDeVentaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PuntoDeVentaLogic.class.getName());

    @Inject
    PuntoDeVentaPersistence persistence;
    
    @Inject
    AutomovilLogic automovilLogic;
    
    @Inject
    VentaLogic ventaLogic;
    
    @Inject
    CompraLogic compraLogic;
    
    @Inject
    VendedorLogic vendedorLogic;
    
     /**
     * Obtiene la lista de las puntos de venta.
     *
     * @return Colección de objetos de CalificacionCarroEntity.
     */
    public List<PuntoDeVentaEntity> getPuntosDeVenta() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las calificaciones de carros");
        return persistence.findAll();
    }
    
    
    /**
     * Obtiene los datos de una instancia de PuntoDeVenta a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de PuntoDeVentaEntity con los datos del punto de venta consultado.
     */
    public PuntoDeVentaEntity getPuntoDeVenta(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un punto de venta con id = {0}", id);
        return persistence.find(id);
    }
    
    /**
     * Se encarga de crear un PuntoDeVenta en la base de datos.
     *
     * @param entity Objeto de PuntoDeVentaEntity con los datos nuevos
     * @return Objeto de PuntoDeVentaEntity con los datos nuevos y su ID.
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public PuntoDeVentaEntity createPuntoDeVenta(PuntoDeVentaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un punto de venta ");
        if(entity.getTelefono() > 9999999 || entity.getTelefono() < 1000000) throw new BusinessLogicException("Numero de telefono inválido");
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de PuntoDeVenta.
     *
     * @param id identificador del punto de venta a actualizar
     * @param entity Instancia de PuntoDeVentaEntity con los nuevos datos.
     * @return Instancia de PuntoDeVentaEntity con los datos actualizados.
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public PuntoDeVentaEntity updatePuntoDeVenta(PuntoDeVentaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un punto de venta con id={0}", entity.getId());
        if(persistence.find(entity.getId()) == null) throw new BusinessLogicException("El punto de venta ingresado no existe");
        if(entity.getTelefono() > 9999999 || entity.getTelefono() < 1000000) throw new BusinessLogicException("Numero de telefono inválido");
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de PuntoDeVenta de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    public void deletePuntoDeVenta(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un punto de venta ");
        if(persistence.find(id) == null) throw new BusinessLogicException("El punto de venta ingresado no existe");
        persistence.delete(id);
    }
    
    /**
     * Obtiene una colección de instancias de VentaEntity asociadas a una
     * instancia de PuntoDeVenta
     *
     * @param id Identificador de la instancia de PuntoDeVenta
     * @return Colección de instancias de VentaEntity asociadas a la instancia de
     * PuntoDeVenta
     */
    public List<VentaEntity> listVentas(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las ventas del punto de venta con id = {0}", id);
        return getPuntoDeVenta(id).getVentas();
    }
    
    /**
     * Obtiene una colección de instancias de CompraEntity asociadas a una
     * instancia de PuntoDeVenta
     *
     * @param id Identificador de la instancia de PuntoDeVenta
     * @return Colección de instancias de CompraEntity asociadas a la instancia de
     * PuntoDeVenta
     */
    public List<CompraEntity> listCompras(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las compras del punto de venta con id = {0}", id);
        return getPuntoDeVenta(id).getCompras();
    }
    
    /**
     * Obtiene una colección de instancias de VendedorEntity asociadas a una
     * instancia de PuntoDeVenta
     *
     * @param id Identificador de la instancia de PuntoDeVenta
     * @return Colección de instancias de VendedorEntity asociadas a la instancia de
     * PuntoDeVenta
     */
    public List<VendedorEntity> listVendedores(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las vendedores del punto de venta con id = {0}", id);
        return getPuntoDeVenta(id).getVendedores();
    }
    
     /**
     * Obtiene una colección de instancias de AutomovilEntity asociadas a una
     * instancia de PuntoDeVenta
     *
     * @param id Identificador de la instancia de PuntoDeVenta
     * @return Colección de instancias de AutomovilEntity asociadas a la instancia de
     * PuntoDeVenta
     */
    public List<AutomovilEntity> listAutos(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las  del punto de venta con id = {0}", id);
        return getPuntoDeVenta(id).getAutomoviles();
    }
    
    //TODO hacer métodos para obtener un auto, vendedor, venta y compra especifico con 2do id como parametro
    
    
    /**
     * Retorna un auto asociado a un punto de venta
     *
     * @param autoId El id de la editorial a buscar.
     * @param puntoVentaId El id del libro a buscar
     * @return El auto encontrado dentro del punto de venta.
     * @throws BusinessLogicException Si el auto no se encuentra en el punto de venta
     *
    public AutomovilEntity getAutomovil(Long puntoVentaId, Long autoId) throws BusinessLogicException {
        List<AutomovilEntity> autos = getPuntoDeVenta(puntoVentaId).getAutomoviles();
        AutomovilEntity auto = automovilLogic.getAutomovil(autoId);
        int index = autos.indexOf(auto);
        if (index >= 0) {
            return autos.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la editorial");

    }
    
    /**
     * Retorna un vendedor asociado a un punto de venta
     *
     * @param vendedorCedula El id de la editorial a buscar.
     * @param puntoVentaId El id del libro a buscar
     * @return El vendedor encontrado dentro del punto de venta.
     * @throws BusinessLogicException Si el vendedor no se encuentra en el punto de venta
     *
    public VendedorEntity getVendedor(Long puntoVentaId, Long vendedorCedula) throws BusinessLogicException {
        List<VendedorEntity> vds = getPuntoDeVenta(puntoVentaId).getVendedores();
        VendedorEntity vendedor = vendedorLogic.findVendedorByCedula(vendedorCedula);
        int index = vds.indexOf(vendedor);
        if (index >= 0) {
            return vds.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la editorial");

    }
    
    /**
     * Retorna una compra asociado a un punto de venta
     *
     * @param compraId El id de la editorial a buscar.
     * @param puntoVentaId El id del libro a buscar
     * @return El vendedor encontrado dentro del punto de venta.
     * @throws BusinessLogicException Si el vendedor no se encuentra en el punto de venta
     *
    public CompraEntity getCompra(Long puntoVentaId, Long compraId) throws BusinessLogicException {
        List<CompraEntity> cmps = getPuntoDeVenta(puntoVentaId).getCompras();
        CompraEntity auto = compraLogic.findCompra(compraId);
        int index = cmps.indexOf(auto);
        if (index >= 0) {
            return cmps.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la editorial");

    }*/
}
