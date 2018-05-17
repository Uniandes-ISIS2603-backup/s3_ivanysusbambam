/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.CalificacionCarroLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionCarroPersistence;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CalificacionCarroLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    
    @Inject
    private CalificacionCarroLogic ccarroLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction utx;
    
    private List<CalificacionCarroEntity> data = new ArrayList<CalificacionCarroEntity>();
    

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionCarroEntity.class.getPackage())
                .addPackage(CalificacionCarroLogic.class.getPackage())
                .addPackage(CalificacionCarroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     *
     *
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
    
    private void clearData() {
        em.createQuery("delete from CalificacionCarroEntity").executeUpdate();
    }
    
    private void insertData() {
        System.out.println("-INSERT- ");

        for (int i = 0; i < 3; i++) {
            CalificacionCarroEntity entity = factory.manufacturePojo(CalificacionCarroEntity.class);
            
            em.persist(entity);
            data.add(entity);
            System.out.println("cc " + entity.getName());
        }
    }
    
    /**
     * Prueba para crear una CalificacionCarro
     *
     *
     */
    @Test
    public void createCalificacionCarroTest(){
        
        try {
            CalificacionCarroEntity newEntity = factory.manufacturePojo(CalificacionCarroEntity.class);
            CalificacionCarroEntity result = ccarroLogic.createCalificacionCarro(newEntity);
            Assert.assertNotNull(result);
            CalificacionCarroEntity entity = em.find(CalificacionCarroEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
            Assert.assertEquals(newEntity.getPuntaje(), entity.getPuntaje());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CalificacionCarroLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /**
         * Prueba el caso de error para crear una calificacion carro
         * Excepcion: calificacion inválida
         */
        CalificacionCarroEntity cc = new CalificacionCarroEntity();
        cc.setComentario("abcdhijk");
        cc.setPuntaje(0.2);
        CalificacionCarroEntity result;
        boolean exc = false;
        try{
            result = ccarroLogic.createCalificacionCarro(cc);
        }
        catch(BusinessLogicException ex){
            exc = true;
        } 
        
        Assert.assertTrue(exc);
        
    }
    
    /**
     * Prueba para consultar la lista de CalificacionCarro
     *
     *
     */
    @Test
    public void getCalificacionesCarroTest() {
        List<CalificacionCarroEntity> list = ccarroLogic.getCalificacionesCarro();
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionCarroEntity entity : list) {
            boolean found = false;
            for (CalificacionCarroEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
    /**
     * Prueba para consultar una CalificacionCarro
     *
     *
     */
    @Test
    public void getCalificacionCarroTest() {
        CalificacionCarroEntity entity = data.get(0);
        CalificacionCarroEntity resultEntity = ccarroLogic.getCalificacionCarro(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getComentario(), resultEntity.getComentario());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getPuntaje(), resultEntity.getPuntaje());
    }
    
    /**
     * Prueba para eliminar una CalificacionCarro
     *
     *
     */
    @Test
    public void deleteCalificacionCarroTest() {
        try {
            CalificacionCarroEntity entity = data.get(0);
            ccarroLogic.deleteCalificacionCarro(entity.getId());
            CalificacionCarroEntity deleted = em.find(CalificacionCarroEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CalificacionCarroLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /**
         * Prueba la eliminacion de una calificacion carro con
         * Caso de excepcion: id inexistente
         */       
        boolean exc = false;
        try{
            ccarroLogic.deleteCalificacionCarro(Long.MIN_VALUE);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        
        Assert.assertTrue(exc);
    }
    
    
    /**
     * Prueba para actualizar un CalificacionCarro
     *
     *
     */
    @Test
    public void updateCalificacionCarroTest() throws BusinessLogicException {
        CalificacionCarroEntity entity = data.get(0);
        CalificacionCarroEntity pojoEntity = factory.manufacturePojo(CalificacionCarroEntity.class);
        
        pojoEntity.setId(entity.getId());
        
        ccarroLogic.updateCalificacionCarro(pojoEntity);
        CalificacionCarroEntity resp = em.find(CalificacionCarroEntity.class, entity.getId());
        
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getComentario(), resp.getComentario());
        Assert.assertEquals(pojoEntity.getPuntaje(), resp.getPuntaje());

        /**
         * Prueba la actualizacion de una calificacion carro con casos
         * de Excepcion: id no existente
         */            
        boolean exc = false;
        CalificacionCarroEntity var = new CalificacionCarroEntity();
        var.setId(Long.MIN_VALUE);
        try{
            ccarroLogic.updateCalificacionCarro(var);
        }
        catch(BusinessLogicException e){
            exc = true;
        }
        Assert.assertTrue(exc);
        
        
        /**
         * Prueba la actualizacion de una calificacion carro con casos
         * de Excepcion: puntaje invalido arriba
         */            
        boolean excep = false;
        CalificacionCarroEntity varEx = data.get(1);
        var.setPuntaje(12.0);
        try{
            ccarroLogic.updateCalificacionCarro(varEx);
        }
        catch(BusinessLogicException e){
            excep = true;
        }
        Assert.assertTrue(exc);
        
        /**
         * Prueba la actualizacion de una calificacion carro con casos
         * de Excepcion: puntaje invalido arriba
         */            
        boolean excepcion = false;
        CalificacionCarroEntity varExcep = data.get(1);
        var.setPuntaje(0.1);
        try{
            ccarroLogic.updateCalificacionCarro(varEx);
        }
        catch(BusinessLogicException e){
            excepcion = true;
        }
        Assert.assertTrue(exc);
        
        
    }
   
}
