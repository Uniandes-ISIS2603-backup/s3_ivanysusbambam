/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link AutomovilDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del automovil vaya a la documentacion de {@link AutomovilDTO}
 *
 * 
 * /**
 * Objeto de transferencia de datos del automovil.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 * "id":Number, 
  *  "name":String,
  *  "color":String,
  *  "anio":Number,
  *  "placa":String,
  *  "chasis":Number,
  *  "fechaListado":Date,
  *  "valorListado":Number,
  *  "modelo":ModeloDTO,
  *  "puntoDeVenta":PuntoDeVentaDTO,
  *  "marca":MarcaDTO,
  *  "compra":CompraDTO    
*}
 * </pre> Por ejemplo un cliente se representa así:<br>
 *
 * <pre>
 *
 *   {
 *"id":2, 
 *   "name":"",
 *   "color":"azul",
 *   "anio":2007,
 *   "placa":"ABE-234",
 *   "chasis":5875,
 *   "fechaListado":"2018-05-24",
 *   "valorListado":505000,
 *   "modelo":{"id":1},
 *   "puntoDeVenta":{"id":1},
 *   "marca":{"id":1},
 *   "compra":{"idCompra":1}
 *   
 *   
 *   
*
 *   
*}
 *
 * </pre>
 * 
 * @author a.bravo y hd.castellanos
 */
public class AutomovilDetailDTO extends AutomovilDTO {

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
     * ventaa de este automovil
     */
    private List<VentaDTO> ventas;

    /**
     * Constructor por defecto
     */
    public AutomovilDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad del automovil a partir de la cual se construye
     * el objeto
     */
    public AutomovilDetailDTO(AutomovilEntity entity) {
        super(entity);
        if (entity != null) {
            prospectosCompra = new ArrayList();
            for (ProspectoCompraEntity entityprospectos : entity.getProspectosCompra()) {
                prospectosCompra.add(new ProspectoCompraDTO(entityprospectos));
            }

            ventas = new ArrayList();
            for (VentaEntity ventaEntity : entity.getVentas()) {
                ventas.add(new VentaDTO(ventaEntity));
            }
            modelo = new ModelDTO(entity.getModel());
            marca = new MarcaDTO(entity.getMarca());
            puntoDeVenta = new PuntoDeVentaDTO(entity.getPuntoDeVenta());
            compra = new CompraDTO(entity.getCompra());
        }

    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public AutomovilEntity toEntity() {
        AutomovilEntity autoE = super.toEntity();
        if (ventas != null) {
            List<VentaEntity> ventaEntity = new ArrayList<>();
            for (VentaDTO dtoVenta : ventas) {
                ventaEntity.add(dtoVenta.toEntity());
            }
            autoE.setVentas(ventaEntity);
        }

        if (prospectosCompra != null) {
            List<ProspectoCompraEntity> prospectosEntity = new ArrayList();
            for (ProspectoCompraDTO dtoProspecto : prospectosCompra) {
                prospectosEntity.add(dtoProspecto.toEntity());
            }
            autoE.setProspectosCompra(prospectosEntity);
        }
        if (marca != null) {
            autoE.setMarca(marca.toEntity());
        }
        if (modelo != null) {

            autoE.setModel(modelo.toEntity());
        }
        if (puntoDeVenta != null) {

            autoE.setPuntoDeVenta(puntoDeVenta.toEntity());
        }
        if (compra != null) {

            autoE.setCompra(compra.toEntity());
        }

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

    /**
     * @return the venta
     */
    public List<VentaDTO> getVenta() {
        return ventas;
    }

    /**
     * @param ventas the venta to set
     */
    public void setVenta(List<VentaDTO> ventas) {
        this.ventas = ventas;
    }
}
