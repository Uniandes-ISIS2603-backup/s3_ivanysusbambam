/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;
//TODO: sobra este import
import co.edu.uniandes.csw.ivanysusbambam.dtos.MedioDePagoDTO;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
/**
 *
 * @author j.sierrac
 */
public class MedioDePagoDetailDTO extends MedioDePagoDTO {
    private ClienteDTO cliente;
    
    public MedioDePagoDetailDTO() {
        super();
    }
    
    public MedioDePagoDetailDTO(MedioDePagoEntity entity) {
        super(entity);
        if(entity != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        }
    }

    @Override
    public MedioDePagoEntity toEntity() {
        MedioDePagoEntity entity = super.toEntity();
        if(this.cliente != null) {
            entity.setCliente(this.cliente.toEntity());
        }
        return entity;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
}
