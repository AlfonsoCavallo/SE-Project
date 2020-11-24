/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.awt.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utente
 */
public class UserAccessRepoTest
{
    
    public UserAccessRepoTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of queryAllUserAccesses method, of class UserAccessRepo.
     */
    @Test
    public void testQueryAllUserAccesses()
    {
        System.out.println("queryAllUserAccesses");
        UserAccessRepo instance = new UserAccessRepo();
        List expResult = null;
        List result = instance.queryAllUserAccesses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of queryUserAccesses method, of class UserAccessRepo.
     */
    @Test
    public void testQueryUserAccesses()
    {
        System.out.println("queryUserAccesses");
        String username = "";
        UserAccessRepo instance = new UserAccessRepo();
        List expResult = null;
        List result = instance.queryUserAccesses(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeUserAccess method, of class UserAccessRepo.
     */
    @Test
    public void testStoreUserAccess()
    {
        System.out.println("storeUserAccess");
        UserAccess userAccess = null;
        UserAccessRepo instance = new UserAccessRepo();
        instance.storeUserAccess(userAccess);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeCurrentUserAccess method, of class UserAccessRepo.
     */
    @Test
    public void testStoreCurrentUserAccess()
    {
        System.out.println("storeCurrentUserAccess");
        String username = "";
        UserAccessRepo instance = new UserAccessRepo();
        instance.storeCurrentUserAccess(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
