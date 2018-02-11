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
 * Versiones:
 *  10/02/2018
 *      -Creación de atributos
 *      -Creación de getters y setters
 */
public class CalificacionCarroDTO {
    
    /**
     * Representa el id del objeto
     */
    private Long id;
    
    /**
     * Representa el nombre del objeto
     */
    private String name;
    
    /**
     * Representa el comentario de la calificacion
     */
    private String comentario;
    
    /**
     * Representa el puntaje que le da el cliente al carro
     */
    private int puntaje;
    
    /**
     * Crea una nueva calificacion
     */
    public CalificacionCarroDTO(){
        
    }
    
    /**
     * Crea una nueva calificacion a partir de un Entity
     * @param calificacionCarro entity de la calificacion
     */
    public CalificacionCarroDTO(CalificacionCarroEntity calificacionCarro){
        this.id = calificacionCarro.getId();
        this.name = calificacionCarro.getName();
        this.comentario = calificacionCarro.getComentario();
        this.puntaje = calificacionCarro.getPuntaje();
        
    }
    
    /**
     * Retorna el id del la calificacion
     * @return 
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Cambia el id de la calificacion
     * @param id 
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * Retorna el nombre de la entidad de la calificacion
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Cambia el nombre de la entidad de la calificacion
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Retorna el comentario que acompaña a la calificacion
     * @return 
     */
    public String getComentario(){
        return comentario;
    }
    
    /**
     * Cambia el comentario de la calificacion
     * @param comentario 
     */
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    
    /**
     * Retorna el puntaje asignado por el cliente al carro
     * @return 
     */
    public int getPuntaje(){
        return puntaje;
    }
    
    /**
     * Cambia el puntaje asignado al carro por el cliente
     * @param puntaje 
     */
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    /**
     * Convierte el objeto existente en una entidad
     * @return entity
     */
    public CalificacionCarroEntity toEntity(){
        CalificacionCarroEntity entity = new CalificacionCarroEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setComentario(this.comentario);
        entity.setPuntaje(this.puntaje);
        
        return entity;
    }
    
}
