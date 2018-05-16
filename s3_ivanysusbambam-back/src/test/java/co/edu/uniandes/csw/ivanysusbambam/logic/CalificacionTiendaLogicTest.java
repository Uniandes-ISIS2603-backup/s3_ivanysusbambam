/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.CalificacionTiendaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionTiendaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.CalificacionTiendaPersistence;
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
public class CalificacionTiendaLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();
    
    
    @Inject
    private CalificacionTiendaLogic ctiendaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject 
    private UserTransaction utx;
    
    private List<CalificacionTiendaEntity> data = new ArrayList<>();
    
    private List<ClienteEntity> clienteData = new ArrayList<>();
    
    private List<PuntoDeVentaEntity> puntoVentaData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionTiendaEntity.class.getPackage())
                .addPackage(CalificacionTiendaLogic.class.getPackage())
                .addPackage(CalificacionTiendaPersistence.class.getPackage())
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
        em.createQuery("delete from CalificacionTiendaEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();
    }
    
    private void insertData() {
        System.out.println("-INSERT- ");

        int i;
        for(i = 0; i < 3; i++){
            PuntoDeVentaEntity puntoVentaEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);
            em.persist (puntoVentaEntity);
            puntoVentaData.add(puntoVentaEntity);
            System.out.println("puntoVenta " + puntoVentaEntity.getName());
        }
        for(i = 0; i < 3; i++ ){
            ClienteEntity clienteEntity = factory.manufacturePojo(ClienteEntity.class);
            
            em.persist(clienteEntity);
            clienteData.add(clienteEntity);
            System.out.println("cliente " + clienteEntity.getNombre());

        }
        for (i = 0; i < 3; i++) {
            CalificacionTiendaEntity entity = factory.manufacturePojo(CalificacionTiendaEntity.class);
            entity.setCliente(clienteData.get(i));
            entity.setPuntoDeVenta(puntoVentaData.get(i));
            
            em.persist(entity);
            data.add(entity);
            System.out.println("cc " + entity.getName());
           
        }
    }
    
    /**
     * Prueba para crear una CalificacionTienda
     *
     *
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    @Test
    public void createCalificacionTiendaTest() throws BusinessLogicException {
        
        CalificacionTiendaEntity newEntity = factory.manufacturePojo(CalificacionTiendaEntity.class);
        newEntity.setCliente(clienteData.get(0));
        CalificacionTiendaEntity result = ctiendaLogic.createCalificacionTienda(newEntity);
        
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getCliente());

        CalificacionTiendaEntity entity = em.find(CalificacionTiendaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getPuntaje(), entity.getPuntaje());
        
        
        /**
         * Prueba el caso de error para crear una calificacion tienda
         * Excepcion: calificacion inválida
         */        
        CalificacionTiendaEntity ct = new CalificacionTiendaEntity();
        //Datos cableados para generar error a la hora de crearlo
        ct.setComentario("abcdhijk");
        ct.setPuntaje(0.2);
        CalificacionTiendaEntity resultB;
        boolean exc = false;
        try{
            resultB = ctiendaLogic.createCalificacionTienda(ct);
        }
        catch(BusinessLogicException ex){
            exc = true;
        } 
        
        Assert.assertTrue(exc);
    }
    
    /**
     * Prueba para consultar la lista de CalificacionTienda
     *
     */
    @Test
    public void getCalificacionesTiendaTest() {
        List<CalificacionTiendaEntity> list = ctiendaLogic.getCalificacionesTienda();
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionTiendaEntity entity : list) {
            boolean found = false;
            for (CalificacionTiendaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    } 
    
    /**
     * Prueba para consultar una CalificacionTienda
     */
    @Test
    public void getCalificacionCarroTest() {
        CalificacionTiendaEntity entity = data.get(0);
        CalificacionTiendaEntity resultEntity = ctiendaLogic.getCalificacionTienda(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getComentario(), resultEntity.getComentario());
        Assert.assertEquals(entity.getPuntaje(), resultEntity.getPuntaje());
    }
    
    /**
     * Prueba para eliminar una CalificacionTienda
     *
     *
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    @Test
    public void deleteCalificacionTiendaTest() throws BusinessLogicException {
        CalificacionTiendaEntity entity = data.get(0);
        ctiendaLogic.deleteCalificacionTienda(entity.getId());
        CalificacionTiendaEntity deleted = em.find(CalificacionTiendaEntity.class, entity.getId());
        Assert.assertNull(deleted);
       
        
        /**
         * Prueba la eliminacion de una calificacion tienda con
         * Caso de excepcion: id inexistente
         */
        boolean exc = false;
        try{
            ctiendaLogic.deleteCalificacionTienda(Long.MIN_VALUE);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        
        Assert.assertTrue(exc);
    }
    
   
    /**
     * Prueba para actualizar un CalificacionTienda
     *
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    @Test
    public void updateCalificacionTiendaTest() throws BusinessLogicException {
        CalificacionTiendaEntity entity = data.get(0);
        CalificacionTiendaEntity pojoEntity = factory.manufacturePojo(CalificacionTiendaEntity.class);
        
        pojoEntity.setId(entity.getId());
        pojoEntity.setCliente(entity.getCliente());
        pojoEntity.setPuntoDeVenta(entity.getPuntoDeVenta());
        

        System.out.println(ctiendaLogic.updateCalificacionTienda(pojoEntity).getCliente().getCedula());
        CalificacionTiendaEntity resp = em.find(CalificacionTiendaEntity.class, entity.getId());
        System.out.println(resp.getCliente().getCedula() + "----");
        
        Assert.assertNotNull(resp.getPuntoDeVenta());
        Assert.assertNotNull(resp.getCliente());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getComentario(), resp.getComentario());
        Assert.assertEquals(pojoEntity.getPuntaje(), resp.getPuntaje());
    
        /**
         * Prueba la actualizacion de una calificacion tienda con casos
         * de Excepcion:  id no existente
         */
        boolean exc = false;
        CalificacionTiendaEntity ct = data.get(0);
        CalificacionTiendaEntity var = new CalificacionTiendaEntity();
        var.setId(Long.MIN_VALUE);
        try{
            ctiendaLogic.updateCalificacionTienda(var);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        Assert.assertTrue(exc);
        
            
        /**
         * Prueba la actualizacion de una calificacion carro con casos
         * de Excepcion: puntaje invalido arriba
         */            
        boolean excep = false;
        CalificacionTiendaEntity varEx = data.get(1);
        var.setPuntaje(12.0);
        try{
            ctiendaLogic.updateCalificacionTienda(varEx);
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
        CalificacionTiendaEntity varExcep = data.get(1);
        var.setPuntaje(0.1);
        try{
            ctiendaLogic.updateCalificacionTienda(varEx);
        }
        catch(BusinessLogicException e){
            excepcion = true;
        }
        Assert.assertTrue(exc);
    }
    
    /**
     * Prueba de la obtención del cliente correspondiente a una calificacion
     * tienda
     */
    @Test
    public void getClienteTest(){
        for(int i= 0; i < data.size(); i++){
            ClienteEntity ce = ctiendaLogic.getCliente(data.get(i).getId());
            Assert.assertEquals(ce, clienteData.get(i));
        }
    }
    
    /**
     * Prueba de la obtención del punto de venta correspondiente a una 
     * calificacion tienda
     */
    @Test
    public void getPuntoDeVentaTest(){
        for(int i= 0; i < data.size(); i++){
            PuntoDeVentaEntity ce = ctiendaLogic.getPuntoVenta(data.get(i).getId());
            Assert.assertEquals(ce, puntoVentaData.get(i));
        }
    }
    
}
