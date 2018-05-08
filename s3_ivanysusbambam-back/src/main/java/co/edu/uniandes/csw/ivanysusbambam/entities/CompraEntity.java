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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
     private  VendedorEntity vendedorEncargado;
    /**
     * Atributo que representa el punto de venta de la compra
     */ 
     @PodamExclude
    @ManyToOne
        private  PuntoDeVentaEntity puntoDeVenta;
     /**
     * Atributo que representa el cliente que le vendio el carro a MiAutomovil
     */
     @PodamExclude
    @ManyToOne
      private ClienteEntity cliente;
    
   
    /**
     * Da el id de la Compra
     * @return el id de la compra 
     */
    public Integer getIdCompra() {
        return idCompra;
    }
/**
 * Cambia el id de la compra
 * @param idCompra 
 */
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public AutomovilEntity getAutomovil() {
        return automovil;
    }

    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;
    }

    public VendedorEntity getVendedorEncargado() {
        return vendedorEncargado;
    }

    public void setVendedorEncargado(VendedorEntity vendedorEncargado) {
        this.vendedorEncargado = vendedorEncargado;
    }

    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }

    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
}
