/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;

/**
 *
 * @author if.garcia
 */
public class QuejaReclamoDTO {
    
    private Long id;
    
    private String name;
    
    private String texto;
    
    private String tipo;
    
    public QuejaReclamoDTO(){
        
    }
    
    public QuejaReclamoDTO(QuejaReclamoEntity quejaReclamo){ 
        this.id = quejaReclamo.getId();
        this.name = quejaReclamo.getName();
        this.texto = quejaReclamo.getTexto();
        this.tipo = quejaReclamo.getTipo();
    }
    
    public Long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public QuejaReclamoEntity toEntity(){
        QuejaReclamoEntity entity = new QuejaReclamoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setTexto(this.texto);
        entity.setTipo(this.tipo);
        
        return entity;
    }
}
