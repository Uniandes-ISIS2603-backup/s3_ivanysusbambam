/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.ejb;

import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author f.velasquez
 */
@Stateless
public class ClienteLogic {

    /**
     * Constantre para el logger
     */
    private static final Logger LOG = Logger.getLogger(ClienteLogic.class.getName());

    /**
     * Atributo para la persistencia del cliente
     */
    @Inject
    private ClientePersistence persistence;

    /**
     * Persiste un cliente en la base de datos.
     *
     * @param ce el cliente entity que se busca persistir
     * @return el cliente que se persistió
     * @throws BusinessLogicException Si la cédula del cliente no está en un
     * formáto válido, ya hay un cliente registrado con esa cédula o si el
     * nombre no es una cadena alfabética.
     */
    public ClienteEntity createCliente(ClienteEntity ce) throws BusinessLogicException {
        LOG.log(Level.INFO, "Revisando si el cliente: {0} cumple los requisitos para ser añadido a la base de datos", ce.getCedula());
        VendedorLogic.cedulaValida(ce.getCedula());
        if (persistence.find(ce.getCedula()) != null) {
            throw new BusinessLogicException("Ya existe un cliente con la cédula dada");
        }
        if (ce.getNombre() == null) {
            throw new BusinessLogicException("El nombre no puede ser null");
        }
        if (!VendedorLogic.esAlfabetica(ce.getNombre())) {
            throw new BusinessLogicException("Sólo se aceptan nombres alfabéticos");
        }

        return persistence.create(ce);
    }

    /**
     * Consulta todos los clientes registrados en la base de datos.
     *
     * @return una lista con todos los clientes registrados en la base de datos,
     * null si no hay ninguno.
     */
    public List<ClienteEntity> findAllClientes() {
        LOG.info("consultando todos los clientes");
        return persistence.findAll();
    }

    /**
     * Actualiza un cliente pasado por parámetro.
     *
     * @param ce el cliente con la información actualizada.
     * @return el cliente que se acaba de actualizar.
     * @throws BusinessLogicException si el cliente que se buscaba actualizar no
     * existe o si el nombre del cliente actualizado es invalido.
     */
    public ClienteEntity updateCliente(ClienteEntity ce) throws BusinessLogicException {
        if (ce == null) {
            throw new BusinessLogicException("El cliente a ser actualizado no puede ser null");
        }

        LOG.log(Level.INFO, "Actualizando cliente con cédula: {0}", ce.getCedula());

        ClienteEntity ceo = persistence.find(ce.getCedula());
        if (ceo == null) {
            throw new BusinessLogicException("No se puede actualizar un cliente inexistente");
        }
        if (ce.getNombre() == null || !VendedorLogic.esAlfabetica(ce.getNombre())) {
            throw new BusinessLogicException("Nombre inválido");
        }
        return persistence.update(ce);
    }

    /**
     * Elimina el cliente correspondiente a la cédula dada por parámetro.
     *
     * @param id cedula del cliente que se quiere eliminar.
     * @return el cliente que se acaba de eliminar de la base de datos.
     * @throws BusinessLogicException si el cliente que se busca eliminar no
     * existe o si el id dado por parámetro == null.
     */
    public ClienteEntity deleteCliente(Long id) throws BusinessLogicException {
        LOG.log(Level.INFO, "Intentando aeliminar cliente con cédula: {0}", id);
        if (id == null) {
            throw new BusinessLogicException("La cédula no puede ser null");
        }
        ClienteEntity ce = persistence.find(id);
        if (ce == null) {
            throw new BusinessLogicException("No existe un cliente con la cédula dada.");
        }
        return persistence.delete(id);
    }

    /**
     * Busca un cliente según su cédula.
     *
     * @param id cedula del cliente que se busca.
     * @return el cliente buscado, null si no existe.
     * @throws BusinessLogicException si id == null o id no está en un formato
     * válido.
     */
    public ClienteEntity findCliente(Long id) throws BusinessLogicException {
        VendedorLogic.cedulaValida(id);
        return persistence.find(id);
    }

    /**
     * Busca todos los clientes con un nombre dado.
     *
     * @param name nombre que se busca.
     * @return todos los clientes con el nombre dado.
     * @throws BusinessLogicException Si name == null o si name no s alfabética.
     */
    public List<ClienteEntity> findClienteByName(String name) throws BusinessLogicException {
        if (name == null) {
            throw new BusinessLogicException("El nombre no puede ser null");
        }
        if (!VendedorLogic.esAlfabetica(name)) {
            throw new BusinessLogicException("El nombre debe ser alfabético");
        }
        return persistence.findByName(name);
    }

}
