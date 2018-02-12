/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;

/**
 *
 * @author hd.castellanos
 */
public class VentaEntity extends BaseEntity implements Serializable
{
    /**
     * Id de la entity de venta
     */
    private int idVenta;
    
    /**
     * @return el id de la venta
     */
    public int getIdVenta (){
        return idVenta;
    }
    
     /**
     * @param pId el id para asignar a esta venta
     */
    public void setId(int pId) {
        this.idVenta = pId;
    }
}
