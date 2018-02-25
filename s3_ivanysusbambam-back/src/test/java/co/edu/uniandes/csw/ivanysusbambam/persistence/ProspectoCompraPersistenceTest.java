/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
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
public class ProspectoCompraPersistenceTest {
    
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
                .addPackage(ProspectoCompraEntity.class.getPackage())
                .addPackage(ProspectoCompraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ProspectoCompraPersistence pcPersistence;
    
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
        em.createQuery("delete from ProspectoCompraEntity").executeUpdate();
    }
    
    private List<ProspectoCompraEntity> data = new ArrayList<>();
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            ProspectoCompraEntity entity = factory.manufacturePojo(ProspectoCompraEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    @Test
    public void createProspectoCompraTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ProspectoCompraEntity newEntity = factory.manufacturePojo(ProspectoCompraEntity.class);
        ProspectoCompraEntity result = pcPersistence.create(newEntity);
        //VendedorEntity result  = null;
        Assert.assertNotNull(result);

        ProspectoCompraEntity entity = em.find(ProspectoCompraEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    @Test
    public void getProspectosComoraTest(){
        
        List<ProspectoCompraEntity>lista = pcPersistence.findAll();
        
        boolean found;
        for(ProspectoCompraEntity e : lista){
            found = false;
            for(ProspectoCompraEntity a : data) if(a.equals(e)) found = true;
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getProspectoCompraTest(){
        
    ProspectoCompraEntity vee;
    for(ProspectoCompraEntity ve: data){
        vee = pcPersistence.find(ve.getId());
        Assert.assertNotNull(vee);
        Assert.assertTrue(ve.equals(vee));
    }
    }
    @Test
    public void updateProspectoCompraTest(){
        ProspectoCompraEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ProspectoCompraEntity newEntity = factory.manufacturePojo(ProspectoCompraEntity.class);

        newEntity.setId(entity.getId());

        pcPersistence.update(newEntity);

        ProspectoCompraEntity resp = em.find(ProspectoCompraEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getTexto(), resp.getTexto());
       /*Assert.assertEquals(newEntity.getVendedor(), resp.getVendedor);
        Assert.assertEquals(newEntity.getCliente(), resp.getCliente());*/
    }
    
    @Test
    public void deleteProspectoCompraTest(){
        ProspectoCompraEntity pc= data.get(0);
        pcPersistence.delete(pc.getId());
        Assert.assertNull(pcPersistence.find(pc.getId()));
        
    }
}
