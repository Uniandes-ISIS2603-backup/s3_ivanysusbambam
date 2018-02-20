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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Felipe Velásquez Montoya
 * 
 * <pre>
 * Versiones: 
 *  18/02/2018
 *      -Creada la clase, atributos, getters y setters.
 * </pre>
 */
@Entity
public class VendedorEntity extends BaseEntity implements Serializable{
    
    private Long cedula;
    
    
    @PodamExclude
    @OneToMany(mappedBy="vendedor",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;
    
    @PodamExclude
    @OneToMany(mappedBy="vendedor")
    private List<VentaEntity> ventas;
    
    @PodamExclude
    @OneToMany(mappedBy="vendedor")
    private List<CompraEntity> compras;
    
    @PodamExclude
    @ManyToOne
    private PuntoDeVentaEntity puntoDeVenta;

    public void setProspectosCompra(List<ProspectoCompraEntity> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    public void setPuntoDeVenta(PuntoDeVentaEntity puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }
    
    
    
    /**
     * 
     * @return cedula
     */
    public Long getCedula(){
        return cedula;
    }
    
    /**
     * 
     * @return carnet del vendedor
     */
    public Long getCarnetVendedor(){
        return super.getId();
    }
    
    /**
     * 
     * @return nombre del vendedor.
     */
    public String getNombre(){
        return super.getName();
    }

    /**
     * 
     * @param cedula cédula del vendedor.
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
    
    /**
     * 
     * @param name nombre del vendedor.
     */
    public void setNombre(String name){
        super.setName(name);
    }
    
    /**
     * 
     * @param id carnet del vendedor.
     */
    public void setCarnetVendedor(Long id){
        super.setId(id);
    }

    public List<ProspectoCompraEntity> getProspectosCompra() {
        return prospectosCompra;
    }

    public List<VentaEntity> getVentas() {
        return ventas;
    }

    public List<CompraEntity> getCompras() {
        return compras;
    }

    public PuntoDeVentaEntity getPuntoDeVenta() {
        return puntoDeVenta;
    }
}
