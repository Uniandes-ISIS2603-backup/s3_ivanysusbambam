/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.ProspectoCompraDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.ProspectoCompraLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;

import co.edu.uniandes.csw.ivanysusbambam.mappers.WebApplicationExceptionMapper;
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
 * @author Felipe Velásquez Montoya
 */
@Path("prospectoscompra")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ProspectoCompraResource {
    
    @Inject
    private ProspectoCompraLogic pcLogic;
    
    /**
     * GET api/prospectoscompra Retorna todos los prospectos de 
     * compra.
     * 
     * <pre>Busca y devuelve todos los prospectos de compra.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los prospectos de compra del cliente.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información de todos los prospectos de compra.
     * @throws BusinessLogicException si el cliente con el id dado no existe.
     */
    @GET
    public List<ProspectoCompraDetailDTO> getProspectosCompra() throws BusinessLogicException{
        List<ProspectoCompraDetailDTO> prospectosCompra = new ArrayList<>();
        for(ProspectoCompraEntity pc : pcLogic.findAllProspectosCompra()){
            prospectosCompra.add(new ProspectoCompraDetailDTO(pc));
        }
        return prospectosCompra;
    }
    
     /**
     * GET /api/prospectoscompra/(pid): Obtiene un prospecto de compra específico.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se encontró el prospecto de compra..
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param pid id del prospecto de compra.
     * @return JSON el prospecto de compra buscado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado..
     */
    @GET
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO getProspectoCompra(@PathParam("pid") long pid) throws BusinessLogicException{
        ProspectoCompraEntity pc = pcLogic.findProspectoCompra(pid);
        if(pc == null) throw new WebApplicationException("El recurso prospecto de compra " + pid+ " no existe");
        return new ProspectoCompraDetailDTO(pc);
    }
    
    /**
     * PUT /api/prospectoscompra/(pid): Obtiene un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó el prospecto de compra.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param pid id del prospecto de compra.
     * @param prospecto prospecto de compra con la nueva información.
     * @return JSON el prospecto de compra actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @PUT
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO putProspectoCompra(@PathParam("pid") long pid, ProspectoCompraDetailDTO prospecto) throws BusinessLogicException{
        ProspectoCompraEntity pc = pcLogic.findProspectoCompra(pid);
        
        if(pc == null) throw new WebApplicationException("El rescurso prospecto de compra " + pid + " no existe");
        
        return new ProspectoCompraDetailDTO(pcLogic.updateProspectoCompra(prospecto.toEntity()));
    }
    
    /**
     * POST /api/prospectoscompra: Crea un nuevo prospecto de compra.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se creó el prospecto de compra.
     * </code> 
     * </pre>
     * @param prospecto el prospecto de compra que se añadirá.
     * @return JSON el prospecto de compra creado con su id autoasignado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @POST
    public ProspectoCompraDetailDTO postProspectoCompra(ProspectoCompraDetailDTO prospecto)throws BusinessLogicException{
        //Por favor vea el comentario en el método POST de Vendedor para entender por qué se hacen dos accesos a la base de datos
        //en lugar de uno.
        ProspectoCompraEntity pc = pcLogic.createProspectoCompra(prospecto.toEntity());
        return new ProspectoCompraDetailDTO(pcLogic.findProspectoCompra(pc.getId()));
    }
    /**
     * DELETE /api/prospectoscompra/(pid):elimina un prospecto de compra según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó el prospecto de compra.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found no existe el prospecto de compra con el id dado.
     * </code> 
     * </pre>
     * @param pid id del prospecto de compra.
     * @return JSON el prospecto de compra actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado o el prospecto con el id dado.
     */
    @DELETE
    @Path("{pid: \\d+}")
    public ProspectoCompraDetailDTO deleteProspectoCompra(@PathParam("pid") long pid) throws BusinessLogicException{
        ProspectoCompraEntity pc = pcLogic.findProspectoCompra(pid);
        
        if(pc == null) throw new WebApplicationException("El recurso prospecto de compra " + pid + " no existe");
        
        return new ProspectoCompraDetailDTO(pcLogic.deleteProspectoCompra(pid));
    }
    
}
