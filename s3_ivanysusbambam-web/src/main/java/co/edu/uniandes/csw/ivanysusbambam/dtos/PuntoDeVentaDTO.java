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

    private Long id;

    private String name;

    private String direccion;

    private Integer telefono;

    public PuntoDeVentaDTO() {

    }

    public PuntoDeVentaDTO(PuntoDeVentaEntity puntoDeVenta) {

        if (puntoDeVenta != null) {
            this.direccion = puntoDeVenta.getDireccion();
            this.id = puntoDeVenta.getId();
            this.name = puntoDeVenta.getName();
            this.telefono = puntoDeVenta.getTelefono();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public PuntoDeVentaEntity toEntity() {
        PuntoDeVentaEntity entity = new PuntoDeVentaEntity();
        entity.setDireccion(this.direccion);
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setTelefono(this.telefono);

        return entity;
    }
}
