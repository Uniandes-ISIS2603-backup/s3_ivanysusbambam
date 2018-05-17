/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author j.sierrac
 */
@Entity
public class MedioDePagoEntity implements Serializable {

    /**
     * Id de la Entity del medio de
     */
    @Id
    private Long numero;

    /**
     * Define el tipo del medio de pago
     */
    @Enumerated(EnumType.STRING)
    private TipoMedioDePago tipo;

    /**
     * Cliente del medio de pago
     */
    @ManyToOne
    @PodamExclude
    private ClienteEntity cliente;

    /**
     * Ventas del medio de pago
     */
    @PodamExclude
    @OneToMany(mappedBy = "medioDePago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VentaEntity> ventas;

    /**
     * Da el numero del medio de pago
     *
     * @return numero
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * Cambia el numero del medio de pago
     *
     * @param numero
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * @return tipo de medio de pago
     */
    public TipoMedioDePago getTipo() {
        return tipo;
    }

    /**
     * Sete el tipo de medio de pago al dado por parametro
     *
     * @param tipo tipo del medio de pago
     */
    public void setTipo(TipoMedioDePago tipo) {
        this.tipo = tipo;
    }

    /**
     * @return el cliente del medio de pago
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Setea el cliente del medio de pago al dado por parametro
     *
     * @param cliente cliente del medio de pago
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Valida el tipo de pago
     *
     * @return true si el tipo de pago es valido. false de lo contrario
     */
    public boolean validarTipoMedioDePago() {
        for (TipoMedioDePago pTipo : TipoMedioDePago.values()) {
            if (this.tipo.equals(pTipo)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Enumeracion del tipo de medio de pago
     */
    public enum TipoMedioDePago {
        PAY_PAL, CREDITO, PSE;
    }

    /**
     * comprara el medio de pago
     *
     * @param mdp medio de pago a comparar
     * @return metodos equals de los ids de los medio de pago a comparar
     */
    public boolean compararMedioDePago(MedioDePagoEntity mdp) {
        if (mdp == null) {
            return false;
        }
        return this.numero.equals(mdp.numero);
    }
}
