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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @OneToOne(mappedBy="compra")
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
    @OneToOne(mappedBy="compra")
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
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    
    
    
}
