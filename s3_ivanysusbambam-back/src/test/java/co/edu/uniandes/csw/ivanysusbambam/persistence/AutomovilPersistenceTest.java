/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;

import java.util.ArrayList;
import java.util.List;

import org.jboss.arquillian.junit.Arquillian;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
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
 * @author hd.castellanos
 */
@RunWith(Arquillian.class)
public class AutomovilPersistenceTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Automovil, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyecciÃ³n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AutomovilEntity.class.getPackage())
                .addPackage(AutomovilPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyeccion de la dependencia a la clase AutomovilPersistence cuyos metodos
     * se van a probar.
     */
    @Inject
    private AutomovilPersistence automovilPersistence;

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
        em.createQuery("delete from MarcaEntity").executeUpdate();
        em.createQuery("delete from ModelEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();
    }

    /**
     * lista de datos de automoviles
     */
    private List<AutomovilEntity> data = new ArrayList<AutomovilEntity>();

    /**
     * data de la marca
     */
    private List<MarcaEntity> marcaData = new ArrayList<MarcaEntity>();

    /**
     * Data del modelo
     */
    private List<ModelEntity> modelData = new ArrayList<ModelEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AutomovilEntity entity = factory.manufacturePojo(AutomovilEntity.class);
            MarcaEntity marca = factory.manufacturePojo(MarcaEntity.class);
            ModelEntity model = factory.manufacturePojo(ModelEntity.class);
            em.persist(entity);
            em.persist(marca);

            data.add(entity);
            marcaData.add(marca);
            modelData.add(model);
        }
    }

    /**
     * Prueba para crear un automovil.
     *
     *
     */
    @Test
    public void createAutomovilTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);
        AutomovilEntity result = automovilPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AutomovilEntity entity = em.find(AutomovilEntity.class, result.getId());

        Assert.assertEquals(newEntity.getPlaca(), entity.getPlaca());

    }

    /**
     * Prueba para consultar la lista de automoviles.
     *
     *
     */
    @Test
    public void getautomovilesTest() {
        List<AutomovilEntity> list = automovilPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (AutomovilEntity ent : list) {
            boolean found = false;
            for (AutomovilEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un automovil.
     *
     *
     */
    @Test
    public void getAutomovilTest() {
        AutomovilEntity entity = data.get(0);
        AutomovilEntity newEntity = automovilPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getPlaca(), newEntity.getPlaca());
        Assert.assertEquals(entity.getColor(), newEntity.getColor());

        Assert.assertEquals(entity.getChasis(), newEntity.getChasis());
    }

    /**
     * Prueba para consultar automoviles por marca
     */
    @Test
    public void getAutomovilMarcaTest() {
        AutomovilEntity entity = data.get(0);
        entity.setMarca(marcaData.get(0));
        entity.getMarca().setName("marca");

        List<AutomovilEntity> newEntity = automovilPersistence.findByMarca(entity.getMarca().getName());
        Assert.assertNotNull(newEntity);

    }

    /**
     * Prueba para consultar automoviles por modelo
     */
    @Test
    public void getAutomovilModelTest() {
        AutomovilEntity entity = data.get(0);
        entity.setModel(modelData.get(0));
        entity.getModel().setName("model");

        List<AutomovilEntity> newEntity = automovilPersistence.findByModelo(entity.getModel().getName());
        Assert.assertNotNull(newEntity);

    }

    /**
     * Prueba para consultar automoviles por Color
     */
    @Test
    public void getAutomovilColorTest() {
        AutomovilEntity entity = data.get(0);
        entity.setColor("Amarillo");

        List<AutomovilEntity> newEntity = automovilPersistence.findByColor(entity.getColor());
        Assert.assertNotNull(newEntity);

    }

    /**
     * Prueba para consultar los colores de los automoviles
     */
    @Test
    public void getAutomovilColoresTest() {
        AutomovilEntity entity = data.get(0);
        entity.setColor("Amarillo");

        List<String> colores = automovilPersistence.listColores();

        Assert.assertNotNull(colores);

    }

    /**
     * Prueba para consultar los automoviles con cierta placa
     */
    @Test
    public void getAutomovilPlacaTest() {
        AutomovilEntity entity = data.get(0);
        entity.setPlaca("ABC-123");

        List<AutomovilEntity> auto = automovilPersistence.findByPlate(entity.getPlaca());

        if (auto.isEmpty()) {
            Assert.assertNotNull(auto);
        } else {
            Assert.assertEquals(entity.getPlaca(), auto.get(0).getPlaca());
        }

    }

    /**
     * Prueba para consultar los automoviles con cierto numero de chasis
     */
    @Test
    public void getAutomovilChasisTest() {
        AutomovilEntity entity = data.get(0);
        entity.setChasis(2546498);

        List< AutomovilEntity> auto = automovilPersistence.findBychasis(entity.getChasis());

        if (auto.isEmpty()) {
            Assert.assertNotNull(auto);
        } else {
            Assert.assertEquals(entity.getChasis(), auto.get(0).getChasis());
        }
    }

    /**
     * Prueba para consultar los automoviles en cierto rango de anios
     */
    @Test
    public void getAutomovilRangoAniosTest() {
        AutomovilEntity entity = data.get(0);
        AutomovilEntity entity2 = data.get(1);
        entity.setAnio(1);
        entity2.setAnio(2);
        List<AutomovilEntity> autos = automovilPersistence.findRangoAnios(entity.getAnio(), entity2.getAnio());

        Assert.assertNotNull(autos);

    }

    /**
     * Prueba para consultar los automoviles en cierto rango de precios
     */
    @Test
    public void getAutomovilRangoPreciosTest() {
        AutomovilEntity entity = data.get(0);
        AutomovilEntity entity2 = data.get(1);
        entity.setValorListado(20.0);
        entity2.setValorListado(40.0);
        Integer precio = entity.getValorListado().intValue();
        Integer precio2 = entity2.getValorListado().intValue();
        List<AutomovilEntity> autos = automovilPersistence.findRangoPrecios(precio, precio2);

        Assert.assertNotNull(autos);

    }

    /**
     * Prueba para eliminar un automovil.
     *
     *
     */
    @Test
    public void deleteAutomovilTest() {
        AutomovilEntity entity = data.get(0);
        automovilPersistence.delete(entity.getId());
        AutomovilEntity deleted = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un automovil.
     *
     *
     */
    @Test
    public void updateAutomovilTest() {
        AutomovilEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);

        newEntity.setId(entity.getId());

        automovilPersistence.update(newEntity);

        AutomovilEntity resp = em.find(AutomovilEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getPlaca(), resp.getPlaca());
        Assert.assertEquals(newEntity.getColor(), resp.getColor());
        Assert.assertEquals(newEntity.getChasis(), resp.getChasis());
    }

}
