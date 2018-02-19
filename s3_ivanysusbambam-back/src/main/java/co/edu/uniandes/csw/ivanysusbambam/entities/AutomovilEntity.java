/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author a.bravo
 */

@Entity
public class AutomovilEntity extends BaseEntity implements Serializable{
    private String color;
    private int anio;
    private String placa;
    private int chasis;
    
    @OneToOne
    private Calendar fechaListado;
    private double valorListado;
    
    public String getColor(){
        return color;
    }
    public int getAnio(){
        return anio;
    }
    public String getPlaca(){
        return placa;
    }
    public int getChasis(){
        return chasis;
    }
    public Calendar getFechaListado(){
        return fechaListado;
    }
    public double getValorListado(){
        return valorListado;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setChasis(int chasis){
        this.chasis = chasis;
    }
    public void setFechaListado(Calendar fechaListado){
        this.fechaListado = fechaListado;
    }
    public void setValorListado(double valorListado){
        this.valorListado = valorListado;
    }
}
