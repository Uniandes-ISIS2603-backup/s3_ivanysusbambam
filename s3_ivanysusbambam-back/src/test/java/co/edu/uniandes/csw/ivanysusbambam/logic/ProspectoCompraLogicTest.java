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

    private List<VendedorEntity> vData = new ArrayList<>();

    private List<ClienteEntity> cData = new ArrayList<>();

    private List<AutomovilEntity> aData = new ArrayList<>();

    private void insertData() {

        for (int i = 0; i < 3; i++) {

            ProspectoCompraEntity entity = factory.manufacturePojo(ProspectoCompraEntity.class);

            ClienteEntity ce = factory.manufacturePojo(ClienteEntity.class);
            VendedorEntity ve = factory.manufacturePojo(VendedorEntity.class);
            AutomovilEntity ae = factory.manufacturePojo(AutomovilEntity.class);

            em.persist(ce);
            em.persist(ve);
            em.persist(ae);

            entity.setAutomovil(ae);
            entity.setCliente(ce);
            entity.setVendedor(ve);

            em.persist(entity);

            data.add(entity);
            vData.add(ve);
            cData.add(ce);
            aData.add(ae);
        }

    }

    @Test
    public void createProspectoCompraTest() {
        ProspectoCompraEntity newEntity = factory.manufacturePojo(ProspectoCompraEntity.class);
        newEntity.setAutomovil(aData.get(0));
        newEntity.setCliente(cData.get(1));
        newEntity.setVendedor(vData.get(2));
        
        try {
            ProspectoCompraEntity result = prospectoCompraLogic.createProspectoCompra(newEntity);

            Assert.assertNotNull(result);
            ProspectoCompraEntity entity = em.find(ProspectoCompraEntity.class, result.getId());
            Assert.assertEquals(newEntity.getTexto(), entity.getTexto());
            Assert.assertEquals(newEntity.getId(), entity.getId());
        } catch (BusinessLogicException e) {
            Assert.fail();
        }

    }

    @Test
    public void deleteProspectoCompraTest() {
        ProspectoCompraEntity entity = data.get(0);

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
        pojoEntity.setVendedor(entity.getVendedor());
        pojoEntity.setCliente(entity.getCliente());
        pojoEntity.setAutomovil(entity.getAutomovil());
        
        try {
            prospectoCompraLogic.updateProspectoCompra(pojoEntity);

            ProspectoCompraEntity resp = em.find(ProspectoCompraEntity.class, entity.getId());
            Assert.assertEquals(pojoEntity.getTexto(), resp.getTexto());
            Assert.assertEquals(pojoEntity.getId(), resp.getId());
        } catch (BusinessLogicException e) {
            Assert.fail();
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
    public void findProspectoDeCompraByVendedor() {
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
    public void findProspectoDeCompraByAutomovil() {
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
