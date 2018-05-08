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
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;
/**
 *
 * @author if.garcia
 */
@Entity
public class CalificacionCarroEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @OneToOne(mappedBy = "calificacionCarro")
    private VentaEntity venta;
    
    private String comentario;
    
    @PodamStrategyValue(PuntajeStrategy.class)
    private Double puntaje;
    
    public String getComentario() {
        return comentario;
    }

    public Double getPuntaje(){
        return puntaje;
    }
    
    public VentaEntity getVenta(){
        return venta;
    }
    
    public void setPuntaje(Double puntaje){
        this.puntaje = puntaje;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void setVenta(VentaEntity venta){
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final CalificacionCarroEntity other = (CalificacionCarroEntity) obj;
        if (!Objects.equals(this.venta, other.venta)) {
            return false;
        }
        return true;
    }
    
}
