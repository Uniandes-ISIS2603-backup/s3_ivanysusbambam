/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.AutomovilDetailDTO;
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
 * @author a.bravo
 */
@Path("automoviles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AutomovilResource {
    @POST
    public AutomovilDetailDTO createAutomovil(AutomovilDetailDTO auto) throws BusinessLogicException{
        return auto;
    }
    
    @GET
    public List<AutomovilDetailDTO> getAutomoviles(){
        return new ArrayList<>();
    }
    
    @GET
    @Path("{id: \\d+}")
    public AutomovilDetailDTO getAutomovil(@PathParam("id") Long id){
        return null;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public AutomovilDetailDTO updateAutomovil(@PathParam("id") Long id, AutomovilDetailDTO auto) throws BusinessLogicException{
        return auto;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAutomovil(@PathParam("id") Long id)throws BusinessLogicException{
        
    }
}
