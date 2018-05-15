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
import co.edu.uniandes.csw.ivanysusbambam.entities.QuejaReclamoEntity;
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

    /**
     * Atributo para el podamFactory
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * Atriburo para la logia de venta
     */
    @Inject
    private VentaLogic ventaLogic;

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Atributo para el usertTransaction
     */
    @Inject
    private UserTransaction utx;

    /**
     * data de la venta
     */
    private List<VentaEntity> data = new ArrayList<VentaEntity>();

    /**
     * data del cliente
     */
    private List<ClienteEntity> ClienteData = new ArrayList<ClienteEntity>();

    /**
     * data del vendedor
     */
    private List<VendedorEntity> vendedorData = new ArrayList<VendedorEntity>();
    /**
     * data del automovil
     */
    private List<AutomovilEntity> automovilData = new ArrayList<AutomovilEntity>();
    /**
     * Data del calificacion Carro
     */
    private List<CalificacionCarroEntity> calificacionData = new ArrayList<CalificacionCarroEntity>();
    /**
     * data del punto de venta
     */
    private List<PuntoDeVentaEntity> puntoData = new ArrayList<PuntoDeVentaEntity>();
    /**
     * data del medio de pago
     */
    private List<MedioDePagoEntity> medioData = new ArrayList<MedioDePagoEntity>();

    /**
     * data de quejaReclamo
     */
    private List<QuejaReclamoEntity> quejaData = new ArrayList<QuejaReclamoEntity>();

    /**
     * Metodo para el deployment
     *
     * @return
     */
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
        em.createQuery("delete from QuejaReclamoEntity").executeUpdate();
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

            QuejaReclamoEntity queja = factory.manufacturePojo(QuejaReclamoEntity.class);
            em.persist(queja);
            quejaData.add(queja);
        }
        for (int i = 0; i < 3; i++) {
            VentaEntity entity = factory.manufacturePojo(VentaEntity.class);
            entity.setCliente(ClienteData.get(0));
            entity.setAutomovil(automovilData.get(0));
            entity.setCalificacionCarro(calificacionData.get(0));
            entity.setVendedorEncargado(vendedorData.get(0));
            entity.setMedioDePago(medioData.get(0));
            entity.setPuntoDeVenta(puntoData.get(0));
            entity.setQuejaReclamo(quejaData.get(0));

            Long id = i + 2L;
            entity.setId(id);

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
    public void createVentaTest() {

        VentaEntity newEntity1 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity2 = factory.manufacturePojo(VentaEntity.class);
        VentaEntity newEntity3 = factory.manufacturePojo(VentaEntity.class);
        Long id1 = 14L;
        Long id2 = 15L;
        Long id3 = 16L;
        newEntity1.setId(id1);
        newEntity2.setId(id2);
        newEntity3.setId(id3);
        newEntity1.setAutomovil(automovilData.get(0));
        newEntity1.setMedioDePago(medioData.get(0));
        newEntity1.setPuntoDeVenta(puntoData.get(0));
        newEntity1.setCliente(ClienteData.get(0));
        newEntity1.setQuejaReclamo(quejaData.get(0));

        boolean ex = false;
        try {
            VentaEntity result = ventaLogic.createVenta(newEntity1);
            Assert.assertNotNull(result);
            VentaEntity entity = em.find(VentaEntity.class, result.getId());
            Assert.assertEquals(newEntity1.getId(), entity.getId());
            Assert.assertEquals(newEntity1.getName(), entity.getName());
            Assert.assertEquals(newEntity1.getAutomovil(), entity.getAutomovil());
            Assert.assertEquals(newEntity1.getCalificacionCarro(), entity.getCalificacionCarro());
            Assert.assertEquals(newEntity1.getCliente(), entity.getCliente());
            Assert.assertEquals(newEntity1.getMedioDePago(), result.getMedioDePago());
            Assert.assertEquals(newEntity1.getPuntoDeVenta(), entity.getPuntoDeVenta());
            Assert.assertEquals(newEntity1.getVendedorEncargado(), entity.getVendedorEncargado());
            Assert.assertEquals(newEntity1.getQuejaReclamo(), result.getQuejaReclamo());
        } catch (BusinessLogicException e) {
            ex = true;
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
        entity.setMedioDePago(medioData.get(0));
        entity.getMedioDePago().setCliente(entity.getCliente());

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
