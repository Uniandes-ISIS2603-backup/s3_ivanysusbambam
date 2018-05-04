/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;


import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author hd.castellanos
 */
@RunWith(Arquillian.class)
public class VentaPersistenceTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Venta, el descriptor de la base
     * de datos y el archivo benas.xml para resolver la inyecciÃ³n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VentaEntity.class.getPackage())
                .addPackage(VentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyeccion de la dependencia a la clase VentaPersistence cuyos metodos se
     * van a probar.
     */
    @Inject
    private VentaPersistence ventaPersistence;

    /**
     * Contexto de Persostencia que se va autilizar para acceder a la Base de
     * datos por fuera de los metodos que se estan probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del EntityManager anterior cuando
     * se crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuracion inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
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
     * Limpia las tablas que estan implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from VentaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<VentaEntity> data = new ArrayList<VentaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
       PodamFactory factory = new PodamFactoryImpl();
        VentaEntity newEntity1 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity2 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity3 = factory.manufacturePojo(VentaEntity.class);
       Long id1 = 11L;
       Long id2 = 12L;
       Long id3 = 13L;
        newEntity1.setId(id1);
        newEntity2.setId(id2);
        newEntity3.setId(id3);



            em.persist(newEntity1);
            data.add(newEntity1);
        
            em.persist(newEntity2);
            data.add(newEntity2);
        
            em.persist(newEntity3);
            data.add(newEntity3);
        
    }

    /**
     * Prueba para crear una Venta.
     *
     *
     */
    @Test
    public void createVentaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        VentaEntity newEntity1 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity2 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity3 = factory.manufacturePojo(VentaEntity.class);
       Long id1 = 14L;
       Long id2 = 15L;
       Long id3 = 16L;
        newEntity1.setId(id1);
        newEntity2.setId(id2);
        newEntity3.setId(id3);
        VentaEntity result = ventaPersistence.create(newEntity1);

        Assert.assertNotNull(result);

        VentaEntity entity = em.find(VentaEntity.class, result.getId());

        Assert.assertEquals(newEntity1.getName(), entity.getName());

    }

    /**
     * Prueba para consultar la lista de Ventas.
     *
     *
     */
    @Test
    public void getVentasTest() {
        List<VentaEntity> list = ventaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (VentaEntity ent : list) {
            boolean found = false;
            for (VentaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Venta.
     *
     *
     */
    @Test
    public void getVentaTest() {
        VentaEntity entity = data.get(0);
        VentaEntity newEntity = ventaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());

    }
    
    /**
     * Prueba para eliminar una Venta.
     *
     *
     */
    @Test
    public void deleteVentaTest() {
        VentaEntity entity = data.get(0);
        ventaPersistence.delete(entity.getId());
        VentaEntity deleted = em.find(VentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Venta.
     *
     *
     */
    @Test
    public void updateVentaTest() {
        VentaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VentaEntity newEntity = factory.manufacturePojo(VentaEntity.class);

        newEntity.setId(entity.getId());

        ventaPersistence.update(newEntity);

        VentaEntity resp = em.find(VentaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        }




}