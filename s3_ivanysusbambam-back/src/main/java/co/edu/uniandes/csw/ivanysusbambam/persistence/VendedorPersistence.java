/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felipe Velásquez Montoya  <pre>
 *  Versiones:
 *      19/02/2018
 *          -Creación de la clase y métodos de busqueda, creación, actualización y eliminación´básicos.
 * </pre>
 */
@Stateless
public class VendedorPersistence {

    /**
     * COnstante para el logger
     */
    private static final Logger LOGGER = Logger.getLogger(VendedorPersistence.class.getName());

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext(unitName = "IvanysusbambamPU")
    protected EntityManager em;

    /**
     * Persiste un VendedorEntity
     *
     * @param ve el VendedorEntity a persistir
     * @return el VendedorEntity que se persistió.
     */
    public VendedorEntity create(VendedorEntity ve) {
        LOGGER.info("Creando nuevo vendedor");
        em.persist(ve);
        LOGGER.info("Creado nuevo vendedor");
        return ve;
    }

    /**
     * Elimina el VendedorEntity pasado por parámetro.
     *
     * @param id id del vendedor que se eliminará.
     * @return VendedorEntity recién eliminado.
     */
    public VendedorEntity delete(Long id) {
        LOGGER.log(Level.INFO, "eliminando al vendedor con carnet: {0}", id);
        VendedorEntity ve = find(id);
        em.remove(ve);
        return ve;
    }

    public List<VendedorEntity> findAll() {
        LOGGER.info("Recuperando todos los vendedores");
        TypedQuery tp = em.createQuery("select v from VendedorEntity v", VendedorEntity.class);
        return tp.getResultList();
    }

    /**
     * Encuentra un VendedorEntity según el carnet del vendedor.
     *
     * @param id id el carnet del vendedor.
     * @return el VendedorEntity correspondiente a ese id o null si no existe.
     */
    public VendedorEntity find(Long id) {
        LOGGER.log(Level.INFO, "buscando id: {0}", id);
        return em.find(VendedorEntity.class, id);
    }

    /**
     * Encuentra un VendedorEntity según la cédula del vendedor.
     *
     * @param cedula cédula del vendedor.
     * @return una lista con vendedor correspondiente a esa cédula o null si no
     * existe.
     */
    public List<VendedorEntity> findByCedula(Long cedula) {
        LOGGER.log(Level.INFO, "buscando vendedor con cedula: ", cedula);
        TypedQuery tq = em.createQuery("select v from VendedorEntity v where v.cedula = :cedula", VendedorEntity.class);
        tq.setParameter("cedula", cedula);
        if (tq.getResultList().isEmpty()) {
            return new ArrayList<>();
        } else {
            return tq.getResultList();
        }
    }

    /**
     * Encuentra los VendedorEntity correspondientes a un nombre dado.
     *
     * @param name nombre que se busca.
     * @return los VendedorEntity con ese nombre.
     */
    public List<VendedorEntity> findByName(String name) {
        LOGGER.log(Level.INFO, "buscando vendedores con nombre: ", name);
        TypedQuery tq = em.createQuery("select v from VendedorEntity v where v.nombre = :nombre", VendedorEntity.class);
        tq.setParameter("nombre", name);
        return tq.getResultList();
    }

    /**
     * Actualiza un VendedorEntity dado.
     *
     * @param ce VendedorEntity con la información actualizada.
     * @return VendedorEntity actualizado.
     */
    public VendedorEntity update(VendedorEntity ce) {
        LOGGER.log(Level.INFO, "Actualizando vendedor con cédula: ", ce.getCarnetVendedor());
        return em.merge(ce);
    }
}
