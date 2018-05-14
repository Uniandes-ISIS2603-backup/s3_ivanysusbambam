/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.QuejaReclamoDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.QuejaReclamoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
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
 * @author if.garcia y hd.castellanos
 */
@Path("quejasReclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejaReclamoResource {

    /**
     * atributo de la logia de la queja Reclamo
     */
    @Inject
    private QuejaReclamoLogic quejaLogic;

    /**
     * GET quejasReclamos Retorna todas las quejas y reclamos
     *
     *
     * <pre>Busca y devuelve todos las quejas y reclamos .
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las quejas y reclamos .</code>
     * </pre>
     *
     * @return JSONArray con la información de todas las quejas y reclamos .
     * @throws BusinessLogicException si no hay quejasReclamos
     */
    @GET
    public List<QuejaReclamoDTO> getQuejasReclamos() throws BusinessLogicException {
        List<QuejaReclamoDTO> quejasReclamos = new ArrayList<>();
        for (QuejaReclamoEntity qre : quejaLogic.findAllQuejasReclamos()) {
            quejasReclamos.add(new QuejaReclamoDetailDTO(qre));
        }
        return quejasReclamos;
    }

    /**
     * GET api/quejasReclamos/(pid): Obtiene una queja o reclamo según su id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró la queja o reclamo.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe  queja y relcamo con los id dados.
     * </code>
     * </pre>
     *
     * @param pid id de la queja o reclamo .
     * @return JSON la queja o reclamo buscada.
     * @throws BusinessLogicException la queja o reclamo con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO getQuejaReclamo(@PathParam("pid") Long pid) throws BusinessLogicException {
        QuejaReclamoEntity queja = quejaLogic.findQuejaReclamo(pid);

        if (queja == null) {
            throw new WebApplicationException("El recurso Queja reclamo " + pid + " no existe en la base de dtaos");
        } else {
            return new QuejaReclamoDetailDTO(queja);
        }
    }

    /**
     * PUT /api/quejasReclamos/(pid): actualiza una queja o reclamo según su id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó la queja o el reclamo .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la queja o reclamo con el id dado.
     * </code>
     * </pre>
     *
     * @param pid id de la queja o reclamo.
     * @param quejaReclamo queja o reclamo con la nueva información.
     * @return JSON la queja o reclamo actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o
     * la queja o reclamo con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public QuejaReclamoDetailDTO putQuejaReclamo(@PathParam("pid") Long pid, QuejaReclamoDetailDTO quejaReclamo) throws BusinessLogicException {
        QuejaReclamoEntity entity = quejaLogic.findQuejaReclamo(pid);

        if (entity == null) {
            throw new WebApplicationException("El recurso QuejaReclamo " + pid + " no esta persisitido");
        } else {
            return new QuejaReclamoDetailDTO(quejaLogic.updateQuejaReclamo(quejaReclamo.toEntity()));
        }

    }

    /**
     * POST /api/quejasReclamos: Crea una nueva queja o reclamo.
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
     * @param quejaReclamo la queja o reclamo que se añadirá.
     * @return JSON la queja o reclamo creado con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public QuejaReclamoDetailDTO postQuejaReclamo(QuejaReclamoDetailDTO quejaReclamo) throws BusinessLogicException {
        return new QuejaReclamoDetailDTO(quejaLogic.createQuejaReclamo(quejaReclamo.toEntity()));
    }

    /**
     * DELETE /api/quejasReclamos/(pid):elimina una queja o reclamo según su id.
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
     * @param id Identificador de la venta que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteQuejaReclamo(@PathParam("id") Long id) throws BusinessLogicException {
        QuejaReclamoEntity queja = quejaLogic.findQuejaReclamo(id);

        if (queja == null) {
            throw new WebApplicationException("El recurso quejaReclamo " + id + " no existe");
        }
        quejaLogic.deleteQuejaReclamo(queja.getId());
    }
}
