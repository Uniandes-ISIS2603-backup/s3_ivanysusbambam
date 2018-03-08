/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;

import java.util.Date;

/**
 * AutomovilDTO Objeto de transferencia de datos de Automoviles. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "color": string,
 *      "anio: int,
 *      "placa": string,
 *      "chasis": int,
 *      "fechaListado": string,
 *      "valorListado": double
 *   }
 * </pre> Por ejemplo un automovil se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "color": "azul",
 *      "anio": 2001,
 *      "placa": "XYZ123",
 *      "chasis": 1,
 *      "fechaListado": "2018-05-13",
 *      "valorListado": 5000000
 *   }
 *
 * </pre>
 *
 * @author a.bravo
 */
public class AutomovilDTO {

    private Long id; 
    
    private String name;
    
    /**
     * Color del automovil
     */
    private String color;
    /**
     * Anio del automovil
     */
    private Integer anio;
    /**
     * placa del automovil
     */
    private String placa;
    /**
     * Chasis del automovil
     */
    private Integer chasis;
    /**
     * FechaListado del automovil
     */
    private Date fechaListado;
    /**
     * Valor listado del automovil
     */
    private Double valorListado;

    /**
     * Constructor por defecto
     */
    public AutomovilDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param auto: Es la entidad que se va a convertir a DTO
     */
    public AutomovilDTO(AutomovilEntity auto) {
      if(auto != null){
        this.color = auto.getColor();
        this.anio = auto.getAnio();
        this.placa = auto.getPlaca();
        this.chasis = auto.getChasis();
        this.fechaListado = auto.getFechaListado();
        this.valorListado = auto.getValorListado();
        this.id = auto.getId();
        this.name = auto.getName();
      }
    }

    /**
     * @return El ID de la ciudad
     */
    public String getColor() {
        return color;
    }

    /**
     * @return El anio del automovil
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @return La placa del automovil
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @return El chasis del automovil
     */
    public Integer getChasis() {
        return chasis;
    }

    /**
     * @return La fecha de listado del automovil
     */
    public Date getFechaListado() {
        return fechaListado;
    }

    /**
     * @return El valor del listado del automovil
     */
    public Double getValorListado() {
        return valorListado;
    }

    /**
     * @param color El nuevo color del automovil
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param anio El nuevo anio del automovil
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @param placa La nueva placa del automovil
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @param chasis El nuevo chasis del automovil
     */
    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    /**
     * @param fechaListado La nueva fecha de listado del automovil
     */
    public void setFechaListado(Date fechaListado) {
        this.fechaListado = fechaListado;
    }

    /**
     * @param valorListado El nuevo valor de listado del automovil
     */
    public void setValorListado(Double valorListado) {
        this.valorListado = valorListado;
    }

    public AutomovilEntity toEntity() {
        AutomovilEntity entity = new AutomovilEntity();
        entity.setColor(this.color);
        entity.setAnio(this.anio);
        entity.setPlaca(this.placa);
        entity.setChasis(this.chasis);
        entity.setFechaListado(this.fechaListado);
        entity.setValorListado(this.valorListado);
        entity.setId(this.id);
        entity.setName(this.name);
        
        return entity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
