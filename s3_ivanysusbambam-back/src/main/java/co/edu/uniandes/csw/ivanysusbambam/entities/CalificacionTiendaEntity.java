/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author if.garcia
 */
@Entity
public class CalificacionTiendaEntity extends BaseEntity implements Serializable{
    
    
    private String comentario;

    private Integer puntaje;
   
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    public String getComentario() {
        return comentario;
    }

    public int getPuntaje(){
        return puntaje;
    }
    
    public ClienteEntity getCliente(){
        return cliente;
    }
    
    public void setCliente(ClienteEntity cliente){
        this.cliente = cliente;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
