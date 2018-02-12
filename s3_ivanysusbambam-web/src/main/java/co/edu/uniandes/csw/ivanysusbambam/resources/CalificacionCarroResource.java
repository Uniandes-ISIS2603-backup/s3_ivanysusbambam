/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.mappers.BusinessLogicExceptionMapper;
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
 * @author if.garcia
 */

@Path("calificacionCarro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionCarroResource {
    
    
}
