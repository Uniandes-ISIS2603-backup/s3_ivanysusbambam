/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MedioDePagoResource 
{   
    
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
     * @return JSONArray  con la información básica de todos los medios de pago.
     */
    @GET
    public List<MedioDePagoDetailDTO> getMediosDePago(){
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
     * @param numero de medio de pago que se busca.
     * @return JSON el medio de pago buscado.
     */
    
    @GET
    @Path("{id: \\d+}")
    public MedioDePagoDetailDTO getMedioDePago(@PathParam("id")Long numero){
         //TODO si no existe debe disparar WebApplicationException pero no hacer este try catch
        try {
            MedioDePagoEntity entity = mdpLogic.findMedioDePago(numero);
            return new MedioDePagoDetailDTO(entity);
        } catch (BusinessLogicException ex) {
            throw new WebApplicationException("El recurso /medios_de_pago/" + numero + "no existe", 404);
        }
    }
   
    @POST
    public MedioDePagoDTO createMedioDePago(MedioDePagoDetailDTO mdp) {
        //TODO si no existe debe disparar WebApplicationException pero no hacer este try catch
        try {
            return new MedioDePagoDetailDTO(mdpLogic.createMedioDePago(mdp.toEntity()));
        } catch (BusinessLogicException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
     /**
     * <h1>PUT /api/MediosDePago/{id} : Actualizar MediosDePago con el numero dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MedioDePagoDTO}.
     * 
     * Actualiza el medio del pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la compra con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del medio de pago que se desea actualizar.
     * @param compra {@link MedioDePagoDTO} El medio de pago que se desea actualizat.
     * @return JSON {@link CompraDetailDTO} - El medio de pago actualizado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el medio de pago porque ya existe una con ese id.
     */
    
    @PUT
    @Path("{numeroMedioDePago: \\d+}")
    public MedioDePagoDetailDTO updateMedioDePago(@PathParam("numeroMedioDePago") Long numeroMedioDePago, MedioDePagoDetailDTO mdp)
    {
        mdp.setNumero(numeroMedioDePago);
        //TODO si no existe debe disparar WebApplicationException pero no hacer este try catch
        try {
            return new MedioDePagoDetailDTO(mdpLogic.updateMedioDePago(mdp.toEntity()));
        } catch (BusinessLogicException ex) {
            throw new WebApplicationException("El recurso /medios_de_pago/" + numeroMedioDePago + "no existe", 404);
        }
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
     * @param id Identificador de la compra que se desea borrar. 
     */
    
    @DELETE
    @Path("{numeroMedioDePago: \\d+}")
    public void deleteMedioDePago(@PathParam("numeroMedioDePago") Long numeroMedioDePago)
    {//TODO si no existe debe disparar WebApplicationException pero no hacer este try catch
        try {
            mdpLogic.deleteMedioDePago(numeroMedioDePago);
        } catch (BusinessLogicException ex) {
            throw new WebApplicationException("El recurso /medios_de_pago/" + numeroMedioDePago + "no existe", 404);
        }
    }
    
    private List<MedioDePagoDetailDTO> listEntity2DTO(List<MedioDePagoEntity> entityList) {
        List<MedioDePagoDetailDTO> list = new ArrayList<>();
        for (MedioDePagoEntity entity : entityList) {
            list.add(new MedioDePagoDetailDTO(entity));
        }
        return list;
    }
    
    
}
