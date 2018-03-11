package co.edu.uniandes.csw.ivanysusbambam.resources;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MarcaDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MarcaDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ModelDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ModelDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.MarcaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseph Ortíz Moreno
 */
@Path("marcas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MarcaResource {
    
    @Inject
    private MarcaLogic logica;
     /**
     * GET /api/marcas: Retorna todas las marcas disponibles.
     * Retorna la información de las marcas registradas
     * @return JSON  con las marcas y su información
     */
       /**
     * <h1>GET /api/marcas : Obtener todas las marcas.</h1>
     * 
     * <pre>Retorna todas las marcas adscritas al concesionario
     * 
     * Códigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * Retorna correctamente.</code> 
     * </pre>
     * @return JSONArray {@link MarcaDTO} - Las marcas encontradas.
     */
    @GET
    public List<MarcaDTO> getMarcas(){
        List<MarcaDTO> marc = new ArrayList<MarcaDTO>();
        for(MarcaEntity c: logica.findAllMarcas()){
            marc.add(new MarcaDetailDTO(c));
        }
        return marc;
    }
    /**
     * <h1>GET /api/marcas/{nombre} : Buscar marca por Id.</h1>
     * 
     * <pre>Busca la marca requerida y la retorna
     * 
     * Códigos de respuesta:
     * <code style="color:#2A0A0A; background-color: #B40404;">
     * Retorna correctamente la marca según su id
     * </code> 
     * <code style="color: #2A0A0A; background-color: #AEB404;">
     * 404 Not Found No existe la marca que se  busca
     * </code> 
     * </pre>
     * @param Id Identificador de la marca que se busca
     * @return JSON {@link MarcaDTO} - Representa la marca buscada
     */
    @Path("{Id: \\d+}")
    @GET
    public MarcaDetailDTO getMarca(@PathParam("Id")Long id) throws BusinessLogicException{
        MarcaEntity  mdl = logica.findMarca(id);
        MarcaDetailDTO nueva = null;
        if(mdl == null){
            throw new BusinessLogicException("El resource marca "+id+" no existe");
        }
        else
        {
            return new MarcaDetailDTO(mdl);
        }
    }
           /**
     * <h1>POST /api/Marcas : Crea una nueva marca.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link MarcaDTO}.
     * 
     * Crea una marca, como la recibida por parámetro
     * 
     * Codigos de respuesta:
     * <code style="color:#2A0A0A;; background-color: #B40404;">
     * Se creó correctamente la marca
     * </code>
     * <code style="color: :#2A0A0A; background-color: #AEB404;">
     * 412 Precodition Failed: Ya existe la marca
     * </code>
     * </pre>
     * @param Nueva {@link MarcaDTO} - La marca que se desea guardar
     * @return JSON {@link MarcaDTO}  - La marca que se creó
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error debido a la existencia de la marca que se deseaba crear.
     */
    @POST
    public MarcaDetailDTO postMarca(MarcaDetailDTO Nueva) throws BusinessLogicException{
         return new MarcaDetailDTO(logica.createMarca(Nueva.toEntity()));
    }
     /**
     * <h1>PUT /api/marcas/{id} : Actualizar la marca con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MarcaDTO}.
     * 
     * Actualiza la marca con el id dado por parámetro.
     * 
     * Codigos de respuesta:
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * 200 OK Actualiza la marca con el id dado por parámetro y la retorna.</code> 
     * <code style="color:#2A0A0A; background-color:#AEB404;">
     * 404 Not Found. No existe una marca con el id dado
     * </code> 
     * </pre>
     * @param id de la marca que se quiere actualizar
     * @param Nuevo {@link MarcaDTO} La marca que se quiere guardar
     * @return JSON {@link MarcaDTO} - La marca guardada
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error porque no existe una marca con ese id
     */
    @Path("{Id: \\d+}")
    @PUT
    public MarcaDetailDTO putMarca(@PathParam("Id") Long id, MarcaDetailDTO Nuevo) throws BusinessLogicException{
      MarcaEntity mar = logica.findMarca(id);
      if(mar == null){
          throw new BusinessLogicException("El recurso marca" +id+ "no existe");
      }
      else{
          return new MarcaDetailDTO(logica.updateMarca(mar));
      }
    }
      /**
     * <h1>DELETE /api/marcas/{id} : Borrar una marca por id.</h1>
     * 
     * <pre>Borra la marca con el id asociado
     * 
     * Códigos de respuesta:<br>
     * <code style="color: #2A0A0A; background-color: #B40404;">
     * Elimina correctamente la marca con el id asociado.</code>
     * <code style="color:#2A0A0A; background-color: #AEB404;">
     * 404 Not Found. No existe una marca, con el id asociado.
     * </code>
     * </pre>
     * @param nombr Identificador de la marca que se desea borrar
     */
    @DELETE
    @Path("{Id: \\d+}")
     public void deleteMarca(@PathParam("Id") Long id) throws BusinessLogicException {
        MarcaEntity entity = logica.findMarca(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso marca" + id + " no existe.");
        }
        logica.deleteMarca(id);
    }
    
}
