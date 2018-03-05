/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.CalificacionCarroDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.CalificacionCarroLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
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
/**
 *
 * @author if.garcia
 */

@Path("calificacionesCarro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionCarroResource {
    
    @Inject
    CalificacionCarroLogic ccarroLogic;
    
    /**
     * GET api/calificacionesCarro Retorna todos las calificaciones de carros
     * 
     * <pre>Busca y devuelve todos las calificaciones de carros.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las calificaciones de carros del cliente.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información de todos las calificaciones de carros.
     */
    @GET
    public List<CalificacionCarroDetailDTO> getCalificacionesCarroVenta(){
        List<CalificacionCarroDetailDTO> pts = new ArrayList<>();
        for(CalificacionCarroEntity pv : ccarroLogic.getCalificacionesCarro()) {
            pts.add(new CalificacionCarroDetailDTO(pv));
        }
        return pts;
    }
    
    /**
     * <h1>GET /api/calificacionesCarro/{id} : Obtener calificacion de un carro por id.</h1>
     *
     * <pre>Busca la calificacion de un carro con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la calificacion de un carro correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe la calificacion de un carro con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la calificacion de un carro que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CalificacionCarroDetailDTO} - La calificacion de carro buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra la calificacion de un carro.
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionCarroDetailDTO getCalificacionCarro(@PathParam("id") Long id)throws BusinessLogicException{
        CalificacionCarroEntity cc = ccarroLogic.getCalificacionCarro(id);
        if(cc == null) throw new WebApplicationException("El recurso prospecto de compra " + id + " no existe");

        return new CalificacionCarroDetailDTO(cc);
    }
    
     /**
     * <h1>PUT /api/calificacionesCarro/{id} : Actualizar una calificacionde carro con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CalificacionCarroDetailDTO}.
     *
     * Actualiza una calificacionde carro con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza una calificacionde carro el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una calificacionde carro con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la calificacionde carro que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param calificacion {@link CalificacionCarroDetailDTO} La calificacionde carro que se desea guardar.
     * @return JSON {@link CalificacionCarroDTO} - La calificacion de carro guardada.
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra una calificacionde carro a actualizar.
     */
    @PUT
    @Path("{idCarro: \\d+}")
    public CalificacionCarroDetailDTO putCalificacionCarro(@PathParam("idCarro") Long id, CalificacionCarroDetailDTO calificacion) throws BusinessLogicException{
        CalificacionCarroEntity cc = calificacion.toEntity();
        cc.setId(id);
        
        CalificacionCarroEntity oldEntity = ccarroLogic.getCalificacionCarro(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El punto de venta no existe", 404);
        }
        
        //TODO
        //cc.setVenta(oldEntity.getVenta());
        return new CalificacionCarroDetailDTO(ccarroLogic.updateCalificacionCarro(cc));
    }
    
    
    /**
     * POST /api/calificacionesCarro: Crea una nueva calificación de carro.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creóla nueva calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la calificacion con el id dado.
     * </code> 
     * </pre>
     * @param calificacionCarro la calificacion que se añadira que se añadirá.
     * @return JSON de la calificacion de carro creada con su id autoasignado.
     * @throws BusinessLogicException si no existe la venta con el id dado.
     */
    @POST
    public CalificacionCarroDetailDTO postCalificacionCarro(CalificacionCarroDetailDTO calificacionCarro)throws BusinessLogicException{
        return new CalificacionCarroDetailDTO(ccarroLogic.createCalificacionCarro(calificacionCarro.toEntity()));
    }
    
    /**
     * DELETE /api/calificacionCarro/{id} : Borrar una calificacion de carro por id
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó la calificacion del carro.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la calificacion id dado.
     * </code> 
     * </pre>
     * @param id id de la calificacion.
     * @return JSON el de la calificacion del carro actualizado.
     * @throws BusinessLogicException si no existe la calificacion con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacionCarro(@PathParam("id") Long id) throws BusinessLogicException{
        CalificacionCarroEntity entity = ccarroLogic.getCalificacionCarro(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
       ccarroLogic.deleteCalificacionTienda(id);
    }
    
    
}
