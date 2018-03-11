/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.VentaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.CalificacionCarroEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VendedorEntity;

import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.VentaPersistence;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author hd.castellanos
 */
@RunWith(Arquillian.class)
public class VentaLogicTest {

   private  PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private VentaLogic ventaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<VentaEntity> data = new ArrayList<VentaEntity>();

    private List<ClienteEntity> ClienteData = new ArrayList<ClienteEntity>();

    private List<VendedorEntity> vendedorData = new ArrayList<VendedorEntity>();
    private List<AutomovilEntity> automovilData = new ArrayList<AutomovilEntity>();
    private List<CalificacionCarroEntity> calificacionData = new ArrayList<CalificacionCarroEntity>();
    private List<PuntoDeVentaEntity> puntoData = new ArrayList<PuntoDeVentaEntity>();
    private List<MedioDePagoEntity> medioData = new ArrayList<MedioDePagoEntity>();
    
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VentaEntity.class.getPackage())
                .addPackage(VentaLogic.class.getPackage())
                .addPackage(VentaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * ConfiguraciÃ³n inicial de la prueba.
     *
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
     * Limpia las tablas que estÃ¡n implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from VentaEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();
        em.createQuery("delete from VendedorEntity").executeUpdate();
        em.createQuery("delete from CalificacionCarroEntity").executeUpdate();
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            em.persist(cliente);
            ClienteData.add(cliente);
            
            AutomovilEntity auto = factory.manufacturePojo(AutomovilEntity.class);
            em.persist(auto);
            automovilData.add(auto);
            
            VendedorEntity vendedor = factory.manufacturePojo(VendedorEntity.class);
            em.persist(vendedor);
            vendedorData.add(vendedor);
            
            CalificacionCarroEntity calificacion = factory.manufacturePojo(CalificacionCarroEntity.class);
            em.persist(calificacion);
            calificacionData.add(calificacion);
            
            PuntoDeVentaEntity Punto = factory.manufacturePojo(PuntoDeVentaEntity.class);
            em.persist(Punto);
            puntoData.add(Punto);
            
            MedioDePagoEntity medio = factory.manufacturePojo(MedioDePagoEntity.class);
            em.persist(medio);
            medioData.add(medio);
        }
        for (int i = 0; i < 3; i++) {
            VentaEntity entity = factory.manufacturePojo(VentaEntity.class);
            entity.setCliente(ClienteData.get(0));
            entity.setAutomovil(automovilData.get(0));
            entity.setCalificacionCarro(calificacionData.get(0));
            entity.setVendedorEncargado(vendedorData.get(0));
            entity.setMedioDePago(medioData.get(0));
            entity.setPuntoDeVenta(puntoData.get(0));

            em.persist(entity);
            data.add(entity);
            
        }
    }

    /**
     * Prueba para crear un Book
     *
     *
     */
    @Test
    public void createVentaTest()   {
          
        VentaEntity newEntity = factory.manufacturePojo(VentaEntity.class);
        
        
        boolean ex = false;
          try{
        VentaEntity result = ventaLogic.createVenta(newEntity);
        Assert.assertNotNull(result);
        VentaEntity entity = em.find(VentaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());}
           catch(BusinessLogicException e) 
        {
            ex =true;
        }
        
        
        
     
    }

    /**
     * Prueba para consultar la lista de Books
     *
     *
     */
    @Test
    public void getVentasTest() {
        List<VentaEntity> list = ventaLogic.findAllVentas();
        Assert.assertEquals(data.size(), list.size());
        for (VentaEntity entity : list) {
            boolean found = false;
            for (VentaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Book
     *
     *
     */
    @Test
    public void getVentaTest() throws BusinessLogicException {
        VentaEntity entity = data.get(0);
        VentaEntity resultEntity = ventaLogic.findVenta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        
    }

    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteVentaTest() throws BusinessLogicException {
        VentaEntity entity = data.get(0);
        ventaLogic.deleteVenta(entity.getId());
        VentaEntity deleted = em.find(VentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book
     *
     *
     */
    @Test
    public void updateVentaTest() throws BusinessLogicException {
        VentaEntity entity = data.get(0);
        VentaEntity pojoEntity = factory.manufacturePojo(VentaEntity.class);

        pojoEntity.setId(entity.getId());
        pojoEntity.setCliente(entity.getCliente());
        pojoEntity.setVendedorEncargado(entity.getVendedorEncargado());
        
        pojoEntity.setAutomovil(entity.getAutomovil());
       pojoEntity.setPuntoDeVenta(entity.getPuntoDeVenta());
        pojoEntity.setMedioDePago(entity.getMedioDePago());
        ventaLogic.updateVenta(pojoEntity);

        

        
    }    
}
