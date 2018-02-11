/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;


import co.edu.uniandes.csw.ivanysusbambam.dtos.VentaDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.VentaDetailDTO;
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
 * @author hd.castellanos
 */
@Path("ventas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class VentaResource
{

     /**
     * GET /api/ventas: Retorna todas las ventas registradas.
     * 
     * <pre>Busca y devuelve todas las ventas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las ventas de la aplicacion.</code> 
     * </pre>
     * 
     * @return JSONArray  con la información básica de todas las ventas.
     */
    @GET
    public List<VentaDTO> getVentas(){
        return null;
    }
    
    /**
     * GET /api/ventas/(id): Obtiene una venta según su id.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la venta  correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una venta con el id dado.
     * </code> 
     * </pre>
     * @param id id de la venta que se busca 
     * @return JSON de la venta buscada.
     */
    @Path("{id: \\d+}")
    @GET
    public VentaDetailDTO getVenta(@PathParam("id")Integer id){
        return null;
    }
    /**
     * POST /api/ventas: Crea una nueva venta.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se crea la nueva venta
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una venta con el id dado.
     * </code> 
     * </pre>
     * @param pVenta la nueva venta.
     * @return JSON el la venta recien creado.
     * @throws BusinessLogicException si ya existe el cliente.
     */
    @POST
    public VentaDetailDTO postVenta(VentaDetailDTO pVenta ) throws BusinessLogicException{
         return null;
    }
    
    /**
     * PUT /api/ventas/(id): Actualiza una venta.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se actualiza la venta 
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una venta  con el id dado.
     * </code> 
     * </pre>
     * @param pVenta venta con la información actualizada.
     * @param id id de la venta  que se actualizará
     * @return JSON la venta recien actualizado.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @Path("{id: \\d+}")
    @PUT
    public VentaDetailDTO putVenta(@PathParam("id") Integer id, VentaDetailDTO pVenta) throws BusinessLogicException{
        return null;
    }
    
    /**
     * DELETE /api/ventas/(id): Elimina una venta.
     * <pre> 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK se elimina la venta
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una venta con el id dado.
     * </code> 
     * </pre>
     * @param id id de la venta que se eliminará.
     * @return JSON la venta eliminada.
     * @throws BusinessLogicException si no existe el cliente con el id dado.
     */
    @Path("{id: \\d+}")
    @DELETE
    public VentaDetailDTO deleteVenta(@PathParam("id") Integer id) throws BusinessLogicException{
      return null;  
    }
    
}
