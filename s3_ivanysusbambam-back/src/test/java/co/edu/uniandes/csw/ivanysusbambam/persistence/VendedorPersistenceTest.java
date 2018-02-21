/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
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
 * @author Felipe Velásquez Montoya
 */
@RunWith(Arquillian.class)
public class VendedorPersistenceTest {
    
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
                .addPackage(VendedorEntity.class.getPackage())
                .addPackage(VendedorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private VendedorPersistence vendedorPersistence;
    
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
    
    private void clearData() {
        em.createQuery("delete from VendedorEntity").executeUpdate();
    }
    
    private List<VendedorEntity> data = new ArrayList<>();
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            VendedorEntity entity = factory.manufacturePojo(VendedorEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    
     @Test
    public void createVendedorTest() {
        PodamFactory factory = new PodamFactoryImpl();
        VendedorEntity newEntity = factory.manufacturePojo(VendedorEntity.class);
        VendedorEntity result = vendedorPersistence.create(newEntity);
        //VendedorEntity result  = null;
        Assert.assertNotNull(result);

        VendedorEntity entity = em.find(VendedorEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void deleteVendedorTest(){
        VendedorEntity vendedor = data.get(0);
        vendedorPersistence.delete(vendedor.getCarnetVendedor());
        Assert.assertNull(vendedorPersistence.find(vendedor.getCarnetVendedor()));
        
    }
    
    @Test
    public void getVendedoresTest(){
        
        List<VendedorEntity>lista = vendedorPersistence.findAll();
        
        boolean found;
        for(VendedorEntity e : lista){
            found = false;
            for(VendedorEntity a : data) if(a.equals(e)) found = true;
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getVendedorTest(){
        
    VendedorEntity vee;
    for(VendedorEntity ve: data){
        vee = vendedorPersistence.find(ve.getCarnetVendedor());
        Assert.assertNotNull(vee);
        Assert.assertEquals(ve,vee);
    }
    }
    
    @Test
    public void getVendedorCedula(){
        
        boolean found;
        for(VendedorEntity ve : data){
            found = false;
            for(VendedorEntity vee : vendedorPersistence.findByCedula(ve.getCedula()))if(vee.equals(ve)) found = true;
            Assert.assertTrue(found);
        }
    }
    
   @Test
    public void getVendedorNombre(){
        boolean found;
        for(VendedorEntity ve : data){
            found = false;
            for(VendedorEntity vee : vendedorPersistence.findByName(ve.getName())) if (vee.equals(ve)) found = true;
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void updateVendedor(){
        VendedorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VendedorEntity newEntity = factory.manufacturePojo(VendedorEntity.class);

        newEntity.setId(entity.getId());

        vendedorPersistence.update(newEntity);

        VendedorEntity resp = em.find(VendedorEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getCedula(), resp.getCedula());
        Assert.assertEquals(newEntity.getCarnetVendedor(), resp.getCarnetVendedor());
    }
}
