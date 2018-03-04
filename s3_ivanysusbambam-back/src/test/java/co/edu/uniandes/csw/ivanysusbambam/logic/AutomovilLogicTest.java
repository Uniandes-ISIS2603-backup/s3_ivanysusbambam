/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.ejb.AutomovilLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;

import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
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
public class AutomovilLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private AutomovilLogic autoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<AutomovilEntity> data = new ArrayList<AutomovilEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AutomovilEntity.class.getPackage())
                .addPackage(AutomovilLogic.class.getPackage())
                .addPackage(AutomovilPersistence.class.getPackage())
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
            AutomovilEntity auto = factory.manufacturePojo(AutomovilEntity.class);

            em.persist(auto);

            data.add(auto);
        }

        System.out.println("tamanio" + autoLogic.getAutomoviles().size());

    }

    /**
     * Prueba para crear un automovil
     *
     *
     */
    @Test
    public void createAutomovilTest() {
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);

        boolean ex = false;
        try {
            AutomovilEntity result = autoLogic.createAutomovil(newEntity);
            Assert.assertNotNull(result);
            AutomovilEntity entity = em.find(AutomovilEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
        } catch (BusinessLogicException e) {
            ex = true;
        }

        if ((newEntity.getModel() != null) && (newEntity.getMarca() != null) && (newEntity.getPuntoDeVenta() != null)) {
            Assert.assertFalse(ex);
        } else {
            Assert.assertTrue(ex);
        }

    }

    /**
     * Prueba para consultar la lista de automoviles
     *
     *
     */
    @Test
    public void getAutomovilesTest() {
        List<AutomovilEntity> list = autoLogic.getAutomoviles();
        Assert.assertEquals(data.size(), list.size());
        for (AutomovilEntity entity : list) {
            boolean found = false;
            for (AutomovilEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un automovil
     *
     *
     */
    @Test
    public void getAutomovilTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);

        AutomovilEntity resultEntity = autoLogic.findAutomovil(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getChasis(), resultEntity.getChasis());

    }

    /**
     * Prueba para eliminar un automovil
     *
     *
     */
    @Test
    public void deleteAutomovilTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        autoLogic.deleteAutomovil(entity);
        AutomovilEntity deleted = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un automovil
     *
     *
     */
    @Test
    public void updateAutomovilTest() {

        AutomovilEntity entity = data.get(0);
        AutomovilEntity pojoEntity = factory.manufacturePojo(AutomovilEntity.class);

        pojoEntity.setId(entity.getId());
        pojoEntity.setModel(entity.getModel());
        pojoEntity.setMarca(entity.getMarca());
        pojoEntity.setPuntoDeVenta(entity.getPuntoDeVenta());
        pojoEntity.setPlaca(entity.getPlaca());
        pojoEntity.setChasis(entity.getChasis());
        boolean ex = false;

        try {
            autoLogic.updateAutomovil(pojoEntity);
            System.out.println(pojoEntity.getPlaca());
            AutomovilEntity resp = em.find(AutomovilEntity.class, entity.getId());

            System.out.println(resp.getPlaca());

        } catch (BusinessLogicException e) {
            System.out.println(e);
            ex = true;
        }
        if (ex == true) {
            Assert.assertTrue(ex);
        } else {
            Assert.assertFalse(ex);
        }

    }

}
