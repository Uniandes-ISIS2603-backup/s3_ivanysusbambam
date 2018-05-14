/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.CalificacionTiendaDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.CalificacionTiendaDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.CalificacionTiendaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
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
@Path("calificacionesTienda")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionTiendaResource {

    /**
     * Atributo para la logica de calificacionTienda
     */
    @Inject
    CalificacionTiendaLogic ctiendaLogic;

    /**
     * GET api/calificacionesTienda Retorna todos las calificaciones de carros
     *
     * <pre>Busca y devuelve todos las calificaciones de Tienda.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las calificaciones de Tienda del cliente.</code>
     * </pre>
     *
     * @return JSONArray con la información de todos las calificaciones de
     * Tienda.
     */
    @GET
    public List<CalificacionTiendaDetailDTO> getCalificacionesTienda() {
        List<CalificacionTiendaDetailDTO> pts = new ArrayList<>();
        for (CalificacionTiendaEntity pv : ctiendaLogic.getCalificacionesTienda()) {
            pts.add(new CalificacionTiendaDetailDTO(pv));
        }
        return pts;
    }

    /**
     * <h1>GET /api/calificacionesTienda/{id} : Obtener calificacion de una
     * Tienda por id.</h1>
     *
     * <pre>Busca la calificacion de una Tienda con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la calificacion de una Tienda correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe la calificacion de una Tienda con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la calificacion de una Tienda que se esta
     * buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PuntoDeVentaDetailDTO} - La calificacion de tienda
     * buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la calificacion de
     * una tienda.
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionTiendaDetailDTO getCalificacionTienda(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionTiendaEntity cc = ctiendaLogic.getCalificacionTienda(id);
        if (cc == null) {
            throw new WebApplicationException("El recurso prospecto de compra " + id + " no existe");
        }

        return new CalificacionTiendaDetailDTO(cc);
    }

    /**
     * <h1>PUT /api/calificacionesTienda/{id} : Actualizar una calificacionde
     * Tienda con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CalificacionTiendaDetailDTO}.
     *
     * Actualiza una calificacion de una tienda con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza una calificacion de tienda el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una calificacion de tienda con el id dado.
     * </code>
     * </pre>
     *
     * @param calificacion {@link CalificacionTiendaDetailDTO} La calificacionde
     * carro que se desea guardar.
     * @return JSON {@link CalificacionTiendaDTO} - La calificacion de Tienda
     * guardada.
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra una calificacion de
     * Tienda a actualizar.
     */
    @PUT
    public CalificacionTiendaDetailDTO putCalificacionCarro(CalificacionTiendaDetailDTO calificacion) throws BusinessLogicException {
        System.out.println("CAL: " + calificacion);
        CalificacionTiendaEntity cc = calificacion.toEntity();

        CalificacionTiendaEntity oldEntity = ctiendaLogic.getCalificacionTienda(calificacion.getId());
        if (oldEntity == null) {
            throw new WebApplicationException("El punto de venta no existe", 404);
        }

        cc.setCliente(oldEntity.getCliente());
        return new CalificacionTiendaDetailDTO(ctiendaLogic.updateCalificacionTienda(cc));
    }

    /**
     * POST /api/calificacionesTienda: Crea una nueva calificación de carro.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó la nueva calificacion.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la calificacion con el id dado.
     * </code>
     * </pre>
     *
     * @param calificacion la calificacion que se añadira que se añadirá.
     * @return JSON de la calificacion de carro creada con su id autoasignado.
     * @throws BusinessLogicException si no existe la venta con el id dado.
     */
    @POST
    public CalificacionTiendaDetailDTO postCalificacionTienda(CalificacionTiendaDetailDTO calificacion) throws BusinessLogicException {
        return new CalificacionTiendaDetailDTO(ctiendaLogic.createCalificacionTienda(calificacion.toEntity()));
    }

    /**
     * DELETE /api/calificacionTienda/{id} : Borrar una calificacion de Tienda
     * por id
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó la calificacion de la Tienda.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe la calificacion con el id dado.
     * </code>
     * </pre>
     *
     * @param id id de la calificacion.
     * @return JSON el de la calificacion de la Tienda actualizada.
     * @throws BusinessLogicException si no existe la calificacion de tienda con
     * el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacionTienda(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionTiendaEntity entity = ctiendaLogic.getCalificacionTienda(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        ctiendaLogic.deleteCalificacionTienda(id);
    }

}
