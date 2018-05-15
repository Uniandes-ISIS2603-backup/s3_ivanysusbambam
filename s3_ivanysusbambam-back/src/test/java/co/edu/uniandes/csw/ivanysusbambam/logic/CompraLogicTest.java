/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.CompraLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;

import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CompraPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CompraLogicTest {

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
                .addPackage(CompraEntity.class.getPackage())
                .addPackage(CompraLogic.class.getPackage())
                .addPackage(CompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Atributo para la logica de la compra
     */
    @Inject
    private CompraLogic compraLogic;

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Atributo para el user transaction
     */
    @Inject
    private UserTransaction utx;

    /**
     * Data del automovil
     */
    private AutomovilEntity automovil = factory.manufacturePojo(AutomovilEntity.class);
    /**
     * Data del vendedor
     */
    private VendedorEntity vendedor = factory.manufacturePojo(VendedorEntity.class);
    /**
     * data del punto de venta
     */
    private PuntoDeVentaEntity puntoDeVenta = factory.manufacturePojo(PuntoDeVentaEntity.class);
    /**
     * Data del cliente
     */
    private ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);

    /**
     * Metodo para configurar el escenario de pruebas
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
     * Metodo para eliminar la dara de las entidades
     */
    private void clearData() {
        em.createQuery("delete from CompraEntity").executeUpdate();
    }

    /**
     * Data de la compra
     */
    private List<CompraEntity> data = new ArrayList<>();

    /**
     * metodo para insertar la data de las pruebas
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");

            CompraEntity compra = factory.manufacturePojo(CompraEntity.class);

            em.persist(automovil);
            em.persist(vendedor);
            em.persist(puntoDeVenta);
            em.persist(cliente);
            compra.setAutomovil(automovil);
            compra.setCliente(cliente);
            compra.setPuntoDeVenta(puntoDeVenta);
            compra.setVendedorEncargado(vendedor);

            em.persist(compra);

            data.add(compra);

        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }

    @Test
    public void createCompraTest() {
        CompraEntity compra = factory.manufacturePojo(CompraEntity.class);

        compra.setAutomovil(automovil);
        compra.setCliente(cliente);
        compra.setPuntoDeVenta(puntoDeVenta);
        compra.setVendedorEncargado(vendedor);

        try {
            if (compra.getCliente() == null || compra.getAutomovil() == null || compra.getVendedorEncargado() == null || compra.getPuntoDeVenta() == null) {
                Assert.fail();
            }
            compraLogic.crearCompra(compra);

        } catch (BusinessLogicException excepcion) {
            Logger.getLogger(CompraLogicTest.class.getName()).log(Level.SEVERE, null, excepcion);
            Assert.fail();
        }

    }

    @Test
    public void deleteCompraTest() {
        CompraEntity borrar = data.get(0);
        try {
            if (borrar.getIdCompra() == null) {
                Assert.fail();
            }
            compraLogic.deleteCompra(borrar.getIdCompra());
            Assert.assertNull(em.find(CompraEntity.class, borrar.getIdCompra()));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CompraLogicTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }

    }

    @Test
    public void findAllTest() {
        List<CompraEntity> list = compraLogic.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CompraEntity entity : list) {
            boolean found = false;
            for (CompraEntity storedEntity : data) {
                if (entity.getIdCompra().equals(storedEntity.getIdCompra())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

    }

    @Test
    public void findByIdTest() {
        try {
            if (data.get(0) == null) {
                Assert.fail();
            }
            CompraEntity rpta = compraLogic.findCompra(data.get(0).getIdCompra());
            Assert.assertNotNull(rpta);
            Assert.assertEquals(data.get(0).getIdCompra(), rpta.getIdCompra());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CompraLogicTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }

    @Test
    public void updateTest() {
        try {
            CompraEntity rpta = compraLogic.findCompra(data.get(0).getIdCompra());
            CompraEntity pojoEntity = factory.manufacturePojo(CompraEntity.class);

            pojoEntity.setIdCompra(rpta.getIdCompra());

            if (pojoEntity == null || pojoEntity.getIdCompra() == null) {
                Assert.fail();
            }
            compraLogic.updateCompra(pojoEntity);

            CompraEntity nuevo = compraLogic.findCompra(pojoEntity.getIdCompra());
            Assert.assertEquals(pojoEntity.getIdCompra(), nuevo.getIdCompra());
            Assert.assertEquals(pojoEntity.getAutomovil(), nuevo.getAutomovil());
            Assert.assertEquals(pojoEntity.getCliente(), nuevo.getCliente());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CompraLogicTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }
}
