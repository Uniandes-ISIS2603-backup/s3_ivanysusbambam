/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author hd.castellanos
 */
public class VentaDetailDTO extends VentaDTO{
    
/**
 * Atributo para el cliente que 
 */   
    private ClienteDTO cliente;
    
    /**
     * Atributo para el medio de pago 
     */
    
     private MedioDePagoDTO medioDePago;
    
    /**
     * Atributo para el vendedor encargado
     */
    private VendedorDTO vendedorEncargado;
    
    //---------------------GETTERS-------------------------
    /**
     * @return el clinete asociado con este venta 
     */
    public ClienteDTO getCliente(){
        return cliente;
    }
    /**
     * @return el medio de pago que se uso para esta venta 
     */
    public MedioDePagoDTO getMedioDePago (){
        return medioDePago;
    }
    
    /**
     * @return el vendedor encargado de esa venta  
     */
    public VendedorDTO getVendedorEncgardo (){
        return vendedorEncargado;
    }
    
    
    
    
    
    
}
