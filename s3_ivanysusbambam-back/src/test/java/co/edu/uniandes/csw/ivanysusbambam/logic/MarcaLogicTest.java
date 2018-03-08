/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.MarcaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MarcaPersistence;
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
 * @author js.ortiz
 */
@RunWith(Arquillian.class)
public class MarcaLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private MarcaLogic marcaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<MarcaEntity> data = new ArrayList<MarcaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MarcaEntity.class.getPackage())
                .addPackage(MarcaLogic.class.getPackage())
                .addPackage(MarcaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
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
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from MarcaEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            MarcaEntity entity = factory.manufacturePojo(MarcaEntity.class);
            em.persist(entity);
            data.add(entity);

        }

    }

    /**
     * Prueba para crear un Author
     *
     *
     */
    @Test
    public void createMarcaTest() throws BusinessLogicException {
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);
        MarcaEntity result = marcaLogic.createMarca(newEntity);
        
        Assert.assertNotNull(result);
        MarcaEntity entity = em.find(MarcaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getAutomoviles(), entity.getAutomoviles());
        Assert.assertEquals(newEntity.getModelos(), entity.getModelos());
    }

    /**
     * Prueba para consultar la lista de Authors
     *
     *
     */
    @Test
    public void getMarcasTest() {
        List<MarcaEntity> list = marcaLogic.findAllMarcas();
        Assert.assertEquals(data.size(), list.size());
        for (MarcaEntity entity : list) {
            boolean found = false;
            for (MarcaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una marca
     *
     *
     */
    @Test
    public void findMarcaTest() {
        try {
            MarcaEntity entity = data.get(0);
            
            MarcaEntity resultEntity;
            resultEntity = marcaLogic.findMarca(entity.getId());
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getId(), resultEntity.getId());
            Assert.assertEquals(entity.getName(), resultEntity.getName());
            Assert.assertEquals(entity.getAutomoviles(), resultEntity.getAutomoviles());
            Assert.assertEquals(entity.getModelos(), resultEntity.getModelos());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(MarcaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prueba para eliminar una marca
     *
     *
     */
    @Test
    public void deleteMarcaTest() {
        MarcaEntity entity = data.get(0);
        try {
            marcaLogic.deleteMarca(entity.getId());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(MarcaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        MarcaEntity deleted = em.find(MarcaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una marca
     *
     *
     */
    @Test
    public void updateMarcaTest() {
        try {
            MarcaEntity entity = data.get(0);
            MarcaEntity pojoEntity = factory.manufacturePojo(MarcaEntity.class);
            
            pojoEntity.setId(entity.getId());
            
            marcaLogic.updateMarca(pojoEntity);
            
            MarcaEntity resp = em.find(MarcaEntity.class, entity.getId());
            
            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getName(), resp.getName());
            Assert.assertEquals(pojoEntity.getModelos(), resp.getModelos());
             Assert.assertEquals(pojoEntity.getAutomoviles(), resp.getAutomoviles());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(MarcaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
