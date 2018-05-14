/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MedioDePagoPersistence;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juliana
 */
@Stateless
public class MedioDePagoLogic {

    /**
     * atributo para la persistencia del medio de pago 
     */
    @Inject
    private MedioDePagoPersistence persistence;

    /**
     * Atributo para la persistencia del cliente
     */
    @Inject
    private ClientePersistence clientePersistence;

    /**
     * Crea un nuevo medio de pago
     * @param mdp entidad con lainformacion del medio de pago a crear
     * @return le entidad persistida
     * @throws BusinessLogicException si no se cumplen las reglas de negocio  
     */
    public MedioDePagoEntity createMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException {
        if (mdp.getCliente() == null) {
            throw new BusinessLogicException("Se intentó crear un medio de pago sin cliente");
        }
        if (persistence.find(mdp.getNumero()) != null) {
            throw new BusinessLogicException("Ya existe un medio de pago con dicho número");
        }
        if (clientePersistence.find(mdp.getCliente().getCedula()) == null) {
            throw new BusinessLogicException("El cliente del medio de pago no existe en la base de datos");
        }
        if (!mdp.validarTipoMedioDePago()) {
            throw new BusinessLogicException("El tipo del medio de pago no es valido");
        }
        return persistence.create(mdp);
    }

    /**
     * Elimina el medio de pago con el id dado por paremetro
     *
     * @param numero id del medio de pago a eliminar
     * @throws BusinessLogicException si el medio de pago no esta en la base de
     * datos
     */
    public void deleteMedioDePago(Long numero) throws BusinessLogicException {
        if (persistence.find(numero) == null) {
            throw new BusinessLogicException("No existe el medio de pago del cliente");
        }
        persistence.delete(numero);
    }

    /**
     * Busca un medio de pago en la base de datos con el id dado por parametro
     *
     * @param numero id del medio de pago a buscar
     * @return el medio de pago con el id dado por parametro
     * @throws BusinessLogicException SI no existe el existe
     */
    public MedioDePagoEntity findMedioDePago(Long numero) throws BusinessLogicException {
        if (numero == null) {
            throw new BusinessLogicException("El medio de pago no es valido");
        }
        return persistence.find(numero);

    }

    /**
     * @return todos los medios de pago en la base de datos
     */
    public List<MedioDePagoEntity> findAll() {
        return persistence.findAll();
    }

    /**
     * Actualiza la informacion de un medio de pago
     *
     * @param mdp entidad con la neva informacion del medio de pago
     * @return el medio de pago con la informacion actualizada
     * @throws BusinessLogicException si el medio de pago no existe o si no
     * cumple las reglas de negocio
     */
    public MedioDePagoEntity updateMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException {

        if (persistence.find(mdp.getNumero()) == null) {
            throw new BusinessLogicException("El medio de pago no existe en la base de datos");
        }

        return persistence.update(mdp);
    }
}
