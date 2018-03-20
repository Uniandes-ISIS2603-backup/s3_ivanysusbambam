package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;

/**
 * Objeto de transferencia de datos del cliente.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *      "nombre": string,
 *      "cedula": number
 *   }
 * </pre> Por ejemplo un cliente se representa así:<br>
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
 * @author Felipe Velásquez Montoya  <pre>
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
    
    //TODO: debe ser Long y no long. Pero en el caso de la cédula sería mejor que fuera un String de dígitos
    private long cedula;

    //Constructor vacío
    /**
     * Constructor por defecto.
     */
    public ClienteDTO() {

    }

    /**
     * Construye el DTO a partir de un entity correspondiente.
     * @param ce entity al partir de que se construirá el DTO.
     */
    public ClienteDTO(ClienteEntity ce) {
        if (ce != null) {
            this.nombre = ce.getNombre();
            this.cedula = ce.getCedula();
        }
    }
    
    /**
     * Contruye un Entity y le da la información del DTO.
     * @return Entity construido a partir del DTO.
     */
    public ClienteEntity toEntity(){
        ClienteEntity ce = new ClienteEntity();
        ce.setNombre(nombre);
        ce.setCedula(cedula);
        return ce;
    }

    //----------------------GETTERS-----------------------------------------
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

    //---------------------SETTERS---------------------------
    /**
     * @param nombre nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método no debería ser llamado por nadie menos JAX.
     *
     * @param cedula del cliente
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

}
