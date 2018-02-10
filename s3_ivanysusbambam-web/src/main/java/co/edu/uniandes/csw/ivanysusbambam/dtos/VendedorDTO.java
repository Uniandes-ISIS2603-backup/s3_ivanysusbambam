/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author Felipe Velásquez Montoya
 * Versiones: 
 *  10/02/2018:
 *      -Añadidos atributos.
 *      -Añadidos getters y setters.
 *      
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
