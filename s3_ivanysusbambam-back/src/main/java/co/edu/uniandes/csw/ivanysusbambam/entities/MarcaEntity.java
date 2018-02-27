/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una marca en la persistencia y permite su serialización
 * @author Joseph Ortíz Moreno
 */
@Entity
public class MarcaEntity extends BaseEntity implements Serializable{
      /**
     * Representa el nombre de la marca
     */
    private String nombre;
    
    @PodamExclude
     @OneToMany(mappedBy = "marca")
     private  List<AutomovilEntity> automoviles = new ArrayList<AutomovilEntity>();
    
      @PodamExclude
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private  List<ModelEntity> modelos = new ArrayList<ModelEntity>();
 
    /**
     * Retorna el nombre de la marca
     * @return Nombre de la marca
     */
    public String getNombre(){
        return nombre;
    }
    
    public List<AutomovilEntity> getAutomoviles(){
        return automoviles;
    }
    
    public List<ModelEntity> getModelos(){
        return modelos;
    }
    
    
    public void setNombre(String nom)
    {
        this.nombre= nom;
    }
    
    public void setAutomoviles(List<AutomovilEntity> autos){
        this.automoviles = autos;
    }
    
    public void setModelos(List<ModelEntity> mods){
        this.modelos = mods;
    }
    
    
   
    
    
    
}
