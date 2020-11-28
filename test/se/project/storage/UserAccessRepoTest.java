/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.postgresql.util.PSQLException;
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
            assertEquals(expectedFirstElement, userAccesses.getFirst());
            
            UserAccess expectedLastElement = new UserAccess(2, "jon", LocalDateTime.of(2020, Month.NOVEMBER, 25, 15, 00, 0, 0));
            assertEquals(expectedLastElement, userAccesses.getLast());
            
            closeConnection();
        }
        catch(IOException | SQLException | ClassNotFoundException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    @Test
    public void testQueryUserAccesses()
    {
        // Tests the query of specific user accesses
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo();
            LinkedList<UserAccess> userAccesses = instance.queryUserAccesses("finneas");
            
            // Tests expected elements
            UserAccess expectedFirstElement = new UserAccess(1, "finneas", LocalDateTime.of(2020, Month.NOVEMBER, 26, 15, 30, 2, 0));
            assertEquals(userAccesses.size(), 1);
            assertEquals(expectedFirstElement, userAccesses.getFirst());
            
            // Tests unavailable user
            userAccesses = instance.queryUserAccesses("unavailable_user");
            assertEquals(0, userAccesses.size());
            closeConnection();
        }
        catch(SQLException | ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    @Test
    public void testStoreUserAccess()
    {
        // Tests the query of all user accesses
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo();
            UserAccess modelToStore = new UserAccess(3, "finneas", LocalDateTime.of(2020, Month.DECEMBER, 2, 18, 15, 0, 0));
            
            
            // Tests correct insertion
            instance.storeUserAccess(modelToStore);
            LinkedList<UserAccess> userAccesses = instance.queryUserAccesses("finneas");
            assertEquals(2, userAccesses.size());
            assertEquals(modelToStore, userAccesses.getLast());
            
            closeConnection();
        }
        catch(SQLException | ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    @Test(expected = SQLException.class)
    public void testStoreNotExistingUser() throws IOException, SQLException, ClassNotFoundException
    {
        // Tests the query of all user accesses
        connect(getTestUser());
        UserAccessRepo instance = new UserAccessRepo();
        UserAccess modelToStore = new UserAccess(3, "mark", LocalDateTime.of(2020, Month.DECEMBER, 2, 18, 15, 0, 0));
            
            
        // Tests correct insertion
        instance.storeUserAccess(modelToStore);
          
        closeConnection();
    }
    
}
