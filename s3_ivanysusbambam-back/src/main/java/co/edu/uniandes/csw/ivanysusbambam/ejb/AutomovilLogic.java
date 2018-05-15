/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CompraPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MarcaPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ModelPersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hd.castellanos
 */
@Stateless
public class AutomovilLogic {

    /**
     * Constante para el Logger
     */
    private static final Logger LOGGER = Logger.getLogger(AutomovilLogic.class.getName());
    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private AutomovilPersistence persistence;
    /**
     * variable para la persistencia del modelo del automovil
     */
    @Inject
    private ModelPersistence modeloPersistence;

    /**
     * variable para la persistencia de la marca del automovil
     */
    @Inject
    private MarcaPersistence marcaPersistence;

    /**
     * variable para el punto de venta del automovil
     */
    @Inject
    private PuntoDeVentaPersistence puntoPersistence;

    /**
     * variable para la compra del automovil
     */
    @Inject
    private CompraPersistence compraPersistence;

    /**
     * Método privado para reducir complejidad ciclomática e createAutomovil
     * @param automovilEntity AutomovilEntity sobre el que se harán verificaciones de lógica.
     * @throws BusinessLogicException  si se incumple alguna de las reglas de lógica verificadas.
     */
    private void verificacionesAuto1(AutomovilEntity automovilEntity) throws BusinessLogicException{
        if (!verificarPlaca(automovilEntity.getPlaca())) {
            throw new BusinessLogicException("El formato de a placa del automovil no es valido");
        }

        if (automovilEntity.getCompra() == null) {
            throw new BusinessLogicException("La compra es nula");
        }
        if (automovilEntity.getCompra().getIdCompra() == null) {
            throw new BusinessLogicException("el id de la compra es nula");
        }

        // verifica que el modelo y su id no sean nulos
        if (automovilEntity.getModel() == null) {
            throw new BusinessLogicException("El modelo es nulo");
        }
    }
    
    /**
     * Método privado para reducir complejidad ciclomática e createAutomovil<br>
     * <b>pre: </b> automovilEntity.gettModel() != null
     * @param automovilEntity AutomovilEntity sobre el que se harán verificaciones de lógica.
     * @throws BusinessLogicException  si se incumple alguna de las reglas de lógica verificadas.
     */
    private void verificacionesAuto2(AutomovilEntity automovilEntity)throws BusinessLogicException{
        
        if (automovilEntity.getModel().getId() == null) {
            throw new BusinessLogicException("El id del modelo es nulo");
        }
        // revisa que la marca ni su id sean null
        if (automovilEntity.getMarca() == null) {
            throw new BusinessLogicException("la marca es nulo");
        }

        if (automovilEntity.getMarca().getId() == null) {
            throw new BusinessLogicException("el id de la marca es null ");
        
        }
        if (automovilEntity.getModel().getId() == null) {
            throw new BusinessLogicException("El id del modelo es nulo");
        }
        // revisa que la marca ni su id sean null
        if (automovilEntity.getMarca() == null) {
            throw new BusinessLogicException("la marca es nulo");
        }

        if (automovilEntity.getMarca().getId() == null) {
            throw new BusinessLogicException("el id de la marca es null ");
        }
        
        // revisa que el punto de venta y su id no sea null
        if (automovilEntity.getPuntoDeVenta() == null) {
            throw new BusinessLogicException("el punto de venta es nulo");
        }
        if (automovilEntity.getPuntoDeVenta().getId() == null) {
            throw new BusinessLogicException("el id del punto de venta es null ");
        }
    }
    
    /**
     * Método privado para reducir complejidad ciclomática e createAutomovil
     * @param automovilEntity AutomovilEntity sobre el que se harán verificaciones de lógica.
     * @throws BusinessLogicException  si se incumple alguna de las reglas de lógica verificadas.
     */
    private void verificacionesAuto3(AutomovilEntity automovilEntity)throws BusinessLogicException{
    
        
        
        
        if (puntoPersistence.find(automovilEntity.getPuntoDeVenta().getId()) == null) {
            throw new BusinessLogicException("El Punto de venta del automovil no esta registrado en la base de datos");
        }

        if (modeloPersistence.find(automovilEntity.getModel().getId()) == null) {
            throw new BusinessLogicException("El Modelo del automovil no está registrado en la base de datos");
        }

        if (marcaPersistence.find(automovilEntity.getMarca().getId()) == null) {
            throw new BusinessLogicException("la marca del automovil no esta registrada en la base de datos ");
        }

        if (compraPersistence.find(automovilEntity.getCompra().getIdCompra()) == null) {
            throw new BusinessLogicException("la compra asociada a este automovil no existe ");
        }
        
    }
        
        
    
    /**
     * Crea una nueva entidad del automovil y verifica las reglas de negocio
     *
     * @param automovilEntity entidad de automovil que se quiere crear
     * @return la entidad del automovil que se creo
     * @throws BusinessLogicException si no se cumple las reglas de negocio
     * necesarias para crear el automovil
     */
    public AutomovilEntity createAutomovil(AutomovilEntity automovilEntity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de automovil");

        verificacionesAuto1(automovilEntity);

        verificacionesAuto2(automovilEntity);
        
        verificacionesAuto3(automovilEntity);

        // Invoca la persistencia para crear el automovil 
        persistence.create(automovilEntity);
        LOGGER.info("Termina proceso de creación de automovil");
        return automovilEntity;
    }

    /**
     * retorna todos los automoviles en la persistencia
     *
     * @return
     */
    public List<AutomovilEntity> getAutomoviles() {

        return persistence.findAll();

    }

    /**
     * busca un automovil por su id
     *
     * @param id del automovil que se quiere buscar
     * @return el automovil asociado al id dado por parametro
     * @throws BusinessLogicException si el id no es valido
     *
     */
    public AutomovilEntity getAutomovil(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("Id no es valido");
        }
        return persistence.find(id);
    }

    /**
     * Método privado para reducir complejidad ciclomática de updateAutomovil
     * @param automovilEntity automovil sobre el cuál se harán las verificaciones
     */
    private void verificacionInfoConsistente(AutomovilEntity automovilEntity) throws BusinessLogicException{
        AutomovilEntity newAutoEntity = persistence.find(automovilEntity.getId());
        if (newAutoEntity == null) {
            throw new BusinessLogicException("No existe el automovil que se quiere actualizar");
        }

        if (automovilEntity.getModel() == null || !newAutoEntity.getModel().equals(automovilEntity.getModel())) {
            throw new BusinessLogicException("No se puede modificar el modelo");
        }
        if (automovilEntity.getMarca() == null || !newAutoEntity.getMarca().equals(automovilEntity.getMarca())) {
            throw new BusinessLogicException("No se puede verificar la marca");
        }
        
        verificacionCompraPvConsistente(automovilEntity, newAutoEntity);
    }
    
    /**
     * Método privado para reducir complejidad ciclomática de updateAutomovil
     * @param automovilEntity automovil sobre el cuál se harán las verificaciones
     */
    private void verificacionCompraPvConsistente(AutomovilEntity automovilEntity, AutomovilEntity newAutoEntity)throws BusinessLogicException{
        
        if (automovilEntity.getPuntoDeVenta() == null || !newAutoEntity.getPuntoDeVenta().equals(automovilEntity.getPuntoDeVenta())) {
            throw new BusinessLogicException("No se puede modificar el punto de venta ");
        }

        if (automovilEntity.getCompra() == null || newAutoEntity.compararCompra(automovilEntity.getCompra()) != 0) {
            throw new BusinessLogicException("no se puede cambiar la compra ");
        }
    }
    
    
    /**
     * Actualiza un automovil que ya existe en la persistencia de automovil, y
     * verifica que se sigan cumpliendo las reglas de negocio
     *
     * @param automovilEntity entidad con la informacion para actualizar
     * @return la entidad del automovil actualizada
     * @throws BusinessLogicException si se incumple alguna regla de negocio
     */
    public AutomovilEntity updateAutomovil(AutomovilEntity automovilEntity) throws BusinessLogicException {

        if (automovilEntity == null) {
            throw new BusinessLogicException("El Automovil a actualizar  no debe ser null");
        }

        verificacionInfoConsistente(automovilEntity);
        
        return persistence.update(automovilEntity);
    }

    /**
     * Elimina un automovil de la persistencia
     *
     * @param id entidad que se quiere eliminar
     * @throws BusinessLogicException si la entidad no es valida
     */
    public void deleteAutomovil(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Intentando eliminar automovil con id: {0}", id);
        if (id == null) {
            throw new BusinessLogicException("el id no puede ser null");
        }

        AutomovilEntity automovilEntity = persistence.find(id);
        if (automovilEntity == null) {
            throw new BusinessLogicException("No existe un automovil con el id dada.");
        }
        persistence.delete(id);
    }

    /**
     * Busca un Automovil según su id.
     *
     * @param id del automovil que se busca.
     * @return el automovil buscado, null si no existe.
     * @throws BusinessLogicException si id == null o id no está en un formato
     * válido.
     */
    public AutomovilEntity findAutomovil(Long id) throws BusinessLogicException {
        if (id == null || id <= 0) {
            throw new BusinessLogicException("id no valido");
        }
        return persistence.find(id);
    }

    /**
     * Busca todos los automoviles con un color dado.
     *
     * @param color color que se busca.
     * @return todos los cutomoviles con el color dado.
     * @throws BusinessLogicException Si color == null .
     */
    public List<AutomovilEntity> findAutomovilByColor(String color) throws BusinessLogicException {
        if (color == null) {
            throw new BusinessLogicException("El color no puede ser null");
        }

        return persistence.findByColor(color);
    }

    /**
     * Busca un automovil con la placa dada.
     *
     * @param placa placa que se busca.
     * @return el automovil con la placa dado.
     * @throws BusinessLogicException Si placa == null
     */
    public AutomovilEntity findAutomovilByPlate(String placa) throws BusinessLogicException {
        if (placa == null) {
            throw new BusinessLogicException("la placa no puede ser null");
        }

        return persistence.findByPlate(placa);
    }

    /**
     * Busca un automovil con el chasis dada.
     *
     * @param chasis chasis que se busca.
     * @return el automovil con el chasis dado.
     * @throws BusinessLogicException Si chasis == null
     */
    public AutomovilEntity findAutomovilByChasis(Integer chasis) throws BusinessLogicException {
        if (chasis == null) {
            throw new BusinessLogicException("el chasis no puede ser null");
        }

        return persistence.findBychasis(chasis);
    }

    /**
     * Verifica que la placa contenga el formato valido - Tres letras iniciales,
     * tres números al final-
     *
     * @param pPlaca Placa a la que se le quiere verificar el formato
     * @return True si la placa es válida
     */
    public boolean verificarPlaca(String pPlaca) {

        Boolean rta = true;

        String[] placa = pPlaca.split("-");
        char[] chars = placa[0].toCharArray();
        char[] chars2 = placa[1].toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                rta = false;
            }
        }

        for (char c : chars2) {
            if (!Character.isDigit(c)) {
                rta = false;
            }
        }

        return rta;
    }

    /**
     * Retorna todos los automóviles de una marca dada.
     *
     * @param marca que se busca
     * @return todos los automoviles de la marca dada.
     * @throws BusinessLogicException si la marca es nula.
     */
    public List<AutomovilEntity> findByMarca(String marca) throws BusinessLogicException {
        if (marca == null) {
            throw new BusinessLogicException("La marca no puede ser nula");
        } else {
            return persistence.findByMarca(marca);
        }
    }

    /**
     * Retorna todos los automóviles de un modelo dado.
     *
     * @param modelo modelo que se busca
     * @return lista con todos los automóviles del modelo dado.
     * @throws BusinessLogicException si el modelo es null.
     */
    public List<AutomovilEntity> findByModelo(String modelo) throws BusinessLogicException {
        if (modelo == null) {
            throw new BusinessLogicException("El modelo no puede ser nulo");
        } else {
            return persistence.findByModelo(modelo);
        }
    }

    /**
     * Retorna todos los autmóviles en un rango dado.
     *
     * @param anioInicio año inicial del rango
     * @param anioFin año final del rango
     * @return listado de automóviles en el rango de años.
     * @throws BusinessLogicException si alguno de los años es null o si
     * anioFin<anioInicio
     */
    public List<AutomovilEntity> findByRangoAnios(Integer anioInicio, Integer anioFin) throws BusinessLogicException {
        if (anioInicio == null || anioFin == null) {
            throw new BusinessLogicException("Ninguno de los años puede ser null");
        } else if (anioFin < anioInicio) {
            throw new BusinessLogicException("El año final debe ser después del año inicial");
        } else {
            return persistence.findRangoAnios(anioInicio, anioFin);
        }
    }

    /**
     * Retorna todos los autmóviles en un rango dado.
     *
     * @param precioMin cota inferior del rango
     * @param precioMax cota superior del rango
     * @return listado de automóviles en el rango de precios.
     * @throws BusinessLogicException si alguno de los años es null o si
     * precioMax<anioMin
     */
    public List<AutomovilEntity> findByRangoPrecios(Integer precioMin, Integer precioMax) throws BusinessLogicException {
        if (precioMin == null || precioMax == null) {
            throw new BusinessLogicException("Ninguno de los años puede ser null");
        } else if (precioMax < precioMin) {
            throw new BusinessLogicException("El año final debe ser después del año inicial");
        } else {
            return persistence.findRangoPrecios(precioMin, precioMax);
        }
    }

    
    /**
     * Método auxiliar para reducir complejidad ciclomática. 
     * Verifica que las parejas de la búsqueda vengan o ambas null o ambas not null
     * @param kilometrajeMin cota inferior del rango de kilometraje
     * @param kilometrajeMax cota superior del rango de kilometraje.
     * @param precioMin cota inferior del rango de precios.
     * @param precioMax cota superior del rango de precios.
     * @param anioMin cota inferior del rango de años.
     * @param anioMax cota superior del rango de años.
     * @throws BusinessLogicException si en alguna de las parejas (x,y) uno de los valores (x==null) no es igual a (y==null)
     */
    private void verificarConsistenciaParejas(Integer kilometrajeMin, Integer kilometrajeMax, Integer precioMax, Integer precioMin, Integer anioMax, Integer anioMin) throws BusinessLogicException{
        
        if ((kilometrajeMin == null) != (kilometrajeMax == null)) {
            throw new BusinessLogicException("Para la pareja kilometrajeMin/kilometrajeMax ambos valores deben ser null o ambos deben no serlo.");
        }
        
        if ((precioMin == null )!= (precioMax == null)) {
            throw new BusinessLogicException("Para la pareja precioMin/precioMax ambos valores deben ser null o ambos deben no serlo.");
        }

        if ((anioMax == null) != (anioMin == null)) {
            throw new BusinessLogicException("Para la pareja anioMin/anioMax ambos valores deben ser null o ambos deben no serlo.");
        }
        
    }
    
    /**
     * Método auxiliar para reducir complejidad ciclomática 
     * @param kilometrajeMin cota inferior del rango de kilometraje
     * @param kilometrajeMax cota superior del rango de kilometraje.
     * @param precioMin cota inferior del rango de precios.
     * @param precioMax cota superior del rango de precios.
     * @param anioMin cota inferior del rango de años.
     * @param anioMax cota superior del rango de años.
     * @throws BusinessLogicException si la cota superior de alguno de los rangos es menor a la cota inferior del mismo. 
     */
    private void verificarConsistenciaRangos(Integer precioMax, Integer precioMin, Integer anioMax, Integer anioMin, Integer kilometrajeMin, Integer kilometrajeMax) throws BusinessLogicException{
    
        if (bothNotNull(precioMax, precioMin) && precioMax < precioMin) {
            throw new BusinessLogicException("El precio máximo debe ser mayor al precio mínimo");
        }
        if (bothNotNull(anioMax, anioMin) && anioMax < anioMin) {
            throw new BusinessLogicException("El año máximo debe ser mayor al año mínimo");
        }
        
        if(bothNotNull(kilometrajeMin, kilometrajeMax) && kilometrajeMax < kilometrajeMin){
            throw new BusinessLogicException("El kilometraje máximo debe ser mayor al kilometraje mínimo");
        }
    }
    
    /**
     * Búsqueda maestra que incluye todos los parámetros disponibles en mi
     * automóvil
     *
     * @param tipoAuto tipo del auto
     * @param precioMin cota inferior del rango de precios.
     * @param precioMax cota superior del rango de precios.
     * @param anioMin cota inferior del rango de años.
     * @param anioMax cota superior del rango de años.
     * @param marca marca buscadas
     * @param modelo modelo buscado
     * @param color color buscado
     * @param kilometrajeMin cota inferior del rango de kilometraje
     * @param kilometrajeMax cota superior del rango de kilometraje.
     * @return lista con todos los automóviles que cumplen los filtros.
     * @throws BusinessLogicException si precioMin<precioMax o anioMax<anioMin o
     * si todos los parámetros son null
     */
    public List<AutomovilEntity> masterSearch(String tipoAuto, Integer precioMin, Integer precioMax, Integer anioMin, Integer anioMax, String marca, String modelo, String color, Integer kilometrajeMin, Integer kilometrajeMax) throws BusinessLogicException {

        //Para que sonar no moleste con número de operadores lógicos.
        boolean left = precioMin == null && precioMax == null && anioMin == null;
        boolean right = anioMax == null && marca == null && modelo == null;
        
        if ( left && right && color == null) {
            throw new BusinessLogicException("Los parámetros de búsqueda no pueden estar todos vacíos");
        }
        
        verificarConsistenciaParejas(kilometrajeMin, kilometrajeMax, precioMax, precioMin, anioMax, anioMin);
        
        verificarConsistenciaRangos(precioMax, precioMin, anioMax, anioMin, kilometrajeMin, kilometrajeMax);
        
        return persistence.masterSearch(tipoAuto, precioMin, precioMax, anioMin, anioMax, marca, modelo, color, kilometrajeMin, kilometrajeMax);
    }

    /**
     * Método existente para evitar falsos positivos de sonar. Retorna si dos
     * Integer no son null
     *
     * @param a integer 1
     * @param b integer 2
     * @return integer 1 != null && integer 2 != null
     */
    private boolean bothNotNull(Integer a, Integer b) {
        return a != null && b != null;
    }

    /**
     * @return Retorna la lista de colores de los automoviles
     */
    public List<AutomovilEntity> listColores() {

        List<String> lista = persistence.listColores();
        List<AutomovilEntity> ret = new ArrayList<>();

        for (String s : lista) {
            AutomovilEntity e = new AutomovilEntity();
            e.setColor(s);
            ret.add(e);
        }

        return ret;
    }

}
