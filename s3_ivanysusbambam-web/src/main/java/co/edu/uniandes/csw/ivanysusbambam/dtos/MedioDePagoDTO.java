/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 * Objeto de transferencia de datos del medio de pago.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *      "numero": string
 *
 *   }
 * </pre> Por ejemplo un medio de pago se representa así:<br>
 *
 * <pre>
 *
 *   {
 *      "numero": "123456"
 *
 *   }
 *
 * </pre>
 *
 * @author j.sierrac
 */
public class MedioDePagoDTO {

    /**
     * Atributo que representa el numero del medio de pago
     */
    private long numero;

    /**
     * Atributo que representa el tipo del medio de pago
     */
    private MediosDePago tipo;

    /**
     * Constructor por defecto
     */
    public MedioDePagoDTO() {
    }

    /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param medioDePago: Es la entidad que se va a convertir a DTO
     */
    // public MedioDePagoDTO(MedioDePagoEntity medioDePago) {
    //     this.numero = medioDePago.ge;
    // }
    /**
     * Enumeracion con los distintos medios de pago
     */
    public enum MediosDePago {
        PAY_PAL, CREDITO, PSE;
    }

    //-----------------------------GETTERS-----------------------------
    /**
     * @return El numero del medio de pago
     */
    public long getNumero() {
        return numero;
    }

    //-----------------------------SETTERS-------------------------
    /**
     * @param numero El nuevo numero del medio de pago
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el tipo del medio de pago
     *
     * @return tipo del medio de pago
     */
    public MediosDePago getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo del medio de pago
     *
     * @param tipo del medio de pago
     */
    public void setTipo(MediosDePago tipo) {
        this.tipo = tipo;
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
