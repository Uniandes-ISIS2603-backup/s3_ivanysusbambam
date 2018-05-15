/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
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
public class PuntoDeVentaPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoDeVentaEntity.class.getPackage())
                .addPackage(PuntoDeVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PuntoDeVentaPersistence puntoDeVentaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
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
     *
     * 
     */
    private void clearData() {
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();
    }
    
    /**
     * 
     */
    private List<PuntoDeVentaEntity> data = new ArrayList<PuntoDeVentaEntity>();
    
   
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * 
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PuntoDeVentaEntity entity = factory.manufacturePojo(PuntoDeVentaEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un PuntoDeVenta.
     *
     * 
     */
    @Test
    public void createPuntoDeVentaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PuntoDeVentaEntity newEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);
        PuntoDeVentaEntity result = puntoDeVentaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PuntoDeVentaEntity entity = em.find(PuntoDeVentaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de PuntoDeVenta.
     *
     * 
     */
    
    @Test
    public void getPuntosDeVentaTest() {
        List<PuntoDeVentaEntity> list = puntoDeVentaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PuntoDeVentaEntity ent : list) {
            boolean found = false;
            for (PuntoDeVentaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un PuntoDeVenta.
     *
     * 
     */
    @Test
    public void getPuntoDeVentaTest() {
        PuntoDeVentaEntity entity = data.get(0);
        PuntoDeVentaEntity newEntity = puntoDeVentaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getTelefono(), newEntity.getTelefono());
    }
    
    /**
     * Prueba el caso de consulta de un punto de venta por nombre
     * 
     */
    @Test
    public void getPuntoDeVentaByName(){
        boolean found = false;
        for(PuntoDeVentaEntity pv: data){
            found = false;
            for(PuntoDeVentaEntity var: puntoDeVentaPersistence.findByName(pv.getName())){
                if(var.equals(pv)){
                    Assert.assertEquals(pv.getId(), var.getId());
                    Assert.assertEquals(pv.getDireccion(), var.getDireccion());
                    Assert.assertEquals(pv.getTelefono(), var.getTelefono());
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }
    
    /**
     * Prueba para eliminar un PuntoDeVenta.
     *
     * 
     */
    @Test
    public void deletePuntoDeVentaTest() {
        PuntoDeVentaEntity entity = data.get(0);
        puntoDeVentaPersistence.delete(entity.getId());
        PuntoDeVentaEntity deleted = em.find(PuntoDeVentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un PuntoDeVenta.
     *
     * 
     */
    @Test
    public void updatePuntoDeVentaTest() {
        PuntoDeVentaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PuntoDeVentaEntity newEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);

        newEntity.setId(entity.getId());

        puntoDeVentaPersistence.update(newEntity);

        PuntoDeVentaEntity resp = em.find(PuntoDeVentaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
