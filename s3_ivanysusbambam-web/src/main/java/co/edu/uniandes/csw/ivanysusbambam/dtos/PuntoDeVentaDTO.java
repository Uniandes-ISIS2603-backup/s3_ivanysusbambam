/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;

/**
 *
 * @author if.garcia
 */
public class PuntoDeVentaDTO {

    /**
     * Id del punto de venta
     */
    private Long id;

    /**
     * Nombre del punto de venta
     */
    private String name;

    /**
     * Direccion del punto de venta
     */
    private String direccion;

    /**
     * Telefono del punto de venta
     */
    private Integer telefono;
    
    /**
     * Imagen del punto de venta
     */
    private String imagen;

    /**
     * Constructor por defecto
     */
    public PuntoDeVentaDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Asigna la informacion de la entidad a el DTO
     * @param puntoDeVenta entidad con la informacion
     */
    public PuntoDeVentaDTO(PuntoDeVentaEntity puntoDeVenta) {

        if (puntoDeVenta != null) {
            this.direccion = puntoDeVenta.getDireccion();
            this.id = puntoDeVenta.getId();
            this.name = puntoDeVenta.getName();
            this.telefono = puntoDeVenta.getTelefono();
            this.imagen = puntoDeVenta.getImagen();
        }
    }

    /**
     * @return el id del punto de venta 
     */
    public Long getId() {
        return id;
    }

    /**
     * Setea el id del punto de venta al dado por parametro
     * @param id  id del punto de venta
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre del punto de venta 
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre del punto de venta al dado por parametro
     * @param name nombre del punto de venta
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la direccion del punto de venta 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setea la direccion del punto de venta a la dada por parametro
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return el telefono del punto de venta 
     */
    public Integer getTelefono() {
        return telefono;
    }
    /**
     * Setea el telefono del punto de venta al dado por parametro
     * @param telefono 
     */
    public void setTelefono(Integer telefono){
        this.telefono = telefono;
    }
    
    /**
     * @return La imagen del punto de venta 
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Setea la imagen del punto de venta a la dada por parametro
     * @param pImagen imagen del punto de venta
     */
    public void setImagen(String pImagen) {
        this.imagen = pImagen;
    }

    /**
     * Crea una nueva entidad con la informacion del DTO
     * @return la nueva entidad 
     */
    public PuntoDeVentaEntity toEntity() {
        PuntoDeVentaEntity entity = new PuntoDeVentaEntity();
        entity.setDireccion(this.direccion);
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setTelefono(this.telefono);
        entity.setImagen(this.imagen);

        return entity;
    }
}
