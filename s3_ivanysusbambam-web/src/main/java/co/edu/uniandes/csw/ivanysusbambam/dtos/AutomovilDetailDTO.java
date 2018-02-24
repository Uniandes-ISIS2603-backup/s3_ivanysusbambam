/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import java.util.List;

/**
 * Clase que extiende de {@link AutomovilDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del automovil vaya a la documentacion de {@link AutomovilDTO}
 * @author a.bravo
 */
public class AutomovilDetailDTO extends AutomovilDTO{
   /**
    * modelo del automovil
    */
    private ModelDTO modelo;
    
    
   /**
    * Punto de vento del automovil
    */ 
    private PuntoDeVentaDTO puntoDeVenta;

   /**
    * Marca del automovil
    */
    private MarcaDTO marca;

    /**
     * Compra asociada a este atomovil
     */
    private CompraDTO compra;

    /**
     * Prospectos de compra de este automovil 
     */
    private List<ProspectoCompraDTO> prospectosCompra;
    
    /**
     * Constructor por defecto
     */
    public AutomovilDetailDTO(){
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad del automovil a partir de la cual se construye el objeto
     */
    public AutomovilDetailDTO(AutomovilEntity entity){
        super(entity);
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public AutomovilEntity toEntity(){
        AutomovilEntity autoE = super.toEntity();
        return autoE;
    }

    /**
     * @return the modelo
     */
    public ModelDTO getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModelDTO modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the puntoDeVenta
     */
    public PuntoDeVentaDTO getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @param puntoDeVenta the puntoDeVenta to set
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @return the marca
     */
    public MarcaDTO getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    /**
     * @return the compra
     */
    public CompraDTO getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(CompraDTO compra) {
        this.compra = compra;
    }

    /**
     * @return the prospectosCompra
     */
    public List<ProspectoCompraDTO> getProspectosCompra() {
        return prospectosCompra;
    }

    /**
     * @param prospectosCompra the prospectosCompra to set
     */
    public void setProspectosCompra(List<ProspectoCompraDTO> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }
}
