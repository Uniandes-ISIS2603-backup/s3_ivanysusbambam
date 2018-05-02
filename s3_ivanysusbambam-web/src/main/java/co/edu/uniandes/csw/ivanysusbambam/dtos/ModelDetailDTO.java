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
 * Objeto de transferencia de datos detallado de un modelo. Hereda de ModelDTO
 * <br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *           "numeroPuertas" :Integer,
 *           "id": Integer,
 *           "cilindraje": Integer,
 *           "centCubicos":Double,
 *           "transmision":String,
 *           "automoviles":JSONArray
 *   }
 * </pre> Por ejemplo un modelo se representa así:<br>
 *
 * <pre>
 *   {
 *
 *           "numeroPuertas" :4,
 *           "id": 1,
 *           "cilindraje": 2000,
 *           "centCubicos":2000,
 *           "transmision":"mecanica",
 *           "automoviles":[{"color": "azul","anio": 2001,"placa": "XYZ123","chasis": 1,"fechaListado": "2018-05-13","valorListado": 5000000]
 *   }
 * </pre>
 *
 * @author Joseph ortiz Moreno
 */
public class ModelDetailDTO extends ModelDTO {

    /**
     * Representa la lista de automóviles pertenecientes a una marca
     */
    private List<AutomovilDTO> automoviles;

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

        //Revisar bien esta parte 
        if (entity.getAutomoviles() != null) {
            automoviles = new ArrayList<>();
            for (AutomovilEntity entityAuto : entity.getAutomoviles()) {
                automoviles.add(new AutomovilDTO(entityAuto));

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
