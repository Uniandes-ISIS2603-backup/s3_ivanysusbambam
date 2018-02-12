/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

/**
 *
 * @author if.garcia
 */
public class QuejaReclamoEntity extends BaseEntity{
    
    private String tipo;
    
    private String texto;
    
    public String getTipo(){
        return tipo;
    } 
    
    public String getTexto(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
}
