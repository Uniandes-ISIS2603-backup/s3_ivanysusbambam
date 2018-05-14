/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
/**
 *
 * @author j.sierrac
 */
public class MedioDePagoDetailDTO extends MedioDePagoDTO {
    /**
     * Cliente del medio de pago
     */
    private ClienteDTO cliente;
    
    /**
     * Constructor por defecto
     */
    public MedioDePagoDetailDTO() {
        super();
    }
    
    /**
     * Crea un nuevo detailDTO con lainformacion de la entidad
     * @param entity entidad con la informacion
     */
    public MedioDePagoDetailDTO(MedioDePagoEntity entity) {
        super(entity);
        if(entity != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        }
    }

    /**
     * Crea una nueva entidad con la informacion del detailDTO
     * @return la nueva entidad
     */
    @Override
    public MedioDePagoEntity toEntity() {
        MedioDePagoEntity entity = super.toEntity();
        if(this.cliente != null) {
            entity.setCliente(this.cliente.toEntity());
        }
        return entity;
    }

    /**
     * @return el cliente del medio de pago  
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Setea el cliente del medio de pago al dado por parametro
     * @param cliente cliente del medio de pago 
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
}
