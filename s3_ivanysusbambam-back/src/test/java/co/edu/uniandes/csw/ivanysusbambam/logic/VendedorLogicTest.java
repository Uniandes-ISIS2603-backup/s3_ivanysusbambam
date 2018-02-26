/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.VendedorLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VendedorPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            VendedorEntity entity = factory.manufacturePojo(VendedorEntity.class);

            try{
            entity.setCedula((long)i+1);
            vendedorLogic.createVendedor(entity);
            
            data.add(entity);
            }
            catch(Exception e){
                i--;
                
                System.out.println(i);
            }
        }
    }
    
    @Test
    public void createVendedorTest(){
        VendedorEntity newEntity = factory.manufacturePojo(VendedorEntity.class);
        
        boolean ex = false;
        try{
            VendedorEntity result = vendedorLogic.createVendedor(newEntity);
        
        Assert.assertNotNull(result);
        VendedorEntity entity = em.find(VendedorEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        }
        catch(BusinessLogicException e)
        {
            ex =true;
        }
        if(cedulaValida(newEntity.getCedula()) && esAlfabetica(newEntity.getNombre()) && newEntity.getCarnetVendedor()>0){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
        
    }
    
    @Test
    public void deleteVendedorTest(){
        VendedorEntity entity = data.get(0);
        
        boolean ex = false;
        try{
        vendedorLogic.deleteVendedor(entity.getCarnetVendedor());
        VendedorEntity deleted = em.find(VendedorEntity.class, entity.getId());
        Assert.assertNull(deleted);
        }
        catch(BusinessLogicException e)
        {
            ex = true;
        }
         if(cedulaValida(entity.getCedula()) && esAlfabetica(entity.getNombre()) && entity.getCarnetVendedor()>0){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
    }
    
    
    
    @Test
    public void findAllVendedoresTest(){
        List<VendedorEntity> list = vendedorLogic.findAllVendedores();
        Assert.assertEquals(data.size(), list.size());
        for (VendedorEntity entity : list) {
            boolean found = false;
            for (VendedorEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void findVendedorTest(){
        VendedorEntity entity = data.get(0);
        boolean ex = false;
        try{
            VendedorEntity resultEntity = vendedorLogic.findVendedor(entity.getCarnetVendedor());
        
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getId(), resultEntity.getId());
            Assert.assertEquals(entity.getName(), resultEntity.getName());
            Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
        }
        catch(BusinessLogicException e){
               ex = true;
        }
         if(cedulaValida(entity.getCedula()) && esAlfabetica(entity.getNombre()) && entity.getCarnetVendedor()>0){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
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

        pojoEntity.setId(entity.getId());
        
        boolean ex = false;
        try{
        vendedorLogic.updateVendedor(pojoEntity);

        VendedorEntity resp = em.find(VendedorEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        }
        catch(BusinessLogicException e){
            ex = true;
            
        }
         if(cedulaValida(pojoEntity.getCedula()) && esAlfabetica(pojoEntity.getNombre()) && pojoEntity.getCarnetVendedor()>0){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
    }
    
     /**
     * Verifica si una cédula es válida, es decir que tenga 10 dígitos o menos, que no sea null, y que no sea negativa o cero. 
     * @param cedula cedula cuya validez se busca determinar.
     * @throws BusinessLogicException si la cédula no es válida.
     */
    private static boolean cedulaValida(Long cedula){
        if(cedula == null) return false;
        if(String.valueOf(cedula).length()>10) return false;
        if(cedula<= 0) return false;
        return true;
    }
    
    /**
     * Verifica si la cadena pasada por parámetro está compuesta de (A..Z) U (a..z) U {á,é,í,ó,ú,ü) 
     * @param s la cadena que se busca verificar.
     * @return true si la cadena es alfabética, false de lo contrario.
     */
    private static boolean esAlfabetica(String s){
        char[] arreglo = s.toCharArray();
        for(char c : arreglo){
            //se asegura que c es un caracter de la A-Z o de la a-z o espacio o una vocal con tilde o una ü. 
            if( !((c>=65 && c<= 90) || (c>= 97 && c<=122) || (c == 32) ||(c>=160 && c <=165) || (c==130) || (c==129) )) return false;
                
        }
        return true;
        
    }
      
}
