/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
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
 * @author juliana
 */
@Path("mediosDePago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioDePagoResource {

    @Inject
    MedioDePagoLogic mdpLogic;

    /**
     * GET /api/MediosDePago: Retorna todos los medios de pagos registrados.
     *
     * <pre>Busca y devuelve todos los medios de pago que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los medios de pago de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray con la información básica de todos los medios de pago.
     */
    @GET
    public List<MedioDePagoDetailDTO> getMediosDePago() {
        return listEntity2DTO(mdpLogic.findAll());
    }

    /**
     * GET /api/MediosDePago/(id): Obtiene un medio de pago según el id.
     * <pre>
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el medio de pago correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code>
     * </pre>
     *
     * @param numero de medio de pago que se busca.
     * @return JSON el medio de pago buscado.
     * @throws BusinessLogicException si número == null
     */

    @GET
    @Path("{id: \\d+}")
    public MedioDePagoDetailDTO getMedioDePago(@PathParam("id") Long numero) throws BusinessLogicException {

        MedioDePagoEntity entity = mdpLogic.findMedioDePago(numero);

        if (entity == null) {
            throw new WebApplicationException("El medio de pago de id " + numero + " no existe");
        }

        return new MedioDePagoDetailDTO(entity);
    }

    @POST
    public MedioDePagoDTO createMedioDePago(MedioDePagoDetailDTO mdp) throws BusinessLogicException {
        return new MedioDePagoDetailDTO(mdpLogic.createMedioDePago(mdp.toEntity()));
    }

    /**
     * <h1>PUT /api/MediosDePago/{id} : Actualizar MediosDePago con el numero
     * dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MedioDePagoDTO}.
     *
     * Actualiza el medio del pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el medio de pago con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con el id dado.
     * </code>
     * </pre>
     *
     * @param numeroMedioDePago id del medio de pago que se quiere actualizar
     * @param mdp medio de pago con la información actualizada.
     * @return JSON - El medio de pago actualizado.
     */
    @PUT
    @Path("{numeroMedioDePago: \\d+}")
    public MedioDePagoDetailDTO updateMedioDePago(@PathParam("numeroMedioDePago") Long numeroMedioDePago, MedioDePagoDetailDTO mdp) throws BusinessLogicException{
        
        mdp.setNumero(numeroMedioDePago);
        MedioDePagoEntity nMdp = mdpLogic.updateMedioDePago(mdp.toEntity());

        if (nMdp == null) {
            throw new BusinessLogicException("no fue posible actualizar el mediod de pago");
        }
        return new MedioDePagoDetailDTO(nMdp);
    }

    /**
     * <h1>DELETE /api/MediosDePago/{id} : Borrar medio de pago por id.</h1>
     *
     * <pre>Borra la el medio de pago con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el medio de pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con el id dado.
     * </code>
     * </pre>
     *
     * @param numeroMedioDePago identificador del medio de pago que se desea eliminar.
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException si re romple alguna regla de negocio
     */
    @DELETE
    @Path("{numeroMedioDePago: \\d+}")
    public void deleteMedioDePago(@PathParam("numeroMedioDePago") Long numeroMedioDePago) throws BusinessLogicException {
        MedioDePagoEntity ve = mdpLogic.findMedioDePago(numeroMedioDePago);
        
        if(ve == null) throw new WebApplicationException("El recurso medio de pago " + numeroMedioDePago + " no existe");
        
        mdpLogic.deleteMedioDePago(numeroMedioDePago);
    }

    private List<MedioDePagoDetailDTO> listEntity2DTO(List<MedioDePagoEntity> entityList) {
        List<MedioDePagoDetailDTO> list = new ArrayList<>();
        for (MedioDePagoEntity entity : entityList) {
            list.add(new MedioDePagoDetailDTO(entity));
        }
        return list;
    }

}
