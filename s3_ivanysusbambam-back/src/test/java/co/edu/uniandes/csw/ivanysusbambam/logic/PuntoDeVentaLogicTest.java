/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.PuntoDeVentaLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.PuntoDeVentaEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.PuntoDeVentaPersistence;
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
public class PuntoDeVentaLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PuntoDeVentaLogic puntoVentaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PuntoDeVentaEntity> data = new ArrayList<>();

    //private List<BookEntity> booksData = new ArrayList();
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
//        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
//        for (int i = 0; i < 3; i++) {
//            BookEntity books = factory.manufacturePojo(BookEntity.class);
//            em.persist(books);
//            booksData.add(books);
//        }
        for (int i = 0; i < 3; i++) {
            PuntoDeVentaEntity entity = factory.manufacturePojo(PuntoDeVentaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Editorial
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void createPuntoDeVentaTest() throws BusinessLogicException {
        PuntoDeVentaEntity newEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);
        System.out.println(newEntity.getTelefono());
        PuntoDeVentaEntity result = puntoVentaLogic.createPuntoDeVenta(newEntity);
        Assert.assertNotNull(result);
        PuntoDeVentaEntity entity = em.find(PuntoDeVentaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de Editorials
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
     * Prueba para consultar un Editorial
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
     * Prueba para eliminar un Editorial
     *
     *
     */
    @Test
    public void deletePuntoDeVentaTest() throws BusinessLogicException {
        PuntoDeVentaEntity entity = data.get(0);
        puntoVentaLogic.deletePuntoDeVenta(entity.getId());
        PuntoDeVentaEntity deleted = em.find(PuntoDeVentaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Editorial
     *
     *
     * @throws co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException
     */
    @Test
    public void updatePuntoDeVentaTest() throws BusinessLogicException {
        PuntoDeVentaEntity entity = data.get(0);
        PuntoDeVentaEntity pojoEntity = factory.manufacturePojo(PuntoDeVentaEntity.class);

        pojoEntity.setId(entity.getId());

        puntoVentaLogic.updatePuntoDeVenta(pojoEntity.getId(), pojoEntity);

        PuntoDeVentaEntity resp = em.find(PuntoDeVentaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }

//    /**
//     * Prueba para obtener una instancia de Books asociada a una instancia
//     * Editorial
//     *
//     *
//     */
//    @Test
//    public void getBooksTest() throws BusinessLogicException {
//        EditorialEntity entity = data.get(0);
//        BookEntity bookEntity = booksData.get(0);
//        BookEntity response = editorialLogic.getBook(entity.getId(), bookEntity.getId());
//
//        Assert.assertEquals(bookEntity.getId(), response.getId());
//        Assert.assertEquals(bookEntity.getName(), response.getName());
//        Assert.assertEquals(bookEntity.getDescription(), response.getDescription());
//        Assert.assertEquals(bookEntity.getIsbn(), response.getIsbn());
//        Assert.assertEquals(bookEntity.getImage(), response.getImage());
//    }
//
//    /**
//     * Prueba para obtener una colección de instancias de Books asociadas a una
//     * instancia Editorial
//     *
//     *
//     */
//    @Test
//    public void listBooksTest() {
//        List<BookEntity> list = editorialLogic.listBooks(data.get(0).getId());
//        Assert.assertEquals(1, list.size());
//    }
//
//    /**
//     * Prueba para asociar un Books existente a un Editorial
//     *
//     *
//     */
//    @Test
//    public void addBooksTest() {
//        EditorialEntity entity = data.get(0);
//        BookEntity bookEntity = booksData.get(1);
//        BookEntity response = editorialLogic.addBook(bookEntity.getId(), entity.getId());
//
//        Assert.assertNotNull(response);
//        Assert.assertEquals(bookEntity.getId(), response.getId());
//    }
//
//    /**
//     * Prueba para remplazar las instancias de Books asociadas a una instancia
//     * de Editorial
//     *
//     *
//     */
//    @Test
//    public void replaceBooksTest() {
//        EditorialEntity entity = data.get(0);
//        List<BookEntity> list = booksData.subList(1, 3);
//        editorialLogic.replaceBooks(entity.getId(), list);
//
//        entity = editorialLogic.getEditorial(entity.getId());
//        Assert.assertFalse(entity.getBooks().contains(booksData.get(0)));
//        Assert.assertTrue(entity.getBooks().contains(booksData.get(1)));
//        Assert.assertTrue(entity.getBooks().contains(booksData.get(2)));
//    }
//
//    /**
//     * Prueba para desasociar un Book existente de un Editorial existente
//     *
//     *
//     */
//    @Test
//    public void removeBooksTest() throws BusinessLogicException {
//        try {
//            editorialLogic.removeBook(data.get(0).getId(), booksData.get(0).getId());
//            BookEntity response = editorialLogic.getBook(data.get(0).getId(), booksData.get(0).getId());
//        } catch (BusinessLogicException e) {
//        }
//
//    }
}
