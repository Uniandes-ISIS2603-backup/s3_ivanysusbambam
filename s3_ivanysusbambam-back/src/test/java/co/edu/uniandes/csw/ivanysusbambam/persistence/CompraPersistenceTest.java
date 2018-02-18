/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.persistence;

import co.edu.uniandes.csw.ivanysusbambam.entities.CompraEntity;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author j.sierrac
 */
public class CompraPersistenceTest {
    
    public CompraPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CompraPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CompraEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompraPersistence instance = (CompraPersistence)container.getContext().lookup("java:global/classes/CompraPersistence");
        CompraEntity expResult = null;
        CompraEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CompraPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompraPersistence instance = (CompraPersistence)container.getContext().lookup("java:global/classes/CompraPersistence");
        List<CompraEntity> expResult = null;
        List<CompraEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CompraPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        int id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompraPersistence instance = (CompraPersistence)container.getContext().lookup("java:global/classes/CompraPersistence");
        CompraEntity expResult = null;
        CompraEntity result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CompraPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        CompraEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompraPersistence instance = (CompraPersistence)container.getContext().lookup("java:global/classes/CompraPersistence");
        CompraEntity expResult = null;
        CompraEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CompraPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        CompraEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CompraPersistence instance = (CompraPersistence)container.getContext().lookup("java:global/classes/CompraPersistence");
        instance.delete(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
