/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.logic;

import co.edu.uniandes.csw.ivanysusbambam.ejb.ClienteLogic;
import co.edu.uniandes.csw.ivanysusbambam.ejb.MedioDePagoLogic;
import co.edu.uniandes.csw.ivanysusbambam.entities.ClienteEntity;
import co.edu.uniandes.csw.ivanysusbambam.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.ivanysusbambam.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.ivanysusbambam.persistence.ClientePersistence;
import co.edu.uniandes.csw.ivanysusbambam.persistence.MedioDePagoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.AssertFalse;
import org.hibernate.validator.cfg.defs.AssertTrueDef;
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
public class MedioDePagoLogicTest {

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
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoLogic.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private MedioDePagoLogic mdpl;
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private ClienteEntity cliente;
    
    

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
        em.createQuery("delete from MedioDePagoEntity").executeUpdate();
    }

    private List<MedioDePagoEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {

            System.out.println("INSERTING DATA");
            MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);

            try {

                entity.setNumero((long) i + 1);
                cliente = factory.manufacturePojo(ClienteEntity.class);
                em.persist(cliente);
                entity.setCliente(cliente);
                mdpl.createMedioDePago(entity);

                data.add(entity);

                System.out.println("DATA INSERTED");
            } catch (Exception e) {
                i--;
                System.out.println(i);
            }
        }
        System.out.println("DATA SIZE AFT INS: " + data.size());
    }

    @Test
    public void createMedioDePagoTest() {
        MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);
        boolean ex = false;
        try {
            entity.setCliente(cliente);
            MedioDePagoEntity result = mdpl.createMedioDePago(entity);
             Assert.assertNotNull(result);
             
            
        } 
        catch (BusinessLogicException exepcion) {
            ex=true;
        }
        if(em.find(ClienteEntity.class, cliente.getCedula())!=null && entity.validarTipoMedioDePago())
        {
            Assert.assertFalse(ex);
        }
        else
        {
            Assert.assertTrue(ex);
        }

    }
    @Test
    public void findTest()
    {
          MedioDePagoEntity entity = factory.manufacturePojo(MedioDePagoEntity.class);
         
            boolean ex = false;
            try
            {
                 entity.setCliente(cliente);
             mdpl.createMedioDePago(entity);
             MedioDePagoEntity result= mdpl.find(entity.getNumero());
             Assert.assertNotNull(result);
             
            }
            catch(BusinessLogicException excep)
            {
                ex=true;
            }
            if(entity.getNumero()==null)
            {
                Assert.assertTrue(ex);
            }
            else
            {
                Assert.assertFalse(ex);
            }
            
    }
}


