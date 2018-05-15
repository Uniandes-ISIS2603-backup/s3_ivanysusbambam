/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author h.castellanos
 */
@Entity
public class AutomovilEntity extends BaseEntity implements Serializable {

    /**
     * color de la entidad automovil
     */
    private String color;
    /**
     * anio de la entidad automovil
     */
    private Integer anio;
    /**
     * Placa de la entidad automovil
     */
    private String placa;
    /**
     * chasis de la entidad automovil
     */
    private Integer chasis;
    /**
     * Prospectos de compra de la entidad automovil
     */
    @PodamExclude
    @OneToMany(mappedBy = "automovil", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;

    /**
     * Ventas de la entidad automovil
     */
    @PodamExclude
    @OneToMany(mappedBy = "automovil", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<VentaEntity> ventas;

    /**
     * Compra de la entidad automovil
     */
    @PodamExclude
    @OneToOne(mappedBy = "automovil")
    private CompraEntity compra;

    /**
     * Punto de venta de la entidad
     */
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;

    /**
     * Marca de la entidad automovil
     */
    @PodamExclude
    @ManyToOne
    private MarcaEntity marca;

    /**
     * Fecha de listado de la entidad automovil
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaListado;

    /**
     * modelo de la entidad automovil
     */
    @PodamExclude
    @ManyToOne
    private ModelEntity model;

    /**
     * valorListado de la entidad automovil
     */
    private Double valorListado;

    /**
     * Imagen de la entidad automovil
     */
    @Lob
    private String imagen;
    /**
     * Tipo de la entidad xautomovil
     */
    private String tipo;
    /**
     * Kilometros de la entidad automovil
     */
    private Double kilometros;

    /**
     * @return color de la entidad automovil
     */
    public String getColor() {
        return color;
    }

    /**
     * @return anio de la entidad automovil
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @return placa de la entidad automovil
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @return chasis de la entidad automovil
     */
    public Integer getChasis() {
        return chasis;
    }

    /**
     * @return fecha de listado de la entidad automovil
     */
    public Date getFechaListado() {
        return fechaListado;
    }

    /**
     * @return valor de la entidad automovil
     */
    public Double getValorListado() {
        return valorListado;
    }

    /**
     * @param pColor color a setear en la entidad automovil
     */
    public void setColor(String pColor) {
        this.color = pColor;
    }

    /**
     * @param pAnio anio a setear en la entidad automovil
     */
    public void setAnio(Integer pAnio) {
        this.anio = pAnio;
    }

    /**
     * @param pPlaca placa a setear en la entidad automovil
     */
    public void setPlaca(String pPlaca) {
        this.placa = pPlaca;
    }

    /**
     * @param pChasis chasis a setear en la entidad automovil
     */
    public void setChasis(Integer pChasis) {
        this.chasis = pChasis;
    }

    /**
     * @param pFechaListado fecha del listado a setear en la entidad automovil
     */
    public void setFechaListado(Date pFechaListado) {
        this.fechaListado = pFechaListado;
    }

    /**
     * @param pValorListado valor del listado a setear en la entidad automovil
     */
    public void setValorListado(Double pValorListado) {
        this.valorListado = pValorListado;
    }

    /**
     * @return La imagen de la entidad automovil
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param pImagen imagen a setear en la entidad automovil
     */
    public void setImagen(String pImagen) {
        this.imagen = pImagen;
    }

    /**
     * @return El tipo de la entidad automovil
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param pTipo el tipo a setear en la entidad automovil
     */
    public void setTipo(String pTipo) {
        this.tipo = pTipo;
    }

    /**
     * @return el kilometrjae de la entidad automovil
     */
    public Double getKilometros() {
        return kilometros;
    }

    /**
     * @param pKilometraje kilometraje a setear en la entidad automovil
     */
    public void setKilometros(Double pKilometraje) {
        this.kilometros = pKilometraje;
    }

    /**
     * @return lista de los prospectos de compra de la entidad automovil
     */
    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }

    /**
     * @param prospectosCompra Lista de prospectos compra a setear en la entidad
     * automovil
     */
    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    /**
     * @return el punto de venta de la entidad automovil
     */
    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @param puntoDeVenta el punto de venta a setear en la entidad automovil
     */
    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @return La marca de la entidad automovil
     */
    public MarcaEntity getMarca() {
        return marca;
    }

    /**
     * @param marca la marca a setear en la entidad automovil
     */
    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    /**
     * @return el modela de la entidad automovil
     */
    public ModelEntity getModel() {
        return model;
    }

    /**
     * @param model el modelo a setear en la entidad automovil
     */
    public void setModel(ModelEntity model) {
        this.model = model;
    }

    /**
     * @return la lista de ventas de esta entidad automovil
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @param ventas la lista de ventas a setear en la entidad automovil
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return la compra de la entidad automovil
     */
    public CompraEntity getCompra() {
        return compra;
    }

    /**
     * @param compra la compra a setear en la entidad automovil
     */
    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }

    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return 3;
    }

    /**
     * Metodo equals
     *
     * @param obj objeto a comparar
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutomovilEntity other = (AutomovilEntity) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.chasis, other.chasis)) {
            return false;
        }
        return true;
    }

}
