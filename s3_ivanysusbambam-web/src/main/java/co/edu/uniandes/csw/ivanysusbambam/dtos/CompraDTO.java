/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;
/**Objeto de transferencia de datos de la compra.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 * 
 *      "idCompra": string
 *      
 *   }
 * </pre>
 * Por ejemplo una compra se representa así:<br>
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
    private String idCompra;
    
    
      /**
     * Constructor por defecto
     */
    public CompraDTO()
    {
        
    }

    //-------------------------------------GETTERS-----------------------------
    /**
     * @return El identificador de la compra
     */
    public String getIdCompra() {
        return idCompra;
    }

    
    
      //---------------------------SETTERS-------------------------
     /**
     * @param id El nuevo id de la compra
     */
    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }
     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param city: Es la entidad que se va a convertir a DTO
     */
   // public CompraDTO(CompraEntity compra) {
   //     this.idCompra = compra.getIdCompra();

   // }
    
  //  public CompraEntity toEntity()
  //  {
  //      CompraEntity entity = new CompraEntity();
  //      entity.setId(this.idCompra);
 //       return entity;
 //   }
}
