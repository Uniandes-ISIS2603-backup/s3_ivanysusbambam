/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.CalificacionCarroDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
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
/**
 *
 * @author if.garcia
 */

@Path("calificacionCarro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionCarroResource {
    
    /**
     * GET api/venta/(id)/calificacionCarro Retorna la calificacion de un carro 
     * respectivo a una venta.
     * 
     * <pre>Busca y devuelve la calificacion de un carro respectivo a una venta.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la calificacion de la venta indicada.</code> 
     * </pre>
     * 
     * @param id identificador unico de la venta.
     * @return JSON  con la información de la calificacion del carro vendido.
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionCarroDetailDTO getCalificacionCarro(@PathParam("id") Long id)throws BusinessLogicException{
        return null;
    }
    
    /**
     * PUT /api/centas/(idVenta)/CalificacionCarro/(idCarro): Obtiene un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó la calificación del carro.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param idVenta id de la venta.
     * @param idCarro id de la calificacion del carro.
     * @return JSON de la calificacion del carro actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @PUT
    @Path("{idCarro: \\d+")
    public CalificacionCarroDetailDTO putCalificacionCarro(@PathParam("idVenta") Long idVenta, @PathParam("idCarro") Long id) throws BusinessLogicException{
        return null;
    }
    
    
    /**
     * POST /api/ventas/(id)/prospectosCompra: Crea una nueva calificación de carro.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creóla nueva calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la venta con el id dado.
     * </code> 
     * </pre>
     * @param id id de la venta.
     * @param calificacionCarro la calificacion que se añadira que se añadirá.
     * @return JSON de la calificacion de carro creada con su id autoasignado.
     * @throws BusinessLogicException si no existe la venta con el id dado.
     */
    @POST
    public CalificacionCarroDetailDTO postCalificacionCarro(@PathParam("id") Long id, CalificacionCarroDetailDTO calificacionCarro)throws BusinessLogicException{
        return null;
    }
    
    
}
