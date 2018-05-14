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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Felipe Velásquez Montoya  <pre>
 *  Versiones:
 *      18/02/2018
 *          -Creada clase, atributos, getters y setters.
 * </pre>
 */
@Entity
public class ProspectoCompraEntity implements Serializable {

    /**
     * Constatente del serial version
     */
    private static final long serialVersionUID = 1L;
    /**
     * Id del prospecto de compra
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Texto del prospecto de compra
     */
    @Lob
    private String texto;

    /**
     * Cliente del prospecto de compra
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Vendedor del prospecto de compra
     */
    @PodamExclude
    @ManyToOne
    private VendedorEntity vendedor;

    /**
     * Automovil del prospecto de compra
     */
    @PodamExclude
    @ManyToOne
    private AutomovilEntity automovil;

    /**
     * @return el serial version
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return el texto del prospecto de compra
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @return el cliente del prospecto de compra
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @return el vendedor del prospecto de compra
     */
    public VendedorEntity getVendedor() {
        return vendedor;
    }

    /**
     * @return automovil del prospecto de compra
     */
    public AutomovilEntity getAutomovil() {
        return automovil;
    }

    /**
     * Setea del prospecto de compra del texto al dado por parametro
     *
     * @param texto texto del prospecto de compra
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Setea el cliente del prospecto de compra al dado por parametro
     *
     * @param cliente cliente del prospecto de compra
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(VendedorEntity vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Setea el automovil del prospecto de compra al dado por parametro
     *
     * @param automovil automovil del prospecto de compra
     */
    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;
    }

    /**
     * @return el id del prospecto de compra
     */
    public Long getId() {
        return id;
    }

    /**
     * Seta el id del prospecto de compra al dado por parametro
     *
     * @param id id del prospecto de compra
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo equals
     *
     * @param obj objeto a comparar
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProspectoCompraEntity)) {
            return false;
        }
        if (((ProspectoCompraEntity) obj).id != null && this.id != null) {
            return this.id.equals(((ProspectoCompraEntity) obj).id);
        }
        return super.equals(obj);
    }

    /**
     * @return Metodo del to String
     */
    @Override
    public String toString() {
        return "co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity[ id=" + id + " ]";
    }

}
