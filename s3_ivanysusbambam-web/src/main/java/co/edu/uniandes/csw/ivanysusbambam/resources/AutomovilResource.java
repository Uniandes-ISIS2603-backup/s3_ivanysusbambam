/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.AutomovilDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.AutomovilLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
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
 * <pre>Clase que implementa el recurso "automoviles".
 * URL: /api/automoviles
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "automoviles".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author a.bravo  
 * @version 1.0
 */
@Path("automoviles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AutomovilResource {
    
    @Inject
    private AutomovilLogic autoLogic;
    /**
     * <h1>POST /api/automoviles : Crear una ciudad.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link AutomovilDetailDTO}.
     * 
     * Crea un nuevo auto con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo automovil .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el automovil.
     * </code>
     * </pre>
     * @param auto {@link AutomovilDetailDTO} - El automovil que se desea guardar.
     * @return JSON {@link AutomovilDetailDTO}  - El automovil guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el  automovil.
     */
    @POST
    public AutomovilDetailDTO createAutomovil(AutomovilDetailDTO auto) throws BusinessLogicException{
        return new AutomovilDetailDTO(autoLogic.createAutomovil(auto.toEntity()));
   
    }
    
    /**
     * <h1>GET /api/automoviles : Obtener todos los automoviles.</h1>
     * 
     * <pre>Busca y devuelve todos los automoviles que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los automoviles de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link AutomovilDetailDTO} - Los automoviles encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<AutomovilDetailDTO> getAutomoviles(){
         List<AutomovilDetailDTO> automoviles =  new ArrayList<>();
        for(AutomovilEntity ae : autoLogic.getAutomoviles()){
            automoviles.add(new AutomovilDetailDTO(ae));
        }
        return automoviles;
    }
    
    /**
     * <h1>GET /api/automoviles/{id} : Obtener automovil por id.</h1>
     * 
     * <pre>Busca el automovil con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el automovil correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un automovil con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del automovil que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link AutomovilDetailDTO} - El automovil buscado
     */
    @GET
    @Path("{id: \\d+}")
    public AutomovilDetailDTO getAutomovil(@PathParam("id") Long id) throws BusinessLogicException{
        AutomovilEntity automovil = autoLogic.getAutomovil(id);
       
       if(automovil == null) throw new WebApplicationException("El recurso Automovil " + id + " no existe");
       
       else return new AutomovilDetailDTO(automovil);
    }
    
    /**
     * <h1>PUT /api/automoviles/{id} : Actualizar automovil con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link AutomovilDetailDTO}.
     * 
     * Actualiza el automovil con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el automovil con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un automovil con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del automovil que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param auto {@link AutomovilDetailDTO} El automovil que se desea guardar.
     * @return JSON {@link AutomovilDetailDTO} - El automovil guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar un automovil porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public AutomovilDetailDTO updateAutomovil(@PathParam("id") Long id, AutomovilDetailDTO auto) throws BusinessLogicException{
       AutomovilEntity A = autoLogic.getAutomovil(id);
        
        if(A == null) throw new WebApplicationException("El recurso automovil " + id + " no existe");
        
        else return new AutomovilDetailDTO(autoLogic.updateAutomovil(A));
        
    }
    
    /**
     * <h1>DELETE /api/automoviles/{id} : Borrar automovil por id.</h1>
     * 
     * <pre>Borra el automovil con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el automovil correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un automovil con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del automovil que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAutomovil(@PathParam("id") Long id)throws BusinessLogicException{
        AutomovilEntity automovil = autoLogic.getAutomovil(id);
        
        if(automovil == null) throw new WebApplicationException("El recurso automovil " + id + " no existe");
        autoLogic.deleteAutomovil(automovil);
   }
}
