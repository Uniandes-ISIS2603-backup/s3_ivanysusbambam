/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.VendedorDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.VendedorDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.VendedorLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
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
 * @author Felipe Velásquez Montoya
 */

@Path("vendedores")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class VendedorResource {
    
    @Inject
    private VendedorLogic vendedorLogic;
    
    /**
     * GET /api/vendedor: Retorna la información básica de todos los vendedores registrados.
     * 
     * <pre>Busca y devuelve todas las ciudades que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los vendedores de la aplicacion.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información básica de todos los vendedores.
     */
    @GET
    public List<VendedorDTO> getVendedores(){
       List<VendedorDTO> vendedores = new ArrayList<>();
       for(VendedorEntity v : vendedorLogic.findAllVendedores()){
           vendedores.add(new VendedorDTO(v));
       }
       
       return vendedores;
    }
    
    /**
     * GET /api/vendedores/(id): Obtiene un vendedor según su carnet.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se obtuvo el vendedor
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un vendedor con el id dado.
     * </code> 
     * </pre>
     * @param id carnet del vendedor buscado.
     * @return JSON el vendedor.
     * @throws BusinessLogicException si no existe el vendedor con el id dado.
     */
    @GET
    @Path("{id: \\d+}")
    public VendedorDetailDTO getVendedor(@PathParam("id") long id)throws BusinessLogicException{
        VendedorEntity ve = vendedorLogic.findVendedor(id);
        
        if(ve == null) throw new WebApplicationException("El recurso vendedor " + id + " no existe");
        
        return new VendedorDetailDTO(ve);
    }                   
    
    /**
     * POST /api/vendedores: Crea un nuevo vendedor
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se obtuvo el vendedor
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found Ya existía un vendedor con el id dado.
     * </code> 
     * </pre>
     * @param vendedor vendedor que se va a añadir.
     * @return JSON el vendedor recién añadido..
     * @throws BusinessLogicException si ya existía un vendedor con el mismo carnet.
     */
    @POST
    public VendedorDetailDTO postVendedor(VendedorDetailDTO vendedor) throws BusinessLogicException{
       
        //Esto lo hago pues por alguna razón en vendedorLogic, se devuelve directamente lo que se envió, es decir, 
        //el PuntoDeVentaEntity viene incompleto, con sólo el id.
       VendedorEntity ve = vendedorLogic.createVendedor(vendedor.toEntity());
       return new VendedorDetailDTO(vendedorLogic.findVendedor(ve.getCarnetVendedor()));
    }
    
    /**
     * PUT /api/vendedores/(id): Actualiza la información un vendedor según su carnet.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualizó el vendedor.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un vendedor con el id dado.
     * </code> 
     * </pre>
     * @param vendedor información actualizada del vendedor.
     * @param id carnet del vendedor buscado.
     * @return JSON con la información del vendedor actualizada.
     * @throws BusinessLogicException si no existe el vendedor con el id dado.
     */
    @PUT
    @Path("{id: \\d+}")
    public VendedorDetailDTO putVendedor(@PathParam("id") long id, VendedorDetailDTO vendedor) throws BusinessLogicException{
        VendedorEntity ve = vendedorLogic.findVendedor(id);
        
        if(ve == null) throw new WebApplicationException("El recurso vendedor " + id + " no existe");
        
        return new VendedorDetailDTO(vendedorLogic.updateVendedor(vendedor.toEntity()));
    }
    
    /**
     * DELETE /api/vendedores/(id): Elimina un vendedor según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se eliminó el vendedor.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un vendedor con el id dado.
     * </code> 
     * </pre>
     * @param id carnet del vendedor buscado.
     * @return JSON información del vendedor recién eliminado.
     * @throws BusinessLogicException si no existe el vendedor con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public VendedorDetailDTO deleteVendedor(@PathParam("id") long id) throws BusinessLogicException{
        VendedorEntity ve = vendedorLogic.findVendedor(id);
        
        if(ve == null) throw new WebApplicationException("El recurso vendedor " + id + " no existe");
        
        return new VendedorDetailDTO(vendedorLogic.deleteVendedor(id));
    }
}
