
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.dtos.CompraDetailDTO;
import co.edu.uniandes.csw.ivanysusbambam.ejb.CompraLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
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
 * @author j.sierrac
 */
@Path("compras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CompraResource {

    @Inject
    CompraLogic compraLogic;

    /**
     * <h1>POST /api/compras : Crear una compra.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link CompraDTO}.
     *
     * Crea una nueva compra con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva compra .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la compra.
     * </code>
     * </pre>
     *
     * @param compra {@link CompraDetailDTO} - La compra que se desea guardar.
     * @return JSON {@link CompraDetailDTO} - La compra guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la ciudad.
     */
    @POST
    public CompraDetailDTO crearCompra(CompraDetailDTO compra) throws BusinessLogicException {
        CompraEntity compraE = compra.toEntity();
        CompraDetailDTO rpta = new CompraDetailDTO(compraLogic.crearCompra(compraE));

        return rpta;
    }

    /**
     * <h1>GET /api/compras : Obtener todas las compras.</h1>
     *
     * <pre>Busca y devuelve todas las compras que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las compras de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link CompraDetailDTO} - Las ciudades encontradas en
     * la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CompraDetailDTO> getCompras() {
        List<CompraDetailDTO> rpta = new ArrayList<>();
        for (CompraEntity compra : compraLogic.findAll()) {
            rpta.add(new CompraDetailDTO(compra));
        }

        return rpta;
    }

    /**
     * <h1>GET /api/compras/{id} : Obtener compra por id.</h1>
     *
     * <pre>Busca la compra con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la compra correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una compra con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la compra que se esta buscando.
     * @return JSON {@link CityDetailDTO} - La compra buscada
     * @throws
     * co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException si
     * no existe una compra con ese id.
     */
    @GET
    @Path("{idCompra: \\d+}")
    public CompraDetailDTO getCompra(@PathParam("idCompra") Integer id) throws BusinessLogicException {

        CompraEntity entity = compraLogic.findCompra(id);

        if (entity == null) {
            throw new WebApplicationException("El recurso /compras/" + id + " no existe.", 404);

        }

        return new CompraDetailDTO(entity);

    }

    /**
     * <h1>PUT /api/compras/{id} : Actualizar compra con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CompraDetailDTO}.
     *
     * Actualiza la compra con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la compra con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una compra con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la compra que se desea actualizar.
     * @param compra {@link CompraDetailDTO} La compra que se desea guardar.
     * @return JSON {@link CompraDetailDTO} - La compra guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera al no poder actualizar la ciudad porque ya
     * existe una con ese nombre.
     */
    @PUT
    @Path("{idCompra: \\d+}")
    public CompraDetailDTO updateCompra(@PathParam("idCompra") Integer idCompra, CompraDetailDTO compra) throws BusinessLogicException {

        compra.setIdCompra(idCompra);
        CompraEntity entity = compraLogic.findCompra(idCompra);
        if (entity == null) {
            throw new WebApplicationException("El recurso /compras/" + idCompra + " no existe.", 404);
        }

        return new CompraDetailDTO(compraLogic.updateCompra(entity));

    }

    /**
     * <h1>DELETE /api/compras/{id} : Borrar compra por id.</h1>
     *
     * <pre>Borra la compra con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la compra correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una compra con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la compra que se desea borrar.
     */
    @DELETE
    @Path("{idCompra: \\d+}")
    public void deleteCompra(@PathParam("idCompra") Integer id) throws BusinessLogicException {
        // Void
        CompraEntity entity = compraLogic.findCompra(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /editorials/" + id + " no existe.", 404);
        }
        compraLogic.deleteCompra(id);
    }
}
