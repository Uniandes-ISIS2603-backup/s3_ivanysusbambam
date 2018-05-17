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
 * Objeto de transferencia que contiene información detallada de un punto de
 * venta. Al serializarse como JSON esta clase implementa el siguiente modelo:
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
 * /**
 *
 * @author if.garcia
 */
public class PuntoDeVentaDetailDTO extends PuntoDeVentaDTO {

    /**
     * Automoviles del punto de venta
     */
    private List<AutomovilDTO> automoviles;

    /**
     * Vendedores del punto de venta
     */
    private List<VendedorDTO> vendedores;

    /**
     * Compras del punto de venta
     */
    private List<CompraDTO> compras;

    /**
     * Ventas del punto de venta
     */
    private List<VentaDTO> ventas;

    /**
     * Constructor por defecto
     */
    public PuntoDeVentaDetailDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Crean un nuevo detailDTO con la informacion de la entidad
     *
     * @param entity entidad con la informacion
     */
    public PuntoDeVentaDetailDTO(PuntoDeVentaEntity entity) {
        super(entity);
        if (entity != null) {
            inicializarListas();
            if (entity.getVentas() != null) {
                for (VentaEntity v : entity.getVentas()) {
                    ventas.add(new VentaDTO(v));
                }
            }
            if (entity.getCompras() != null) {
                for (CompraEntity c : entity.getCompras()) {
                    compras.add(new CompraDTO(c));
                }
            }

            if (entity.getVendedores() != null) {
                for (VendedorEntity ve : entity.getVendedores()) {
                    vendedores.add(new VendedorDTO(ve));
                }
            }
            if (entity.getAutomoviles() != null) {
                for (AutomovilEntity at : entity.getAutomoviles()) {
                    automoviles.add(new AutomovilDTO(at));
                }
            }
        }
    }

    /**
     * Crea una nueva entidad con la informacion del detailDTO
     *
     * @return la nueva entidad
     */
    @Override
    public PuntoDeVentaEntity toEntity() {
        PuntoDeVentaEntity pvEntity = super.toEntity();

        if (automoviles != null) {
            List<AutomovilEntity> autos = new ArrayList<>();
            for (AutomovilDTO auto : automoviles) {
                autos.add(auto.toEntity());
            }
            pvEntity.setAutomoviles(autos);
        }
        if (compras != null) {
            List<CompraEntity> cps = new ArrayList<>();
            for (CompraDTO cp : compras) {
                cps.add(cp.toEntity());
            }
            pvEntity.setCompras(cps);
        }
        if (ventas != null) {
            List<VentaEntity> vts = new ArrayList<>();
            for (VentaDTO vt : ventas) {
                vts.add(vt.toEntity());
            }
            pvEntity.setVentas(vts);
        }
        if (vendedores != null) {
            List<VendedorEntity> vds = new ArrayList<>();
            for (VendedorDTO vd : vendedores) {
                vds.add(vd.toEntity());
            }
            pvEntity.setVendedores(vds);
        }

        return pvEntity;
    }

    public void inicializarListas(){
        automoviles = new ArrayList<>();
        vendedores = new ArrayList<>();
        compras = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public List<VendedorDTO> getVendedores() {
        return vendedores;
    }

    public List<CompraDTO> getCompras() {
        return compras;
    }

    public List<VentaDTO> getVentas() {
        return ventas;
    }

    public List<AutomovilDTO> getAutomoviles() {
        return automoviles;
    }

}
