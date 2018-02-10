/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author Felipe Velásquez Montoya
 * Versiones: 
 *  10/02/2018:
 *      -Añadidos atributos.
 *      -Añadidos getters.
 */
public class ProspectoCompraDetailDTO extends ProspectoCompraDTO{
    
    /**
     * Representa el cliente al que pertenece el prospecto de compra.
     */
    private ClienteDTO cliente;
    
    /**
     * Representa el vendedor que creó el propecto de compra.
     */
    private VendedorDTO vendedor;

     /**
     * Representa el automóvil en el que está interesado el cliente.
     */
    //comentado dado que AutomovilDTO no existe aún.
    //private AutomovilDTO automovil;
    
    //-------------------------------------GETTERS-----------------------------
    
    /**
     * @return cliente del prospecto.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }
    
    /**
     * @return el vendedor del prospecto.
     */
    public VendedorDTO getVendedor() {
        return vendedor;
    }

     /**
     * @return el automóvil en el que está interesado el cliente.
     */
    /*public AutomovilDTO getAutomovil(){
        return automovil;
    }*/
   
    
    //---------------------------SETTERS-------------------------
    //Se omiten setters, un cambio en alguno de los atributos correspondería a
    //un nuevo prospecto de compra, no a la modificación de un prospecto 
    //existente.
}
