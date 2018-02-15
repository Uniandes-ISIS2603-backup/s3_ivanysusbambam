/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

/**
 *
 * @author if.garcia
 */
public class CalificacionTiendaDetailDTO extends CalificacionTiendaDTO{
    
    /**
     * Representa el cliente que ha puesto la calificacion
     */
    private ClienteDTO cliente;
    
    /**
     * Asigna un cliente respectivo a la clasificacion
     * @param cliente  cliente.
     */
    public void setCliente(ClienteDTO cliente){
        this.cliente = cliente;
    }
    
    /**
     * Retorna el cliente respectivo a la calificacion
     * @return cliente cliente.
     */
    public ClienteDTO getCliente(){
        return cliente;
    }
}
