/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity.TipoMedioDePago;

/**
 * Objeto de transferencia de datos del medio de pago.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *      "numero": string
 *
 *   }
 * </pre> Por ejemplo un medio de pago se representa así:<br>
 *
 * <pre>
 *
 *   {
 *      "numero": "123456"
 *
 *   }
 *
 * </pre>
 *
 * @author j.sierrac
 */
public class MedioDePagoDTO {

    /**
     * Atributo que representa el numero del medio de pago
     */
    
    //TODO debe ser Long y no long (cambiar los set/get también
    private long numero;

    /**
     * Atributo que representa el tipo del medio de pago
     */
    private TipoMedioDePago tipo;

    /**
     * Constructor por defecto
     */
    public MedioDePagoDTO() {
    }

    public MedioDePagoDTO(MedioDePagoEntity entity) {
        if(entity != null) {
            this.numero = entity.getNumero();
            this.tipo = entity.getTipo();
        }
    }
    
    public MedioDePagoEntity toEntity() {
        MedioDePagoEntity entity = new MedioDePagoEntity();
        entity.setNumero(this.numero);
        entity.setTipo(this.tipo);
        
        return entity;
    }
    
    //-----------------------------GETTERS-----------------------------
    /**
     * @return El numero del medio de pago
     */
    public long getNumero() {
        return numero;
    }

    //-----------------------------SETTERS-------------------------
    /**
     * @param numero El nuevo numero del medio de pago
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el tipo del medio de pago
     *
     * @return tipo del medio de pago
     */
    public TipoMedioDePago getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo del medio de pago
     *
     * @param tipo del medio de pago
     */
    public void setTipo(TipoMedioDePago tipo) {
        this.tipo = tipo;
    }
}
