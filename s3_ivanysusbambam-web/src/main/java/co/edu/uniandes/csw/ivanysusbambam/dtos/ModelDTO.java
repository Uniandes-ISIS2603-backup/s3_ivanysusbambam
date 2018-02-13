package co.edu.uniandes.csw.ivanysusbambam.dtos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseph Ortíz Moreno
 */
public class ModelDTO {
    
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
    private double centCubicos;
    
    public ModelDTO()
    {
        numeroPuertas = null;
        transmision = null;
        cilindraje = null;
        centCubicos = 0.0;
    }
    
    /**
     *
     * @get
     */
    public Integer getNumeroPuertas(){
            return numeroPuertas;
    }
     /**
     * @get
     * 
     */
    public String getTransmision(){
    return transmision;
}
     /**
     * @get
     * 
     */
    public Integer getCilindraje(){
    return cilindraje;
}
    public double centCubicos(){
    return centCubicos;
}
    /**
     * @put
     * 
    **/
    public void putNumeroPuertas(Integer pu){
        numeroPuertas = pu;
    }
     /**
     * @put
     * 
    **/
    public void putTransmision(String nueva){
        transmision = nueva;
    }
      /**
     * @put
     * 
    **/
    public void putCilindraje(Integer  nCil){
        cilindraje = nCil;
    }
      /**
     * @put
     * 
    **/
    public void putCentCubicos(Double nueCent){
        centCubicos = nueCent;
    }

}
    

