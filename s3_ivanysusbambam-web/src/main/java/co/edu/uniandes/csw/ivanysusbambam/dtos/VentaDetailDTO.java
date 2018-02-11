/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

/**
 *
 * @author hd.castellanos
 */
public class VentaDetailDTO extends VentaDTO{
    
/**
 * Atributo para el cliente que 
 */   
    private ClienteDTO cliente;
    
    /**
     * Atributo para el medio de pago 
     */
    
     private MedioDePagoDTO medioDePago;
    
    /**
     * Atributo para el vendedor encargado
     */
    private VendedorDTO vendedorEncargado;
    
    /**
     * Atributo para la calificacion del automovil asociado a esta venta
     */
   private CalificacionCarroDTO calificacionCarro;
    
    /**
     * Atributo para el punto de venta
     */
   //protected PuntoDeVentaDTO puntoDeVenta;
    
    /**
     * Atributo para el Automovil
     */
    
    //protected AutomovilDTO automovil;
    
    
     /**
     * Constructor por defecto
     */
    public VentaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de venta a partir de la cual se construye el objeto
     */
    public VentaDetailDTO(VentaEntity entity) {
      super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
   @Override
   public VentaEntity toEntity() {
     VentaEntity VentaE = super.toEntity();
    return VentaE;
   }

    
    //---------------------GETTERS-------------------------
    /**
     * @return el clinete asociado con este venta 
     */
   // public ClienteDTO getCliente(){
     //   return cliente;
   // }
    /**
     * @return el medio de pago que se uso para esta venta 
     */
//    public MedioDePagoDTO getMedioDePago (){
  //      return medioDePago;
    //}
    
    /**
     * @return el vendedor encargado de esa venta  
     */
    //public VendedorDTO getVendedorEncgardo (){
      //  return vendedorEncargado;
   // }
    
    /**
     * @return el automovil asociado con esta venta
     */
    //public AutomovilDTO getAutomovil(){
      //  return automovil;
    //}
    
    /**
     * @return el punto de venta asciado a esta venta
     */
   // public PuntoDeVentaDTO getPuntoDeVenta(){
     //   return puntoDeVenta;
    //}
    
    /**
     * @return la calificacion del carro asociada a esta venta
     */
    public CalificacionCarroDTO getCalificacionCarro (){
      return calificacionCarro;
   }
    
    //---------------------Setters-------------------------
    
   
    
    
    
    
    
    
}
