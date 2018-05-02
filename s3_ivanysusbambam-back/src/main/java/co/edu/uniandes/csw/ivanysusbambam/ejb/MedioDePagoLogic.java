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
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author juliana
 */
@Stateless
public class MedioDePagoLogic {

    
    @Inject
    private MedioDePagoPersistence persistence;

    @Inject
    private ClientePersistence clientePersistence;

    public MedioDePagoEntity createMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException {
        if(mdp.getCliente() == null) {
            throw new BusinessLogicException("Se intentó crear un medio de pago sin cliente");
        }
        if(persistence.find(mdp.getNumero()) != null) {
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

    public void deleteMedioDePago(Long numero) throws BusinessLogicException {
        if (persistence.find(numero) == null) {
            throw new BusinessLogicException("No existe el medio de pago del cliente");
        }
        persistence.delete(numero);
    }

    public MedioDePagoEntity findMedioDePago(Long numero) throws BusinessLogicException {
        if (numero == null) {
            throw new BusinessLogicException("El medio de pago no es valido");
        }
        MedioDePagoEntity mdp = persistence.find(numero);
        return mdp;
    }

    public List<MedioDePagoEntity> findAll() {
        return persistence.findAll();
    }
    public MedioDePagoEntity updateMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException
    {
        
        if(persistence.find(mdp.getNumero())==null)
        {
             throw new BusinessLogicException("El medio de pago no existe en la base de datos"); 
        }
        
        return persistence.update(mdp);
    }
}

