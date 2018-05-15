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
    
    private List<ArrayList<VentaEntity>> dataVentas = new ArrayList<ArrayList<VentaEntity>>();
    private List<ArrayList<CompraEntity>> dataCompras = new ArrayList<ArrayList<CompraEntity>>();
    private List<ArrayList<AutomovilEntity>> dataAutos = new ArrayList<ArrayList<AutomovilEntity>>();
    private List<ArrayList<VendedorEntity>> dataVendedores = new ArrayList<ArrayList<VendedorEntity>>();

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
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();
//        em.createQuery("delete from VentaEntity").executeUpdate();
        em.createQuery("delete from CompraEntity").executeUpdate();
        em.createQuery("delete from VendedorEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();
    }

    
    /**
     * Metodo auxiliar que crea un ArrayList de autos para un punto de venta
     * 
     */
    private ArrayList<AutomovilEntity> generarAutos(){
        ArrayList<AutomovilEntity> carros = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            AutomovilEntity ae = factory.manufacturePojo(AutomovilEntity.class);
            em.persist(ae);
            carros.add(ae);
        }
        return carros;
    }
    
    /**
     * Metodo auxiliar que crea un ArrayList de compras para un punto de venta
     * 
     */
    private ArrayList<CompraEntity> generarCompras(){
        ArrayList<CompraEntity> compras = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            CompraEntity ce = factory.manufacturePojo(CompraEntity.class);
            em.persist(ce);
            compras.add(ce);
        }
        return compras;
    }
    
//    /**
//     * Metodo auxiliar que crea un ArrayList de ventas para un punto de venta
//     * 
//     */
//    private ArrayList<VentaEntity> generarVentas(){
//        ArrayList<VentaEntity> ventas = new ArrayList<>();
//        
//        for(int i = 0; i < 3; i++){
//            VentaEntity ve = factory.manufacturePojo(VentaEntity.class);
//            em.persist(ve);
//            ventas.add(ve);
//        }
//        return ventas;
//    }
//    
    /**
     * Metodo auxiliar que crea un ArrayList de vendedores para un punto de venta
     * 
     */
    private ArrayList<VendedorEntity> generarVendedores(){
        ArrayList<VendedorEntity> vendedores = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            VendedorEntity vse = factory.manufacturePojo(VendedorEntity.class);
            em.persist(vse);
            vendedores.add(vse);
        }
        return vendedores;
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData(){

        for (int i = 0; i < 3; i++) {
            PuntoDeVentaEntity entity = factory.manufacturePojo(PuntoDeVentaEntity.class);
            
            ArrayList<AutomovilEntity> carros = generarAutos();
            dataAutos.add(i, carros);
            entity.setAutomoviles(dataAutos.get(i));
            
//            ArrayList<VentaEntity> ventas = generarVentas();
//            dataVentas.add(i, ventas);
//            entity.setVentas(dataVentas.get(i));
//            
            ArrayList<CompraEntity> compras = generarCompras();
            dataCompras.add(i, compras);
            entity.setCompras(dataCompras.get(i));
            
            ArrayList<VendedorEntity> vendedores = generarVendedores();
            dataVendedores.add(i, vendedores);
            entity.setVendedores(dataVendedores.get(i));
            
            em.persist(entity);
            data.add(entity);
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
    }

    @Test
    public void createPuntoDeVentaExceptionTest(){
        PuntoDeVentaEntity pv = new PuntoDeVentaEntity();
        //Datos cableados para generar error a la hora de crearlo
        pv.setDireccion("cll 12 # 23 - 4");
        pv.setName("Missouri");
        pv.setTelefono(12);
        PuntoDeVentaEntity result;
        boolean exc = false;
        try{
            result = puntoVentaLogic.createPuntoDeVenta(pv);
        }
        catch(BusinessLogicException ex){
            exc = true;
        }
        
        Assert.assertTrue(exc);
    
    }
    /**
     * Prueba para consultar la lista de puntos de venta
     *
     *
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
     *
     *
     */
    @Test
    public void getPuntoDeVentaTest() {
        PuntoDeVentaEntity entity = data.get(0);
        PuntoDeVentaEntity resultEntity = puntoVentaLogic.getPuntoDeVenta(entity.getId());
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
    }
    
    /**
     * Prueba la eliminacion de un punto de venta con
     * Caso de excepcion: id inexistente
     */
    @Test
    public void deletePuntoDeVentaExceptionTest(){
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
    }
    
    /**
     * Prueba la actualizacion de un punto de venta con casos
     * de Excepcion: telefono, id no existente
     */
    @Test
    public void updatePuntoDeVentaExceptionTest(){
        
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
    public void PuntoDeVentaGetAutosTest(){
        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).getAutomoviles().size(); j++){
                AutomovilEntity org = dataAutos.get(i).get(j);
                AutomovilEntity obt = data.get(i).getAutomoviles().get(j);
                Assert.assertEquals(org, obt);
            }
        }
    }
    
    /**
     * Prueba la solicitud de todas las compras de un punto de venta
     */
    @Test
    public void PuntoDeVentaGetComprasTest(){
        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).getCompras().size(); j++){
                CompraEntity org = dataCompras.get(i).get(j);
                CompraEntity obt = data.get(i).getCompras().get(j);
                Assert.assertEquals(org, obt);
            }
        }
    }
    
    /**
     * Prueba la solicitud de todos los vendedores de un punto de venta
     */
    @Test
    public void PuntoDeVentaGetVendedoresTest(){
        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).getVendedores().size(); j++){
                VendedorEntity org = dataVendedores.get(i).get(j);
                VendedorEntity obt = data.get(i).getVendedores().get(j);
                Assert.assertEquals(org, obt);
            }
        }
    }
}
