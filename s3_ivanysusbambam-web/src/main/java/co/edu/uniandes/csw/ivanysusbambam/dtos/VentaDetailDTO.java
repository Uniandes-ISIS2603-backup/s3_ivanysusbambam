/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

/**
 * Clase que extiende de {@link Ve  ntaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la venta vaya a la documentacion de {@link VentaDTO}
 *
 * @author hd.castellanos
 */
public class VentaDetailDTO extends VentaDTO {

    /**
     * Atributo para el cliente que realizo la venta
     */
    private ClienteDTO cliente;

    /**
     * Atributo para el medio de pago que se uso en la venta
     */
    private MedioDePagoDTO medioDePago;

    /**
     * Atributo que representa el vendedor de la compra
     */
    private VendedorDTO vendedorEncargado;

    /**
     * Atributo para la calificacion del automovil asociado a esta venta
     */
    private CalificacionCarroDTO calificacionCarro;

    /**
     * Atributo para el punto de venta
     */
    protected PuntoDeVentaDTO puntoDeVenta;

    /**
     * Atributo para el Automovil
     */
    protected AutomovilDTO automovil;
    

    /**
     * Constructor por defecto
     */
    public VentaDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de venta a partir de la cual se construye el
     * objeto
     */
    public VentaDetailDTO(VentaEntity entity) {
        super(entity);

        if (entity != null) {
        if (entity.getCliente() != null) {
                cliente = new ClienteDTO(entity.getCliente());
            }
            if (entity.getAutomovil() != null) {
                automovil = new AutomovilDTO(entity.getAutomovil());
            }
            if (entity.getCalificacionCarro() != null) {
                calificacionCarro = new CalificacionCarroDTO(entity.getCalificacionCarro());
            }
            if (entity.getMedioDePago() != null) {
                medioDePago = new MedioDePagoDTO(entity.getMedioDePago());
            }
            if (entity.getPuntoDeVenta() != null) {
                puntoDeVenta = new PuntoDeVentaDTO(entity.getPuntoDeVenta());
            }
            if (entity.getVendedorEncargado() != null) {
                this.vendedorEncargado = new VendedorDTO(entity.getVendedorEncargado());
            }

       }

    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public VentaEntity toEntity() {
        VentaEntity entity = super.toEntity();
        if (automovil != null) {
            entity.setAutomovil(automovil.toEntity());
        }
        if (calificacionCarro != null) {
            entity.setCalificacionCarro(calificacionCarro.toEntity());

        }
        if (cliente != null) {
            entity.setCliente(cliente.toEntity());

        }
        if (medioDePago != null) {
            entity.setMedioDePago(medioDePago.toEntity());
        }

        if (puntoDeVenta != null) {
            entity.setPuntoDeVenta(puntoDeVenta.toEntity());
        }

        if (getVendedorEncgardo() != null) {
            entity.setVendedorEncargado(vendedorEncargado.toEntity());
        }
        return entity;
    }

    //---------------------GETTERS-------------------------
    /**
     * @return el clinete asociado con este venta
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @return el medio de pago que se uso para esta venta
     */
    public MedioDePagoDTO getMedioDePago() {
        return medioDePago;
    }

    /**
     * @return el vendedor encargado de esa venta
     */
    public VendedorDTO getVendedorEncgardo() {
        return vendedorEncargado;
    }

    /**
     * @return el automovil asociado con esta venta
     */
    public AutomovilDTO getAutomovil() {
        return automovil;
    }

    /**
     * @return el punto de venta asciado a esta venta
     */
    public PuntoDeVentaDTO getPuntoDeVenta() {
        return puntoDeVenta;
    }

    /**
     * @return la calificacion del carro asociada a esta venta
     */
    public CalificacionCarroDTO getCalificacionCarro() {
        return calificacionCarro;
    }

    //---------------------Setters-------------------------
    /**
     * asigna al atributo calificacion carro la calificacion recibida por
     * parametro
     *
     * @param pCalificacion calificacion que se le va a signar a esta venta
     */
    public void setCalificacionCarro(CalificacionCarroDTO pCalificacion) {
        this.calificacionCarro = pCalificacion;
    }

    /**
     * Asigna al atributo punto de venta el punto de venta recibido por
     * parametro
     *
     * @param pPunto punto de venta que se va a asignar a esta venta
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO pPunto) {
        this.puntoDeVenta = pPunto;
    }

    /**
     * Asigna al atributo medio de pago el medio de pago recibido por parametro
     *
     * @param pMedio medio de pago que se va a asignar a esta venta
     */
    public void setMedioDePago(MedioDePagoDTO pMedio) {
        this.medioDePago = pMedio;
    }

    /**
     * Asigna al atributo vendedor el vendedor recibido por parametro
     *
     * @param pVendedor vendedor que se va a asignar a esta venta
     */
    public void setVendedorEncargado(VendedorDTO pVendedor) {
        this.vendedorEncargado = pVendedor;
    }

    /**
     * Asigna al atributo cliente el cliente recibido por parametro
     *
     * @param pCliente cliente que se va asiganr a esta venta
     */
    public void setCliente(ClienteDTO pCliente) {
        this.cliente = pCliente;
    }

    /**
     * Asigna al atributo automovil el automovil recibido por parametro
     *
     * @param pAuto automovil que se va a signar a esta venta
     */
    public void setAutomovil(AutomovilDTO pAuto) {
        this.automovil = pAuto;
    }
  
}
