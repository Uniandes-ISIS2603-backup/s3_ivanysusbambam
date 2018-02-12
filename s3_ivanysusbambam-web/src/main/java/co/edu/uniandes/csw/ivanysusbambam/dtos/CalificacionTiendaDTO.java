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
 * Versiones:
 *  10/02/2018
 *      -Creación de atributos
 *      -Creación de getters y setters
 */
public class CalificacionTiendaDTO {
    
    /**
     * Identificador del objeto
     */
    private Long id;
    
    /**
     * Nombre del objeto Entity de la calificacion
     */
    private String name;
    
    /**
     * Comentario respectivo a la calificacion
     */
    private String comentario;
    
    /**
     * Puntaje especificado por el usuario para la tienda
     */
    private int puntaje;
    
    
    /**
     * Construye una nueva Calificacion para una tienda
     */
    public CalificacionTiendaDTO(){
        
    }
    
    /**
     * Construye una nueva calificacion para una tienda a partir de un objeto Entity
     * @param calificacionTienda 
     */
    public CalificacionTiendaDTO(CalificacionTiendaEntity calificacionTienda){
        this.id = calificacionTienda.getId();
        this.name = calificacionTienda.getName();
        this.comentario = calificacionTienda.getComentario();
        this.puntaje = calificacionTienda.getPuntaje();
        
    }
    
    /**
     * Entrega el identificador unico del objeto
     * @return 
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Cambia el identificador unico por el Long que entra por parámetro
     * @param id 
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * 
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @return 
     */
    public String getComentario(){
        return comentario;
    }
    /**
     * 
     * @param comentario 
     */
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    
    /**
     * 
     * @return 
     */
    public int getPuntaje(){
        return puntaje;
    }
    
    /**
     * 
     * @param puntaje 
     */
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    /**
     * 
     * @return 
     */
    public CalificacionTiendaEntity toEntity(){
        CalificacionTiendaEntity entity = new CalificacionTiendaEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setComentario(this.comentario);
        entity.setPuntaje(this.puntaje);
        
        return entity;
    }
}
