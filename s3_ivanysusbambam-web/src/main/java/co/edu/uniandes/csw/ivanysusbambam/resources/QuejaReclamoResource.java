/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDetailDTO;
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

/**
 *
 * @author if.garcia
 */

@Path("quejasReclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejaReclamoResource {
    
    
      /**
     * GET api/clientes/(id)/quejasReclamos Retorna todos los reclamos  
     * que un cliente ha puesto
     * 
     * <pre>Busca y devuelve todos los reclamos que un cliente ha dado.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los reclamos del cliente.</code> 
     * </pre>
     * 
     * @param id identificador unico del cliente.
     * @return JSONArray  con la información de todas las calificaciones del cliente.
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    public List<QuejaReclamoDTO> getQuejasReclamos(@PathParam("id") Long id) throws BusinessLogicException{
        return null;
    }
    
     /**
     * GET /api/clientes/(id)/quejasReclamos/(pid): Obtiene una calificacion según su id.
     * <pre> S
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró la calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un un cliente o calificacion con los id dados.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id de la calificacion.
     * @return JSON la calificacion de tienda buscada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o la calificacion con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO getQuejaReclamo(@PathParam("id") Long id, @PathParam("pid") Long pid) throws BusinessLogicException{
        return null;
    }
    
    /**
     * PUT /api/clientes/(id)/quejasReclamos/(pid): Actualiza una calificacion de una tienda según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó la calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o la calificacion con el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id de la calificacion de la tienda.
     * @return JSON el la calificacion de tienda actualizada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO putQuejaReclamo(@PathParam("id") long id, @PathParam("pid") long pid) throws BusinessLogicException{
        return null;
    }
    
    /**
     * POST /api/clientes/(id)/quejaReclamo: Crea un nuevo prospecto de compra.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó la nueva calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param calificacion calificacion de la tienda que se añadirá.
     * @return JSON la calificacion de la tienda creada con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public QuejaReclamoDetailDTO postQuejaReclamo(@PathParam("id") int id, QuejaReclamoDetailDTO calificacion)throws BusinessLogicException{
        return null;
    }
    /**
     * DELETE /api/clientes/(id)/quejasReclamos/(pid):elimina una calificacion según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó la calificacion.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o la calificacion con el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id de la calificacion de la tienda.
     * @return JSON de la calificacion de tienda actualizada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o la calificacion con el id dado.
     */
    @DELETE
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO deleteQuejaReclamo(@PathParam("id") int id, @PathParam("pid") int pid) throws BusinessLogicException{
        return null;
    }
}