/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;


import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MarcaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Joseph Ortíz Moreno
 */
@Stateless
public class MarcaLogic {

    @Inject
    private MarcaPersistence persistence;
    
   /** @Inject
    private AutomovilPersitence persistencea; // TO DO: FALTA LA PERSISTENCIA DEL AUTOMOVIL.
*/
    
    private static final Logger LOG = Logger.getLogger(MarcaLogic.class.getName());

    /**
     * Persiste una marca en la base de datos.
     *
     * @param ne la marca entity que se busca persistir
     * @return La marca que se persistió
     * @throws BusinessLogicException Si ya existe una marca con el nombre dado, o si el nombre que se busca es null
     */
    public MarcaEntity createMarca(MarcaEntity ne) throws BusinessLogicException {

        if (persistence.find(ne.getNombre()) != null) {
            throw new BusinessLogicException("Ya existe una marca con el nombre dado");
        }
        if (ne.getNombre() == null) {
            throw new BusinessLogicException("El nombre no puede ser null");
        }
        return persistence.create(ne);
    }

    /**
     * Consulta todas las marcas registradas en la base de datos.
     *
     * @return una lista con todas las marcas registradas en la base de datos,
     * null si no hay ningunoa.
     */
    public List<MarcaEntity> findAllMarcas() {
        LOG.info("consultando todas las marcas");
        return persistence.findAll();
    }

    /**
     * Actualiza una marca pasada por parámetro.
     *
     * @param ma la marca con la información actualizada.
     * @return la marca que se acaba de actualizar.
     * @throws BusinessLogicException si la marca que se buscaba actualizar no
     * existe o si se desea ingresar una marca nula.
     */
    public MarcaEntity updateMarca(MarcaEntity ma) throws BusinessLogicException {
        LOG.log(Level.INFO, "Actualizando marca con nombre: {0}", ma.getNombre());
        if (ma == null) {
            throw new BusinessLogicException("La marca  a ser actualizado no puede ser null");
        }
        MarcaEntity mar = persistence.find(ma.getNombre());
        if (mar == null) {
            throw new BusinessLogicException("No se puede actualizar una marca inexistente");
        }
        return persistence.update(ma);
    }

    /**
     * Elimina la marca correspondiente al nombre dado por parametro.
     *
     * @param nom nombre de la marca que se quiere eliminar.
     * @throws BusinessLogicException si la marca que se busca eliminar no
     * existe o si el id dado por parámetro == null.
     */
    public void deleteMarca(String nom) throws BusinessLogicException {
        LOG.log(Level.INFO, "Intentando eliminar marca con nombre: {0}", nom);
        if (nom == null) {
            throw new BusinessLogicException("La nombre no puede ser null");
        }
        if(persistence.find(nom)==null){
            throw new BusinessLogicException("La marca no existe en la base de datos");
        }
        persistence.delete(nom);
    }

    /**
     * Busca una marca según su nombre
     *
     * @param nom nombre de la marca que se busca.
     * @return la marca buscada, null si no existe.
     * @throws BusinessLogicException si nom == null o id no está en un formato
     * válido.
     */
    public MarcaEntity findMarca(String nom) throws BusinessLogicException {
 
        return persistence.find(nom);
    }


}
