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
     */
    public PuntoDeVentaEntity createPuntoDeVenta(PuntoDeVentaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un punto de venta ");
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de PuntoDeVenta.
     *
     * @param entity Instancia de PuntoDeVentaEntity con los nuevos datos.
     * @return Instancia de PuntoDeVentaEntity con los datos actualizados.
     */
    public PuntoDeVentaEntity updatePuntoDeVenta(PuntoDeVentaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un punto de venta ");
        return persistence.update(entity);
    }
    
    /**
     * Elimina una instancia de PuntoDeVenta de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     */
    public void deletePuntoDeVenta(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un punto de venta ");
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
    
    
}
