/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
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
public class ClientePersistenceTest {

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
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ClientePersistence clientePersistence;
    
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    
    private List<ClienteEntity> data = new ArrayList<>();
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        
        System.out.println("REGISTRO");
        
        for (int i = 0; i < 3; i++) {
            
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            System.out.println(entity.getNombre() + " : " + entity.getCedula());
            
            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    @Test
    public void createClienteTest(){
        ClienteEntity ce = new PodamFactoryImpl().manufacturePojo(ClienteEntity.class);
        ClienteEntity resultado = clientePersistence.create(ce);
        Assert.assertNotNull(resultado);
        Assert.assertEquals(resultado,ce);
    }
    
    @Test
    public void getClientesTest(){
        
        System.out.println("CLIENTES: ");
        for(ClienteEntity e : data){
            System.out.println(e.getCedula());
        }
        
        List<ClienteEntity>lista = clientePersistence.findAll();
        
        boolean found;
        for(ClienteEntity e : lista){
            found = false;
            System.out.println("CEDULA E: " + e.getCedula());
            for(ClienteEntity a : data){
                System.out.println("CEDULA A : " +  a.getCedula());
                if(a.equals(e)) found = true;
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getClienteTest(){
        ClienteEntity vee;
        
        System.out.println("GET CLIENTE TEST");
        
        for(ClienteEntity ve: data){
            System.out.println("VE: "+ ve.getCedula());
            vee = clientePersistence.find(ve.getCedula());
            System.out.println("VEE: " + vee.getCedula());
            Assert.assertNotNull(vee);
            System.out.println(vee.equals(ve));
            Assert.assertTrue(ve.equals(vee));
        }
    }
    
    @Test
    public void updateClienteTest(){
        ClienteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);

        newEntity.setCedula(entity.getCedula());

        clientePersistence.update(newEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getCedula());

        System.out.println("ReSP " + resp);
        
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getCedula(), resp.getCedula());
    }
    
    
    @Test
    public void getClienteNombre(){
        boolean found;
        for(ClienteEntity ve : data){
            found = false;
            System.out.println("BUSCANDO: "+ve.getNombre());
            System.out.println( "ENCONTRADO : " +clientePersistence.findByName(ve.getNombre()));
            for(ClienteEntity vee : clientePersistence.findByName(ve.getNombre())) if (vee.equals(ve)) found = true;
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void deleteClienteTest(){
        ClienteEntity c = data.get(0);
        clientePersistence.delete(c.getCedula());
        Assert.assertNull(clientePersistence.find(c.getCedula()));
    }
    
}
