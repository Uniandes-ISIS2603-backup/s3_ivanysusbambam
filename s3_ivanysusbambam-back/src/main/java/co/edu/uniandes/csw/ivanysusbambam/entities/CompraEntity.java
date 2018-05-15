/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author j.sierrac
 */
@Entity
public class CompraEntity implements Serializable {

    /**
     * Id de la Entity de Compra
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    /**
     * El automovil de la compra
     */
    @PodamExclude
    @OneToOne()
    @JoinColumn()
    private AutomovilEntity automovil;

    /**
     * Atributo que representa el vendedor encargado de la compra
     */
    @PodamExclude
    @ManyToOne
    private VendedorEntity vendedorEncargado;
    /**
     * Atributo que representa el punto de venta de la compra
     */
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;
    /**
     * Atributo que representa el cliente que le vendio el carro a MiAutomovil
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Da el id de la Compra
     *
     * @return el id de la compra
     */
    public Integer getIdCompra() {
        return idCompra;
    }

    /**
     * Cambia el id de la compra
     *
     * @param idCompra
     */
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return El automovil de la compra
     */
    public AutomovilEntity getAutomovil() {
        return automovil;
    }

    /**
     * Setea el automovil de la compra al dado por parametro
     *
     * @param automovil automovil de la compra
     */
    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;
    }

    /**
     * @return vendedor de la compra
     */
    public VendedorEntity getVendedorEncargado() {
        return vendedorEncargado;
    }

    /**
     * Setea el vendedor de la compra al dado por parametro
     *
     * @param vendedorEncargado vendedor de la compra
     */
    public void setVendedorEncargado(VendedorEntity vendedorEncargado) {
        this.vendedorEncargado = vendedorEncargado;
    }

    /**
     * @return punto de venta de la compra
     */
    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * Setea el punto de venta de la compra al dado por parametro
     *
     * @param puntoDeVenta punto de venta de la compra
     */
    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @return cliente de la compra
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Setea el cliente de la compra al dado por parametro
     *
     * @param cliente cliente de la compra
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

}
