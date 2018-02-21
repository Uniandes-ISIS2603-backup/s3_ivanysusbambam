/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author j.sierrac
 */
@Entity
public class MedioDePagoEntity implements Serializable
{
     /**
     * Id de la Entity del medio de 
     */
   
    @Id
    private Integer numero;
    
    /**
     * Define el tipo del medio de pago
     */
    @Enumerated(EnumType.STRING)
    private TipoMedioDePago tipo;
    
/**
 * Da el numero del medio de pago
 * @return numero
 */
    public int getNumero() {
        return numero;
    }
/**
 * Cambia el numero del medio de pago
 * @param numero 
 */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}


enum TipoMedioDePago {
    PAY_PAL, CREDITO, PSE;
}