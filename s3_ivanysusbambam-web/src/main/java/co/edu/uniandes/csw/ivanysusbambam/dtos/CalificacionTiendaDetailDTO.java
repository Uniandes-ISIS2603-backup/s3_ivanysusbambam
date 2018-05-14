/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;

/**
 * Objeto de transferencia que contiene información detallada de una
 * calificacion de un cliente a un carro comprado. Al serializarse como JSON
 * esta clase implementa el siguiente modelo:
 * <br>
 * <pre>
 *   {
 *       "id": number,
 *       "name": string,
 *       "comentario":  string,
 *       "puntaje": number
 *
 *   }
 * </pre> Por ejemplo un prospecto de compra representa así:<br>
 *
 * <pre>
 *
 *   {
 *          "id": 12345,
 *          "name": "Chevrolet Optra",
 *          "comentario": "carro deportivo, elegante y muy bueno en funciones mecanicas",
 *          "cliente" : {"cedula": 549897, "nombre": "Juan Perez"}
 *
 *
 *   }
 * </pre>
 *
 * @author if.garcia <pre>
 * Versiones: *
 * </pre>
 */
public class CalificacionTiendaDetailDTO extends CalificacionTiendaDTO {

    /**
     * Representa el cliente que ha puesto la calificacion
     */
    private ClienteDTO cliente;
    
     /**
     * Representa el punto de venta al que correponde  la calificacion
     */
    private PuntoDeVentaDTO puntoVenta;
    
    
    /**
     * Constructor por defecto
     */
    public CalificacionTiendaDetailDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Asigna la informacion  del detailDTO a la informacion de la entidad
     * @param entity entidad con la informacion
     */
    public CalificacionTiendaDetailDTO(CalificacionTiendaEntity entity) {
        super(entity);
        
        if (entity != null) {
            
            if(entity.getCliente() != null){
                cliente = new ClienteDTO(entity.getCliente());
            }
            if(entity.getPuntoDeVenta() != null){
                puntoVenta = new PuntoDeVentaDTO(entity.getPuntoDeVenta());
            }
        }
    }
    

     
    /**
     * crea una nueva entidad con la informacion del detail DTO
     * @return La nueva entidad
     */
    @Override
    public CalificacionTiendaEntity toEntity(){
        CalificacionTiendaEntity ctEntity = super.toEntity();
        
        if(cliente != null){
            ctEntity.setCliente(cliente.toEntity());
        }
        if(getPuntoVenta() != null){
            ctEntity.setPuntoDeVenta(getPuntoVenta().toEntity());
        }
        
        return ctEntity;
    }
    /**
     * Asigna un cliente respectivo a la clasificacion
     *
     * @param cliente cliente.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el cliente respectivo a la calificacion
     *
     * @return cliente cliente.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Retorna el punto de venta respectivo a la calificacion
     * @return the puntoVenta
     */
    public PuntoDeVentaDTO getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * Establece un punto de venta respectivo a la calificacion
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoDeVentaDTO puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
    
    
}
