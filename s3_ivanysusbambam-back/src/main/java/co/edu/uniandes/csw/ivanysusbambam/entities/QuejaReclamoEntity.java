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
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author if.garcia y hd.castellanos
 */
@Entity
public class QuejaReclamoEntity implements Serializable {

    /**
     * Id de la queja/Reclamo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la queja/Reclamo
     */
    private String name;

    /**
     * indica si es queja o reclamo
     */
    private String tipo;

    /**
     * Indica la descripci[on de la queja o el reclamo
     */
    private String texto;

    @PodamExclude
    @ManyToOne
    /**
     * Atributo del cliente asociado a esta QuejaReclamo
     */
    private ClienteEntity cliente;

    /**
     * Venta de la queja/Reclamo
     */
    @PodamExclude
    @OneToOne
    private VentaEntity venta;

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return venta de la queja/Reclamo
     */
    public VentaEntity getVenta() {
        return venta;
    }

    /**
     * Seta la venta de la queja/Reclamo
     *
     * @param venta venta de la queja/Reclamo
     */
    public void setVenta(VentaEntity venta) {
        this.venta = venta;
    }

}
