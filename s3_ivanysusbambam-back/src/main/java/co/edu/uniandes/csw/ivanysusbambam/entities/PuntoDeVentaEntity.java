/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.TelefonoStrategy;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author if.garcia
 */
@Entity
public class PuntoDeVentaEntity extends BaseEntity implements Serializable {

    /**
     * Direcion del punto de venta
     */
    private String direccion;

    /**
     * Imagen del punto de venta
     */
    @Lob
    private String imagen;

    /**
     * Telefono del punto de venta
     */
    @PodamStrategyValue(TelefonoStrategy.class)
    private Integer telefono;

    /**
     * Vendedores del punto de venta
     */
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<VendedorEntity> vendedores;

    /**
     * Compras del punto de venta
     */
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CompraEntity> compras;

    /**
     * Ventas del punto de venta
     */
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<VentaEntity> ventas;

    /**
     * Automoviles del punto de venta
     */
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<AutomovilEntity> automoviles;

    /**
     * @return Direccion del punto de venta
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setea la direccion del punto de venta a la dada por parametro
     *
     * @param direccion direccion del punto de venta
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return el telefono del punto de venta
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Setea el telefono del punto de venta al dado por parametro
     *
     * @param telefono telefono del punto de venta
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return imagen del punto de venta
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param pImagen the urlImagen to set
     */
    public void setImagen(String pImagen) {
        this.imagen = pImagen;
    }

    /**
     * @return the vendedores
     */
    public List<VendedorEntity> getVendedores() {
        return vendedores;
    }

    /**
     * @return the compras
     */
    public List<CompraEntity> getCompras() {
        return compras;
    }

    /**
     * @return the ventas
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @return the automoviles
     */
    public List<AutomovilEntity> getAutomoviles() {
        return automoviles;
    }

    /**
     * @param vendedores the vendedores to set
     */
    public void setVendedores(List<VendedorEntity> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @param automoviles the automoviles to set
     */
    public void setAutomoviles(List<AutomovilEntity> automoviles) {
        this.automoviles = automoviles;
    }

    /**
     * Hash code
     *
     * @return
     */
    @Override
    public int hashCode() {
        return direccion.hashCode();
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
        final PuntoDeVentaEntity other = (PuntoDeVentaEntity) obj;
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }

}
