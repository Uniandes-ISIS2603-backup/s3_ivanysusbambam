/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
/**
 *
 * @author if.garcia
 */
public class CalificacionTiendaEntity extends BaseEntity implements Serializable{
    
    private String comentario;

    private int puntaje;
    
    public String getComentario() {
        return comentario;
    }

    public int getPuntaje(){
        return puntaje;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
