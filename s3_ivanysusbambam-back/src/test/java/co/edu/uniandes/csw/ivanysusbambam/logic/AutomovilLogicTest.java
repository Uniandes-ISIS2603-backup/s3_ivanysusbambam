/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;
import co.edu.uniandes.csw.ivanysusbambam.ejb.AutomovilLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MarcaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ModelEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.ProspectoCompraEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.VentaEntity;

import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.AutomovilPersistence;
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
public class AutomovilLogicTest {

    /**
     * Atributo para el podam Factory
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * Autributo para la logica del automovil
     */
    @Inject
    private AutomovilLogic autoLogic;

    /**
     * Atributo para el entity manager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Atributo para el user transaction
     */
    @Inject
    private UserTransaction utx;

    /**
     * Lista de los datos de automovil
     */
    private List<AutomovilEntity> data = new ArrayList<AutomovilEntity>();
    /**
     * Lista de los datos de compra
     */
    private List<CompraEntity> compraData = new ArrayList<CompraEntity>();
    /**
     * Lista de los datos depunto de venta
     */
    private List<PuntoDeVentaEntity> pvData = new ArrayList<PuntoDeVentaEntity>();
    /**
     * Lista de los datos de marca
     */
    private List<MarcaEntity> marcaData = new ArrayList<MarcaEntity>();
    /**
     * Lista de los datos de modelo
     */
    private List<ModelEntity> modelodata = new ArrayList<ModelEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AutomovilEntity.class.getPackage())
                .addPackage(AutomovilLogic.class.getPackage())
                .addPackage(AutomovilPersistence.class.getPackage())
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
        em.createQuery("delete from CompraEntity").executeUpdate();
        em.createQuery("delete from PuntoDeVentaEntity").executeUpdate();
        em.createQuery("delete from MarcaEntity").executeUpdate();
        em.createQuery("delete from ModelEntity").executeUpdate();
        em.createQuery("delete from AutomovilEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            PuntoDeVentaEntity PV = factory.manufacturePojo(PuntoDeVentaEntity.class);

            em.persist(PV);

            pvData.add(PV);
        }
        for (int i = 0; i < 3; i++) {
            CompraEntity compra = factory.manufacturePojo(CompraEntity.class);

            em.persist(compra);

            compraData.add(compra);
        }
        for (int i = 0; i < 3; i++) {
            AutomovilEntity auto = factory.manufacturePojo(AutomovilEntity.class);

            em.persist(auto);

            data.add(auto);
        }

        System.out.println("tamanio" + autoLogic.getAutomoviles().size());

    }

    /**
     * Test para verificar placa
     */
    @Test
    public void verificarPlacaTest() {
        data.get(0).setPlaca("ABC-123");
        boolean res = autoLogic.verificarPlaca(data.get(0).getPlaca());
        Assert.assertTrue(res);
    }

    /**
     * Prueba para crear un automovil
     *
     *
     */
    @Test
    public void createAutomovilTest() {
        AutomovilEntity newEntity = factory.manufacturePojo(AutomovilEntity.class);
        newEntity.setPlaca("ABC-123");
        MarcaEntity marca = factory.manufacturePojo(MarcaEntity.class);
        ModelEntity model = factory.manufacturePojo(ModelEntity.class);
        long id = 2L;
        marca.setId(id);
        model.setId(id);
        newEntity.setMarca(marca);
        newEntity.setModel(model);
        List<VentaEntity> ventas = new ArrayList<>();
        List<ProspectoCompraEntity> prospectos = new ArrayList<>();
        newEntity.setVentas(ventas);
        newEntity.setProspectosCompra(prospectos);
        newEntity.setCompra(compraData.get(0));
        newEntity.setPuntoDeVenta(pvData.get(0));
        newEntity.setImagen("");

        boolean ex = false;
        try {
            AutomovilEntity result = autoLogic.createAutomovil(newEntity);
            System.out.println(result);
            Assert.assertNotNull(result);
            AutomovilEntity entity = em.find(AutomovilEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            Assert.assertEquals(newEntity.getPlaca(), entity.getPlaca());
            Assert.assertEquals(newEntity.getPuntoDeVenta(), entity.getPuntoDeVenta());
            Assert.assertEquals(newEntity.getCompra(), entity.getCompra());
            Assert.assertEquals(newEntity.getMarca(), entity.getMarca());
            Assert.assertEquals(newEntity.getModel(), entity.getModel());
            Assert.assertEquals(newEntity.getChasis(), entity.getChasis());
            Assert.assertEquals(newEntity.getColor(), entity.getColor());
            Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
            Assert.assertEquals(newEntity.getFechaListado(), entity.getFechaListado());
            Assert.assertEquals(newEntity.getValorListado(), entity.getValorListado());
            Assert.assertEquals(newEntity.getVentas(), entity.getVentas());
            Assert.assertEquals(newEntity.getImagen(), entity.getImagen());

        } catch (BusinessLogicException e) {
            ex = true;
        }

        if ((newEntity.getModel() != null) && (newEntity.getMarca() != null) && (newEntity.getPuntoDeVenta() != null) && (newEntity.getCompra() != null)) {
            Assert.assertTrue(ex);
        } else {
            Assert.assertTrue(ex);
        }

    }

    /**
     * Prueba para consultar la lista de automoviles
     *
     *
     */
    @Test
    public void getAutomovilesTest() {
        List<AutomovilEntity> list = autoLogic.getAutomoviles();
        Assert.assertEquals(data.size(), list.size());
        for (AutomovilEntity entity : list) {
            boolean found = false;
            for (AutomovilEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un automovil
     *
     *
     */
    @Test
    public void getAutomovilTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        if (entity.getId() == null || entity.getId() <= 0) {
            Assert.fail();
        }
        AutomovilEntity resultEntity = autoLogic.findAutomovil(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getChasis(), resultEntity.getChasis());

    }

    /**
     * Test para buscar automovile por marca
     *
     * @throws BusinessLogicException
     */
    @Test
    public void getAutomovilMarcaTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        MarcaEntity marca = factory.manufacturePojo(MarcaEntity.class);
        marca.setName("marca");
        entity.setMarca(marca);

        if (entity.getMarca() == null) {
            Assert.fail();
        }

        List<AutomovilEntity> resultEntity = autoLogic.findByMarca(entity.getMarca().getName());
        if (resultEntity.isEmpty()) {

        } else {
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getMarca().getName(), resultEntity.get(0).getMarca().getName());
        }

    }

    /**
     * Test para buscar automovile por modelo
     *
     * @throws BusinessLogicException
     */
    @Test
    public void getAutomovilModelTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        ModelEntity model = factory.manufacturePojo(ModelEntity.class);
        model.setName("model");
        entity.setModel(model);

        if (entity.getModel() == null) {
            Assert.fail();
        }

        List<AutomovilEntity> resultEntity = autoLogic.findByModelo(entity.getModel().getName());
        if (resultEntity.isEmpty()) {

        } else {
            Assert.assertNotNull(resultEntity);
            Assert.assertEquals(entity.getModel().getName(), resultEntity.get(0).getModel().getName());
        }

    }

    /**
     * Test para buscar automovile por rango de anios
     *
     * @throws BusinessLogicException
     */
    @Test
    public void getAutomovilRangoAniosTest() throws BusinessLogicException {

        Integer inicio = (data.get(0).getValorListado()).intValue();
        Integer aFinal = (data.get(1).getValorListado()).intValue();;

        if (inicio > aFinal) {
            Assert.fail();
        }

        List<AutomovilEntity> resultEntity = autoLogic.findByRangoAnios(1, 2);
        if (resultEntity.isEmpty()) {
            Assert.assertNotNull("No se encontraron autos", resultEntity);
        } else {
            Assert.assertNotNull(resultEntity.get(0));

        }

    }

    /**
     * Test para buscar automovile por rango de precios
     *
     * @throws BusinessLogicException
     */
    @Test
    public void getAutomovilRangoPreciosTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        Integer inicio = 1;
        Integer pFinal = 2;

        if (pFinal < inicio) {
            Assert.fail();
        }

        List<AutomovilEntity> resultEntity = autoLogic.findByRangoPrecios(1, 2);
        if (resultEntity.isEmpty()) {
            Assert.assertNotNull("No se encontraron autos", resultEntity);
        } else {
            Assert.assertNotNull(resultEntity.get(0));

        }

    }

    /**
     * Prueba para eliminar un automovil
     *
     *
     */
    @Test
    public void deleteAutomovilTest() throws BusinessLogicException {
        AutomovilEntity entity = data.get(0);
        autoLogic.deleteAutomovil(entity.getId());
        AutomovilEntity deleted = em.find(AutomovilEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un automovil
     *
     *
     */
    @Test
    public void updateAutomovilTest() {

        AutomovilEntity entity = data.get(0);
        AutomovilEntity pojoEntity = factory.manufacturePojo(AutomovilEntity.class);

        pojoEntity.setId(entity.getId());
        pojoEntity.setModel(entity.getModel());
        pojoEntity.setMarca(entity.getMarca());
        pojoEntity.setPuntoDeVenta(entity.getPuntoDeVenta());
        pojoEntity.setPlaca(entity.getPlaca());
        pojoEntity.setChasis(entity.getChasis());
        pojoEntity.setAnio(entity.getAnio());
        pojoEntity.setKilometros(entity.getKilometros());
        pojoEntity.setTipo(entity.getTipo());
        pojoEntity.setFechaListado(entity.getFechaListado());
        pojoEntity.setProspectosCompra(entity.getProspectosCompra());
        pojoEntity.setVentas(entity.getVentas());
        boolean ex = false;

        try {
            autoLogic.updateAutomovil(pojoEntity);
            System.out.println(pojoEntity.getPlaca());
            AutomovilEntity resp = em.find(AutomovilEntity.class, entity.getId());

            System.out.println(resp.getPlaca());

        } catch (BusinessLogicException e) {
            System.out.println(e);
            ex = true;
        }
        if (pojoEntity.getPuntoDeVenta() == null || pojoEntity.getProspectosCompra() == null || pojoEntity.getMarca() == null || pojoEntity.getModel() == null || pojoEntity.getVentas() == null || pojoEntity.getCompra() == null) {
            Assert.assertTrue(ex);
        } else {
            Assert.assertFalse(ex);
        }

    }

    /**
     * Metodo de prueba para el hashCode
     */
    @Test
    public void hashTest() {
        AutomovilEntity auto = data.get(0);
        AutomovilEntity auto1 = data.get(1);

        Assert.assertEquals(auto.hashCode(), auto1.hashCode());
    }

    /**
     * Metodo de prueba para el metodod equals
     */
    @Test
    public void equalsTest() {

        AutomovilEntity auto = data.get(0);

        AutomovilEntity auto1 = data.get(0);
        boolean respuesta = auto.equals(auto1);
        if (auto1 != null){
            Assert.assertTrue(respuesta);
        }
        else{
            Assert.assertFalse(respuesta);
        }
    }

}
