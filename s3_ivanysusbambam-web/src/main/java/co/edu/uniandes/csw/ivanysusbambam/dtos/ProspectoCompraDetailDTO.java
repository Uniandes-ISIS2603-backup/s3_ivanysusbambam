/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**Objeto de transferencia que contiene información detallada de un prospecto de compra.
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *       
 *      "texto": string,
 *      "id": number,
 *      "cliente": JSON,
 *      "vendedor": JSON
 *      "automovil": JSON,
 *      
 *   }
 * </pre>
 * Por ejemplo un prospecto de compra representa así:<br>
 * 
 * <pre>
 * 
 *   {
 *      "texto": "Cliente parece muy interesado en compra de Chevrolet Sail placas abc123.",
 *      "id": 12431,
 *      "cliente" : {"cedula": 104230633, "nombre": "Felipe Velásquez"},
 *      "vendedor": {"carnetVendedor": 1253, "cedula":1016501589, "nombre": "Iván García"},
 *      "automovil": {"color": "rojo", "año": 2014, "placa": "abc123", "chasis": 12334234, "fechaListado": 12/02/18, "valorListado": 29000000)
 *      
 * }  
 * 
 *
 * </pre>
 * @author Felipe Velásquez Montoya
 * <pre>
 * Versiones: 
 *  10/02/2018:
 *      -Añadidos atributos.
 *      -Añadidos getters.
 * 12/02/2018
 *      -Extendida documentación.
 *      -Añadidos setters faltandes necesarios para funcionamiento de JAXRS
 * </pre>
 */
public class ProspectoCompraDetailDTO extends ProspectoCompraDTO{
    
    /**
     * Representa el cliente al que pertenece el prospecto de compra.
     */
    private ClienteDTO cliente;
    
    /**
     * Representa el vendedor que creó el propecto de compra.
     */
    private VendedorDTO vendedor;

     /**
     * Representa el automóvil en el que está interesado el cliente.
     */    
    private AutomovilDTO automovil;

    
    //-------------------------------------GETTERS-----------------------------
    
    /**
     * @return cliente del prospecto.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }
    
    /**
     * @return el vendedor del prospecto.
     */
    public VendedorDTO getVendedor() {
        return vendedor;
    }

     /**
     * @return el automóvil en el que está interesado el cliente.
     */
    public AutomovilDTO getAutomovil(){
        return automovil;
    }
   
    
    //---------------------------SETTERS-------------------------

    /**
     * 
     * @param cliente cliente interesado en el automóvil.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * 
     * @param vendedor vendedor creador del prospecto.
     */
    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * 
     * @param automovil automóvil en el que se encuentra interesado el cliente.
     */
    public void setAutomovil(AutomovilDTO automovil) {
        this.automovil = automovil;
    }
   
    
}
