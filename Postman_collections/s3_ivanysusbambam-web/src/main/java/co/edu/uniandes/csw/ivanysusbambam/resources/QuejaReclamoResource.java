/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
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

@Path("quejasreclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejaReclamoResource {
    
    
      /**
     * GET api/quejasReclamos Retorna todos los reclamos
     * 
     * <pre>Busca y devuelve todos los reclamos .
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los reclamos </code> 
     * </pre>
     * 
     * @return JSONArray  con la información de todas las calificaciones del cliente.
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    public List<QuejaReclamoDTO> getQuejasReclamos() throws BusinessLogicException{
        return new ArrayList<>();
    }
    
     /**
     * GET /api/quejasReclamos/(pid): Obtiene una queja/reclamo según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró la queja o reclamo.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un un cliente o calificacion con los id dados.
     * </code> 
     * </pre>
     * @param pid id de la queja/reclamo
     * @return JSON la calificacion de tienda buscada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o la calificacion con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO getQuejaReclamo(@PathParam("pid") Long pid) throws BusinessLogicException{
        return null;
    }
    
    /**
     * PUT /api/quejasReclamos/(pid): Actualiza una queja reclamo según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó queja o reclamo.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la queja o reclamo con el id dado.
     * </code> 
     * </pre>
     * @param queja queja o reclamo con la información actualizada.
     * @param pid id de la calificacion de la tienda.
     * @return JSON el la calificacion de tienda actualizada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO putQuejaReclamo(@PathParam("pid") long pid, QuejaReclamoDetailDTO queja)  throws BusinessLogicException{
        return queja;
    }
    
    /**
     * POST /api/quejasreclamos: Crea una nueva queja o reclamo.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó la nueva calificacion.
     * </code> 
     * </pre>
     * @param queja que se añadirá.
     * @return JSON la calificacion de la tienda creada con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public QuejaReclamoDetailDTO postQuejaReclamo(QuejaReclamoDetailDTO queja)throws BusinessLogicException{
        return queja;
    }
    /**
     * DELETE /api/clientes/quejasReclamos/(pid):elimina una calificacion según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó la la queja o reclamo.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la queja con el id dado.
     * </code> 
     * </pre>
     * @param pid id de la queja.
     * @return JSON con la queja eliminada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o la calificacion con el id dado.
     */
    @DELETE
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO deleteQuejaReclamo(@PathParam("pid") int pid) throws BusinessLogicException{
        return null;
    }
}
