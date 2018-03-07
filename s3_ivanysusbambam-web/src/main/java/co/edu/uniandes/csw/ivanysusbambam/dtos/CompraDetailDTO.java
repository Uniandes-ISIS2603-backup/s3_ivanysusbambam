/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;

/**
 * Objeto de transferencia de datos detallado de la compra. Hereda de CompraDTO
 * <br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *
 *      "idCompra": string,
 *      "automovil": JSON,
 *      "cliente" : JSON,
 *      "puntoDeVenta" : JSON,
 *      "vendedorEncargado": JSON
 *
 *   }
 * </pre>
 *
 * @author j.sierrac
 */
public class CompraDetailDTO extends CompraDTO {

    /**
     * Atributo que representa el automovil de la compra
     */
    private AutomovilDTO automovil;
    /**
     * Atributo que representa el vendedor encargado de la compra
     */
    private VendedorDTO vendedorEncargado;
    /**
     * Atributo que representa el punto de venta de la compra
     */
    private PuntoDeVentaDTO puntoDeVenta;
    /**
     * Atributo que representa el cliente que le vendio el carro a MiAutomovil
     */
    private ClienteDTO cliente;

    /**
     * Constructor por defecto
     */
    public CompraDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la cual se construye el DTO
     */
    public CompraDetailDTO(CompraEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getAutomovil() != null) {
                this.automovil = new AutomovilDTO(entity.getAutomovil());
            }
            if (entity.getCliente() != null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            }
            if (entity.getPuntoDeVenta() != null) {
                this.puntoDeVenta = new PuntoDeVentaDTO(entity.getPuntoDeVenta());
            }
            if (entity.getVendedorEncargado() != null) {
                this.vendedorEncargado = new VendedorDTO(entity.getVendedorEncargado());
            }
        }
    }

//-------------------------------------GETTERS-----------------------------
//     
    /**
     * @return El automovil de la compra
     */
    public AutomovilDTO getAutomovil() {
        return automovil;
    }

    /**
     * @return El vendedor encargado de la compra
     */
    public VendedorDTO getVendedorEncargado() {
        return vendedorEncargado;
    }

    /**
     * @return El vendedor punto de venta donde se encuentra la compra
     */
    public PuntoDeVentaDTO getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @return El cliente que le vendio el automovil a MiAutomovil
     */
    public ClienteDTO getCliente() {
        return cliente;
    }
    //-------------------------------------SETTERS-----------------------------   

    /**
     * @param automovil El nuevo automóvil
     */
    public void setAutomovil(AutomovilDTO automovil) {
        this.automovil = automovil;
    }

    /**
     * @param vendedorEncargado El nuevo VendedorEncargado
     */
    public void setVendedorEncargado(VendedorDTO vendedorEncargado) {
        this.vendedorEncargado = vendedorEncargado;
    }

    /**
     * @param puntoDeVenta El nuevo puntoDeVenta
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     * @param cliente El nuevo cliente de la compra
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa el libro.
     */
    @Override
    public CompraEntity toEntity() {
        CompraEntity compraE = super.toEntity();
        if (automovil != null) {
            compraE.setAutomovil(this.getAutomovil().toEntity());
        }
        if (getCliente() != null) {
            compraE.setCliente(this.getCliente().toEntity());
        }
        if (getPuntoDeVenta() != null) {
            compraE.setPuntoDeVenta(this.puntoDeVenta.toEntity());
        }
        if (getVendedorEncargado() != null) {
            compraE.setVendedorEncargado(vendedorEncargado.toEntity());
        }
        return compraE;
    }

}
