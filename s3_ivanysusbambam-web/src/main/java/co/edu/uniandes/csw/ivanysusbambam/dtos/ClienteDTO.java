

package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author Felipe Velásquez Montoya
 * Versiones:
 *  10/02/2018
 *      -Creación de atributos
 *      -Creación de getters y setters
 *      
 */
public class ClienteDTO {
    
    /**
     * Representa el nombre del cliente.
     */
    private String nombre;
    
    /**
     * Representa el número de cédula del cliente.
     */
    private int cedula;

    /** 
     * @return el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la cédula del cliente.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param nombre nuevo nombre del cliente 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Se omite el setCedula pues no tendría sentido que un cliente pudiera 
    //cambiar su número de cédula.
    
    
    
    
    
    
}
