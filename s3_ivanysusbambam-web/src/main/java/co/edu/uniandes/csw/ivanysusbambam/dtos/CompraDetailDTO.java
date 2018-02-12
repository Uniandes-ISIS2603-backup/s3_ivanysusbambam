/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author j.sierrac
 */
public class CompraDetailDTO extends CompraDTO {
    
    
    /**
     * Atributo que representa el automovil de la compra
     */
        private  AutomovilDTO  automovil;
    /**
     * Atributo que representa el vendedor encargado de la compra
     */
      private  VendedorDTO vendedorEncargado;
    /**
     * Atributo que representa el punto de venta de la compra
     */  
        private  PuntoDeVentaDTO puntoDeVenta;
     /**
     * Atributo que representa el cliente que le vendio el carro a MiAutomovil
     */
      private ClienteDTO cliente;
              
    /**
     * Constructor por defecto
     */

    public CompraDetailDTO()
    {
    }
//-------------------------------------GETTERS-----------------------------
//     
    /**
     * @return El automovil de la compra
     */    
       public AutomovilDTO getAutomovil() {
       return automovil;
   }
    /**
     * @return El vendedor encargado de la compra
     */  
    public VendedorDTO getVendedorEncargado() {
        return vendedorEncargado;
    }
    
    /**
     * @return El vendedor punto de venta donde se encuentra la compra
     */ 
    public PuntoDeVentaDTO getPuntoDeVenta() {
        return puntoDeVenta;
    }
    
    
    /**
     * @return El cliente que le vendio el automovil a MiAutomovil
     */ 
    public ClienteDTO getCliente() {
        return cliente;
    }
 //-------------------------------------SETTERS-----------------------------   

    /**
     * @param automovil El nuevo automóvil
     */
    public void setAutomovil(AutomovilDTO automovil) {
        this.automovil = automovil;
    }

    /**
     * @param vendedorEncargado El nuevo VendedorEncargado
     */

    public void setVendedorEncargado(VendedorDTO vendedorEncargado) {
        this.vendedorEncargado = vendedorEncargado;
    }


    /**
     * @param puntoDeVenta El nuevo puntoDeVenta
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

     
/**
     * @param cliente El nuevo cliente de la compra
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
    
    
}
