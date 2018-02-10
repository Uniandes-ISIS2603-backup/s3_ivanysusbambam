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
public class VentaDTO extends CompraDTO
{

/**
     * Atributo del Id de la venta 
     */
    private Integer idVenta;

//---------------------GETTERS-------------------------

/**
 * 
 * @return devuelve el id de la venta
 */
    public Integer getIdVenta (){
    return idVenta;
}  
    
    
    //---------------------Setters-------------------------
    /**
     * Metodo para signar el id de venta que llega por parametro 
     * @param pId nuevo id de la venta 
     */
    public void setId (Integer pId){
        this.idVenta = pId;
    }
}
