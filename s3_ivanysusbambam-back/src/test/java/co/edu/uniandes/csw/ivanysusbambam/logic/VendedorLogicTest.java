/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.VendedorLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VendedorPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author f.velasquez
 */
@RunWith(Arquillian.class)
public class VendedorLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
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
                .addPackage(VendedorLogic.class.getPackage())
                .addPackage(VendedorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private VendedorLogic vendedorLogic;
    
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
    private List<PuntoDeVentaEntity> pvData = new ArrayList<>();
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            PuntoDeVentaEntity pv = factory.manufacturePojo(PuntoDeVentaEntity.class);
            em.persist(pv);
            VendedorEntity entity = factory.manufacturePojo(VendedorEntity.class);
            entity.setPuntoDeVenta(pv);
            
            
            em.persist(entity);
            data.add(entity);
            pvData.add(pv);
            
        }
    }
    
    @Test
    public void createVendedorTest(){
        VendedorEntity newEntity = factory.manufacturePojo(VendedorEntity.class);
        newEntity.setPuntoDeVenta(pvData.get(0));
        System.out.println("NOMBRE: " + newEntity.getNombre() + " IDVENDEDOR" + newEntity.getCarnetVendedor());
        
        try{
            VendedorEntity result = vendedorLogic.createVendedor(newEntity);
        
        Assert.assertNotNull(result);
        VendedorEntity entity = em.find(VendedorEntity.class, result.getCarnetVendedor());
        Assert.assertEquals(newEntity.getCarnetVendedor(), entity.getCarnetVendedor());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        }
        catch(BusinessLogicException e)
        {
           
           Assert.fail();
        }
        
    }
    
    @Test
    public void deleteVendedorTest(){
        VendedorEntity entity = data.get(0);
        
        try{
        vendedorLogic.deleteVendedor(entity.getCarnetVendedor());
        VendedorEntity deleted = em.find(VendedorEntity.class, entity.getCarnetVendedor());
        Assert.assertNull(deleted);
        }
        catch(BusinessLogicException e)
        {
            Assert.fail();
        }
    }
    
    
    
    @Test
    public void findAllVendedoresTest(){
        List<VendedorEntity> list = vendedorLogic.findAllVendedores();
        System.out.println("VENDEDORES: " + list.size());
        Assert.assertEquals(data.size(), list.size());
        for (VendedorEntity entity : list) {
            boolean found = false;
            for (VendedorEntity storedEntity : data) {
                if (entity.getCarnetVendedor().equals(storedEntity.getCarnetVendedor())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void findVendedorTest(){
        VendedorEntity entity = data.get(0);
        
        
        try{
            VendedorEntity resultEntity = vendedorLogic.findVendedor(entity.getCarnetVendedor());
        
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getCarnetVendedor(), resultEntity.getCarnetVendedor());
            Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
            Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
        }
        catch(BusinessLogicException e){
            Assert.fail();
        }
    }
    
    @Test
    public void findVendedorByNameTest(){
        
        VendedorEntity ve;
        try{
            boolean found = false;
            List<VendedorEntity> name;
            for(int i = 0; i<data.size();i++){
                ve=data.get(i);
                name = vendedorLogic.findVendedorByName(ve.getNombre());
                for(VendedorEntity vee : name){
                    if(vee.getCedula().equals(ve.getCedula())){
                        found = true;
                        break;
                    }
                }
                Assert.assertTrue(found);
                found = false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        
            Assert.fail();
        }
    }
    
    @Test
    public void findVendedorByCedulaTest(){
        
        try{
            VendedorEntity vee;
            for(VendedorEntity ve : data){
                vee = vendedorLogic.findVendedorByCedula(ve.getCedula());
                
                Assert.assertTrue(vee.getCarnetVendedor().equals(ve.getCarnetVendedor()));
               
            }
        }
        catch(BusinessLogicException e)
        {
            
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void updateVendedorTest(){
        VendedorEntity entity = data.get(0);
        VendedorEntity pojoEntity = factory.manufacturePojo(VendedorEntity.class);

        pojoEntity.setCarnetVendedor(entity.getCarnetVendedor());
        pojoEntity.setCedula(entity.getCedula());
        pojoEntity.setPuntoDeVenta(pvData.get(0));
        
        try{
        vendedorLogic.updateVendedor(pojoEntity);

        VendedorEntity resp = em.find(VendedorEntity.class, entity.getCarnetVendedor());

        Assert.assertEquals(pojoEntity.getCarnetVendedor(), resp.getCarnetVendedor());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        }
        catch(BusinessLogicException e){
            System.out.println("EXCEPCIÓN " + e.getMessage());
            Assert.fail();
        }
    }
}
