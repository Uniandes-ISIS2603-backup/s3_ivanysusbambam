/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import co.edu.uniandes.csw.ivanysusbambam.podam.CedulaStrategy;
import co.edu.uniandes.csw.ivanysusbambam.podam.NombreStrategy;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.jpa.config.Cascade;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Felipe Velásquez Montoya
 * <pre>
 *  Versiones: 
 *      18/02/2018
 *          -Creada clase, atributos, getters y setters.
 * </pre>
 */

@Entity
public class ClienteEntity implements Serializable{
    
    @Id
    @PodamStrategyValue(CedulaStrategy.class)
    private Long cedula;
    
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;
    
    @PodamExclude
    @OneToMany(mappedBy="cliente",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CalificacionTiendaEntity> calificacionesTienda;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<QuejaReclamoEntity> quejasReclamos;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CompraEntity> compras;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<VentaEntity> ventas;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<MedioDePagoEntity> mediosDePago;

    
    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }
    public List<CalificacionTiendaEntity> getCalificacionesTienda() {
        return calificacionesTienda;
    }

    public List<QuejaReclamoEntity> getQuejasReclamos() {
        return quejasReclamos;
    }

    public List<CompraEntity> getCompras() {
        return compras;
    }

    public List<VentaEntity> getVentas() {
        return ventas;
    }

   public List<MedioDePagoEntity> getMediosDePago() {
        return mediosDePago;
    }

    
    
    public String getNombre(){
        return nombre;
    }
    
    public Long getCedula(){
        return cedula;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCedula(Long cedula){
        this.cedula = cedula;
    }

    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    public void setCalificacionesTienda(List<CalificacionTiendaEntity> calificacionesTienda) {
        this.calificacionesTienda = calificacionesTienda;
    }

    public void setQuejasReclamos(List<QuejaReclamoEntity> quejasReclamos) {
        this.quejasReclamos = quejasReclamos;
    }

    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public void setMediosDePago(List<MedioDePagoEntity> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }
  
    public boolean equals(ClienteEntity obj) {
        
        if (obj.getCedula() != null && this.getCedula() != null) {
            return this.getCedula().equals(obj.cedula);
        }
        
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.cedula != null) {
            return this.cedula.hashCode();
        }
        return super.hashCode();
    }
}
