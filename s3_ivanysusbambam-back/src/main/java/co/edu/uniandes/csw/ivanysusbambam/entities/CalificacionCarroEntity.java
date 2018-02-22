/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
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

    private Integer puntaje;
    
    public String getComentario() {
        return comentario;
    }

    public int getPuntaje(){
        return puntaje;
    }
    
    public VentaEntity getVenta(){
        return venta;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void setVenta(VentaEntity venta){
        this.venta = venta;
    }
}
