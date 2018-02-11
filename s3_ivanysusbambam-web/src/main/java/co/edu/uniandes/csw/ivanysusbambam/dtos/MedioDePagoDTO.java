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
public class MedioDePagoDTO 
{
    private int numero;

    public MedioDePagoDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param medioDePago: Es la entidad que se va a convertir a DTO
     */
   // public MedioDePagoDTO(MedioDePagoEntity medioDePago) {
   //     this.numero = medioDePago.ge;
        

   // }
public enum MediosDePago{
 PAY_PAL,CREDITO,PSE;   
}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
     /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
 //  public MedioDePagoEntity toEntity() {
 //     MedioDePagoEntity entity = new MedioDePago();
 //       entity.setNumero(this.numero);
 //   }
}
