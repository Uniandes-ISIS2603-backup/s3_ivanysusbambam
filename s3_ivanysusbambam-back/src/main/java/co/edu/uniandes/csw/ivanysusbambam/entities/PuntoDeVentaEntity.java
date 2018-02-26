/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author if.garcia
 */
@Entity
public class PuntoDeVentaEntity extends BaseEntity implements Serializable{
    
    private String direccion;
    
    private Integer telefono;
    
    private String nombre;
    
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta")
    private List<VendedorEntity> vendedores;
    
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta")
    private List<CompraEntity> compras;
    
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta")
    private List<VentaEntity> ventas;
    
    @PodamExclude
    @OneToMany(mappedBy = "puntoDeVenta")
    private List<AutomovilEntity> automoviles;

    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * @return the vendedores
     */
    public List<VendedorEntity> getVendedores(){
        return vendedores;
    }
    
     /**
     * @return the compras
     */
    public List<CompraEntity> getCompras(){
        return compras;
    }
 
    /**
     * @return the ventas
     */
    public List<VentaEntity> getVentas() {
        return ventas;
    }

    /**
     * @return the automoviles
     */
    public List<AutomovilEntity> getAutomoviles() {
        return automoviles;
    }

    /**
     * @param vendedores the vendedores to set
     */
    public void setVendedores(List<VendedorEntity> vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraEntity> compras) {
        this.compras = compras;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    /**
     * @param automoviles the automoviles to set
     */
    public void setAutomoviles(List<AutomovilEntity> automoviles) {
        this.automoviles = automoviles;
    }
}
