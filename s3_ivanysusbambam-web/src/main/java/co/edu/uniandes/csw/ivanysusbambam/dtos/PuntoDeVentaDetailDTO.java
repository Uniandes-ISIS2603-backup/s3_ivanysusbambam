/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author if.garcia
 */
public class PuntoDeVentaDetailDTO extends PuntoDeVentaDTO{
    
    //private List<AutomovilDTO> automoviles;
    
    private List<VendedorDTO> vendedores;
    
    private List<CompraDTO> compras;
    
    private List<VentaDTO> ventas;
    
    public void inicializarListas(){
        vendedores = new ArrayList<>();
        compras = new ArrayList<>();
        ventas = new ArrayList<>();
    }
    
    public List<VendedorDTO> getVendedores(){
        return vendedores;
    }
    
    public List<CompraDTO> getCompras(){
        return compras;
    }
    
    public List<VentaDTO> getVentas(){
        return ventas;
    }
    
    public void addVendedor(VendedorDTO nuevoVendedor){
        vendedores.add(nuevoVendedor);
    }
    
    public void addCompra(CompraDTO nuevaCompra){
        compras.add(nuevaCompra);
    }
    
    public void addVenta(VentaDTO nuevaVenta){
        ventas.add(nuevaVenta);
    }
    
    /*
    public void addAutomovil(AutomovilDTO auto){
        this.auto = auto;
    }
    */
}
