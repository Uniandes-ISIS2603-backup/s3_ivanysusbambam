/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transferencia que contiene información detallada de un vendedor. Al
 * serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": string,
 *      "cedula": number,
 *      "carnetVendedor": number,
 *      "prospectosCompra": JSONarray,
 *      "ventas" : JSONarray,
 *      "compras": JSONarray,
 *      "puntoDeVenta": JSON
 *   }
 * </pre> Por ejemplo un vendedr se representa así:<br>
 *
 * <pre>
 *
 *   {
 *      "nombre": "Joseph Ortiz",
 *      "cedula": 1234567890,
 *      "carnetVendedor" : 1432,
 *      "prospectosCompra": [{"texto" : "Cliente muy interesado en dodge ram 2008, "id": 153}],
 *      "ventas": [{"idVenta":1435},{"idVenta":27932}],
 *      "compras": [{"idCompra: 243}],
 *      "puntoDeVenta":{"dirección": "carrera 15 # 127", "teléfono":6343421},"nombre": "Mi automóvil unicentro"}
 *
 *   }
 *
 * </pre>
 *
 * @author Felipe Velásquez Montoya  <pre>
 * Verisones:
 *  10/02/2018:
 *      -Añadidos atributos.
 *      -Añadidos getters, setters y adders.
 * 12/02/2018:
 *      -Extendida documentación.
 *      -Añadidos setters faltantes necesarios para JAXRS
 * </pre>
 */
public class VendedorDetailDTO extends VendedorDTO {

    /**
     * Representa los prospectos de compra creados por el vendedor.
     */
    private List<ProspectoCompraDTO> prospectosCompra;

    /**
     * Representa las ventas del vendedor.
     */
    private List<VentaDTO> ventas;

    /**
     * Representa las compras del vendedor.
     */
    private List<CompraDTO> compras;

    /**
     * Representa el punto de venta en el que trabaja el vendedor.
     */
    private PuntoDeVentaDTO puntoDeVenta;

    //-------------------------CONSTRUCTOR--------------------------
    /**
     * Constructor por defecto.
     */
    public VendedorDetailDTO() {
        //Constructor utilizado por JAX
    }

    /**
     * Metodo auxiliar par reducir complejidad ciclomática del constructor
     * @param ve entity el que se convertirán los prospecto de compra.
     */
    private void convertirProspectosDeCompra(VendedorEntity ve){
        if (ve.getProspectosCompra() != null) {
                if (prospectosCompra == null) {
                    prospectosCompra = new ArrayList();
                }
                for (ProspectoCompraEntity ent : ve.getProspectosCompra()) {
                    prospectosCompra.add(new ProspectoCompraDTO(ent));
                }
            }
    }
    
    /**
     * Metodo auxiliar par reducir complejidad ciclomática del constructor
     * @param ve entity el que se convertirán las compras.
     */
    private void convertirVentas(VendedorEntity ve){
        if (ve.getVentas() != null) {
                if (ventas == null) {
                    ventas = new ArrayList();
                }
                for (VentaEntity ent : ve.getVentas()) {
                    ventas.add(new VentaDTO(ent));
                }
            }
    }
    
    /**
     * Metodo auxiliar par reducir complejidad ciclomática del constructor
     * @param ve entity el que se convertirán las compras.
     */
    private void convertirCompras(VendedorEntity ve){
    
        if (ve.getCompras() != null) {
            if (compras == null) {
                compras = new ArrayList();
            }
            for (CompraEntity ent : ve.getCompras()) {
                compras.add(new CompraDTO(ent));
            }
        }
    }
    
    /**
     * Construye un dto según un entity.
     *
     * @param ve entity.
     */
    public VendedorDetailDTO(VendedorEntity ve) {
        super(ve);
        if (ve != null) {
            
            convertirProspectosDeCompra(ve);
            
            convertirVentas(ve);
            
            convertirCompras(ve);
            
            this.puntoDeVenta = new PuntoDeVentaDTO(ve.getPuntoDeVenta());
        }
    }

    /**
     * Construye y retorna un entity correspondiente al DTO
     *
     * @return Entity
     */
    @Override
    public VendedorEntity toEntity() {
        VendedorEntity ve = super.toEntity();

        if (prospectosCompra != null) {
            List<ProspectoCompraEntity> list = new ArrayList<>();
            for (ProspectoCompraDTO dto : prospectosCompra) {
                list.add(dto.toEntity());
            }
            ve.setProspectosCompra(list);
        }
        if (ventas != null) {
            List<VentaEntity> list = new ArrayList<>();
            for (VentaDTO dto : ventas) {
                list.add(dto.toEntity());
            }
            ve.setVentas(list);
        }

        if (compras != null) {
            List<CompraEntity> list = new ArrayList<>();
            for (CompraDTO dto : compras) {
                list.add(dto.toEntity());
            }
            ve.setCompras(list);
        }

        if (puntoDeVenta != null) {
            ve.setPuntoDeVenta(puntoDeVenta.toEntity());
        }

        return ve;
    }

    //-------------------------GETTERS-------------------------------
    /**
     *
     * @return la lista con los prospectos de compra creados por el vendedor.
     */
    public List<ProspectoCompraDTO> getProspectosCompra() {
        return prospectosCompra;
    }

    /**
     * @return las ventas del vendedor.
     */
    public List<VentaDTO> getVentas() {
        return ventas;
    }

    /**
     * @return las compras del vendedor.
     */
    public List<CompraDTO> getCompras() {
        return compras;
    }

    /**
     * @return el punto de venta del vendedor.
     */
    public PuntoDeVentaDTO getPuntoDeVenta() {
        return puntoDeVenta;
    }

    //---------------------------SETTERS----------------------------
    /**
     * Cambia el punto de venta al que pertenece el vendedor.
     *
     * @param puntoDeVenta el punto de venta al que se asignará el vendedor.
     */
    public void setPuntoDeVenta(PuntoDeVentaDTO puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    /**
     *
     * @param prospectosCompra lista con los prospectos de compra creados por el
     * vendedor.
     */
    public void setProspectosCompra(List<ProspectoCompraDTO> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    /**
     *
     * @param ventas lista con las ventas del vendedor.
     */
    public void setVentas(List<VentaDTO> ventas) {
        this.ventas = ventas;
    }

    /**
     *
     * @param compras lista con las ventas del vendedor.
     */
    public void setCompras(List<CompraDTO> compras) {
        this.compras = compras;
    }

    //---------------------------ADDERS-----------------------------
    /**
     * Añade un prospecto de compra al vendedor.
     * <b>pos: </b> se ha añadido el prospecto de compra.
     *
     * @param prospectoCompra el prospecto de comrpa a ser añadido.
     */
    public void addProspectoCompra(ProspectoCompraDTO prospectoCompra) {
        prospectosCompra.add(prospectoCompra);
    }

    /**
     * Añade una venta al vendedor.
     * <b>pos: </b> se ha añadido la venta
     *
     * @param venta la venta al vendedor.
     */
    public void addVenta(VentaDTO venta) {
        ventas.add(venta);
    }

    /**
     * Añade una compra al vendedor.
     * <b>pos: </b> se ha añadido la compra.
     *
     * @param compra la compra a a ser añadida.
     */
    public void addCompra(CompraDTO compra) {
        compras.add(compra);
    }

}
