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
public class VentaEntity  implements Serializable {

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
     * Atributo del vendedor asociado a esta venta 
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
      public Long getId() {
        return idVenta;
    }

    public void setId(Long id) {
        this.idVenta = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
