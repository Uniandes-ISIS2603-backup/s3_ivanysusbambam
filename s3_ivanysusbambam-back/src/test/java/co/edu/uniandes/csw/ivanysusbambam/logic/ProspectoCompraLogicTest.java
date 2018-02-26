/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.ProspectoCompraLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ProspectoCompraPersistence;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
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
 * @author f.velasquez
 */
@RunWith(Arquillian.class)
public class ProspectoCompraLogicTest {

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
                .addPackage(ProspectoCompraEntity.class.getPackage())
                .addPackage(ProspectoCompraLogic.class.getPackage())
                .addPackage(ProspectoCompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private ProspectoCompraLogic prospectoCompraLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

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

    private void clearData() {
        em.createQuery("delete from ProspectoCompraEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();
        em.createQuery("delete from VendedorEntity").executeUpdate();
    }

    private List<ProspectoCompraEntity> data = new ArrayList<>();

    private void insertData() {
        ClienteEntity ce = factory.manufacturePojo(ClienteEntity.class);
        ce.setCedula((long) 1);
        ce.setNombre("a");
        VendedorEntity ve = factory.manufacturePojo(VendedorEntity.class);
        ve.setCedula((long) 2);
        ve.setNombre("b");

        AutomovilEntity ae = factory.manufacturePojo(AutomovilEntity.class);
        em.persist(ce);
        em.persist(ve);
        em.persist(ae);
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");
            ProspectoCompraEntity entity = factory.manufacturePojo(ProspectoCompraEntity.class);

            entity.setAutomovil(ae);
            entity.setCliente(ce);
            entity.setVendedor(ve);
            try {
                System.out.println("TENGO SUEÑO: " + entity.getCliente());

                prospectoCompraLogic.createProspectoCompra(entity);

                data.add(entity);
                System.out.println("DATA INSERTED");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }

    @Test
    public void createProspectoCompraTest() {
        ProspectoCompraEntity newEntity = factory.manufacturePojo(ProspectoCompraEntity.class);

        boolean ex = false;
        try {
            ProspectoCompraEntity result = prospectoCompraLogic.createProspectoCompra(newEntity);

            Assert.assertNotNull(result);
            ProspectoCompraEntity entity = em.find(ProspectoCompraEntity.class, result.getId());
            Assert.assertEquals(newEntity.getTexto(), entity.getTexto());
            Assert.assertEquals(newEntity.getId(), entity.getId());
        } catch (BusinessLogicException e) {
            ex = true;
        }

        if ((newEntity.getAutomovil() != null) && (newEntity.getCliente() != null) && (newEntity.getVendedor() != null)) {
            Assert.assertFalse(ex);
        } else {
            Assert.assertTrue(ex);
        }

    }

    @Test
    public void deleteProspectoCompraTest() {
        ProspectoCompraEntity entity = data.get(0);

        boolean ex = false;
        try {
            prospectoCompraLogic.deleteProspectoCompra(entity.getId());
            ProspectoCompraEntity deleted = em.find(ProspectoCompraEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    @Test
    public void findAllProspectosCompraTest() {
        List<ProspectoCompraEntity> list = prospectoCompraLogic.findAllProspectosCompra();
        Assert.assertEquals(data.size(), list.size());
        for (ProspectoCompraEntity entity : list) {
            boolean found = false;
            for (ProspectoCompraEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void findProspectoCompraTest() {
        ProspectoCompraEntity entity = data.get(0);
        boolean ex = false;
        try {
            ProspectoCompraEntity resultEntity = prospectoCompraLogic.findProspectoCompra(entity.getId());

            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getTexto(), resultEntity.getTexto());
            Assert.assertEquals(entity.getId(), resultEntity.getId());
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    @Test
    public void updateProspectoCompraTest() {
        System.out.println("DATASIZE: " + data.size());
        ProspectoCompraEntity entity = data.get(0);
        ProspectoCompraEntity pojoEntity = factory.manufacturePojo(ProspectoCompraEntity.class);

        pojoEntity.setId(entity.getId());

        boolean ex = false;
        try {
            prospectoCompraLogic.updateProspectoCompra(pojoEntity);

            ProspectoCompraEntity resp = em.find(ProspectoCompraEntity.class, entity.getId());
            Assert.assertEquals(pojoEntity.getTexto(), resp.getTexto());
            Assert.assertEquals(pojoEntity.getId(), resp.getId());
        } catch (BusinessLogicException e) {
            ex = true;

        }
        if ((pojoEntity.getAutomovil() != null) && (pojoEntity.getCliente() != null) && (pojoEntity.getVendedor() != null)) {
            Assert.assertFalse(ex);
        } else {
            Assert.assertTrue(ex);
        }
    }

    @Test
    public void findProspectoCompraByCliente() {

        ProspectoCompraEntity pe = data.get(0);
        try {
            List<ProspectoCompraEntity> peo = prospectoCompraLogic.findProspectoCompraByCliente(pe.getCliente());

            boolean found = false;
            for (ProspectoCompraEntity pp : peo) {

                if (pp.getId().equals(pe.getId())
                        && pp.getTexto().equals(pe.getTexto())
                        && pp.getVendedor().equals(pe.getVendedor())
                        && pp.getAutomovil().equals(pe.getAutomovil())) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }
    
    @Test
    public void findProspectoDeCompraByVendedor(){
        ProspectoCompraEntity pe = data.get(0);
        try {
            List<ProspectoCompraEntity> peo = prospectoCompraLogic.findProspectoCompraByVendedor(pe.getVendedor());

            boolean found = false;
            for (ProspectoCompraEntity pp : peo) {

                if (pp.getId().equals(pe.getId())
                        && pp.getTexto().equals(pe.getTexto())
                        && pp.getCliente().equals(pe.getCliente())
                        && pp.getAutomovil().equals(pe.getAutomovil())) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }
    
    @Test
    public void findProspectoDeCompraByAutomovil(){
        ProspectoCompraEntity pe = data.get(0);
        try {
            List<ProspectoCompraEntity> peo = prospectoCompraLogic.findProspectoCompraByAutomovil(pe.getAutomovil());

            boolean found = false;
            for (ProspectoCompraEntity pp : peo) {

                if (pp.getId().equals(pe.getId())
                        && pp.getTexto().equals(pe.getTexto())
                        && pp.getCliente().equals(pe.getCliente())
                        && pp.getVendedor().equals(pe.getVendedor())) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

}
