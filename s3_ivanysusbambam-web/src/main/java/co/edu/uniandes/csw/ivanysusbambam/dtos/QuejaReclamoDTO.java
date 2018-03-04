/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;

/**
 *
 * @author if.garcia y hd.castellanos
 */
public class QuejaReclamoDTO {
    
    /**
     * Id para identificar  la queja o reclamos
     */
    private Long id;
    
    /**
     * Nombre de la queja o el reclamos
     */
    private String name;
    
    /**
     * Descripcion de la queja o el reclamo
     */
    private String texto;
    
   /**
    * Indica si es queja o reclamo
    */
    private String tipo;
    
   /**
    * Constructor por defecto
    */
    public QuejaReclamoDTO(){
        
        
        
    }
    
    
    /**
     * @return el id de la queja o reclamo 
     */
    public Long getId(){
        return id;
    }
    
    /**
     * @return el nombre de la queja o el reclamo  
     */
    public String getName(){
        return name;
    }
    
    /**
     * @return el tipo , si es queja o es reclamo  
     */
    public String getTipo(){
        return tipo;
    }
    
    /**
     * @return la descripcion de la queja o el reclamo  
     */
    public String getTexto(){
        return texto;
    }
    
    /**
     * Asigna al id de la venta o el reclamo el id dado por parametro 
     * @param id id que se le va a siganr a la queja o al reclamo 
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * Asigna el nombre dado por parametro como el nombre de la queja o el reclamo 
     * @param name nombre que se va a asignar a la queja o reclamo 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * asigna la descripcion dada por parametro a la queja o al reclamo
     * @param texto descripcion que se va a siganr a la queja o al reclamo 
     */
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    /**
     * asigna el tipo dado por parametro a la queja o al reclamo 
     * @param tipo puede ser Queja o reclamo , y lo asigna a esta queja o reclamo 
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
   /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public QuejaReclamoEntity toEntity(){
        QuejaReclamoEntity entity = new QuejaReclamoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setTexto(this.texto);
        entity.setTipo(this.tipo);
        entity.setCliente(entity.getCliente());
        
        return entity;
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param pQuejaOReclamo: Es la entidad que se va a convertir a DTO
     */
    public QuejaReclamoDTO(QuejaReclamoEntity pQuejaOReclamo) {
        this.id = pQuejaOReclamo.getId();
        this.name = pQuejaOReclamo.getName();
        this.texto = pQuejaOReclamo.getTexto();
        this.tipo = pQuejaOReclamo.getTipo();


    }
    
   
}
