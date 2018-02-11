/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
/**
 *
 * @author if.garcia
 */
public class CalificacionCarroDTO {
    
    private Long id;
    
    private String name;
    
    private String comentario;
    
    private int puntaje;
    
    //private VentaDTO venta;
    
    public CalificacionCarroDTO(){
        
    }
    
    public CalificacionCarroDTO(CalificacionCarroEntity calificacionCarro){
        this.id = calificacionCarro.getId();
        this.name = calificacionCarro.getName();
        this.comentario = calificacionCarro.getComentario();
        this.puntaje = calificacionCarro.getPuntaje();
        
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getComentario(){
        return comentario;
    }
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    public CalificacionCarroEntity toEntity(){
        CalificacionCarroEntity entity = new CalificacionCarroEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setComentario(this.comentario);
        entity.setPuntaje(this.puntaje);
        
        return entity;
    }
    
}
