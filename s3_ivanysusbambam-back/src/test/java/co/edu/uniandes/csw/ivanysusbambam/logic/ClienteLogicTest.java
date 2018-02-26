/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.ClienteLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
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
 * @author f.velasquez
 */
@RunWith(Arquillian.class)
public class ClienteLogicTest {
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
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ClienteLogic clienteLogic;
    
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
        for (int i = 0; i < 3; i++) {
                
            System.out.println("INSERTING DATA");
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            try{
            entity.setCedula((long)i+1);
            clienteLogic.createCliente(entity);
            
            data.add(entity);
            System.out.println("DATA INSERTED");
            }
            catch(Exception e){
                i--;
                System.out.println(i);
            }
        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }
    
    @Test
    public void createClienteTest(){
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        
        boolean ex = false;
        try{
        ClienteEntity result = clienteLogic.createCliente(newEntity);
        
        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getCedula());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        }
        catch(BusinessLogicException e)
        {
            ex =true;
        }
        
        if(cedulaValida(newEntity.getCedula()) && esAlfabetica(newEntity.getNombre())){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
        
    }
    
    @Test
    public void deleteClienteTest(){
        ClienteEntity entity = data.get(0);
        
        boolean ex = false;
        try{
        clienteLogic.deleteCliente(entity.getCedula());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getCedula());
        Assert.assertNull(deleted);
        }
        catch(BusinessLogicException e)
        {
            ex = true;
        }
         if(cedulaValida(entity.getCedula()) && esAlfabetica(entity.getNombre())){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
    }
    
    
    
    @Test
    public void findAllClientesTest(){
        List<ClienteEntity> list = clienteLogic.findAllClientes();
        Assert.assertEquals(data.size(), list.size());
        for (ClienteEntity entity : list) {
            boolean found = false;
            for (ClienteEntity storedEntity : data) {
                if (entity.getCedula().equals(storedEntity.getCedula())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void findClienteTest(){
        ClienteEntity entity = data.get(0);
        boolean ex = false;
        try{
            ClienteEntity resultEntity = clienteLogic.findCliente(entity.getCedula());
        
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
            Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
        }
        catch(BusinessLogicException e){
               ex = true;
        }
         if(cedulaValida(entity.getCedula()) && esAlfabetica(entity.getNombre())){
            Assert.assertFalse(ex);
        }
        else Assert.assertTrue(ex);
    }
    
    @Test
    public void findClienteByNameTest(){
        
        ClienteEntity ve;
        try{
            boolean found = false;
            List<ClienteEntity> name;
            for(int i = 0; i<data.size();i++){
                ve=data.get(i);
                name = clienteLogic.findClienteByName(ve.getNombre());
                for(ClienteEntity vee : name){
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
    public void updateClienteTest(){
        System.out.println("DATASIZE: " + data.size());
        ClienteEntity entity = data.get(0);
        ClienteEntity pojoEntity = factory.manufacturePojo(ClienteEntity.class);

        pojoEntity.setCedula(entity.getCedula());
        
        boolean ex = false;
        try{
        clienteLogic.updateCliente(pojoEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getCedula());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        }
        catch(BusinessLogicException e){
            ex = true;
            
        }
         if(cedulaValida(pojoEntity.getCedula()) && esAlfabetica(pojoEntity.getNombre())){
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
