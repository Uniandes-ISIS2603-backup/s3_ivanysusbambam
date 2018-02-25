/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
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
 * @author j.sierrac
 */
@RunWith(Arquillian.class)
public class CompraPersistenceTest {
    
@Inject
private CompraPersistence compraPersistence;

@PersistenceContext
private EntityManager em;
    
 @Inject
 UserTransaction utx;  
    /**
     *Lista de compras 
     */
    private List<CompraEntity> data = new ArrayList<CompraEntity>();

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
                .addPackage(CompraEntity.class.getPackage())
                .addPackage(CompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
  @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
//            clearData();
//            insertData();
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
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CompraEntity entity = factory.manufacturePojo(CompraEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
     /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * 
     */
    private void clearData() {
        em.createQuery("delete from CompraEntity").executeUpdate();
        
    }
    
/**
     * Prueba para crear una Compra.
     *
     * 
     */
    @Test
    public void createCompraTest() {

        PodamFactory factory = new PodamFactoryImpl();
        CompraEntity newEntity = factory.manufacturePojo(CompraEntity.class);
        CompraEntity result = compraPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CompraEntity entity = em.find(CompraEntity.class, result.getIdCompra());

       
    }
     /**
     * Prueba para consultar la lista de Ventas.
     *
     *
     */
    @Test
    public void getComprasTest() {
        
        List<CompraEntity> list = compraPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CompraEntity ent : list) {
            boolean found = false;
            for (CompraEntity entity : data) {
                if (ent.getIdCompra().equals(entity.getIdCompra())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
     /**
     * Prueba para consultar una Compra.
     *
     *
     */
    @Test
    public void getCompraTest() {
        CompraEntity entity = data.get(0);
        CompraEntity newEntity = compraPersistence.find(entity.getIdCompra());
        Assert.assertNotNull(newEntity);
   

    }
    
    /**
     * Prueba para eliminar una Venta.
     *
     *
     */
    @Test
    public void deleteVentaTest() {
        CompraEntity entity = data.get(0);
        compraPersistence.delete(entity.getIdCompra());
        CompraEntity deleted = em.find(CompraEntity.class, entity.getIdCompra());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Venta.
     *
     *
     */
    @Test
    public void updateVentaTest() {
        CompraEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CompraEntity newEntity = factory.manufacturePojo(CompraEntity.class);

        newEntity.setIdCompra(entity.getIdCompra());

        compraPersistence.update(newEntity);

       CompraEntity resp = em.find(CompraEntity.class, entity.getIdCompra());

     
        }
    
}
