package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joseph Ortíz Moreno
 */
public class MarcaDTO {

    /**
     * Representa el nombre de la marca
     */
    private String name;
    
    /**
     * Id de la marca
     */
    private Long id;
    
    /**
     * Logo/imagen de la marca
     */
    private String logo;
    
    /**
     * Constructor por defecto
     */
     public MarcaDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Constructor a partir de la entidad
     *
     * @param nueva Entidad de la marca
     */

    public MarcaDTO(MarcaEntity nueva){
        if(nueva != null){
            this.name = nueva.getName();
            this.id = nueva.getId();
            this.logo = nueva.getLogo();
        }

    }

    /**
     * @return el id de la marca 
     */
    public Long getId() {
        return id;
    }

    /**
     * Setea el id de la marca al dado por parametro
     * @param id id de la marca
     */
    public void setId(Long id) {
        this.id = id;
    }

   

    /**
     * Método que convierte el DTO en una entidad
     *
     * @return Entidad creada
     */
    public MarcaEntity toEntity() {
        MarcaEntity nueva = new MarcaEntity();
        nueva.setName(this.getName());
        nueva.setId(this.getId());
        nueva.setLogo(this.getLogo());
        return nueva;
    }

    /**
     * Retorna el nombre de la marca
     *
     * @return Nombre de la marca
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre de la marca
     *
     * @param nuevo Nuevo nombre de la marca
     */
    public void setName(String nuevo) {
        this.name = nuevo;
    }

    /**
     * @return el logo/imagen de la marca 
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Setea el logo de la marca al dado por parametro
     * @param logo logo de la marca
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
}
