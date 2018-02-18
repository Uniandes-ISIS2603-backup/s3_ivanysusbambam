/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author j.sierrac
 */
@Entity
public class CompraEntity implements Serializable {
    
     /**
     * Id de la Entity de Compra
     */
    //Se repitiria por la herencia
    @Id
    private int idCompra;

   
    /**
     * Da el id de la Compra
     * @return el id de la compra 
     */
    public int getIdCompra() {
        return idCompra;
    }
/**
 * Cambia el id de la compra
 * @param idCompra 
 */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    
    
    
}
