/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.CalificacionCarroLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionCarroPersistence;
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
 * @author if.garcia
 */
@RunWith(Arquillian.class)
public class CalificacionCarroLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionCarroEntity.class.getPackage())
                .addPackage(CalificacionCarroLogic.class.getPackage())
                .addPackage(CalificacionCarroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CalificacionCarroLogic ccarroLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction utx;
    
    
    private List<CalificacionCarroEntity> data = new ArrayList<>();

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
        em.createQuery("delete from CalificacionCarroEntity").executeUpdate();
    }
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");
            CalificacionCarroEntity entity = factory.manufacturePojo(CalificacionCarroEntity.class);

            em.persist(entity);

            data.add(entity);

        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }
    
    /**
     * Prueba para crear una CalificacionCarro
     *
     *
     */
    @Test
    public void createCalificacionCarroTest() {
        CalificacionCarroEntity newEntity = factory.manufacturePojo(CalificacionCarroEntity.class);
        CalificacionCarroEntity result = ccarroLogic.createCalificacionCarro(newEntity);
        Assert.assertNotNull(result);
        CalificacionCarroEntity entity = em.find(CalificacionCarroEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPuntaje(), entity.getPuntaje());
    }
    
    /**
     * Prueba para consultar la lista de CalificacionCarro
     *
     *
     */
    @Test
    public void getCalificacionesCarroTest() {
        List<CalificacionCarroEntity> list = ccarroLogic.getCalificacionesCarro();
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionCarroEntity entity : list) {
            boolean found = false;
            for (CalificacionCarroEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
    /**
     * Prueba para consultar una CalificacionCarro
     *
     *
     */
    @Test
    public void getCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        CalificacionCarroEntity resultEntity = ccarroLogic.getCalificacionCarro(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getPuntaje(), resultEntity.getPuntaje());
    }
    
    /**
     * Prueba para eliminar una CalificacionCarro
     *
     *
     */
    @Test
    public void deleteCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        ccarroLogic.deleteCalificacionTienda(entity.getId());
        CalificacionCarroEntity deleted = em.find(CalificacionCarroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un CalificacionCarro
     *
     *
     */
    @Test
    public void updateCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        CalificacionCarroEntity pojoEntity = factory.manufacturePojo(CalificacionCarroEntity.class);

        pojoEntity.setId(entity.getId());

        ccarroLogic.updateCalificacionCarro(pojoEntity);

        CalificacionCarroEntity resp = em.find(CalificacionCarroEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getPuntaje(), resp.getPuntaje());
    }
}
