/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    
    private ClienteEntity cliente;
    
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
      for(TipoMedioDePago tipo: TipoMedioDePago.values())
      {
          if(this.tipo.equals(tipo))
          {
              return true;
          }
      }
      return false;
                
                
    }
    
}


enum TipoMedioDePago {
    PAY_PAL, CREDITO, PSE;
}
