/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import co.edu.uniandes.csw.ivanysusbambam.ejb.QuejaReclamoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;

import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.QuejaReclamoPersistence;
import com.gs.collections.impl.list.fixed.ArrayAdapter;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author hd.castellanos
 */
@RunWith(Arquillian.class)
public class QuejaReclamoLogicTest {
   private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private QuejaReclamoLogic quejaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<QuejaReclamoEntity> data = new ArrayList<QuejaReclamoEntity>();

    private List<ClienteEntity> ClienteData = new ArrayList();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejaReclamoEntity.class.getPackage())
                .addPackage(QuejaReclamoLogic.class.getPackage())
                .addPackage(QuejaReclamoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * ConfiguraciÃ³n inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
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
     * Limpia las tablas que estÃ¡n implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from QuejaReclamoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            em.persist(cliente);
            ClienteData.add(cliente);
        }
        for (int i = 0; i < 3; i++) {
            QuejaReclamoEntity entity = factory.manufacturePojo(QuejaReclamoEntity.class);
            entity.setCliente(ClienteData.get(0));

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Book
     *
     *
     */
    @Test
    public void createQuejaReclamoTest() throws BusinessLogicException {
          QuejaReclamoEntity newEntity = factory.manufacturePojo(QuejaReclamoEntity.class);
          newEntity.setCliente(ClienteData.get(0));
           
          System.out.println("Cliente de la queja"+newEntity.getCliente());
        QuejaReclamoEntity result = quejaLogic.createQuejaReclamo(newEntity);
        Assert.assertNotNull(result);
        QuejaReclamoEntity entity = em.find(QuejaReclamoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        
     
    }

    /**
     * Prueba para consultar la lista de Books
     *
     *
     */
    @Test
    public void getQuejasReclamosTest() {
        List<QuejaReclamoEntity> list = quejaLogic.findAllQuejasReclamos();
        Assert.assertEquals(data.size(), list.size());
        for (QuejaReclamoEntity entity : list) {
            boolean found = false;
            for (QuejaReclamoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Book
     *
     *
     */
    @Test
    public void getQuejaReclamoTest() throws BusinessLogicException {
        QuejaReclamoEntity entity = data.get(0);
        QuejaReclamoEntity resultEntity = quejaLogic.findQuejaReclamo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        
    }

    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteQuejaReclamoTest() throws BusinessLogicException {
        QuejaReclamoEntity entity = data.get(0);
        quejaLogic.deleteQuejaReclamo(entity.getId());
        QuejaReclamoEntity deleted = em.find(QuejaReclamoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book
     *
     *
     */
    @Test
    public void updateQuejaReclamoTest() throws BusinessLogicException {
        QuejaReclamoEntity entity = data.get(0);
        QuejaReclamoEntity pojoEntity = factory.manufacturePojo(QuejaReclamoEntity.class);

        pojoEntity.setId(entity.getId());
        pojoEntity.setCliente(entity.getCliente());
        
        quejaLogic.updateQuejaReclamo( pojoEntity);

        QuejaReclamoEntity resp = em.find(QuejaReclamoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        
    }
  
}
