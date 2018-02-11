/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
/**
 *
 * @author if.garcia
 */
public class CalificacionTiendaDTO {
    
    private Long id;
    
    private String name;
    
    private String comentario;
    
    private int puntaje;
    
    //private VentaDTO venta;
    
    public CalificacionTiendaDTO(){
        
    }
    
    public CalificacionTiendaDTO(CalificacionTiendaEntity calificacionTienda){
        this.id = calificacionTienda.getId();
        this.name = calificacionTienda.getName();
        this.comentario = calificacionTienda.getComentario();
        this.puntaje = calificacionTienda.getPuntaje();
        
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
    
    public CalificacionTiendaEntity toEntity(){
        CalificacionTiendaEntity entity = new CalificacionTiendaEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setComentario(this.comentario);
        entity.setPuntaje(this.puntaje);
        
        return entity;
    }
}
