/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link MarcaDTO} para manejar las relaciones entre los
 * Marca JSON y otros DTOs.
 *
 * @author Joseph Ortiz Moreno
 */
public class MarcaDetailDTO extends MarcaDTO {

    /**
     * Representa la lista de automóviles pertenecientes a una marca
     */
    private List<AutomovilDTO> automoviles;
    /**
     * Representa la lista de modelos pertenecientes a una marca
     */
    private List<ModelDTO> modelos;

    private Long id;

    //-----------------------------------------------------------------------------------------------------------------
    // Métodos Get
    //-----------------------------------------------------------------------------------------------------------------
    /**
     * Retorna la lista de automoviles pertenecientes a la marca
     *
     * @return Lista con los automoviles
     */
    public List<AutomovilDTO> getAutomoviles() {
        return automoviles;
    }

    /**
     * Retorna una lista con los modelos de la marca
     *
     * @return Lista con los modelos
     */
    public List<ModelDTO> getModelos() {
        return modelos;
    }

    public MarcaDetailDTO() {

    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la cual se construye el DTO
     */
    public MarcaDetailDTO(MarcaEntity entity) {
        super(entity);

        if (entity.getName() != null) {
            this.SetNombre(entity.getName());
        } else {
            entity.setName(null);
        }

        if (entity.getAutomoviles() != null) {
            automoviles = new ArrayList<>();
            for (AutomovilEntity entityAutomovil : entity.getAutomoviles()) {
                automoviles.add(new AutomovilDTO(entityAutomovil));
            }
        }

        if (entity != null) {
            if (entity.getName() != null) {
                this.SetNombre(entity.getName());
            } else {
                entity.setName(null);
            }
        }
        if (entity.getModelos()
                != null) {
            modelos = new ArrayList<>();
            for (ModelEntity entityModelo : entity.getModelos()) {
                modelos.add(new ModelDTO(entityModelo));
            }
        }
    }

    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa el libro.
     */
    @Override
    public MarcaEntity toEntity() {
        MarcaEntity marca = super.toEntity();
        if (this.getNombre() != null) {
            marca.setName(this.getNombre());
        }

        if (this.getId() != null) {
            marca.setId(id);
        }

        if (getModelos() != null) {
            List<ModelEntity> modelsEntity = new ArrayList<>();
            for (ModelDTO dtoModel : getModelos()) {
                modelsEntity.add(dtoModel.toEntity());
            }
            marca.setModelos(modelsEntity);
        }
        if (getAutomoviles() != null) {
            List<AutomovilEntity> autosEntity = new ArrayList<>();
            for (AutomovilDTO dtoAuto : automoviles) {
                autosEntity.add(dtoAuto.toEntity());
            }
            marca.setAutomoviles(autosEntity);
        }
        return marca;
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

    /**
     * Refresca la lista de modelos
     *
     * @param models Lista de modelos que se quiere mostrar
     */
    public void setModelos(List<ModelDTO> models) {
        this.modelos = models;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
