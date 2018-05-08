package co.edu.uniandes.csw.ivanysusbambam.resources;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ModelDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ModelDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.ModelLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseph Ortíz Moreno
 */
@Path("modelos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ModelResource {
    
    
    @Inject
    private ModelLogic logica;
    
     /**
     * GET /api/modelos: Retorna todos los modelos disponibles en el concesionario
     * Retorna la información de los modelos
     * @return JSON  con los modelos y su información
     */
       /**
     * <h1>GET /api/modelos : Obtener los modelos.</h1>
     * 
     * <pre>Retorna todos los modelos adscritos al concesionario
     * 
     * Códigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * 200 OK Retorna correctamente.</code> 
     * </pre>
     * @return JSONArray {@link ModelDTO} - Los modelos encontrados.
     */
    @GET
    public List<ModelDTO> getModelos(){
        List<ModelDTO> modelos = new ArrayList<>();
        for (ModelEntity md : logica.findAllModels()) {
            modelos.add(new ModelDetailDTO(md));
        }
        return modelos;
    }
     /**
     * GET /api/modelos: Retorna el modelo asociado con el id
     * @return JSON  con el modelo y su información
     */
       /**
     * <h1>GET /api/modelos : Obtener un modelo.</h1>
     * 
     * <pre>Retorna el modelo adscrito al concesionario, con el id deseado
     * 
     * Códigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * 200 OK Retorna correctamente.</code> 
     * </pre>
     * @return JSONArray {@link ModelDTO} - Los modelos encontrados.
     * @param id del modelo que se desea buscar
     */
    @Path("{Id: \\d+}")
    @GET
    public ModelDetailDTO getModelo(@PathParam("Id")Long id) throws BusinessLogicException{
        ModelEntity modelo = logica.findModel(id);

        if (modelo == null) {
            throw new WebApplicationException("El recurso modelo " + id + " no existe");
        } else {
            return new ModelDetailDTO(modelo);
        }
    }
    /**
     * <h1>POST /api/Modelos : Crea un nuevo modelo.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ModelDTO}.
     * 
     * Crea un modelo, similar al recibido por parámetro
     * 
     * Codigos de respuesta:
     * <code style="color:#2A0A0A;; background-color: #B40404;">
     * 200 OK Se creó correctamente el modelo
     * </code>
     * <code style="color: :#2A0A0A; background-color: #AEB404;">
     * 412 Precodition Failed: Ya existe el modelo
     * </code>
     * </pre>
     * @param nuevo {@link ModelDTO} - El modelo que se desea guardar
     * @return JSON {@link ModelDTO}  - El modelo que se creó
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error debido a la existencia del modelo que se deseaba crear.
     */
    @POST
    public ModelDetailDTO postModelo(ModelDetailDTO nuevo) throws BusinessLogicException{
         return new ModelDetailDTO(logica.createModel(nuevo.toEntity()));
    }
     /**
     * <h1>PUT /api/modelos/{id} : Actualizar el modelo con las especificaciones dadas.</h1>
     * <pre>Cuerpo de petición: JSON {@link ModelDTO}.
     * 
     * Actualiza el modelo con las especificaciones dadas por parámetro
     * 
     * Codigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * 200 OK Actualiza el modelo con las especificaciones dadas por parámetro y lo retorna.</code> 
     * <code style="color:#2A0A0A; background-color:#AEB404;">
     * 404 Not Found. No existe un modelo con el nombre dado por parámetro
     * </code> 
     * </pre>
     * @param id del modelo que se quiere actualizar
     * @param nuevo {@link ModeloDTO} El modelo que se quiere guardar
     * @return JSON {@link MarcaDTO} - El modelo guardado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error porque no existe un modelo con ese nombre
     */
    @Path("{Id: \\d+}")
    @PUT
    public ModelDetailDTO putModelo(@PathParam("Id") Long id, ModelDTO nuevo) throws BusinessLogicException{
        ModelEntity modelo = logica.findModel(id);
        
        if(modelo == null)
        {
            throw new BusinessLogicException("El recurso modelo:" +id+ "no existe en la base de dtaos ");
        }
        
        return new ModelDetailDTO(logica.updateModel(nuevo.toEntity()));
    }
          /**
     * <h1>DELETE /api/modelos/{id} : Borrar un modelo por el id.</h1>
     * 
     * <pre>Borra un modelo por el id asociado
     * 
     * Códigos de respuesta:<br>
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * 200 ok Elimina correctamente el modelo con el id asociado.</code>
     * <code style="color:#2A0A0A; background-color: #AEB404;">
     * 404 Not Found. No existe un modelo, con el id asociado.
     * </code>
     * </pre>
     * @param id Identificador del modelo que se desea borrar
     */
    @DELETE
    @Path("{Id: \\d+}")
     public void deleteModelo(@PathParam("Id") Long id) throws BusinessLogicException {
        ModelEntity modelo = logica.findModel(id);
        
        if(modelo == null)
        {
            throw new BusinessLogicException("El recurso modelo:" +id+ "no existe");
        }
        else
        {
           logica.deleteModel(id);
        }
    }
}

