/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una marca en la persistencia y permite su serialización
 *
 * @author Joseph Ortíz Moreno
 */
@Entity
public class MarcaEntity implements Serializable {

    /**
     * Automoviles de la marca
     */
    @PodamExclude
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    private List<AutomovilEntity> automoviles = new ArrayList<>();

    /**
     * Modelos de la marca
     */
    @PodamExclude
    @OneToMany(mappedBy = "marca", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ModelEntity> modelos = new ArrayList<>();

    /**
     * Logo/imagen de la marca
     */
    @Lob
    private String logo;

    /**
     * Id de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la entidad
     */
    private String name;

    /**
     * @return Id de la entidad
     */
    public Long getId() {
        return id;
    }

    /**
     * Seta el id de la entidad al dado por parametro
     *
     * @param id id de la entidad
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nombre de la enitdad
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre de la entidad al dado por parametro
     *
     * @param name nombre de la entidad
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Los automoviles de la marca
     */
    public List<AutomovilEntity> getAutomoviles() {
        return automoviles;
    }

    /**
     * @return los modelos de la marca
     */
    public List<ModelEntity> getModelos() {
        return modelos;
    }

    /**
     * Setea los automoviles de la marca a los dados por parametro
     *
     * @param autos autos de la marca
     */
    public void setAutomoviles(List<AutomovilEntity> autos) {
        this.automoviles = autos;
    }

    /**
     * Setea los modelos de la marca a los dados por parametro
     *
     * @param mods modelos de la marca
     */
    public void setModelos(List<ModelEntity> mods) {
        this.modelos = mods;
    }

    /**
     * @return el logo de la marca
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Setea el logo de la marca al dado por parametro
     *
     * @param logo logo de la marca
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Hash code
     *
     * @return
     */
    @Override

    public int hashCode() {
        return 3;
    }

    /**
     * Equals
     *
     * @param obj objeto con el que se compara
     * @return true si son equivalentes
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        return true;
    }

}
