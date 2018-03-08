/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link ModelDTO} para manejar las relaciones entre los
 * Model JSON y otros DTOs.
 *
 * @author Joseph Ortiz Moreno
 */
public class ModelDetailDTO extends ModelDTO {

    /**
     * Representa la lista de automóviles pertenecientes a una marca
     */
    private List<AutomovilDTO> automoviles;

    

    /**
     * =======
     *
     * /**
     * >>>>>>> d72aac146e12e938887e2305fd868434aea7ce9a Representa el numero de
     * puertas del vehículo
     */
    private Integer numeroPuertas;
    /**
     * Representa la transmisión del vehículo
     */
    private String transmision;
    /**
     * Representa el cilindraje del vehículo
     */
    private Integer cilindraje;
    /**
     * Representa los centímetros cúbicos
     */
    private Double centCubicos;

    public ModelDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la cual se construye el DTO
     */
    public ModelDetailDTO(ModelEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getCentCubicos() != null) {
                this.centCubicos = entity.getCentCubicos();
            } else {
                entity.setCentCubicos(null);
            }
            if (entity.getCilindraje() != null) {
                this.cilindraje = entity.getCilindraje();
            } else {
                entity.setCilindraje(null);
            }
            if (entity.getNumeroPuertas() != null) {
                this.numeroPuertas = entity.getNumeroPuertas();
            } else {
                entity.setNumeroPuertas(null);
            }
            if (entity.getTransmision() != null) {
                this.transmision = entity.getTransmision();
            } else {
                entity.setTransmision(null);
            }
            
            //Revisar bien esta parte 
            if (entity.getAutomoviles() != null) {
                automoviles = new ArrayList<>();
                for (AutomovilEntity entityAuto : entity.getAutomoviles()) {
                    automoviles.add(new AutomovilDTO(entityAuto));

                }
            }
        }
    }

    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa el libro.
     */
    @Override
    public ModelEntity toEntity() {
        ModelEntity modl = super.toEntity();

        if (this.getCentCubicos() != null) {
            modl.setCentCubicos(this.getCentCubicos());
        }
        if (this.getCilindraje() != null) {
            modl.setCilindraje(this.getCilindraje());
        }
        if (this.getNumeroPuertas() != null) {
            modl.setNumeroPuertas(this.getNumeroPuertas());
        }
        if (this.getTransmision() != null) {
            modl.setTransmision(this.getTransmision());
        }

        if (getAutomoviles() != null) {
            List<AutomovilEntity> autosEntity = new ArrayList<>();
            for (AutomovilDTO dtoAuto : getAutomoviles()) {
                autosEntity.add(dtoAuto.toEntity());
            }
            modl.setAutomoviles(autosEntity);
        }

        return modl;
    }
    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Set
    //-----------------------------------------------------------------------------------------------------------------

    /**
     * Refresca la lista de automoviles
     *
     * @param listaAuto Nueva lista que se quiere mostrar
     */
    public void setAutomoviles(List<AutomovilDTO> listaAuto) {
        this.automoviles = listaAuto;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Get
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Retorna la lista de automoviles pertenecientes a un modelo
     *
     * @return Lista con los automoviles
     */
    public List<AutomovilDTO> getAutomoviles() {
        return automoviles;
    }

    

}
