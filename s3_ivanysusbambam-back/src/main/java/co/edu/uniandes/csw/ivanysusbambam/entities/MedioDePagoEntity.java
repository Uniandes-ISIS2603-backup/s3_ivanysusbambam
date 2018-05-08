/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author j.sierrac
 */
@Entity
public class MedioDePagoEntity implements Serializable
{
     /**
     * Id de la Entity del medio de 
     */
   
    @Id
    private Long numero;
    
    /**
     * Define el tipo del medio de pago
     */
    @Enumerated(EnumType.STRING)
    private TipoMedioDePago tipo;
    
    @ManyToOne
    @PodamExclude
    private ClienteEntity cliente;
    
     @PodamExclude
    @OneToMany(mappedBy = "medioDePago", cascade = CascadeType.ALL)
    private List<VentaEntity> ventas;
    
/**
 * Da el numero del medio de pago
 * @return numero
 */
    public Long getNumero() {
        return numero;
    }
/**
 * Cambia el numero del medio de pago
 * @param numero 
 */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoMedioDePago getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedioDePago tipo) {
        this.tipo = tipo;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    public boolean validarTipoMedioDePago()
    {
      for(TipoMedioDePago pTipo: TipoMedioDePago.values())
      {
          if(this.tipo.equals(pTipo))
          {
              return true;
          }
      }
      return false;
                
                
    }
    
    public enum TipoMedioDePago {
        PAY_PAL, CREDITO, PSE;
    }
    
    
    public boolean compararMedioDePago(MedioDePagoEntity mdp){
        if(mdp == null){
            return false;
        }
        return this.numero.equals(mdp.numero);
    }
}


