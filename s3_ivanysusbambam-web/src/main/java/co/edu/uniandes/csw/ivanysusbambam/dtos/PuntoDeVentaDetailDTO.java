/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transferencia que contiene información detallada de un punto de venta.
 *  Al serializarse como JSON esta clase implementa el siguiente modelo:
 * <br>
 * <pre>
 *   {
 *       "id": number,
 *       "name": string,
 *       "direccion": string,
 *       "telefono": number,
 *       "automoviles": JSONArray
 *       "vendedores": JSONArray
 *       "compras": JSONArray
 *       "ventas": JSONArray
 *
 *
 *
 *   }
 * </pre> Por ejemplo un prospecto de compra representa así:<br>
 *
 * <pre>
 *
 *   {
 *          ""id": 12345,
 *          "name": "Los ángeles concesionario",
 *          "direccion": "cr 1 # 2 - 33",
 *          "telefono": "724 5874",
 *          "automoviles": {[]}
 *          "vendedores": {[]}
 *          "compras": {[]}
 *          "ventas": {[]}
 *
 *    }
 * </pre>
 *
/**
 *
 * @author if.garcia
 */
public class PuntoDeVentaDetailDTO extends PuntoDeVentaDTO{
    
    private List<AutomovilDTO> automoviles;
    
    private List<VendedorDTO> vendedores;
    
    private List<CompraDTO> compras;
    
    private List<VentaDTO> ventas;
    
    /**
     * Constructor por defecto
     */
    public PuntoDeVentaDetailDTO(){
        
    }
    
    public PuntoDeVentaDetailDTO(PuntoDeVentaEntity entity){
        super(entity);
        if(entity != null){
            inicializarListas();
            for(VentaEntity v : entity.getVentas()){
                ventas.add(new VentaDTO(v));
            }
            for(CompraEntity c: entity.getCompras()){
                compras.add(new CompraDTO(c));
            }
            for(VendedorEntity ve : entity.getVendedores()){
                vendedores.add(new VendedorDTO(ve));
            }
            for(AutomovilEntity at : entity.getAutomoviles()){
                automoviles.add(new AutomovilDTO(at));
            }
        }
    }
    
    //TODO: Falta el método toEntity
    
    
    public void inicializarListas(){
        automoviles = new ArrayList<>();
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
    
    public List<AutomovilDTO> getAutomoviles(){
        return automoviles;
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
    
    
    public void addAutomovil(AutomovilDTO nuevoAuto){
        automoviles.add(nuevoAuto);
    }
    
}
