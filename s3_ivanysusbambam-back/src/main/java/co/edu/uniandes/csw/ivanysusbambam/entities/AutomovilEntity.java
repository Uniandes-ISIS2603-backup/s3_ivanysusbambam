/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author a.bravo
 */
@Entity
public class AutomovilEntity extends BaseEntity implements Serializable{
    private String color;
    private Integer anio;
    private String placa;
    private int chasis;
    @OneToMany
    private List<ProspectoCompraEntity> prospectosCompra;
   
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;
   
    @ManyToOne 
    private MarcaEntity marca;
    
    @Temporal(TemporalType.DATE)
    private Calendar fechaListado;
    
@ManyToOne

  private  ModelEntity model;
   
private double valorListado;
    
    /**
     * @return color del auto
     */
    public String getColor(){
        return color;
    }
    /**
     * @return anio del auto
     */
    public int getAnio(){
        return anio;
    }
    /**
     * @return placa del auto
     */
    public String getPlaca(){
        return placa;
    }
    /**
     * @return chasis del auto
     */
    public int getChasis(){
        return chasis;
    }
    /**
     * @return fecha de listado del auto
     */
    public Calendar getFechaListado(){
        return fechaListado;
    }
    /**
     * @return valor del listado del auto
     */
    public double getValorListado(){
        return valorListado;
    }
    
    /**
     * @param color color a setear
     */
    public void setColor(String color){
        this.color = color;
    }
    /**
     * @param anio anio a setear
     */
    public void setAnio(int anio){
        this.anio = anio;
    }
    /**
     * @param placa placa a setear
     */
    public void setPlaca(String placa){
        this.placa = placa;
    }
    /**
     * @param chasis chasis a setear
     */
    public void setChasis(int chasis){
        this.chasis = chasis;
    }
    /**
     * @param fechaListado fecha del listado a setear
     */
    public void setFechaListado(Calendar fechaListado){
        this.fechaListado = fechaListado;
    }
    /**
     * @param valorListado valor del listado a setear
     */
    public void setValorListado(double valorListado){
        this.valorListado = valorListado;
    }
    
    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }

    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }
}
