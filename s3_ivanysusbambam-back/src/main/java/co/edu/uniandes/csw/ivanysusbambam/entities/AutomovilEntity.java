/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author a.bravo
 */
@Entity
public class AutomovilEntity extends BaseEntity implements Serializable {

    /**
     * color del automovil
     */
    private String color;
    /**
     * anio del automovil
     */
    private Integer anio;
    /**
     * Placa del automovil
     */
    private String placa;
    /**
     * chasis del automovil
     */
    private Integer chasis;
    /**
     * Prospectos de compra del automovil
     */
    @PodamExclude
    @OneToMany(mappedBy = "automovil", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;

    @PodamExclude
    @OneToMany(mappedBy = "automovil", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaEntity> ventas;
    
    @PodamExclude
    @OneToOne (cascade = CascadeType.ALL)
    private CompraEntity compra;
    
    /**
     * Punto de venta del automovil 
     */
    @PodamExclude
    @ManyToOne 
    private PuntoDeVentaEntity puntoDeVenta;

    /**
     * Marca de este automovil 
     */
    @PodamExclude
    @ManyToOne 
    private MarcaEntity marca;

    /**
     * Fecha de listado de este automovil
     */
    @Temporal(TemporalType.DATE )
    private Calendar fechaListado;

   /**
    * modelo de este automovil
    */
    @PodamExclude
    @ManyToOne 
    private ModelEntity model;

    /**
     * valorListado de este automovil 
     */
    private Double valorListado;

    /**
     * @return color del auto
     */
    public String getColor() {
        return color;
    }

    /**
     * @return anio del auto
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @return placa del auto
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @return chasis del auto
     */
    public Integer getChasis() {
        return chasis;
    }

    /**
     * @return fecha de listado del auto
     */
    public Calendar getFechaListado() {
        return fechaListado;
    }

    /**
     * @return valor del listado del auto
     */
    public Double getValorListado() {
        return valorListado;
    }

    /**
     * @param color color a setear
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param anio anio a setear
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @param placa placa a setear
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @param chasis chasis a setear
     */
    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    /**
     * @param fechaListado fecha del listado a setear
     */
    public void setFechaListado(Calendar fechaListado) {
        this.fechaListado = fechaListado;
    }

    /**
     * @param valorListado valor del listado a setear
     */
    public void setValorListado(Double valorListado) {
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



    /**
     * @return the marca
     */
    public MarcaEntity getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    /**
     * @return the model
     */
    public ModelEntity getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(ModelEntity model) {
        this.model = model;
    }

    /**
     * @return the ventas
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the compra
     */
    public CompraEntity getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }
}
