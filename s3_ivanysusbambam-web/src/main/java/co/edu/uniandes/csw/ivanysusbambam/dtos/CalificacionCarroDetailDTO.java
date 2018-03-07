/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;

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
 *       "venta" : JSON
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
 *          "puntaje": "4,5"
 *          "venta": {424345, "paco perez"}
 *   }
 * </pre>
 *
 * @author if.garcia <pre>
 * Versiones: *
 * </pre>
 */
public class CalificacionCarroDetailDTO extends CalificacionCarroDTO {

    /**
     * Constructor por defecto
     */
    public CalificacionCarroDetailDTO() {

    }

    public CalificacionCarroDetailDTO(CalificacionCarroEntity entity) {
        super(entity);
        if (entity.getVenta() != null) {
            this.setVenta(new VentaDTO(entity.getVenta()));
        }
    }

    /**
     * Representa la venta de la cual proviene la calificacion
     */
    private VentaDTO venta;

    /**
     * Asigna una venta a la calificacion
     *
     * @param venta venta.
     */
    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }

    /**
     * Retorna la venta de la cual proviene la calificacion
     *
     * @return venta
     */
    public VentaDTO getVenta() {
        return venta;
    }
}
