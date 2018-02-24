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
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author if.garcia y hd.castellanos
 */
@Entity
public class QuejaReclamoEntity extends BaseEntity implements Serializable{
    
    
    @Enumerated(EnumType.STRING)
    /**
     * indica si es queja o reclamo 
     */
    private tiposDeQueja tipo;
    
    /**
     * Indica la descripci[on de la queja o el reclamo 
     */
    private String texto;
    
    @PodamExclude
    @ManyToOne
    /**
     * Atributo del cliente asociado a esta QuejaReclamo 
     */
    private ClienteEntity cliente; 

    

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    enum tiposDeQueja {
    ESTADO_VEHICULO, PROBLEMA_TRANSACCION, DEMORA_ENTREGA;
}

    /**
     * @return the tipo
     */
    public tiposDeQueja getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(tiposDeQueja tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
