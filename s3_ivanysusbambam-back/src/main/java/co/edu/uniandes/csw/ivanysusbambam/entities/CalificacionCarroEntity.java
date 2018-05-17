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
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author if.garcia
 */
@Entity
public class CalificacionCarroEntity extends BaseEntity implements Serializable {

    /**
     * Venta de la calificacion carro
     */
    @PodamExclude
    @OneToOne(mappedBy = "calificacionCarro", fetch = FetchType.LAZY)
    private VentaEntity venta;
    /**
     * Comentario de la calificacion Carro
     */
    private String comentario;

    /**
     * Puntaje de la queja Reclamo
     */
    @PodamStrategyValue(PuntajeStrategy.class)
    private Double puntaje;

    /**
     * @return comentario de la calificacion Carro
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @return puntaje de la calificacion Carro
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * @return venta de la calificacion Carro
     */
    public VentaEntity getVenta() {
        return venta;
    }

    /**
     * Setea el puntaje de la calificacion carro al dado por parametro
     *
     * @param puntaje de la calificacionCarro
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Setea el copmentario de la califiacion Carro al dado por parametro
     *
     * @param comentario comentario de la calificacion Carro
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Setea la venta de la calificacion Carro a la dada por parametro
     *
     * @param venta de la calificacion carro
     */
    public void setVenta(VentaEntity venta) {
        this.venta = venta;
    }

    /**
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return 3;
    }

    /**
     * Metodo Equals
     *
     * @param obj objeto a comparar
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CalificacionCarroEntity ce = (CalificacionCarroEntity) obj;
        return this.getId().equals(ce.getId());
    }

}
