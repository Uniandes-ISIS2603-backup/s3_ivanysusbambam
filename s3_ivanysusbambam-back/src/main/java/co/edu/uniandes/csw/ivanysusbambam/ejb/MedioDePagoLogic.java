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

    private static final Logger LOG = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private MedioDePagoPersistence persistence;

    @Inject
    private ClientePersistence clientePersistence;

    public MedioDePagoEntity createMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException {
        if (clientePersistence.find(mdp.getCliente().getCedula()) == null) {
            throw new BusinessLogicException("El cliente del medio de pago no existe en la base de datos");
        }
        if (!mdp.validarTipoMedioDePago()) {
            throw new BusinessLogicException("El tipo del medio de pago no es valido");
        }
        persistence.create(mdp);
        return mdp;
    }

    public MedioDePagoEntity deleteMedioDePago(MedioDePagoEntity mdp) throws BusinessLogicException {
        if (persistence.find(mdp.getNumero()) == null) {
            throw new BusinessLogicException("No existe el medio de pago del cliente");
        }
        persistence.delete(mdp.getNumero());
        return mdp;
    }

    public MedioDePagoEntity find(Long numero) throws BusinessLogicException {
        if (numero == null) {
            throw new BusinessLogicException("El medio de pago no es valido");
        }
        MedioDePagoEntity mdp = persistence.find(numero);
        if (mdp == null) {
            throw new BusinessLogicException("No existe un medio de pago con ese numero");
        }
        return mdp;
    }

    public List<MedioDePagoEntity> findAll() throws BusinessLogicException {
        return persistence.findAll();
    }
    public MedioDePagoEntity updateCompra(MedioDePagoEntity mdp) throws BusinessLogicException
    {
        if(mdp==null)
        {
            throw new BusinessLogicException("No se pueden actualizar valores nulos");    
        }
        if(persistence.find(mdp.getNumero())==null)
        {
             throw new BusinessLogicException("El medio de pago no existe en la base de datos"); 
        }
        
        return persistence.update(mdp);
    }
}

