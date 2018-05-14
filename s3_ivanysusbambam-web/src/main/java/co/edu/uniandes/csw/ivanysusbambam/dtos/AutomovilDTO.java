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
 *      "placa": "XYZ-123",
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

    /**
     * Atributo para el id del automovil
     */
    private Long id;

    /**
     * Atributo para el nombre del automovil
     */
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
     * Imagen del automovil
     */
    private String imagen;
    /**
     * Tipo del automovil
     */
    private String tipo;
    /**
     * Kilometraje del automovil
     */
    private Double kilometros;

    /**
     * Constructor por defecto
     */
    public AutomovilDTO() {

        //Método vacío utilizado únicamente por JAX
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param auto: Es la entidad que se va a convertir a DTO
     */
    public AutomovilDTO(AutomovilEntity auto) {
        if (auto != null) {
            this.color = auto.getColor();
            this.anio = auto.getAnio();
            this.placa = auto.getPlaca();
            this.chasis = auto.getChasis();
            this.fechaListado = auto.getFechaListado();
            this.valorListado = auto.getValorListado();
            this.id = auto.getId();
            this.name = auto.getName();
            this.imagen = auto.getImagen();
            this.kilometros = auto.getKilometros();
            this.tipo = auto.getTipo();
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

    /**
     * Constuye una nueva entidad y le da la informacion del DTO
     *
     * @return la nueva entidad del automovil
     */
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
        entity.setImagen(this.imagen);
        entity.setKilometros(this.kilometros);
        entity.setTipo(this.tipo);
        return entity;
    }

    /**
     * @return el id del autmovil
     */
    public Long getId() {
        return id;
    }

    /**
     * @return El nombre del automovil
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el id del automovil por el dado por parametro
     *
     * @param id id a setear en el automovil
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setea el nombre del automovil por el dado por parametro
     *
     * @param name nombre a setear en el automovil
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return a imagen del automovil
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Setea la imagen del automovil por el dado porparametro
     *
     * @param imagen imagen a setear en el automovil
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return el tipo del automovil
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setea el tipo del automvil al dado por parametro
     *
     * @param tipo tipo a setear al automovil
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return el kilometraje del automovil
     */
    public Double getKilometros() {
        return kilometros;
    }

    /**
     * Setea el kilometraje del automovil al dado por parametro
     *
     * @param kilometros Kilometraje a setear al automovil
     */
    public void setKilometros(Double kilometros) {
        this.kilometros = kilometros;
    }

}
