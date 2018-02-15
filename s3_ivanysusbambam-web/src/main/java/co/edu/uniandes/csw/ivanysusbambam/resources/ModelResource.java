package co.edu.uniandes.csw.ivanysusbambam.resources;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ModelDTO;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
     * Retorna correctamente.</code> 
     * </pre>
     * @return JSONArray {@link ModelDTO} - Los modelos encontrados.
     */
    @GET
    public List<ModelDTO> getModelos(){
        return null;
    }
     /**
     * GET /api/modelos: Retorna todos los modelos disponibles segun una especificacion
     * Retorna los modelos buscados bajo el filtro aplicaod
     * @return JSON  con los modelos y su información
     */
       /**
     * <h1>GET /api/modelos : Obtener los modelos.</h1>
     * 
     * <pre>Retorna todos los modelos adscritos al concesionario, con las especificaciones deseadas
     * 
     * Códigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * Retorna correctamente.</code> 
     * </pre>
     * @return JSONArray {@link ModelDTO} - Los modelos encontrados.
     * @param spec especificacion del modelo que se desea buscar
     */
    @Path("{spec: \\d+}")
    @GET
    public ModelDTO getModelo(@PathParam("nombre")String spec){
        return null;
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
     * Se creó correctamente el modelo
     * </code>
     * <code style="color: :#2A0A0A; background-color: #AEB404;">
     * 412 Precodition Failed: Ya existe el modelo
     * </code>
     * </pre>
     * @param Nuevo {@link ModelDTO} - El modelo que se desea guardar
     * @return JSON {@link ModelDTO}  - El modelo que se creó
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error debido a la existencia del modelo que se deseaba crear.
     */
    @POST
    public ModelDTO postModelo(ModelDTO Nuevo) throws BusinessLogicException{
         return null;
    }
     /**
     * <h1>PUT /api/modelos/{id} : Actualizar el modelo con las especificaciones dadas.</h1>
     * <pre>Cuerpo de petición: JSON {@link ModelDTO}.
     * 
     * Actualiza el modelo con las especificaciones dadas por parámetro
     * 
     * Codigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * Actualiza el modelo con las especificaciones dadas por parámetro y lo retorna.</code> 
     * <code style="color:#2A0A0A; background-color:#AEB404;">
     * 404 Not Found. No existe un modelo con el nombre dado por parámetro
     * </code> 
     * </pre>
     * @param Nombre Nombre del modelo que se quiere actualizar
     * @param Nuevo {@link ModeloDTO} El modelo que se quiere guardar
     * @return JSON {@link MarcaDTO} - El modelo guardado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error porque no existe un modelo con ese nombre
     */
    @Path("{Nombre: \\d+}")
    @PUT
    public ModelDTO putModelo(@PathParam("Nombre") String Nombre, ModelDTO Nuevo) throws BusinessLogicException{
        return null;
    }
          /**
     * <h1>DELETE /api/modelos/{id} : Borrar un modelo por la placa.</h1>
     * 
     * <pre>Borra un modelo por la placa asociada
     * 
     * Códigos de respuesta:<br>
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * Elimina correctamente el modelo con la placa asociada.</code>
     * <code style="color:#2A0A0A; background-color: #AEB404;">
     * 404 Not Found. No existe un modelo, con la placa asociada.
     * </code>
     * </pre>
     * @param placa Identificador de la placa perteneciente al modelo que se desea borrar
     */
    @DELETE
    @Path("{nomMarca: \\d+}")
     public void deleteModelo(@PathParam("nomMarca") String placa) {
        //ssssssss
    }
}

