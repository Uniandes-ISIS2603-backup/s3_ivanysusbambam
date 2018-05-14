/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

/**
 * VentaDTO Objeto de transferencia de datos de ventas. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number
 *      "name": String 
 *   }
 * </pre> Por ejemplo una venta se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "name": ""
 *
 *   }
 *
 * </pre>
 *
 * @author hd.castellanos
 */
public class VentaDTO {

    /**
     * Atributo del Id de la venta
     */
    private Long idVenta;
    
    /**
     * Atributo para el nombre de la venta
     */
    private String name;

    /**
     * Constructor por defecto
     */
    public VentaDTO() {
        //Constructor utilizado por JAX
    }
     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param pVenta: Es la entidad que se va a convertir a DTO
     */
    public VentaDTO(VentaEntity pVenta) {
        if (pVenta != null) {
            if (pVenta.getId() != null)
                this.idVenta = pVenta.getId();
            if (pVenta.getName()!= null)
                this.name = pVenta.getName();
        }

    }

//---------------------GETTERS-------------------------
    /**
     *
     * @return devuelve el id de la venta
     */
    public Long getIdVenta() {
        return idVenta;
    }

    //---------------------Setters-------------------------
    /**
     * Metodo para signar el id de venta que llega por parametro
     *
     * @param pId nuevo id de la venta
     */
    public void setIdVenta(Long pId) {
        this.idVenta = pId;
        
        
    }


    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public VentaEntity toEntity() {
        VentaEntity entity = new VentaEntity();
        entity.setId(this.idVenta);
        entity.setName(this.name);
        return entity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
