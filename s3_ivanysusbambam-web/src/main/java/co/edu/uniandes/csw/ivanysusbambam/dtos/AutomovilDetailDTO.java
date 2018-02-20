/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;

/**
 * Clase que extiende de {@link AutomovilDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del automovil vaya a la documentacion de {@link AutomovilDTO}
 * @author a.bravo
 */
public class AutomovilDetailDTO extends AutomovilDTO{
    /**
     * Constructor por defecto
     */
    public AutomovilDetailDTO(){
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad del automovil a partir de la cual se construye el objeto
     */
    public AutomovilDetailDTO(AutomovilEntity entity){
        super(entity);
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public AutomovilEntity toEntity(){
        AutomovilEntity autoE = super.toEntity();
        return autoE;
    }
}
