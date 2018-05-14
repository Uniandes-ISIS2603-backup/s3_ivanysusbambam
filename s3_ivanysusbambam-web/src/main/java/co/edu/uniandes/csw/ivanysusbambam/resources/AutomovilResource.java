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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

/**
 * <pre>Clase que implementa el recurso "automoviles".
 * URL: /api/automoviles
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "automoviles".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author a.bravo
 * @version 1.0
 */
@Path("automoviles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AutomovilResource {

    
    
    /**
     * atributo para la logica del automovil
     */
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
     *
     * @param auto {@link AutomovilDetailDTO} - El automovil que se desea
     * guardar.
     * @return JSON {@link AutomovilDetailDTO} - El automovil guardado con el
     * atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe el automovil.
     */
    @POST
    public AutomovilDetailDTO createAutomovil(AutomovilDetailDTO auto) throws BusinessLogicException {
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
     *
     * @return JSONArray {@link AutomovilDetailDTO} - Los automoviles
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<AutomovilDetailDTO> getAutomoviles() {
        List<AutomovilDetailDTO> automoviles = new ArrayList<>();
        for (AutomovilEntity ae : autoLogic.getAutomoviles()) {
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
     *
     * @param id Identificador del automovil que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link AutomovilDetailDTO} - El automovil buscado
     */
    @GET
    @Path("{id: \\d+}")
    public AutomovilDetailDTO getAutomovil(@PathParam("id") Long id) throws BusinessLogicException {
        AutomovilEntity automovil = autoLogic.getAutomovil(id);

        if (automovil == null) {
            throw new WebApplicationException("El recurso Automovil " + id + " no esta en la base de datos");
        } else {
            return new AutomovilDetailDTO(automovil);
        }
    }

    /**
     * <h1>GET /api/automoviles/sortmarca?marca=(marca) : Buscar automóviles de una
     * marca</h1>
     *
     * Retorna todos los automóviles de una marca dada.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil de la marca buscada.
     * </code>
     *
     * @param marca marca que se busca.
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles de la marca buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si se pasa una marca nula.
     */
    @GET
    @Path("/sortmarca")
    public List<AutomovilDetailDTO> getAutomovilMarca(@QueryParam("marca") String marca) throws BusinessLogicException{

        List<AutomovilEntity> autos = autoLogic.findByMarca(marca);

        if (autos.isEmpty()) {
            throw new WebApplicationException("No se encontraron automóviles de marca " + marca);
        }
        return entityToDTOList(autos);

    }

    
    /**
     * <h1>GET /api/automoviles/sortmodelo?modelo=(marca) : Buscar automóviles de un
     * modelo</h1>
     *
     * Retorna todos los automóviles de un modelo dado.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil del modelo buscado.
     * </code>
     *
     * @param modelo marca que se busca.
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles del modelo buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si se pasa un modelo nulo.
     */
    @GET
    @Path("/sortmodelo")
    public List<AutomovilDetailDTO> getAutomovilModelo(@QueryParam("modelo") String modelo) throws BusinessLogicException{
        
        List<AutomovilEntity> autos = autoLogic.findByModelo(modelo);
        
        if(autos.isEmpty()){
            throw new WebApplicationException("No se encontraron automóviles del modelo: " + modelo);
        }
        return entityToDTOList(autos);
    }
    
    
    /**
     * <h1>GET /api/automoviles/sortanios?anioInicio = (anioInicio) &anioFin = (anioFin) : Buscar automóviles entre un rango
     * de años</h1>
     *
     * Retorna todos los automóviles en el rango dado.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil en el rango.
     * </code>
     *
     * @param anioInicio año de inicio del rango.
     * @param anioFin   año de fin del rango
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles en el rango buscado buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si se pasa un año nulo o si anioFin<anioInicio.
     */
    @GET
    @Path("/sortanios")
    public List<AutomovilDetailDTO> getAutomovilRangoAnios(@QueryParam("anioInicio") Integer anioInicio, @QueryParam("anioFin") Integer anioFin) throws BusinessLogicException{
        List<AutomovilEntity> autos = autoLogic.findByRangoAnios(anioInicio, anioFin);
        
        if(autos.isEmpty()){
            throw new WebApplicationException("No se encontraron automóviles en el rango: [" + anioInicio + "," + anioFin +"]");
        }
        return entityToDTOList(autos);
    }
    
    
    /**
     * <h1>GET /api/automoviles/sortprecios? precioMin= (precioMin) & precioMax= (precioMax) : Buscar automóviles entre un rango
     * de precios</h1>
     *
     * Retorna todos los automóviles en el rango dado.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil en el rango.
     * </code>
     *
     * @param precioMin cota inferior del rango
     * @param precioMax cota superior del rango
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles en el rango buscado buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si se pasa un precio nulo o si precioMax<precioMin
     */
    @GET
    @Path("/sortprecios")
    public List<AutomovilDetailDTO> getAutomovilRangoPrecios(@QueryParam("precioMin") Integer precioMin, @QueryParam("precioMax") Integer precioMax) throws BusinessLogicException{
        
        List<AutomovilEntity> autos = autoLogic.findByRangoPrecios(precioMin, precioMax);
        
        if(autos.isEmpty()){
            throw new WebApplicationException("No se encontraron automóviles en el rango: [" + precioMin + "," + precioMax +"]");
        }
        return entityToDTOList(autos);
    }
    
    
    /**
     * <h1>GET /api/automoviles/sortcolor? color = (color): Buscar automóviles de un color</h1>
     *
     * Retorna todos los automóviles de un color.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil del color dado.
     * </code>
     *
     * @param color color que se busca en los automóviles
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles del color buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si color == nulls
     */
    @GET
    @Path("/sortcolor")
    public List<AutomovilDetailDTO> getAutomovilColor(@QueryParam("color") String color) throws BusinessLogicException{
       
        List<AutomovilEntity> autos = autoLogic.findAutomovilByColor(color);
        
        if(autos.isEmpty()){
            throw new WebApplicationException("No se encontraron automóviles del color: " + color);
        }
        return entityToDTOList(autos);
    }
    
    /**
     * <h1>GET /api/automoviles/search?precioMin = (precioMin)& precioMax = (precioMax) & anioMin = (anioMin) & anioMax = (anioMax) & marca = (marca) & modelo = (modelo) & color = (color)
     * : Buscar automóviles que cumplen los filtros dados</h1>
     *
     * Retorna todos los automóviles que cumplen los filtros.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con los automóviles.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No hay ningún automóvil que cumpla los filtros.
     * </code>
     *
     * @param tipoAuto el tipo del automóvil, camioneta, sedan, etc...
     * @param precioMin cota inferior del precio
     * @param precioMax cota superior del precio
     * @param anioMin cota inferior de rango de años
     * @param anioMax cota superior de rango de años
     * @param marca marca que se busca
     * @param modelo modelo que se busca
     * @param color color que se busca en los automóviles
     * @param kilometrajeMin cota inferior del kilometraje
     * @param kilometrajeMax cota superior del kilometraje
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles del color buscado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera si todos los parámetros son null o 
     * si anioMax < anioMin o precioMax < precioMin
     */
    @GET
    @Path("/search")
    public List<AutomovilDetailDTO> masterSearch(@QueryParam("tipoAuto") String tipoAuto, @QueryParam("precioMin") Integer precioMin, @QueryParam("precioMax") Integer precioMax, @QueryParam("anioMin") Integer anioMin, @QueryParam("anioMax") Integer anioMax, 
            @QueryParam("marca")String marca, @QueryParam("modelo") String modelo, @QueryParam("color") String color, @QueryParam("kilometrajeMin") Integer kilometrajeMin, @QueryParam("kilometrajeMax") Integer kilometrajeMax) throws BusinessLogicException{
        
        List<AutomovilEntity> autos = autoLogic.masterSearch(tipoAuto, precioMin, precioMax, anioMin, anioMax, marca, modelo, color, kilometrajeMin, kilometrajeMax);
        
        if(autos.isEmpty()){
            throw new WebApplicationException("No se encontraron automóviles ");
        }
        return entityToDTOList(autos);
    }
    
    
    /**
     * <h1>GET /api/automoviles/colores
     * : Buscar todos los colroes de autos en la BD</h1>
     *
     * Retorna todos los automóviles que cumplen los filtros.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Retorna una lista con el nombre de todos los colores de los autos en la BD.</code>
     * @return JSONArray {@link AutomovilDetailDTO} - Automóviles del color buscado.
     * @throws  BusinessLogicException si no hay automóviles con colores.
     */
    @GET
    @Path("/colores")
    public List<AutomovilEntity> listColores() throws BusinessLogicException{
        List<AutomovilEntity> list = autoLogic.listColores();
        
        if(list.isEmpty()){
            throw new BusinessLogicException("No hay automóviles con colores en la BD");
        }
       
        return list;
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
     *
     * @param id Identificador del automovil que se desea actualizar.Este debe
     * ser una cadena de dígitos.
     * @param auto {@link AutomovilDetailDTO} El automovil que se desea guardar.
     * @return JSON {@link AutomovilDetailDTO} - El automovil guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera al no poder actualizar un automovil porque
     * ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public AutomovilDetailDTO updateAutomovil(@PathParam("id") Long id, AutomovilDetailDTO auto) throws BusinessLogicException {
        AutomovilEntity entity = autoLogic.findAutomovil(id);

        if (entity == null) {
            throw new WebApplicationException("El recurso automovil " + id + " no se encuentra en la base de datos");
        } else {
            return new AutomovilDetailDTO(autoLogic.updateAutomovil(auto.toEntity()));
        }

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
     *
     * @param id Identificador del automovil que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAutomovil(@PathParam("id") Long id) throws BusinessLogicException {
        AutomovilEntity auto = autoLogic.findAutomovil(id);
        System.out.println("ENCONTRADO EL AUTOMOVIL: " + auto);
        if (auto == null) {
            System.out.println("Lanzando excepción");
            throw new WebApplicationException("El recurso AUTOMOVIL " + id + " no se encuentra en la base de datos");
        } else {
            autoLogic.deleteAutomovil(id);
        }
    }
   

    /**
     * Convierte una lista de entities a detail DTP
     *
     * @param lista lista de entities
     * @return lista de DTO's convertida
     */
    private List<AutomovilDetailDTO> entityToDTOList(List<AutomovilEntity> lista) {

        List<AutomovilDetailDTO> ret = new ArrayList();
        for (AutomovilEntity ae : lista) {
            ret.add(new AutomovilDetailDTO(ae));
        }
        return ret;
    }
}
