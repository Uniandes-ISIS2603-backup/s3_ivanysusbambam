/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * Clase que representa un modelo en la persistencia y permite su serialización
 * @author Joseph Ortíz Moreno
 */
@Entity
public class ModelEntity extends BaseEntity implements Serializable {
    
      /**
     * Representa el numero de puertas del vehículo
     */
    private Integer numeroPuertas;
    /**
     * Representa la transmisión del vehículo
     */
    private String transmision;
    /**
     * Representa el cilindraje del vehículo
     */
    private Integer cilindraje;
    /**
     * Representa los centímetros cúbicos 
     */
    private Double centCubicos;
    
    @OneToMany(mappedBy = "model")
    
    private List<AutomovilEntity> automoviles = new ArrayList<AutomovilEntity>();
    /**
     * Obtiene el número de puertas
     * @return Numero de puertas
     */
    public Integer getNumeroPuertas() {
        return numeroPuertas;
    }
    /**
    * Actualiza el valor del número de puertas
    * @param numeroPuertas nuevo valor 
    */
    public void setNumeroPuertas(Integer numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
       /**
     * Obtiene la transmision
     * @return Transmision
     */
    public String getTransmision() {
        return transmision;
    }
    /**
     * Actualiza el tipo de transmisión
     * @param transmision nuevo valor
     */
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
      /**
     * Obtiene el cilindraje
     * @return Cilindraje
     */
    public Integer getCilindraje() {
        return cilindraje;
    }
    /**
     * Actualiza el valor del cilindraje
     * @param cilindraje nuevo valor
     */
    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }
    /**
     * Obtiene los centrimetros cubicos
     * @return Centimetros Cubicos
     */
    public Double getCentCubicos() {
        return centCubicos;
    }
    /**
     * Actualiza el valor de los centimetros cubicos
     * @param centCubicos nuevo valor
     */
    public void setCentCubicos(Double centCubicos) {
        this.centCubicos = centCubicos;
    }
        /**
     * Obtiene los automoviles
     * @return Automoviles
     */
    public List<AutomovilEntity> getAutomoviles() {
        return automoviles;
    }
    
    /**
     * Actualiza el valor de los automoviles
     * @param nuevoAuto nueva lista de autos
     */
    public void setAutomoviles(List<AutomovilEntity> nuevoAuto) {
        this.automoviles = nuevoAuto;
    }
   
    
    
}
