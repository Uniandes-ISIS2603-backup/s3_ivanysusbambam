/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.VentaDTO;
import co.edu.uniandes.csw.ivanysusbambam.dtos.VentaDetailDTO;
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
 * <pre>Clase que implementa el recurso "ventas".
 * URL: /api/ventas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "ventas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author hd.castellanos
 * @version 1.0
 */
@Path("ventas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class VentaResource {

    
    /**
     * <h1>POST /api/ventas : Crear una venta.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link VentaDetailDTO}.
     * 
     * Crea una nueva venta con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva venta .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la venta.
     * </code>
     * </pre>
     * @param venta {@link VentaDetailDTO} - La venta que se desea guardar.
     * @return JSON {@link VentaDetailDTO}  - La venta guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la venta.
     */
    @POST
    public VentaDetailDTO createVenta(VentaDetailDTO venta) throws BusinessLogicException {
        return venta;
    }
    
   /**
     * <h1>GET /api/ventas : Obtener todas las ventas.</h1>
     * 
     * <pre>Busca y devuelve todas las ventas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ventas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link VentaDetailDTO} - Las ventas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<VentaDetailDTO> getVentas() {
        return new ArrayList<>();
    }
    
     /**
     * <h1>GET /api/ventas/{id} : Obtener una venta por id.</h1>
     * 
     * <pre>Busca la venta con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la venta correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una venta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la venta que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link VentaDetailDTO} - La venta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public VentaDetailDTO getVenta(@PathParam("id") int id) {
        return null;
    }
    /**
     * <h1>PUT /api/ventas/{id} : Actualizar venta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link VentaDetailDTO}.
     * 
     * Actualiza la venta con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la venta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una venta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la venta que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param venta {@link VentaDetailDTO} La venta que se desea guardar.
     * @return JSON {@link VentaDetailDTO} - La venta guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una venta con ese id.
     */
    @PUT
    @Path("{id: \\d+}")
    public VentaDetailDTO updateVenta(@PathParam("id") int id, VentaDetailDTO venta) throws BusinessLogicException {
        return venta;
    }
    
    /**
     * <h1>DELETE /api/ventas/{id} : Borrar venta por id.</h1>
     * 
     * <pre>Borra la venta con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la venta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una venta con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la venta que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteVenta(@PathParam("id") int id) {
        // Void
    }
    
    

}
