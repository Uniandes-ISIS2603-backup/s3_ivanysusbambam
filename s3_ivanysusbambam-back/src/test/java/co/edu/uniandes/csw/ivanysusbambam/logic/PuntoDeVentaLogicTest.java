/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.PuntoDeVentaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
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
public class PuntoDeVentaLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PuntoDeVentaLogic puntoVentaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PuntoDeVentaEntity> data = new ArrayList<>();
    
    private List<VentaEntity> dataVentas = new ArrayList<>();
    private List<CompraEntity> dataCompras = new ArrayList<>();
    private List<AutomovilEntity> dataAutos = new ArrayList<>();
    private List<VendedorEntity> dataVendedores = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoDeVentaEntity.class.getPackage())
                .addPackage(PuntoDeVentaLogic.class.getPackage())
                .addPackage(PuntoDeVentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
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

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     */
    private void clearData() {
        em.createQuery("delete from VendedorEntity").executeUpdate();        
//        em.createQuery("delete from VentaEntity").executeUpdate();       
        em.createQuery("delete from CompraEntity").executeUpdate();        
        em.createQuery("delete from AutomovilEntity").executeUpdate();
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData(){
        for(int i = 0; i < 9; i++){
            AutomovilEntity autos = factory.manufacturePojo(AutomovilEntity.class);
            em.persist(autos);
            dataAutos.add(autos);
        }
        for(int i = 0; i < 9; i++){
            VendedorEntity vendedores = factory.manufacturePojo(VendedorEntity.class);
            em.persist(vendedores);
            dataVendedores.add(vendedores);
        }

//        for(int i = 0; i < 9; i++){
//            VentaEntity ventas = factory.manufacturePojo(VentaEntity.class);
//            em.persist(ventas);
//            dataVentas.add(ventas);
//        }
                
        for(int i = 0; i < 9; i++){
            CompraEntity compras = factory.manufacturePojo(CompraEntity.class);
            em.persist(compras);
            dataCompras.add(compras);
        }
        
        for (int i = 0; i < 3; i++) {
            PuntoDeVentaEntity entity = factory.manufacturePojo(PuntoDeVentaEntity.class);
     
            em.persist(entity);
            data.add(entity);
            switch (i) {
                case 0:
                    for(int j = 0; j < 3; j++){
                        dataAutos.get(j).setPuntoDeVenta(entity);
                        dataVendedores.get(j).setPuntoDeVenta(entity);
                        dataCompras.get(j).setPuntoDeVenta(entity);
//                        dataVentas.get(j).setPuntoDeVenta(entity);
                    }   break;
                case 1:
                    for(int j = 3; j < 6; j++){
                        dataAutos.get(j).setPuntoDeVenta(entity);
                        dataVendedores.get(j).setPuntoDeVenta(entity);
                        dataCompras.get(j).setPuntoDeVenta(entity);
//                        dataVentas.get(j).setPuntoDeVenta(entity);
                    }   break;
                case 2:
                    for(int j = 3; j < 6; j++){
                        dataAutos.get(j).setPuntoDeVenta(entity);
                        dataVendedores.get(j).setPuntoDeVenta(entity);
                        dataCompras.get(j).setPuntoDeVenta(entity);
//                        dataVentas.get(j).setPuntoDeVenta(entity);
                    }   break;
                default:
                    break;
            }
        }
    }

    /**
     * Prueba para crear un punto de venta
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void createPuntoDeVentaTest(){
        PuntoDeVentaEntity newEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);
        PuntoDeVentaEntity result;
        try {
            result = puntoVentaLogic.createPuntoDeVenta(newEntity);
            Assert.assertNotNull(result);
            PuntoDeVentaEntity entity = em.find(PuntoDeVentaEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
        } catch (BusinessLogicException ex) {
            System.out.println("no debería arrojar excepcion");
            Logger.getLogger(PuntoDeVentaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /**
         * Prueba el caso de error para crear un punto de  venta
         * Excepcion: telefono inválido
         */
        PuntoDeVentaEntity pv = new PuntoDeVentaEntity();
        //Datos cableados para generar error a la hora de crearlo
        pv.setDireccion("cll 12 # 23 - 4");
        pv.setName("Missouri");
        pv.setTelefono(12);
        PuntoDeVentaEntity resultB;
        boolean exc = false;
        try{
            resultB = puntoVentaLogic.createPuntoDeVenta(pv);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        
        Assert.assertTrue(exc);
    
    }
    
    /**
     * Prueba para consultar la lista de puntos de venta
     */
    @Test
    public void getPuntosDeVentaTest() {
        List<PuntoDeVentaEntity> list = puntoVentaLogic.getPuntosDeVenta();
        Assert.assertEquals(data.size(), list.size());
        for (PuntoDeVentaEntity entity : list) {
            boolean found = false;
            for (PuntoDeVentaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un punto de venta
     */
    @Test
    public void getPuntoDeVentaTest() {
        PuntoDeVentaEntity entity = data.get(0);
        PuntoDeVentaEntity resultEntity = puntoVentaLogic.getPuntoDeVenta(entity.getId());
        
        Assert.assertNotNull(resultEntity.getAutomoviles());
        Assert.assertNotNull(resultEntity.getAutomoviles().get(0));
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para eliminar un punto de venta
     *
     *
     */
    @Test
    public void deletePuntoDeVentaTest(){
        PuntoDeVentaEntity entity = data.get(0);
        try {
            puntoVentaLogic.deletePuntoDeVenta(entity.getId());
            PuntoDeVentaEntity deleted = em.find(PuntoDeVentaEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(PuntoDeVentaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /**
        * Prueba la eliminacion de un punto de venta con
        * Caso de excepcion: id inexistente
        */
        boolean exc = false;
        try{
            puntoVentaLogic.deletePuntoDeVenta(Long.MIN_VALUE);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        
        Assert.assertTrue(exc);
    }
    
    /**
     * Prueba para actualizar un punto de venta
     *
     */
    @Test
    public void updatePuntoDeVentaTest(){
        PuntoDeVentaEntity entity = data.get(0);
        PuntoDeVentaEntity pojoEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);
        pojoEntity.setId(entity.getId());
        try {
            puntoVentaLogic.updatePuntoDeVenta(pojoEntity);
            PuntoDeVentaEntity resp = em.find(PuntoDeVentaEntity.class, entity.getId());
            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getName(), resp.getName());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(PuntoDeVentaLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /**
        * Prueba la actualizacion de un punto de venta con casos
        * de Excepcion: telefono, id no existente
        */
        boolean exc = false;
        PuntoDeVentaEntity pv = data.get(0);
        PuntoDeVentaEntity var = new PuntoDeVentaEntity();
        var.setId(Long.MIN_VALUE);
        var.setTelefono(12);
        var.setName("Missouri");
        var.setTelefono(12);
        try{
            puntoVentaLogic.updatePuntoDeVenta(var);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        Assert.assertTrue(exc);
    }
    
    /**
     * Prueba la solicitud de todos los autos de un punto de venta
     */
    @Test
    public void listAutosTest(){
        List<AutomovilEntity> list = puntoVentaLogic.listAutos(data.get(0).getId());
        Assert.assertEquals(3, list.size());
    }
    
//    /**
//     * Prueba la solicitud de todas las ventas de un punto de venta
//     */
//    @Test
//    public void listVentasTest(){
//        List<VentaEntity> list = puntoVentaLogic.listVentas(data.get(0).getId());
//        Assert.assertEquals(3, list.size());
//    }
    
    /**
     * Prueba la solicitud de todos los vendedores de un punto de venta
     */
    @Test
    public void listVendedoresTest(){
        List<VendedorEntity> list = puntoVentaLogic.listVendedores(data.get(0).getId());
        Assert.assertEquals(3, list.size());
    }
    
    /**
     * Prueba la solicitud de todas las compras de un punto de venta
     */
    @Test
    public void listComprasTest(){
        List<CompraEntity> list = puntoVentaLogic.listCompras(data.get(0).getId());
        Assert.assertEquals(3, list.size());
    }
    
}
