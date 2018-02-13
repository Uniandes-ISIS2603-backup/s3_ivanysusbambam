/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.List;

/**
 *
 * @author Felipe Velásquez Montoya
 * Versiones: 
 * 10/02/2018
 *      -Creación de atributos.
 *      -Creación de getters y adders.
 */
public class ClienteDetailDTO extends ClienteDTO {
    
    /**
     * Representa los prospectos de compra del cliente.
     */
    private List<ProspectoCompraDTO> prospectosCompra;
    
    
    /**
     * Representa las calificaciones de la tienda hechas por el cliente.
     */
    private List<CalificacionTiendaDTO> calificacionesTienda;
    
    /**
    * Representa las quejas o reclamos puestas por el cliente.
    */
    
    private List<QuejaReclamoDTO> quejasReclamos;
    
    /**
     * Representa las compras del cliente.
     */
    private List<CompraDTO> compras;
    
    /**
     * Representa las ventas del cliente.
     */
    private List<VentaDTO> ventas;
    
    /**
     * Representa los medios de pago registrados por el cliente.
     */
    private List<MedioDePagoDTO>  mediosDePago;
    
    
    //-----------------------------GETTERS--------------------------------
    
    /**
     * @return una lista conteniendo todos los prospectos de compra del cliente.
     */
    public List<ProspectoCompraDTO> getProspectosCompra(){
        return prospectosCompra;
    }  
    
    
    /**
     * @return una lista conteniendo todas las calificaciones hechas por el cliente.
     */
    public List<CalificacionTiendaDTO> getCalificacionesTienda(){
        return calificacionesTienda;
    }
    
    /**
     * @return una lista conteniendo todas las quejas o reclamos hechas por el cliente.
     */
    /*public List<QuejaReclamoDTO> getQuejasReclamos(){
        return quejasReclamos;
    }*/
    
    /**
     * @return una lista conteniendo todas las compras del cliente.
     */
    public List<CompraDTO> getCompras(){
        return compras;
    }
    
    /**
     * @return una lista conteniendo todas las ventas del cliente.
     */
    public List<VentaDTO> getVentas(){
        return ventas;
    }
    
    /**
     * @return una lista conteniendo todos los medio de pago registrados por el cliente.
     */
    public List<MedioDePagoDTO> getMediosDePago(){
        return mediosDePago;
    }
    
    //---------------------------ADDERS----------------------------------
    
    /**
     * Añade el prospecto de compra pasado por parámetro a los prospectos de compra del cliente.
     * <b>pos</b> se ha añadido el prospecto de compra.
     * @param prospecto el prospecto de compra que se desea añadir.
     */
    public void addProspectoCompra(ProspectoCompraDTO prospecto){
        prospectosCompra.add(prospecto);
    }
    
    /**
     * Añade la calificación de la tienda pasada por parámetro a las calificaciones de la tienda hechas por el cliente.
     * <b>pos</b> se ha añadido la calificacion
     * @param calificacion la calificación que se desea añadir.
     */
    public void addCalificacionTienda(CalificacionTiendaDTO calificacion){
        calificacionesTienda.add(calificacion);
    }
    
    /**
     * Añade la queja o reclamo pasada por parametro a las quejas y reclamos del cliente.
     * <b>pos</b> se ha añadido la queja o reclamo.
     * @param quejaReclamo la queja o reclamo que se desea añadir.
     */
    /*public void addQuejaReclamo(QuejaReclamoDTO quejaReclamo){
        quejasReclamos.add(quejaReclamo);
    }*/
    
    /**
     * Añade la compra pasada por parámetro a las compras del cliente.
     * <b>pos</b> se ha añadido la compra.
     * @param compra la compra que se desea añadir.
     */
    public void addCompra(CompraDTO compra){
        compras.add(compra);
    }
    
    /**
     * Añade la venta pasada por parámetro a las ventas del cliente.
     * <b>pos</b> se ha añadido la venta.
     * @param venta la venta que se desea añadir.
     */
    public void addVenta(VentaDTO venta){
        ventas.add(venta);
    }
    
    /**
     * Añade el medio de pago pasado por parámetro a los medio de pago registrados por el cliente.
     * <b>pos</b> se ha añadido el medio de pago.
     * @param medioPago el medio de pago que se desea añadir.
     */
    public void addMedioDePago(MedioDePagoDTO medioPago){
        mediosDePago.add(medioPago);
    }
}
