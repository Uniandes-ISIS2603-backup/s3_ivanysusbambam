/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.CedulaStrategy;
import co.edu.uniandes.csw.ivanysusbambam.podam.NombreStrategy;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Felipe Velásquez Montoya
 *
 * <pre>
 * Versiones:
 *  18/02/2018
 *      -Creada la clase, atributos, getters y setters.
 * </pre>
 */
@Entity
public class VendedorEntity implements Serializable {

    /**
     * Nombre del vendedor
     */
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;

    /**
     * Id del vendedor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carnetVendedor;

    /**
     * Cedula del vendedor
     */
    @PodamStrategyValue(CedulaStrategy.class)
    private Long cedula;

    /**
     * imagen del vendedor
     */
    @Lob
    private String imagen;

    /**
     * prospectos de compra del vendedor
     */
    @PodamExclude
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProspectoCompraEntity> prospectosCompra;

    /**
     * Ventas del vendedor
     */
    @PodamExclude
    @OneToMany(mappedBy = "vendedorEncargado", fetch = FetchType.LAZY)
    private List<VentaEntity> ventas;

    /**
     * Compras del vendedor
     */
    @PodamExclude
    @OneToMany(mappedBy = "vendedorEncargado", fetch = FetchType.LAZY)
    private List<CompraEntity> compras;

    /**
     * Punto de venta del vendedor
     */
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;

    /**
     * Setea los prospectos de compra del vendedor a los dados por parametro
     *
     * @param prospectosCompra prospetos de compra del vendedor
     */
    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    /**
     * Setea las ventas del vendedor a los dados por parametro
     *
     * @param ventas ventas del vendedor
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * Setea las compras del vendedor a los dados por parametro
     *
     * @param compras compras del vendedor
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * Setea el punto de venta del vendedor al dado por parametro
     *
     * @param puntoDeVenta punto de venta del vendedor
     */
    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @return la cedula del vendedor
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * @return carnet del vendedor
     */
    public Long getCarnetVendedor() {
        return carnetVendedor;
    }

    /**
     * @return nombre del vendedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea la cedula del vendedor a la dada por parametro
     *
     * @param cedula cédula del vendedor.
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    /**
     *
     * @param name nombre del vendedor.
     */
    public void setNombre(String name) {
        this.nombre = name;
    }

    /**
     * Setea el carnet del vendedor al dado por parametro
     *
     * @param id carnet del vendedor.
     */
    public void setCarnetVendedor(Long id) {
        this.carnetVendedor = id;
    }

    /**
     * @return Los prospectos de compra del vendedor
     */
    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }

    /**
     * @return Las ventas del vendedor
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @return Las compras del vendedor
     */
    public List<CompraEntity> getCompras() {
        return compras;
    }

    /**
     * @return El punto de venta del vendedor
     */
    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @return La imagen del vendedor
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Setea la imagen del vendedor a la dada por parametro
     *
     * @param imagen imagen del vendedor
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * metodo equals
     *
     * @param obj objeto a compara
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof VendedorEntity)) {
            return false;
        }

        if (this.getCarnetVendedor() != null && ((VendedorEntity) obj).getCarnetVendedor() != null) {
            return this.getCarnetVendedor().equals(((VendedorEntity) obj).getCarnetVendedor());
        }
        return super.equals(obj);
    }

}
