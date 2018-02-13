/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.ProspectoCompraDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ProspectoCompraDetailDTO;
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
 * @author Felipe Velásquez Montoya
 */
@Path("clientes/{id:\\d+}/prospectoscompra")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ProspectoCompraResource {
    
    /**
     * GET api/clientes/(id)/prospectoscompra Retorna todos los prospectos de 
     * compra de un cliente dado.
     * 
     * <pre>Busca y devuelve todos los prospecros de compra del cliente dado.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los prospectos de compra del cliente.</code> 
     * </pre>
     * 
     * @param id cédula del cliente.
     * @return JSONArray  con la información de todos los prospectos de compra.
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    public List<ProspectoCompraDTO> getProspectosCompra(@PathParam("id") long id) throws BusinessLogicException{
        List<ProspectoCompraDTO> prospectosCompra = new ArrayList<>();
        return prospectosCompra;
    }
    
     /**
     * GET /api/clientes/(id)/prospectoscompra/(pid): Obtiene un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró el prospecto de compra..
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un un cliente o prospecto de compra con los id dados.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id del prospecto de compra.
     * @return JSON el prospecto de compra buscado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO getProspectoCompra(@PathParam("id") long id, @PathParam("pid") long pid) throws BusinessLogicException{
        return null;
    }
    
    /**
     * PUT /api/clientes/(id)/prospectoscompra/(pid): Obtiene un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó el prospecto de compra.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id del prospecto de compra.
     * @param prospecto prospecto de compra con la nueva información.
     * @return JSON el prospecto de compra actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO putProspectoCompra(@PathParam("id") long id, @PathParam("pid") long pid, ProspectoCompraDetailDTO prospecto) throws BusinessLogicException{
        return prospecto;
    }
    
    /**
     * POST /api/clientes/(id)/prospectoscompra: Crea un nuevo prospecto de compra.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó el prospecto de compra.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param prospecto el prospecto de compra que se añadirá.
     * @return JSON el prospecto de compra creado con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public ProspectoCompraDetailDTO postProspectoCompra(@PathParam("id") long id, ProspectoCompraDetailDTO prospecto)throws BusinessLogicException{
        return prospecto;
    }
    /**
     * DELETE /api/clientes/(id)/prospectoscompra/(pid):elimina un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó el prospecto de compra.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el cliente o prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param id id del cliente.
     * @param pid id del prospecto de compra.
     * @return JSON el prospecto de compra eliminado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @DELETE
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO deleteProspectoCompra(@PathParam("id") long id, @PathParam("pid") long pid) throws BusinessLogicException{
        return null;
    }
    
}
