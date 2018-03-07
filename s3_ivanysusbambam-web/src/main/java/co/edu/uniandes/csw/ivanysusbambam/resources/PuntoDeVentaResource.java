/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

/**
 *
 * @author if.garcia
 */

import co.edu.uniandes.csw.ivanysusbambam.dtos.PuntoDeVentaDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.PuntoDeVentaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
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

@Path("puntosDeVenta")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PuntoDeVentaResource {
    
    @Inject
    private PuntoDeVentaLogic puntoDeVentaLogic;
    /**
     * GET api/puntosDeVenta Retorna todos los puntos de 
     * venta.
     * 
     * <pre>Busca y devuelve todos los puntos de venta.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los puntos de venta del cliente.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información de todos los puntos de venta.
     */
    @GET
    public List<PuntoDeVentaDetailDTO> getPuntosDeVenta(){
        List<PuntoDeVentaDetailDTO> pts = new ArrayList<>();
        for (PuntoDeVentaEntity pv : puntoDeVentaLogic.getPuntosDeVenta()) {
            pts.add(new PuntoDeVentaDetailDTO(pv));
        }
        return pts;
    }
    
    /**
     * <h1>GET /api/puntosDeVenta/{id} : Obtener punto de venta por id.</h1>
     *
     * <pre>Busca el punto de venta con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el punto de venta correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un punto de venta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del punto de venta que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PuntoDeVentaDetailDTO} - El punto de venta buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra el punto de venta.
     */
    @GET
    @Path("{id: \\d+}")
    public PuntoDeVentaDetailDTO getPuntoDeVenta(@PathParam("id") Long id){
        PuntoDeVentaEntity pv = puntoDeVentaLogic.getPuntoDeVenta(id);
        if(pv == null) throw new WebApplicationException("El recurso prospecto de compra " + id+ " no existe");
        return new PuntoDeVentaDetailDTO(pv);
    }
    
    /**
     * <h1>PUT /api/puntosDeVenta/{id} : Actualizar punto de venta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PuntoDeVentaDetailDTO}.
     *
     * Actualiza el punto de venta con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el punto de venta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un punto de venta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del punto de venta que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param pv {@link PuntoDeVentaDetailDTO} El punto de venta que se desea guardar.
     * @return JSON {@link PuntoDeVentaDTO} - El punto de venta guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra el punto de venta a actualizar.
     */
    @PUT
    @Path("{id: \\d+}")
    public PuntoDeVentaDetailDTO updatePuntoDeVenta(@PathParam("id") Long id, PuntoDeVentaDetailDTO pv) throws BusinessLogicException{
        PuntoDeVentaEntity entity = pv.toEntity();
        entity.setId(id);
        PuntoDeVentaEntity oldEntity = puntoDeVentaLogic.getPuntoDeVenta(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El punto de venta no existe", 404);
        }
//        entity.setAutomoviles(oldEntity.getAutomoviles());
//        entity.setCompras(oldEntity.getCompras());
//        entity.setVendedores(oldEntity.getVendedores());
//        entity.setAutomoviles(oldEntity.getAutomoviles());
        return new PuntoDeVentaDetailDTO(puntoDeVentaLogic.updatePuntoDeVenta(id, entity));
    }
    
    /**
     * <h1>DELETE /api/puntosDeVenta/{id} : Borrar punto de venta por id.</h1>
     *
     * <pre>Borra el punto de venta con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el punto de venta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un punto de venta con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del punto de venta que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePuntoDeVenta(@PathParam("id") Long id)throws BusinessLogicException{
        PuntoDeVentaEntity entity = puntoDeVentaLogic.getPuntoDeVenta(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
       puntoDeVentaLogic.deletePuntoDeVenta(id);
    }
    
    
    /**
     * <h1>POST /api/puntosDeVenta : Crear un punto de venta.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link PuntoDeVentaDetailDTO}.
     * 
     * Crea un nuevo punto de venta con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo punto de venta .
     * </code>
     * </pre>
     * @param  pv{@link PuntoDeVentaDetailDTO} - EL punto de venta que se desea guardar.
     * @return JSON {@link PuntoDeVentaDetailDTO}  - El punto de venta guardado con el atributo id autogenerado.
     */
    @POST
    public PuntoDeVentaDetailDTO createPuntoDeVenta(PuntoDeVentaDetailDTO pv) throws BusinessLogicException{
        return new PuntoDeVentaDetailDTO(puntoDeVentaLogic.createPuntoDeVenta(pv.toEntity()));
    }
}
