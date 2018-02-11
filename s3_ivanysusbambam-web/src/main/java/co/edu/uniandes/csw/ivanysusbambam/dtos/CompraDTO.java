/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author j.sierrac
 */
public class CompraDTO {
    private String idCompra;
    
    
    public CompraDTO()
    {
        
    }

    public String getIdCompra() {
        return idCompra;
    }

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
