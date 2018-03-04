/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
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
                .addPackage(CalificacionCarroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject 
    private CalificacionCarroPersistence calificacionCarroPersistence;
    
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
        em.createQuery("delete from CalificacionCarroEntity").executeUpdate();
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
        CalificacionCarroEntity result = calificacionCarroPersistence.create(cc);
        
        Assert.assertNotNull(result);      
        Assert.assertEquals(cc, result);
    }
    
    
     /**
     * Prueba para consultar la lista de Calificaciones de carro.
     *
     * 
     */
    @Test 
    public void getCalificacionesCarroTest(){
   
        List<CalificacionCarroEntity> lista = calificacionCarroPersistence.findAll();
        System.out.println(data.size());
        System.out.println(lista.size());
        Assert.assertEquals(data.size(), lista.size());
        for(CalificacionCarroEntity ent : lista){
            boolean found  = false;
            for(CalificacionCarroEntity enti : data){
                if(ent.getId().equals(enti.getId())){
                    found = true;
                }
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
        CalificacionCarroEntity entity;
        
        for(CalificacionCarroEntity cc : data){
            entity = calificacionCarroPersistence.find(cc.getId());
            Assert.assertNotNull(entity);
            Assert.assertTrue(cc.equals(entity));
        }
    }
    
    /**
     * Prueba para eliminar una CalificacionCarro.
     *
     * 
     */
    @Test
    public void deleteCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        calificacionCarroPersistence.delete(entity.getId());
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

        calificacionCarroPersistence.update(newEntity);

        CalificacionCarroEntity resp = em.find(CalificacionCarroEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
}
