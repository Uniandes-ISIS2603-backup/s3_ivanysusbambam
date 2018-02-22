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
 * @author if.garcia y hd.castellanos
 */
@Path("quejasReclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejaReclamoResource {

    /**
     * GET api/clientes/(id)/quejasReclamos Retorna todas las quejas y reclamos
     * de un cliente dado.
     *
     * <pre>Busca y devuelve todos las quejas y reclamos del cliente dado.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las quejas y reclamos del cliente.</code>
     * </pre>
     *
     * @param id cédula del cliente.
     * @return JSONArray con la información de todas las quejas y reclamos .
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    public List<QuejaReclamoDTO> getQuejasReclamos(@PathParam("id") long id) throws BusinessLogicException {
        List<QuejaReclamoDTO> quejasReclamos = new ArrayList<>();
        return quejasReclamos;
    }

    /**
     * GET /api/clientes/(id)/quejasReclamos/(pid): Obtiene una queja o reclamo
     * según su id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró la queja o reclamo.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe  un cliente o queja y relcamo con los id dados.
     * </code>
     * </pre>
     *
     * @param id id del cliente.
     * @param pid id de la queja o reclamo .
     * @return JSON la queja o reclamo buscada.
     * @throws BusinessLogicException si no existe el cliente con el id dado o
     * la queja o reclamo con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO getQuejaReclamo(@PathParam("id") long id, @PathParam("pid") Long pid) throws BusinessLogicException {
        return null;
    }

    /**
     * PUT /api/clientes/(id)/quejasReclamos/(pid): actualiza una queja o
     * reclamo según su id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó la queja o el reclamo .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o la queja o reclamo con el id dado.
     * </code>
     * </pre>
     *
     * @param id id del cliente.
     * @param pid id de la queja o reclamo.
     * @param quejaReclamo queja o reclamo con la nueva información.
     * @return JSON la queja o reclamo actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o
     * la queja o reclamo con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO putProspectoCompra(@PathParam("id") long id, @PathParam("pid") Long pid, QuejaReclamoDetailDTO quejaReclamo) throws BusinessLogicException {
        return quejaReclamo;
    }

    /**
     * POST /api/clientes/(id)/quejasReclamos: Crea una nueva queja o reclamo.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó la queja o el reclamo.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente el id dado.
     * </code>
     * </pre>
     *
     * @param id id del cliente.
     * @param quejaReclamo la queja o reclamo que se añadirá.
     * @return JSON la queja o reclamo creado con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public QuejaReclamoDetailDTO postQuejaReclamo(@PathParam("id") long id, QuejaReclamoDetailDTO quejaReclamo) throws BusinessLogicException {
        return quejaReclamo;
    }

    /**
     * DELETE /api/clientes/(id)/quejasReclamos/(pid):elimina una queja o
     * reclamo según su id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó la queja o el reclamo.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o la queja o reclamo con el id dado.
     * </code>
     * </pre>
     *
     * @param id id del cliente.
     * @param pid id de la queja o reclamo .
     * @throws BusinessLogicException si no existe el cliente con el id dado o
     * la queja o reclamo con el id dado.
     */
    @DELETE
    @Path("{pid: \\d+}")
    public void deleteQuejaReclamo(@PathParam("id") long id, @PathParam("pid") Long pid) throws BusinessLogicException {

    }
}
