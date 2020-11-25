/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.DatabaseTesting.*;
import se.project.storage.models.UserAccess;
import se.project.storage.repos.UserAccessRepo;

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
        resetDatabase();
    }
    
    @After
    public void tearDown()
    {
        try
        {
            closeConnection();
        }
        catch (SQLException ex)
        {
            
        }
    }

    @Test
    public void testQueryAllUserAccesses()
    {
        // Tests the query of all user accesses
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo();
            LinkedList<UserAccess> userAccesses = instance.queryAllUserAccesses();
            
            // Tests expected elements
            UserAccess expectedFirstElement = new UserAccess(1, "finneas", LocalDateTime.of(2020, Month.NOVEMBER, 26, 15, 30, 2, 0));
            assertEquals(userAccesses.getFirst(), expectedFirstElement);
            
            UserAccess expectedLastElement = new UserAccess(2, "jon", LocalDateTime.of(2020, Month.NOVEMBER, 25, 15, 00, 0, 0));
            assertEquals(userAccesses.getLast(), expectedLastElement);
            
            closeConnection();
        }
        catch (IOException | SQLException | ClassNotFoundException ex)
        {
            fail();
        }
    }

    @Test
    public void testQueryUserAccesses()
    {
        
    }

    @Test
    public void testStoreUserAccess()
    {
        
    }

    @Test
    public void testStoreCurrentUserAccess()
    {
        
    }
    
}
