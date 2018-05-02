/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;

/**
 *
 * @author if.garcia Versiones: 10/02/2018 -Creación de atributos -Creación de
 * getters y setters
 */
public class CalificacionTiendaDTO {

    /**
     * Identificador del objeto
     */
    private Long id;

    /**
     * Nombre del objeto Entity de la calificacion
     */
    private String name;

    /**
     * Comentario respectivo a la calificacion
     */
    private String comentario;

    /**
     * Puntaje especificado por el usuario para la tienda
     */
    private Double puntaje;

    /**
     * Construye una nueva Calificacion para una tienda
     */
    public CalificacionTiendaDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Construye una nueva calificacion para una tienda a partir de un objeto
     * Entity
     *
     * @param calificacionTienda entity correspondiente.
     */
    public CalificacionTiendaDTO(CalificacionTiendaEntity calificacionTienda) {
        if (calificacionTienda != null) {
            this.id = calificacionTienda.getId();
            this.name = calificacionTienda.getName();
            this.comentario = calificacionTienda.getComentario();
            this.puntaje = calificacionTienda.getPuntaje();
        }

    }

    /**
     * Entrega el identificador unico del objeto
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el identificador unico por el Long que entra por parámetro
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la entidad correspondiente a la calificacion
     *
     * @return name nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna un nombre a la entidad correspondiente a la calificacion
     *
     * @param name nombre que será asignado.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna el comentario puesto por el cliente al agregar la calificacion
     *
     * @return comentario comentario.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Asigna el valor que el cliente haya puesto a la calificacion de la tienda
     *
     * @param comentario comentario que será asginado.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene el puntaje que el cliente haya asignado segun la tienda
     *
     * @return puntaje puntaje.
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * Asigna el puntaje que el cliente haya puesto a la tienda
     *
     * @param puntaje puntaje que será asignado.
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Convierte el objeto en una entidad
     *
     * @return entity entity que será asignado.
     */
    public CalificacionTiendaEntity toEntity() {
        CalificacionTiendaEntity entity = new CalificacionTiendaEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setComentario(this.comentario);
        entity.setPuntaje(this.puntaje);

        return entity;
    }
}
