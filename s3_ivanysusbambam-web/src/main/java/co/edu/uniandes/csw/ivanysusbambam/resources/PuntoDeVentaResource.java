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
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
 * @author if.garcia
 */

@Path("puntoDeVenta")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PuntoDeVentaResource {
    
    @POST
    public PuntoDeVentaDetailDTO createPuntoDeVenta(PuntoDeVentaDetailDTO auto) throws BusinessLogicException{
        return auto;
    }
    
    @GET
    public List<PuntoDeVentaDetailDTO> getPuntoDeVenta(){
        return new ArrayList<>();
    }
    
    @GET
    @Path("{id: \\d+}")
    public PuntoDeVentaDetailDTO getPuntoDeVenta(@PathParam("id") Long id){
        return null;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public PuntoDeVentaDetailDTO updatePuntoDeVenta(@PathParam("id") Long id, PuntoDeVentaDetailDTO auto) throws BusinessLogicException{
        return auto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public PuntoDeVentaDetailDTO deletePuntoDeVenta(@PathParam("id") Long id)throws BusinessLogicException{
        return null;
    }
}
