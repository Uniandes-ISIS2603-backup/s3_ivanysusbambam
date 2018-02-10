/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author Felipe Velásquez Montoya
 * Versiones: 
 *  10/02/2018:
 *      -Añadido atributo
 *      -Añadidos getters y setters.
 */
public class ProspectoCompraDTO {
    
    /**
     * Representa el texto escrito por el vendedor con respecto al prospecto.
     */
    private String texto;

    /**
     * @return el texto respectivo.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto el texto escrito por el vendedor.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
