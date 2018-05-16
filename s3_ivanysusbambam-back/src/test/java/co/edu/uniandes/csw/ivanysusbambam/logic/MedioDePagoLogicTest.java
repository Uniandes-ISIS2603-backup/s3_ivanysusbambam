/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;

import co.edu.uniandes.csw.ivanysusbambam.persistence.MedioDePagoPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author juliana
 */
@RunWith(Arquillian.class)
public class MedioDePagoLogicTest {

    /**
     * Atributo para el podam factory
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoLogic.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Atributo para la logica de medio de pago
     */
    @Inject
    private MedioDePagoLogic mdpl;
    /**
     * Atributo para el entityManager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Atributo para el userTransaction
     */
    @Inject
    private UserTransaction utx;

    /**
     * Atributo para la entidad de cliente
     */
    private ClienteEntity cliente;

    /**
     * Configura el escenario de prueba
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Metodo para clear data
     */
    private void clearData() {
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();
    }

    /**
     * Data del medio de pago
     */
    private List<MedioDePagoEntity> data = new ArrayList<>();

    /**
     * Metodo para insertar data
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");
            MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);

            try {

                entity.setNumero((long) i + 1);
                cliente = factory.manufacturePojo(ClienteEntity.class);
                em.persist(cliente);
                entity.setCliente(cliente);
                mdpl.createMedioDePago(entity);

                data.add(entity);

                System.out.println("DATA INSERTED");
            } catch (Exception e) {
                i--;
                System.out.println(i);
            }
        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }

    /**
     * Metodo para probar el metodo create de medio de pago
     */
    @Test
    public void createMedioDePagoTest() {
        MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);
        boolean ex = false;
        try {
            entity.setCliente(cliente);
            MedioDePagoEntity result = mdpl.createMedioDePago(entity);
            Assert.assertNotNull(result);

        } catch (BusinessLogicException exepcion) {
            ex = true;
        }
        if (!entity.validarTipoMedioDePago() || entity.getCliente() == null || em.find(ClienteEntity.class, cliente.getCedula()) == null || em.find(MedioDePagoEntity.class, entity.getNumero()) != null) {
            Assert.assertFalse(ex);
        }
        if (entity.getCliente() != null && em.find(ClienteEntity.class, cliente.getCedula()) != null && entity.validarTipoMedioDePago() && em.find(MedioDePagoEntity.class, entity.getNumero()) == null) {
            Assert.assertFalse(ex);
        }

    }

    /**
     * Metodo para probar el Get de medios de pago
     */
    @Test
    public void getMedioDePagoTest() {
        MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);

        boolean ex = false;
        try {
            entity.setCliente(cliente);
            mdpl.createMedioDePago(entity);
            MedioDePagoEntity result = mdpl.findMedioDePago(entity.getNumero());
            Assert.assertNotNull(result);

        } catch (BusinessLogicException excep) {
            ex = true;
        }
        if (entity.getNumero() == null) {
            Assert.assertTrue(ex);
        } else {
            Assert.assertFalse(ex);
        }

    }

    /**
     * Metodo para probar el delete de medio de pago
     */
    @Test
    public void deleteMedioDePagoTest() {
        MedioDePagoEntity entity = data.get(0);

        try {
            mdpl.deleteMedioDePago(entity.getNumero());
            MedioDePagoEntity deleted = em.find(MedioDePagoEntity.class, entity.getNumero());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    /**
     * Metodo para probar el getAll de medios de pagos
     */
    @Test
    public void getMediosDePagoTest() {
        List<MedioDePagoEntity> list = mdpl.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MedioDePagoEntity entity : list) {
            boolean found = false;
            for (MedioDePagoEntity storedEntity : data) {
                if (entity.getNumero().equals(storedEntity.getNumero())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * metodo para probar el actualizar de medio de pago
     */
    @Test
    public void updateMedioDePagoTest() {
        MedioDePagoEntity entity = data.get(0);
        MedioDePagoEntity pojoEntity = factory.manufacturePojo(MedioDePagoEntity.class);

        pojoEntity.setNumero(entity.getNumero());

        try {
            mdpl.updateMedioDePago(pojoEntity);

            MedioDePagoEntity resp = em.find(MedioDePagoEntity.class, entity.getNumero());
            Assert.assertEquals(pojoEntity.getNumero(), resp.getNumero());
            Assert.assertEquals(pojoEntity.getTipo(), resp.getTipo());
        } catch (BusinessLogicException ex) {
            Assert.fail();
        }

    }

    /**
     * Prueba para comprara un medio de pago
     */
    @Test
    public void compararMedioDePago() {

        MedioDePagoEntity entity = data.get(0);
        MedioDePagoEntity entity1 = data.get(0);

        boolean resp = entity.compararMedioDePago(entity1);
        if (entity1 == null) {
            Assert.assertFalse(resp);
        } else {
            Assert.assertTrue(resp);
        }
    }

    /**
     * Prueba para validar el tipo de pago
     */
    @Test
    public void ValidarTipoMedioDePagoTest() {
        MedioDePagoEntity entity = data.get(0);
        entity.setTipo(MedioDePagoEntity.TipoMedioDePago.CREDITO);

        boolean respuesta = entity.validarTipoMedioDePago();
        Assert.assertTrue(respuesta);

    }

}
