/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**Objeto de transferencia que representa a un vendedor.
 *Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": string,
 *      "cedula": number,
 *      "carnetVendedor": number
 *   }
 * </pre>
 * Por ejemplo un vendedr se representa así:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombre": "Joseph Ortiz",
 *      "cedula": 1234567890,
 *      "carnetVendedor" : 1432
 *   }
 *
 * </pre>
 * @author Felipe Velásquez Montoya
 * <pre>
 * Versiones: 
 *  10/02/2018:
 *      -Añadidos atributos.
 *      -Añadidos getters y setters.
 * 12/02/2018
 *      -Extendida documentación.
 * </pre>
 */
public class VendedorDTO {
    
    /**
     * Representa el nombre del vendedor.
     */
    private String nombre;
    
    /**
     * Representa la cédula del vendedor.
     */
    private int cedula;
    
    /**
     * Representa el carnet del vendedor.
     */
    private int carnetVendedor;

    //---------------------GETTERS-------------------------
    
    /**
     * 
     * @return el nombre del vendedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return la cédula del vendedor.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * 
     * @return el carnet del vendedor.
     */
    public int getCarnetVendedor() {
        return carnetVendedor;
    }

    //--------------------------SETTERS---------------------------------
    
    /**
     * 
     * @param nombre el nuevo nombre del vendedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       
    //Se omiten setters de cédula y carnet, pues no debería ser posible que 
    //una persona cambiara de cédula.
}
