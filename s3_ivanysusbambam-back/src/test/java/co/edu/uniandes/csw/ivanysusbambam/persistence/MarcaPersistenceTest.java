/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
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
 * @author Joseph Ortíz Moreno
 */
@RunWith(Arquillian.class)
public class MarcaPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MarcaEntity.class.getPackage())
                .addPackage(MarcaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private MarcaPersistence marcaPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    /**
     * Se configura inicialmente la prueba
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
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from MarcaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<MarcaEntity> data = new ArrayList<MarcaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MarcaEntity entity = factory.manufacturePojo(MarcaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Marca
     */
    @Test
    public void createMarcaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);
        MarcaEntity result = marcaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        MarcaEntity entity = em.find(MarcaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Prueba para consultar la lista de Marcas
     */
    @Test
    public void getMarcasTest() {
        List<MarcaEntity> list = marcaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MarcaEntity ent : list) {
            boolean found = false;
            for (MarcaEntity entity : data) {
                if (ent.getName().equals(entity.getName())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Marca
     */
    @Test
    public void getMarcaTest() {
        MarcaEntity entity = data.get(0);
        MarcaEntity newEntity = marcaPersistence.find(entity.getNombre());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getAutomoviles(), newEntity.getAutomoviles());
        Assert.assertEquals(entity.getModelos(), newEntity.getModelos());

    }

    /**
     * Prueba para eliminar una Marca
     */
    @Test
    public void deleteAuthorTest() {
        MarcaEntity entity = data.get(0);
        marcaPersistence.delete(entity.getNombre());
        MarcaEntity deleted = em.find(MarcaEntity.class, entity.getNombre());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Marca
     */
    @Test
    public void updateAuthorTest() {
       MarcaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MarcaEntity newEntity = factory.manufacturePojo(MarcaEntity.class);

        newEntity.setNombre(entity.getNombre());

        marcaPersistence.update(newEntity);

        MarcaEntity resp = em.find(MarcaEntity.class, entity.getNombre());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

}
