/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import java.util.List;

/**Objeto de transferencia de datos detallado del cliente. Hereda de ClienteDTO <br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * < Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 * 
 *      "nombre": string,
 *      "cedula": number,
 *      "calificacionesTienda" : JSONarray,
 *      "compras" : JSONarray,
 *      "prospectosCompra": JSONarray,
 *      "quejasReclamos": JSONarray,
 *      "ventas": JSONarray
 *   }
 * </pre>
 * Por ejemplo un cliente se representa así:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombre": "Felipe Velasquez",
 *      "cedula": 1016609031,
 *      "calificacionesTienda" : [{"comentario" : "Excelente tienda, recomendada","id": 1, "puntaje": 4.5}], 
 *      "compras" : [{"idCompra": 4562}],
 *      "prospectosCompra": [{"texto": "Cliente muy interesado en la compra de Chevrolet Sail", "id": 123}],
 *      "quejasReclamos": [],
 *      "ventas": [{"idVenta": 17231}]
 *   }
 * </pre>
 * 
 * @author Felipe Velásquez Montoya
 * <pre>
 * Versiones: 
 * 10/02/2018
 *      -Creación de atributos.
 *      -Creación de getters y adders.
 * 12/02/2018
 *      -Extendida documentación.
 *      -añadidos setters, necesarios para JAX-RS
 * </pre>
 */
public class ClienteDetailDTO extends ClienteDTO {
    
    /**
     * Representa los prospectos de compra del cliente.
     */
    private List<ProspectoCompraDTO> prospectosCompra;
    
    
    /**
     * Representa las calificaciones de la tienda hechas por el cliente.
     */
    private List<CalificacionTiendaDTO> calificacionesTienda;
    
    /**
    * Representa las quejas o reclamos puestas por el cliente.
    */
    
    private List<QuejaReclamoDTO> quejasReclamos;
    
    /**
     * Representa las compras del cliente.
     */
    private List<CompraDTO> compras;
    
    /**
     * Representa las ventas del cliente.
     */
    private List<VentaDTO> ventas;
    
    /**
     * Representa los medios de pago registrados por el cliente.
     */
    private List<MedioDePagoDTO>  mediosDePago;
    
    //-----------------------------CONSTRUCTOR---------------------------
    public ClienteDetailDTO(){
        
    }
    
    //-----------------------------GETTERS--------------------------------
    
    /**
     * @return una lista conteniendo todos los prospectos de compra del cliente.
     */
    public List<ProspectoCompraDTO> getProspectosCompra(){
        return prospectosCompra;
    }  
    
    
    /**
     * @return una lista conteniendo todas las calificaciones hechas por el cliente.
     */
    public List<CalificacionTiendaDTO> getCalificacionesTienda(){
        return calificacionesTienda;
    }
    
    /**
     * @return una lista conteniendo todas las quejas o reclamos hechas por el cliente.
     */
    /*public List<QuejaReclamoDTO> getQuejasReclamos(){
        return quejasReclamos;
    }*/
    
    /**
     * @return una lista conteniendo todas las compras del cliente.
     */
    public List<CompraDTO> getCompras(){
        return compras;
    }
    
    /**
     * @return una lista conteniendo todas las ventas del cliente.
     */
    public List<VentaDTO> getVentas(){
        return ventas;
    }
    
    /**
     * @return una lista conteniendo todos los medio de pago registrados por el cliente.
     */
    public List<MedioDePagoDTO> getMediosDePago(){
        return mediosDePago;
    }
    
    //---------------------------ADDERS----------------------------------
    
    /**
     * Añade el prospecto de compra pasado por parámetro a los prospectos de compra del cliente.
     * <b>pos</b> se ha añadido el prospecto de compra.
     * @param prospecto el prospecto de compra que se desea añadir.
     */
    public void addProspectoCompra(ProspectoCompraDTO prospecto){
        prospectosCompra.add(prospecto);
    }
    
    /**
     * Añade la calificación de la tienda pasada por parámetro a las calificaciones de la tienda hechas por el cliente.
     * <b>pos</b> se ha añadido la calificacion
     * @param calificacion la calificación que se desea añadir.
     */
    public void addCalificacionTienda(CalificacionTiendaDTO calificacion){
        calificacionesTienda.add(calificacion);
    }
    
    /**
     * Añade la queja o reclamo pasada por parametro a las quejas y reclamos del cliente.
     * <b>pos</b> se ha añadido la queja o reclamo.
     * @param quejaReclamo la queja o reclamo que se desea añadir.
     */
    public void addQuejaReclamo(QuejaReclamoDTO quejaReclamo){
        quejasReclamos.add(quejaReclamo);
    }
    
    /**
     * Añade la compra pasada por parámetro a las compras del cliente.
     * <b>pos</b> se ha añadido la compra.
     * @param compra la compra que se desea añadir.
     */
    public void addCompra(CompraDTO compra){
        compras.add(compra);
    }
    
    /**
     * Añade la venta pasada por parámetro a las ventas del cliente.
     * <b>pos</b> se ha añadido la venta.
     * @param venta la venta que se desea añadir.
     */
    public void addVenta(VentaDTO venta){
        ventas.add(venta);
    }
    
    /**
     * Añade el medio de pago pasado por parámetro a los medio de pago registrados por el cliente.
     * <b>pos</b> se ha añadido el medio de pago.
     * @param medioPago el medio de pago que se desea añadir.
     */
    public void addMedioDePago(MedioDePagoDTO medioPago){
        mediosDePago.add(medioPago);
    }
    
    //------------------SETTERS---------------------

    /**
     * 
     * @param prospectosCompra la lista de prospectos de compra.
     */
    public void setProspectosCompra(List<ProspectoCompraDTO> prospectosCompra) {
        this.prospectosCompra = prospectosCompra;
    }

    /**
     * 
     * @param calificacionesTienda la lista de calificaciones de la tienda.
     */
    public void setCalificacionesTienda(List<CalificacionTiendaDTO> calificacionesTienda) {
        this.calificacionesTienda = calificacionesTienda;
    }

    /**
     * 
     * @param quejasReclamos la lista de quejas y reclamos.
     */
    public void setQuejasReclamos(List<QuejaReclamoDTO> quejasReclamos) {
        this.quejasReclamos = quejasReclamos;
    }

    /**
     * 
     * @param compras la lista de compras.
     */
    public void setCompras(List<CompraDTO> compras) {
        this.compras = compras;
    }

    /**
     * 
     * @param ventas la lista de ventas.
     */
    public void setVentas(List<VentaDTO> ventas) {
        this.ventas = ventas;
    }

    /**
     * 
     * @param mediosDePago la lista de medios de pagos registrados
     */
    public void setMediosDePago(List<MedioDePagoDTO> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }
    
}
