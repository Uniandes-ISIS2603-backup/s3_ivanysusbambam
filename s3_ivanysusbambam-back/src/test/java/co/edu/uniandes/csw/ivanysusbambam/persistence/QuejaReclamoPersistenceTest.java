/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import org.junit.runner.RunWith;
import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
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
public class QuejaReclamoPersistenceTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de QuejaReclamo, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyecciÃ³n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejaReclamoEntity.class.getPackage())
                .addPackage(QuejaReclamoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyeccion de la dependencia a la clase quejaReclamoPersistence cuyos
     * metodos se van a probar.
     */
    @Inject
    private QuejaReclamoPersistence quejaReclamoPersistence;

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
        em.createQuery("delete from QuejaReclamoEntity").executeUpdate();
    }

    /**
     *
     */
    private List<QuejaReclamoEntity> data = new ArrayList<QuejaReclamoEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            QuejaReclamoEntity entity = factory.manufacturePojo(QuejaReclamoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Queja o Reclamo.
     *
     *
     */
    @Test
    public void createQuejaReclamoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        QuejaReclamoEntity newEntity = factory.manufacturePojo(QuejaReclamoEntity.class);
        QuejaReclamoEntity result = quejaReclamoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        QuejaReclamoEntity entity = em.find(QuejaReclamoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getTexto(), entity.getTexto());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }

    /**
     * Prueba para consultar la lista de QuejasReclamos.
     *
     *
     */
    @Test
    public void getQuejasReclamosTest() {
        List<QuejaReclamoEntity> list = quejaReclamoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (QuejaReclamoEntity ent : list) {
            boolean found = false;
            for (QuejaReclamoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una QuejaReclamo.
     *
     *
     */
    @Test
    public void getQuejaReclamoTest() {
        QuejaReclamoEntity entity = data.get(0);
        QuejaReclamoEntity newEntity = quejaReclamoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getTexto(), newEntity.getTexto());

        Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
    }
    
    /**
     * Prueba para eliminar una QuejaReclamo.
     *
     *
     */
    @Test
    public void deleteQuejaReclamoTest() {
        QuejaReclamoEntity entity = data.get(0);
        quejaReclamoPersistence.delete(entity.getId());
        QuejaReclamoEntity deleted = em.find(QuejaReclamoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     /**
     * Prueba para actualizar una QuejaReclamo.
     *
     *
     */
    @Test
    public void updateQuejaReclamoTest() {
        QuejaReclamoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        QuejaReclamoEntity newEntity = factory.manufacturePojo(QuejaReclamoEntity.class);

        newEntity.setId(entity.getId());

        quejaReclamoPersistence.update(newEntity);

        QuejaReclamoEntity resp = em.find(QuejaReclamoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getTexto(), resp.getTexto());
        Assert.assertEquals(newEntity.getTipo(), resp.getTipo());
        }

    
    
    
}