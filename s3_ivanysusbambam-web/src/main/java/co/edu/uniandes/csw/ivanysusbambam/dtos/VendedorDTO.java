/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;

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
 *      -Añadidos setters faltantes necesarios para JAX-RS
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
    private Long cedula;
    
    /**
     * Representa el carnet del vendedor.
     */
    private Long carnetVendedor;
    
    /*
    *Representa el link a la imagen del vendedor
    */
    private String imagen;
    //---------------------CONSTRUCTORES---------------------
    
    /**
     * Constructor por defecto.
     */
    public VendedorDTO(){
        //Constructor utilizado por JAX
    }
    
    /**
     * Construye un DTO según un Entity.
     * @param ve Entity
     */
    public VendedorDTO(VendedorEntity ve){
      if(ve != null){
        this.nombre = ve.getNombre();
        this.cedula = ve.getCedula();
        this.carnetVendedor = ve.getCarnetVendedor();
        this.imagen = ve.getImagen();
      }
    }
    
    /**
     * Construye y retorna un entity según el DTO.
     * @return Entity.
     */
    public VendedorEntity toEntity(){
        VendedorEntity ve = new VendedorEntity();
        ve.setNombre(nombre);
        ve.setCedula(cedula);
        ve.setCarnetVendedor(carnetVendedor);
        ve.setImagen(imagen);
        return ve;
    }

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
    public Long getCedula() {
        return cedula;
    }

    /**
     * 
     * @return el carnet del vendedor.
     */
    public Long getCarnetVendedor() {
        return carnetVendedor;
    }
    
    /**
     * 
     * @return el link a la imagen del vendedor
     */
    public String getImagen(){
        return imagen;
    }

    //--------------------------SETTERS---------------------------------
    
    /**
     * 
     * @param nombre el nuevo nombre del vendedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Solo para uso de JAXRS
     * @param cedula número de cédula del vendedor
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    /**
     * Solo para uso de JAXRS
     * @param carnetVendedor el número de carnet del vendedor.
     */
    public void setCarnetVendedor(Long carnetVendedor) {
        this.carnetVendedor = carnetVendedor;
    }
    
    /**
     * Sólo para uso de JAXRS
     * @param img el link a la imagen
     */
    public void setImagen(String img){
        imagen = img;
    }
       
}
