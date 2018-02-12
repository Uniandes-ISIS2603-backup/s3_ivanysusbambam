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
 * Verisones: 
 *  10/02/2018:
 *      -Añadidos atributos 
 *      -Añadidos getters, setters y adders.
 */
public class VendedorDetailDTO extends VendedorDTO{
    
    /**
     * Representa los prospectos de compra creados por el vendedor.
     */
    private List<ProspectoCompraDTO> prospectosCompra;
    
    /**
     * Representa las ventas del vendedor.
     */
    
    private List<VentaDTO> ventas;
    
    /**
     * Representa las compras del vendedor.
     */
    
    private List<CompraDTO> compras;
    
    /**
     * Representa el punto de venta en el que trabaja el vendedor.
     */
    
    private PuntoDeVentaDTO puntoDeVenta;
    
    //-------------------------GETTERS-------------------------------
    
    /**
     * 
     * @return la lista con los prospectos de compra creados por el vendedor. 
     */
    public List<ProspectoCompraDTO> getProspectosCompra() {
        return prospectosCompra;
    }
    
    /**
     * @return las ventas del vendedor. 
     */
    public List<VentaDTO> getVentas(){
        return ventas;
    }
    
    /**
     * @return las compras del vendedor.
     */
    public List<CompraDTO> getCompras(){
        return compras;
    }
    
    /**
     * @return el punto de venta del vendedor.
     */
    public PuntoDeVentaDTO getPuntoDeVenta(){
        return puntoDeVenta;
    }
    
    
    //---------------------------SETTERS----------------------------
    
    /**
     * Cambia el punto de venta al que pertenece el vendedor.
     * @param puntoDeVenta el punto de venta al que se asignará el vendedor.
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO puntoDeVenta){
        this.puntoDeVenta = puntoDeVenta;
    }
    
    //---------------------------ADDERS-----------------------------
    
    /**
    * Añade un prospecto de compra al vendedor.
    * <b>pos: </b> se ha añadido el prospecto de compra.
    * @param prospectoCompra el prospecto de comrpa a ser añadido.
    */
    public void addProspectoCompra(ProspectoCompraDTO prospectoCompra){
        prospectosCompra.add(prospectoCompra);
    }
    
    /**
    * Añade una venta al vendedor.
    * <b>pos: </b> se ha añadido la venta
    * @param venta la venta al vendedor.
    */
    public void addVenta(VentaDTO venta){
        ventas.add(venta);
    }
    
    /**
    * Añade una compra al vendedor.
    * <b>pos: </b> se ha añadido la compra.
    * @param compra la compra a a ser añadida.
    */
    public void addCompra(CompraDTO compra){
        compras.add(compra);
    }
     
}
