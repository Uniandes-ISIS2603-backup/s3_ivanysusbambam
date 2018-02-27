/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
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
public class CalificacionCarroPersistenceTest {
    
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
                .addPackage(CalificacionCarroEntity.class.getPackage())
                .addPackage(CalificacionCarroEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    CalificacionCarroPersistence persistence;
    
    
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
    
    private List<CalificacionCarroEntity> data = new ArrayList<>();

    
    private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        
        //System.out.println("REGISTRO");
        
        for (int i = 0; i < 3; i++) {
            
            CalificacionCarroEntity entity = factory.manufacturePojo(CalificacionCarroEntity.class);

            //System.out.println(entity.getName() + " : " + entity.getId());
            
            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una CalificacionCarro.
     *
     * 
     */
    @Test
    public void createCalificacionCarroTest(){
        CalificacionCarroEntity cc = new PodamFactoryImpl().manufacturePojo(CalificacionCarroEntity.class);
        CalificacionCarroEntity result = persistence.create(cc);
        
        Assert.assertNotNull(result);
        
        CalificacionCarroEntity entity = em.find(CalificacionCarroEntity.class, result.getId());
        
        Assert.assertEquals(entity.getName(), result.getName());
    }
    
    
     /**
     * Prueba para consultar la lista de Calificaciones de carro.
     *
     * 
     */
    @Test 
    public void getCalificacionesCarroTest(){
   
        System.out.println("CALIFICACIONES: ");
        for(CalificacionCarroEntity e : data){
            System.out.println(e.getId());
        }
        
        List<CalificacionCarroEntity>lista = persistence.findAll();
        
        boolean found;
        for(CalificacionCarroEntity e : lista){
            found = false;
            for(CalificacionCarroEntity a : data){
                if(a.equals(e)) found = true;
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar una CalificacionCarro.
     *
     * 
     */
    @Test
    public void getCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        CalificacionCarroEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPuntaje(), newEntity.getPuntaje());
    }
    
    /**
     * Prueba para eliminar una CalificacionCarro.
     *
     * 
     */
    @Test
    public void deleteCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CalificacionCarroEntity deleted = em.find(CalificacionCarroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una calificacion de carro .
     *
     * 
     */
    @Test
    public void updateCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionCarroEntity newEntity = factory.manufacturePojo(CalificacionCarroEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        CalificacionCarroEntity resp = em.find(CalificacionCarroEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
