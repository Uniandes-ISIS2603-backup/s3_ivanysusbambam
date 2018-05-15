/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.ModelLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ModelPersistence;
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
 * @author Js.ortiz
 */
@RunWith(Arquillian.class)
public class ModelLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ModelLogic modelLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ModelEntity> data = new ArrayList<ModelEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ModelEntity.class.getPackage())
                .addPackage(ModelLogic.class.getPackage())
                .addPackage(ModelPersistence.class.getPackage())
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
        em.createQuery("delete from ModelEntity").executeUpdate();
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
            ModelEntity entity = factory.manufacturePojo(ModelEntity.class);
            em.persist(entity);
            data.add(entity);

        }

    }

    /**
     * Metodo para probar el hashCode de la marca
     */
    @Test
    public void HashCodeTest() {
        ModelEntity model = data.get(0);
        ModelEntity model1 = data.get(1);
        model1.setId(model.getId());
        Assert.assertEquals(model.hashCode(), model1.hashCode());
    }

    /**
     * Prueba para crear un Modelo
     *
     *
     */
    @Test
    public void createModelTest() {
        try {
            ModelEntity newEntity = factory.manufacturePojo(ModelEntity.class);
            newEntity.setAutomoviles(new ArrayList<>());
            ModelEntity result = modelLogic.createModel(newEntity);
            Assert.assertNotNull(result);
            ModelEntity entity = em.find(ModelEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getCentCubicos(), entity.getCentCubicos());
            Assert.assertEquals(newEntity.getCilindraje(), entity.getCilindraje());
            Assert.assertEquals(newEntity.getTransmision(), entity.getTransmision());
            Assert.assertEquals(newEntity.getNumeroPuertas(), entity.getNumeroPuertas());
            Assert.assertEquals(newEntity.getAutomoviles(), entity.getAutomoviles());

        } catch (BusinessLogicException ex) {
            Logger.getLogger(ModelLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prueba para consultar la lista de Modelos
     *
     *
     */
    @Test
    public void findModelsTest() {
        List<ModelEntity> list = modelLogic.findAllModels();
        Assert.assertEquals(data.size(), list.size());
        for (ModelEntity entity : list) {
            boolean found = false;
            for (ModelEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Modelo
     *
     *
     */
    @Test
    public void findModelTest() {
        try {
            ModelEntity entity = data.get(0);
            ModelEntity resultEntity;
            resultEntity = modelLogic.findModel(entity.getId());
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getId(), resultEntity.getId());
            Assert.assertEquals(entity.getCilindraje(), resultEntity.getCilindraje());
            Assert.assertEquals(entity.getNumeroPuertas(), resultEntity.getNumeroPuertas());
            Assert.assertEquals(entity.getTransmision(), resultEntity.getTransmision());
            Assert.assertEquals(entity.getCentCubicos(), resultEntity.getCentCubicos());
            // Assert.assertTrue(entity.getAutomoviles( )== resultEntity.getAutomoviles());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ModelLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prueba para eliminar un Modelo
     */
    @Test
    public void deleteModelTest() {
        try {
            ModelEntity entity = data.get(0);
            modelLogic.deleteModel(entity.getId());
            ModelEntity deleted = em.find(ModelEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ModelLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prueba para actualizar un Modelo
     *
     *
     */
    @Test
    public void updateModelTest() {
        try {
            ModelEntity entity = data.get(0);
            ModelEntity pojoEntity = factory.manufacturePojo(ModelEntity.class);

            pojoEntity.setId(entity.getId());
            pojoEntity.setAutomoviles(entity.getAutomoviles());

            modelLogic.updateModel(pojoEntity);

            ModelEntity resp = em.find(ModelEntity.class, entity.getId());

            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getTransmision(), resp.getTransmision());
            Assert.assertEquals(pojoEntity.getCentCubicos(), resp.getCentCubicos());
            Assert.assertEquals(pojoEntity.getCilindraje(), resp.getCilindraje());
            Assert.assertEquals(pojoEntity.getNumeroPuertas(), resp.getNumeroPuertas());
            // Assert.assertTrue(verificarLista(pojoEntity.getAutomoviles(), resp.getAutomoviles()));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ModelLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que verifica que dos listas tengan los mismos objetos
     *
     * @param luno Lista uno de la que se quieren verificar los objetos
     * @param ldos Lista dos de la que se quieren verificar los objetos
     * @return True si las dos listas contienen los mismos objetos
     */
    public boolean verificarLista(List luno, List ldos) {
        boolean ase = false;
        if (luno.size() == ldos.size()) {
            ase = true;
            //while (ase = true) {
            //  for (Integer i = 0; i < luno.size(); i++) {
            //    Object a = luno.get(i);
            //  Object b = ldos.get(i);
            // if(a!=b){
            //   ase = false;
            //}
            // }

            //}
        }
        return ase;
    }
}
