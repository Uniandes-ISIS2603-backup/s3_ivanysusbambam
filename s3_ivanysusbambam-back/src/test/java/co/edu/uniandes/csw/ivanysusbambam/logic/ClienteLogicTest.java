/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.ClienteLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
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
public class ClienteLogicTest {

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
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private ClienteLogic clienteLogic;

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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    private List<ClienteEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            em.persist(entity);

            data.add(entity);

        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }

    @Test
    public void createClienteTest() {
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);

        try {
            ClienteEntity result = clienteLogic.createCliente(newEntity);

            Assert.assertNotNull(result);
            ClienteEntity entity = em.find(ClienteEntity.class, result.getCedula());
            Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
            Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    @Test
    public void deleteClienteTest() {
        ClienteEntity entity = data.get(0);

        try {
            clienteLogic.deleteCliente(entity.getCedula());
            ClienteEntity deleted = em.find(ClienteEntity.class, entity.getCedula());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    @Test
    public void findAllClientesTest() {
        List<ClienteEntity> list = clienteLogic.findAllClientes();
        Assert.assertEquals(data.size(), list.size());
        for (ClienteEntity entity : list) {
            boolean found = false;
            for (ClienteEntity storedEntity : data) {
                if (entity.getCedula().equals(storedEntity.getCedula())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void findClienteTest() {
        ClienteEntity entity = data.get(0);
        try {
            ClienteEntity resultEntity = clienteLogic.findCliente(entity.getCedula());

            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
            Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }

    @Test
    public void findClienteByNameTest() {

        ClienteEntity ve;
        try {
            boolean found = false;
            List<ClienteEntity> name;
            for (int i = 0; i < data.size(); i++) {
                ve = data.get(i);
                name = clienteLogic.findClienteByName(ve.getNombre());
                for (ClienteEntity vee : name) {
                    if (vee.getCedula().equals(ve.getCedula())) {
                        found = true;
                        break;
                    }
                }
                Assert.assertTrue(found);
                found = false;
            }
        } catch (Exception e) {
            e.printStackTrace();

            Assert.fail();
        }
    }

    @Test
    public void updateClienteTest() {
        System.out.println("DATASIZE: " + data.size());
        ClienteEntity entity = data.get(0);
        ClienteEntity pojoEntity = factory.manufacturePojo(ClienteEntity.class);
        
        pojoEntity.setCedula(entity.getCedula());

        try {
            clienteLogic.updateCliente(pojoEntity);

            ClienteEntity resp = em.find(ClienteEntity.class, entity.getCedula());
            Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
            Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        } catch (BusinessLogicException e) {
            Assert.fail();
        }
    }
}
