/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;

/**
 * Objeto de transferencia de datos de la compra.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *      "idCompra": string
 *
 *   }
 * </pre> Por ejemplo una compra se representa así:<br>
 *
 * <pre>
 *
 *   {
 *      "idCompra": "123456"
 *
 *   }
 *
 * </pre>
 *
 *
 * @author j.sierrac
 */
public class CompraDTO {

    /**
     * Atributo que representa el identificador de la compra
     */
    private Integer idCompra;

    /**
     * Constructor por defecto
     */
    public CompraDTO() {
        //Constructor utilizado por JAX
    }

     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param compra: Es la entidad que se va a convertir a DTO
     */
     public CompraDTO(CompraEntity compra) {
        if(compra!=null)
        {
            this.idCompra = compra.getIdCompra();
           
        }
         }
    //-------------------------------------GETTERS-----------------------------
    /**
     * @return El identificador de la compra
     */
    public Integer getIdCompra() {
        return idCompra;
    }

    //---------------------------SETTERS-------------------------
    /**
     * @param idCompra El nuevo id de la compra
     */
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
   
     
    /**
     * @return la entidad con la informacion del DTO 
     */
      public CompraEntity toEntity()
      {
          CompraEntity entity = new CompraEntity();
          entity.setIdCompra(this.idCompra);
           return entity;
       }
}
