/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.PuntajeStrategy;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author if.garcia
 */
@Entity
public class CalificacionTiendaEntity extends BaseEntity implements Serializable {

    /**
     * Comentario de la calificacionTienda
     */
    private String comentario;

    /**
     * Puntaje de la calificacionTienda
     */
    @PodamStrategyValue(PuntajeStrategy.class)
    private Double puntaje;

    /**
     * Cliente de la calificacionTienda
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    /**
     * Punto de venta al que hace referencia la calificacionTienda
     */
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;

    /**
     * @return comentario de la calififcacionTienda
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @return puntaje de la calificacionTienda
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * @return cliente de la calififacionTienda
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Setea el cliente de la calififacionTienda al dado por parametro
     *
     * @param cliente cliente de la calififacionTienda
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Setea el puntaje de la calificacionTienda al dadpo por parametro
     *
     * @param puntaje puntaje de la calificacionTienda
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Setea el comentario de la calificacionTienda al dado por parametro
     *
     * @param comentario comentario de la calificacionTienda
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
}
