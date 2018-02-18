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
import javax.persistence.OneToMany;

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
public class ClienteEntity extends BaseEntity implements Serializable{
    
    @OneToMany(mappedBy="cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;
    
    @OneToMany(mappedBy = "cliente")
    private List<CalificacionTiendaEntity> calificacionesTienda;
    
    @OneToMany(mappedBy = "cliente")
    private List<QuejaReclamoEntity> quejasReclamos;
    
    @OneToMany(mappedBy = "cliente")
    private List<CompraEntity> compras;
    
    @OneToMany(mappedBy = "cliente")
    private List<VentaEntity> ventas;
    
    @OneToMany(mappedBy = "cliente")
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
        return super.getName();
    }
    
    public Long getCedula(){
        return super.getId();
    }
    
    public void setNombre(String nombre){
        super.setName(nombre);
    }
    
    public void setCedula(Long cedula){
        super.setId(cedula);
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
    
    
}
