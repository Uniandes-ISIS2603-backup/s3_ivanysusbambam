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
    
    private int telefono;
    
    private String nombre;
    
    public PuntoDeVentaDTO(){
        
    }
    
    public PuntoDeVentaDTO(PuntoDeVentaEntity puntoDeVenta){
        this.direccion = puntoDeVenta.getDireccion();
        this.id = puntoDeVenta.getId();
        this.name = puntoDeVenta.getName();
        this.nombre = puntoDeVenta.getNombre();
        this.telefono = puntoDeVenta.getTelefono();
    }
    
    public Long getId(){
        return id;
    } 
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public PuntoDeVentaEntity toEntity(){
        PuntoDeVentaEntity entity = new PuntoDeVentaEntity();
        entity.setDireccion(this.direccion);
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setNombre(this.nombre);
        entity.setTelefono(this.telefono);
        
        return entity;
    }
}
