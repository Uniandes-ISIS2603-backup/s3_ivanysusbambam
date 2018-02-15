/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.List;

/**Representación, para transferencia de Marca, Hereda de MarcaDTO <br>
 * Se serializalizarse: <br>
 * < Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 * 
 *      "nombre": string,
 *       "modelos": JSON Array
 *       "automoviles": JSON Array
 *   }
 * </pre>
 * Una marca se representa de la siguiente forma:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombre": "Chevrolet",
 *      "modelos" : [{"numPuertas": 4}],
 *      "automóviles" :[{"placa":"VEF221"]
 *   }
 * </pre>
 * 
 * @author Joseph Ortíz Moreno
 */
public class MarcaDetail  extends MarcaDTO{
    /**
     *  Representa la lista de automóviles pertenecientes a una marca
     */
    private List<AutomovilDTO> automoviles;
    /**
     *  Representa la lista de modelos pertenecientes a una marca
     */
    private List<ModelDTO> modelos;
    
    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Get
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Retorna la lista de automoviles pertenecientes a la marca
     * @return Lista con los automoviles
     */
    public List<AutomovilDTO> getAutomoviles(){
        return automoviles;
    }
    /**
     * Retorna una lista con los modelos de la marca
     * @return Lista con los modelos
     */
    public List<ModelDTO> getModelos(){
        return modelos;
    } 
    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Add
    //-----------------------------------------------------------------------------------------------------------------
    
    /**
     *  Agrega el automovil dado por parametro
     * <b>pos</b> se aniadio el automovil
     * @param auto Automovil que se quiere agregar
     */
    public void addAutomovil(AutomovilDTO auto){
        automoviles.add(auto);
    }
        /**
     *  Agrega el modelo dado por parametro
     * <b>pos</b> se aniadio el modelo
     * @param mod Modelo que se quiere agregar.
     */
    public void addModel(ModelDTO mod){
        modelos.add(mod);
    }
    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Set
    //-----------------------------------------------------------------------------------------------------------------
    /**
     *  Refresca la lista de automoviles
     * @param listaAuto Nueva lista que se quiere mostrar 
     */
    public void setAutomoviles(List<AutomovilDTO> listaAuto){
        this.automoviles = listaAuto;
    }
    /**
     * Refresca la lista de modelos
     * @param models Lista de modelos que se quiere mostrar
     */
    public void setModelos(List<ModelDTO> models){
        this.modelos = models;
    }
}
