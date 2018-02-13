package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseph Ortíz Moreno
 */
public class MarcaDTO {
    /**
     * Representa el nombre de la marca
     */
    private String nombre;
    /**
     * Representa la lista de modelos de la marca
     */
    private List<ModelDTO> modelos;
    /**
     * Retorna el nombre de la marca
     * @return Nombre de la marca
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Retorna una lista con los modelos de la marca
     * @return Lista con los modelos de la marca
      */
    public List<ModelDTO> getModelos(){
        return modelos;
    }
    
}
