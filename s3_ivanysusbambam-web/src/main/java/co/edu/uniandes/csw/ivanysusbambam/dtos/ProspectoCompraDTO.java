/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;

/**Objeto de transferencia de un prospecto de compra cliente.<br>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "texto": string,
 *      "id": number
 *   }
 * </pre>
 * Por ejemplo un prospecto de compra representa así:<br>
 * 
 * <pre>
 * 
 *   {
 *      "texto": "Cliente parece muy interesado en compra de Chevrolet Sail placas abc123.",
 *      "id": 12431
 *   }
 *
 * </pre>
 * @author Felipe Velásquez Montoya
 * <pre>
 * Versiones: 
 *  10/02/2018:
 *      -Añadido atributo
 *      -Añadidos getters y setters.
 * 12/02/2018
 *      -Extendida documentación.
 *      -Añadidos setters faltantes necesarios para JAXRS.
 * </pre>
 */
public class ProspectoCompraDTO {
    
    /**
     * Representa el texto escrito por el vendedor con respecto al prospecto.
     */
    private String texto;
    
    /**
     * Representa el identificador único del prospecto de compra.
     */
    //TODO: debe ser long y no Long (cambiar tambien set/get)
    private long id;

    //-------------------------------------CONSTRUCTOR-------------------------
    
    /**
     * Constructor por defecto.
     */
    public ProspectoCompraDTO(){
        
    }
    
    /**
     * Construye dto a partir de un Entity.
     * @param pe Entity al partir del cual se construirá dto
     */
    public ProspectoCompraDTO(ProspectoCompraEntity pe){
        if(pe!=null){
            this.texto = pe.getTexto();
            this.id = pe.getId();
        }
    }
    
    /**
     * Construye y retorna un entity a partir del actual dto.
     * @return Entity construido con la información del este dto.
     */
    public ProspectoCompraEntity toEntity(){
        ProspectoCompraEntity pe = new ProspectoCompraEntity();
        
        pe.setTexto(texto);
        pe.setId(id);
        return pe;
    }
    
    //---------------------------------------GETTERS----------------------------
    /**
     * @return el texto respectivo.
     */
    public String getTexto() {
        return texto;
    }
    
    /**
     * 
     * @return identificador del prospecto.
     */
    public long getId(){
        return id;
    }

    //-------------------------------------------SETTERS---------------------------------
    /**
     * @param texto el texto escrito por el vendedor.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * 
     * @param id el id del prospecto.
     */
    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
}
