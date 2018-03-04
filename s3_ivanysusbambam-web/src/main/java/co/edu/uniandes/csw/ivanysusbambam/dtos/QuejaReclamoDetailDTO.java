/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;

/**
 * Objeto de transferencia que contiene información detallada de una queja o
 * reclamo. Al serializarse como JSON esta clase implementa el siguiente modelo:
 * <br>
 * <pre>
 *   {
 *       "id": number,
 *       "name": string,
 *      "texto": string,
 *      "tipo": string,
 *      "cliente": JSON,
 *
 *
 *   }
 * </pre> Por ejemplo un prospecto de compra representa así:<br>
 *
 * <pre>
 *
 *   {
 *          "id": 12431
 *          "name": "Proceso de compra"
 *          "texto": " No quede contento con el proceso de compra, demasiado lento",
 *          "tipo": "Reclamo",
 *           "cliente" : {"cedula": 549897, "nombre": "Juan Perez"},
 *
 * }
 *
 *
 * </pre>
 *
 * @author if.garcia y hd.castellanos  <pre>
 * Versiones: *
 * </pre>
 */
public class QuejaReclamoDetailDTO extends QuejaReclamoDTO {

    /**
     * Cliente que realizo la queja o el reclamo 
     */
    private ClienteDTO cliente;

    /**
    * Constructor por defecto
    */
    public QuejaReclamoDetailDTO(){
        
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la QuejaReclamo a partir de la cual se construye el objeto
     */
    public QuejaReclamoDetailDTO(QuejaReclamoEntity entity){
        super(entity);
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    
    public QuejaReclamoEntity toEntity(){
        QuejaReclamoEntity QuejaE = super.toEntity();
        return QuejaE;
    }
    
    
    /**
     * @return el/la cliente/ta que realio la queja o el reclamo  
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    
    /**
     * Asigna al clinete que realio la queja o el reclamo el cliente dado por parametro
     * @param cliente cliente que se va a signar a esta queja o reclamo
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}