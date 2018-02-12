

package co.edu.uniandes.csw.ivanysusbambam.dtos;


/**Objeto de transferencia de datos del cliente.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 * 
 *      "nombre": string,
 *      "cedula": number
 *   }
 * </pre>
 * Por ejemplo un cliente se representa así:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombre": "Felipe Velasquez",
 *      "cedula": 1016609031
 *   }
 *
 * </pre>
 *
 *
 * @author Felipe Velásquez Montoya
 *<pre>
 * Versiones:
 *  10/02/2018
 *      -Creación de atributos
 *      -Creación de getters y setters
 * 12/02/2018
 *      -Extendida documentacion.
 * </pre> 
 */
public class ClienteDTO {
    
    /**
     * Representa el nombre del cliente.
     */
    private String nombre;
    
    /**
     * Representa el número de cédula del cliente.
     */
    private long cedula;

    /** 
     * @return el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la cédula del cliente.
     */
    public long getCedula() {
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
