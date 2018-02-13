/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.resources;

import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author j.sierrac
 */
@Path("compras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CompraResource {
     /**
     * <h1>POST /api/cities : Crear una ciudad.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Crea una nueva ciudad con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva ciudad .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la ciudad.
     * </code>
     * </pre>
     * @param city {@link CityDetailDTO} - La ciudad que se desea guardar.
     * @return JSON {@link CityDetailDTO}  - La ciudad guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la ciudad.
     */
    
//    public CompraDetailDTO crearCompra() throws BusinessLogicException{
//        
//    }
}
