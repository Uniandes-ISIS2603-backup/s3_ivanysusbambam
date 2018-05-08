/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.PuntajeStrategy;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;
/**
 *
 * @author if.garcia
 */
@Entity
public class CalificacionTiendaEntity extends BaseEntity implements Serializable{
    
    
    private String comentario;

    @PodamStrategyValue(PuntajeStrategy.class)
    private Double puntaje;
   
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    public String getComentario() {
        return comentario;
    }

    public Double getPuntaje(){
        return puntaje;
    }
    
    public ClienteEntity getCliente(){
        return cliente;
    }
    
    public void setCliente(ClienteEntity cliente){
        this.cliente = cliente;
    }
    
    public void setPuntaje(Double puntaje){
        this.puntaje = puntaje;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
       return 5;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalificacionTiendaEntity other = (CalificacionTiendaEntity) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
}
