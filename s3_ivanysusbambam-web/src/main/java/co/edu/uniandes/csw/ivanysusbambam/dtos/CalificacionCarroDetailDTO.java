/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author if.garcia
 */
public class CalificacionCarroDetailDTO extends CalificacionCarroDTO {
    
    /**
     * Representa la venta de la cual proviene la calificacion
     */
    private VentaDTO venta;
    /**
     * Asigna una venta a la calificacion
     * @param venta 
     */
    public void setVenta(VentaDTO venta){
        this.venta = venta;
    }
    
    /**
     * Retorna la venta de la cual proviene la calificacion
     * @return venta
     */
    public VentaDTO getVenta(){
        return venta;
    }  
}
