/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;


import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
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
 * @author juliana
 */
@RunWith(Arquillian.class)
public class MedioDePagoPersistenceTest {

    @Inject
    private MedioDePagoPersistence mdp;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    /**
     * Lista de compras
     */
    private List<MedioDePagoEntity> data = new ArrayList<MedioDePagoEntity>();

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
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

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

   

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();

    }
    
   /**
     * Prueba para eliminar un medio de pago.
     *
     *
     */
    @Test
     public void deleteMedioDePagoTest() {
         
        MedioDePagoEntity entity = data.get(0);
        mdp.delete(entity.getNumero());
        MedioDePagoEntity deleted = em.find(MedioDePagoEntity.class, entity.getNumero());
        Assert.assertNull(deleted);
     }
     
      /**
     * Prueba para crear un Medio de pago.
     */
    @Test
    public void createMedioDePagoTest() {

        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity newEntity = factory.manufacturePojo(MedioDePagoEntity.class);
        MedioDePagoEntity result = mdp.create(newEntity);

        Assert.assertNotNull(result);

        MedioDePagoEntity entity = em.find(MedioDePagoEntity.class, result.getNumero());

       
    }
    /**
     * Prueba para consultar la lista de medios de pagos.
     *
     *
     */
    @Test
    public void getMedioDePagoTest() {
        
        List<MedioDePagoEntity> list = mdp.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MedioDePagoEntity ent : list) {
            boolean found = false;
            for (MedioDePagoEntity entity : data) {
                if (ent.getNumero().equals(entity.getNumero())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
    /**
     * Prueba para actualizar un medio de pago.
     *
     *
     */
    @Test
    public void updateCompraTest() {
        MedioDePagoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity newEntity = factory.manufacturePojo(MedioDePagoEntity.class);

        newEntity.setNumero(entity.getNumero());

        mdp.update(newEntity);

       MedioDePagoEntity resp = em.find(MedioDePagoEntity.class, entity.getNumero());

     
        }
    
    
}
