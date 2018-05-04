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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

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
public class VendedorEntity implements Serializable{
    
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carnetVendedor;
    
    @PodamStrategyValue(CedulaStrategy.class)
    private Long cedula;
    
    @Lob
    private String imagen;
    
    @PodamExclude
    @OneToMany(mappedBy="vendedor",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProspectoCompraEntity> prospectosCompra;
    
    @PodamExclude
    @OneToMany(mappedBy="vendedorEncargado")
    private List<VentaEntity> ventas;
    
    @PodamExclude
    @OneToMany(mappedBy="vendedorEncargado")
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
        return carnetVendedor;
    }
    
    /**
     * 
     * @return nombre del vendedor.
     */
    public String getNombre(){
        return nombre;
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
        this.nombre = name;
    }
    
    /**
     * 
     * @param id carnet del vendedor.
     */
    public void setCarnetVendedor(Long id){
        this.carnetVendedor = id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        
        if (!(obj instanceof VendedorEntity))
            return false;
        
        if (this.getCarnetVendedor() != null && ((VendedorEntity) obj).getCarnetVendedor() != null) {
            return this.getCarnetVendedor().equals(((VendedorEntity) obj).getCarnetVendedor());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getCarnetVendedor() != null) {
            return this.getCarnetVendedor().hashCode();
        }
        return super.hashCode();
    
    }
}
