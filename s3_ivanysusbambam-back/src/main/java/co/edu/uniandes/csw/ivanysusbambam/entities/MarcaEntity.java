/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
   
    
    @PodamExclude
     @OneToMany(mappedBy = "marca")
     private  List<AutomovilEntity> automoviles = new ArrayList<>();
    
      @PodamExclude
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private  List<ModelEntity> modelos = new ArrayList<>();
 
      private String logo;
  
    
    public List<AutomovilEntity> getAutomoviles(){
        return automoviles;
    }
    
    public List<ModelEntity> getModelos(){
        return modelos;
    }
    
    public void setAutomoviles(List<AutomovilEntity> autos){
        this.automoviles = autos;
    }
    
    public void setModelos(List<ModelEntity> mods){
        this.modelos = mods;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }     

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaEntity other = (MarcaEntity) obj;
        if (!Objects.equals(this.logo, other.logo)) {
            return false;
        }
        return true;
    }
    
}
