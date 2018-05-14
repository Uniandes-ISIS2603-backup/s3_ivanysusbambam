/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author hd.castellanos
 */
@Entity
public class VentaEntity implements Serializable {

    /**
     * Id de la venta
     */
    @Id
    private Long idVenta;
    /**
     * Nombre de la venta
     */
    private String name;

    /**
     * Atributo del cliente asociado a esta venta
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Atributo del Medio de pago asociado a esta venta
     */
    @PodamExclude
    @ManyToOne
    private MedioDePagoEntity medioDePago;

    /**
     * Atributo que representa el vendedor encargado de la venta
     */
    @PodamExclude
    @ManyToOne
    private VendedorEntity vendedorEncargado;

    /**
     * Atributo de la calificacion del carro asociado a esta venta
     */
    @PodamExclude
    @OneToOne
    private CalificacionCarroEntity calificacionCarro;

    /**
     * Atributo del punto de venta asociado a esta venta
     */
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;

    /**
     * Atributo del automovil asociado a esta venta
     */
    @PodamExclude
    @ManyToOne
    private AutomovilEntity automovil;

    /**
     * Atributo de la queja/Reclamo de la venta
     */
    @PodamExclude
    @OneToOne
    private QuejaReclamoEntity quejaReclamo;

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the medioDePago
     */
    public MedioDePagoEntity getMedioDePago() {
        return medioDePago;
    }

    /**
     * @param medioDePago the medioDePago to set
     */
    public void setMedioDePago(MedioDePagoEntity medioDePago) {
        this.medioDePago = medioDePago;
    }

    /**
     * @return the vendedorEncargado
     */
    public VendedorEntity getVendedorEncargado() {
        return vendedorEncargado;
    }

    /**
     * @param vendedorEncargado the vendedorEncargado to set
     */
    public void setVendedorEncargado(VendedorEntity vendedorEncargado) {
        this.vendedorEncargado = vendedorEncargado;
    }

    /**
     * @return the calificacionCarro
     */
    public CalificacionCarroEntity getCalificacionCarro() {
        return calificacionCarro;
    }

    /**
     * @param calificacionCarro the calificacionCarro to set
     */
    public void setCalificacionCarro(CalificacionCarroEntity calificacionCarro) {
        this.calificacionCarro = calificacionCarro;
    }

    /**
     * @return the puntoDeVenta
     */
    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @param puntoDeVenta the puntoDeVenta to set
     */
    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @return the automovil
     */
    public AutomovilEntity getAutomovil() {
        return automovil;
    }

    /**
     * @param automovil the automovil to set
     */
    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;

    }

    /**
     * @return la queja/Reclamo de la venta
     */
    public QuejaReclamoEntity getQuejaReclamo() {
        return quejaReclamo;
    }

    /**
     * Setea la queja/Reclamo de la venta a la dada por parametro
     *
     * @param quejaReclamo queja/Reclamo de la venta
     */
    public void setQuejaReclamo(QuejaReclamoEntity quejaReclamo) {
        this.quejaReclamo = quejaReclamo;
    }

    /**
     * @return id de la venta
     */
    public Long getId() {
        return idVenta;
    }

    /**
     * Setea el id de la venta a la dada por parametro
     *
     * @param id id de la venta
     */
    public void setId(Long id) {
        this.idVenta = id;
    }

    /**
     * @return el nombre del punto de venta
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre de la venta al dado por parametro
     *
     * @param name nombre de la venta
     */
    public void setName(String name) {
        this.name = name;
    }

}
