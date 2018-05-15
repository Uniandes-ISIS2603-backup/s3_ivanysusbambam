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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Felipe Velásquez Montoya  <pre>
 *  Versiones:
 *      18/02/2018
 *          -Creada clase, atributos, getters y setters.
 * </pre>
 */
@Entity
public class ClienteEntity implements Serializable {

    /**
     * Cedula del cliente
     */
    @Id
    @PodamStrategyValue(CedulaStrategy.class)
    private Long cedula;

    /**
     * nombre del cliente
     */
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;

    /**
     * prospectos de compra del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;

    /**
     * Calificaciones tienda del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CalificacionTiendaEntity> calificacionesTienda;

    /**
     * quejas/Reclamos del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<QuejaReclamoEntity> quejasReclamos;

    /**
     * Compras del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CompraEntity> compras;

    /**
     * Ventas del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<VentaEntity> ventas;

    /**
     * Medios de pago del cliente
     */
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<MedioDePagoEntity> mediosDePago;

    /**
     * Imagen del cliente
     */
    @Lob
    private String imagen;

    /**
     * @return cedula del cliente
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * Setea la cedula del cliente ala dada por parametro
     *
     * @param cedula cedula del cliente
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    /**
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre del cliente al dado por parametro
     *
     * @param nombre nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return prospectos de compra del cliente
     */
    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }

    /**
     * Seta los prospectos del cliente a los dados por parametro
     *
     * @param prospectosCompra prospectos de compra del cliente
     */
    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    /**
     * @return las calificacionesTieda del cliente
     */
    public List<CalificacionTiendaEntity> getCalificacionesTienda() {
        return calificacionesTienda;
    }

    /**
     * Setea las calificaciones tienda del cliente a las dadas por parametro
     *
     * @param calificacionesTienda calificaciones tienda del cliente
     */
    public void setCalificacionesTienda(List<CalificacionTiendaEntity> calificacionesTienda) {
        this.calificacionesTienda = calificacionesTienda;
    }

    /**
     * @return las quejas Reclamos del cliente
     */
    public List<QuejaReclamoEntity> getQuejasReclamos() {
        return quejasReclamos;
    }

    /**
     * Setea las quejas/Reclamos del cliente a las dadas por parametro
     *
     * @param quejasReclamos quejas/Reclamos del cliente
     */
    public void setQuejasReclamos(List<QuejaReclamoEntity> quejasReclamos) {
        this.quejasReclamos = quejasReclamos;
    }

    /**
     * @return compras del cliente
     */
    public List<CompraEntity> getCompras() {
        return compras;
    }

    /**
     * Setea las compras del cliente a las dadas por parametro
     *
     * @param compras compras del cliente
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * @return ventas del cliente
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * Setea las vetnas del cliente a las dadas por parametros
     *
     * @param ventas vetnas del cliente
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return medios de pagos del cliente
     */
    public List<MedioDePagoEntity> getMediosDePago() {
        return mediosDePago;
    }

    /**
     * Setea los medios de pago del cliente a los dados por parametor
     *
     * @param mediosDePago medios de pago del cliente
     */
    public void setMediosDePago(List<MedioDePagoEntity> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    /**
     * metodo equals
     *
     * @param obj objeto a comparar
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ClienteEntity)) {
            return false;
        }
        if (((ClienteEntity) obj).getCedula() != null && this.getCedula() != null) {
            return this.getCedula().equals(((ClienteEntity) obj).getCedula());
        }

        return super.equals(obj);
    }

    /**
     * Hash Code
     *
     * @return
     */
    @Override
    public int hashCode() {
        if (this.cedula != null) {
            return this.cedula.hashCode();
        }
        return super.hashCode();
    }

    /**
     * @return Imagen del cliente
     */
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
