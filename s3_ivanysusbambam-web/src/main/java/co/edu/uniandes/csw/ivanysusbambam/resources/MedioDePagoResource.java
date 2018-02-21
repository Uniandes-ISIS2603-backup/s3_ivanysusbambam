/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDTO;
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
 * @author juliana
 */
@Path("MediosDePago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioDePagoResource 
{
    
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
    public List<MedioDePagoDTO> getClientes(){
        //List clientes = null;
        List<MedioDePagoDTO> medioDePagos =  new ArrayList<>();
        return medioDePagos;
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
    public MedioDePagoDTO getMedioDePago(@PathParam("id")long numero){
        return null;
    }
    /**
     * POST /api/MediosDePago: Crea un nuevo medio de pago.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se crea el nuevo medio de pago
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un medio de pago con el numero dado.
     * </code> 
     * </pre>
     * @param MedioDePagoDTO {@link CompraDetailDTO} el medio de pago.
     * @return JSON {@link CompraDetailDTO} el medio de pago recien creado.
     * @throws BusinessLogicException si ya existe el medio de pago.
     */
    @POST
    public MedioDePagoDTO postCliente(MedioDePagoDTO mdp ) throws BusinessLogicException{
        //Debe retornar el DetailDTO correspondiente al DTO que le entra por param.
        return null;
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
    @Path("{idMedioDePago: \\d+}")
    public MedioDePagoDTO updateMedioDePago(@PathParam("numeroMedioDePago") String numeroMedioDePago, MedioDePagoDTO mdp)
    {
        return mdp;
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
     @Path("{idMedioDePago: \\d+}")
    public MedioDePagoDTO deleteMedioDePago(@PathParam("idMedioDePago") String numeroMedioDePago,MedioDePagoDTO mdp)
    {
        return mdp;
    }
    
    
    
}
