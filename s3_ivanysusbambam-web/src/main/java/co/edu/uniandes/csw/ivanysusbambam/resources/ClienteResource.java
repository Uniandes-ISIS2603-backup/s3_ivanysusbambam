
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.ClienteDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
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
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource {
    
    /**
     * GET /api/clientes: Retorna todos los clientes registrados.
     * 
     * <pre>Busca y devuelve todos los clientes que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los clientes de la aplicacion.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información básica de todos los clientes.
     */
    @GET
    public List<ClienteDTO> getClientes(){
        return null;
    }
    
    /**
     * GET /api/clientes/(id): Obtiene un cliente según su cédula.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el cliente correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id cédula del cliente que se busca.
     * @return JSON el cliente buscado.
     */
    @Path("{id: \\d+}")
    @GET
    public ClienteDetailDTO getCliente(@PathParam("id")int id){
        return null;
    }
    
    /**
     * POST /api/clientes: Crea un nuevo cliente.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se crea el nuevo cliente
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param cliente el nuevo cliente.
     * @return JSON el cliente recien creado.
     * @throws BusinessLogicException si ya existe el cliente.
     */
    @POST
    public ClienteDetailDTO postCliente(ClienteDetailDTO cliente ) throws BusinessLogicException{
         return null;
    }
    
    /**
     * PUT /api/clientes/(id): Actualiza un cliente.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualiza el cliente
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param cliente cliente con la información actualizada.
     * @param id cédula del cliente que se actualizará
     * @return JSON el cliente recien actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @Path("{id: \\d+}")
    @PUT
    public ClienteDetailDTO putCliente(@PathParam("id") int id, ClienteDetailDTO cliente) throws BusinessLogicException{
        return null;
    }
    
    /**
     * DELETE /api/clientes/(id): Elimina un cliente.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se elimina el cliente
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id cédula del cliente que se eliminará.
     * @return JSON el cliente eliminado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @Path("{id: \\d+}")
    @DELETE
    public ClienteDetailDTO deleteCliente(@PathParam("id") int id) throws BusinessLogicException{
      return null;  
    }
}
