/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.List;

/**Representación, para transferencia de Modelo, Hereda de ModeloDTO <br>
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
 * Un modelo se representa de la siguiente forma:<br>
 * 
 * <pre>
 * 
 *   {
 *      "numeroPuertas": 4
 *      "transmision": "mecanica"
 *      "cilindraje":"500cc"
 *      "centimetrosCubicos":"";
 *      "automóviles" :[{"placa":"VEF221"]
 *   }
 * </pre>
 * 
 * @author Joseph Ortíz Moreno
 */
public class ModelDetailDTO extends ModelDTO {
    /**
     *  Representa la lista de automóviles pertenecientes a una marca
     */
    private List<AutomovilDTO> automoviles;
     //-----------------------------------------------------------------------------------------------------------------
    // Métodos Get
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Retorna la lista de automoviles pertenecientes a un modelo
     * @return Lista con los automoviles
     */
    public List<AutomovilDTO> getAutomoviles(){
        return automoviles;
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
}
