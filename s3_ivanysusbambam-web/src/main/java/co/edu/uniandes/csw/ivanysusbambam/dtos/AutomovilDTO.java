/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import java.util.Calendar;

/**
 *
 * @author a.bravo
 */
public class AutomovilDTO {
    private String color;
    private int anio;
    private String placa;
    private int chasis;
    private Calendar fechaListado;
    private double valorListado;
    
    public AutomovilDTO(){
    }
    public AutomovilDTO(AutomovilEntity auto){
        this.color = auto.getColor();
        this.anio = auto.getAnio();
        this.placa = auto.getPlaca();
        this.chasis = auto.getChasis();
        this.fechaListado = auto.getFechaListado();
        this.valorListado = auto.getValorListado();
    }
    
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
    
    public AutomovilEntity toEntity(){
        AutomovilEntity entity = new AutomovilEntity();
        entity.setColor(this.color);
        entity.setAnio(this.anio);
        entity.setPlaca(this.placa);
        entity.setChasis(this.chasis);
        entity.setFechaListado(this.fechaListado);
        entity.setValorListado(this.valorListado);
        return entity;
    }
}
