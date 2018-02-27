/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
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
public class CalificacionTiendaPersistenceTest {
       
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
                .addPackage(CalificacionTiendaEntity.class.getPackage())
                .addPackage(CalificacionTiendaEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CalificacionTiendaPersistence persistence;
    
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    @Before
    public void configTest(){
        try{
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
    
    private List<CalificacionTiendaEntity> data = new ArrayList<>();

    
    private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        
        //System.out.println("REGISTRO");
        
        for (int i = 0; i < 3; i++) {
            
            CalificacionTiendaEntity entity = factory.manufacturePojo(CalificacionTiendaEntity.class);

            //System.out.println(entity.getName() + " : " + entity.getId());
            
            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una CalificacionTienda.
     *
     * 
     */
    @Test
    public void createCalificacionTiendaTest(){
        CalificacionTiendaEntity cc = new PodamFactoryImpl().manufacturePojo(CalificacionTiendaEntity.class);
        CalificacionTiendaEntity result = persistence.create(cc);
        
        Assert.assertNotNull(result);
        
        CalificacionTiendaEntity entity = em.find(CalificacionTiendaEntity.class, result.getId());
        
        Assert.assertEquals(entity.getName(), result.getName());
    }
    
    
     /**
     * Prueba para consultar la lista de Calificaciones de tienda.
     *
     * 
     */
    @Test 
    public void getCalificacionesTiendaTest(){
   
        System.out.println("CALIFICACIONES: ");
        for(CalificacionTiendaEntity e : data){
            System.out.println(e.getId());
        }
        
        List<CalificacionTiendaEntity>lista = persistence.findAll();
        
        boolean found;
        for(CalificacionTiendaEntity e : lista){
            found = false;
            for(CalificacionTiendaEntity a : data){
                if(a.equals(e)) found = true;
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar una CalificacionTienda.
     *
     * 
     */
    @Test
    public void getCalificacionTiendaTest() {
        CalificacionTiendaEntity entity = data.get(0);
        CalificacionTiendaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPuntaje(), newEntity.getPuntaje());
    }
    
    /**
     * Prueba para eliminar una CalificacionTienda.
     *
     * 
     */
    @Test
    public void deleteCalificacionTiendaTest() {
        CalificacionTiendaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CalificacionTiendaEntity deleted = em.find(CalificacionTiendaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una calificacion de tienda .
     *
     * 
     */
    @Test
    public void updateCalificacionTiendaTest() {
        CalificacionTiendaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionTiendaEntity newEntity = factory.manufacturePojo(CalificacionTiendaEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        CalificacionTiendaEntity resp = em.find(CalificacionTiendaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
