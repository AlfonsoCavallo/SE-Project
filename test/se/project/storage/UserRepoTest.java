/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;

/**
 *
 * @author Giorgio
 */
public class UserRepoTest
{
    
    public UserRepoTest()
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
    public void testQueryAllUsers()
    {
        try
        {
            // Test queryAllUsers method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            LinkedList<User> users = instance.queryAllUsers();
            
            // Tests expected elements
            User expectedFirstElement = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", null);
            assertEquals(expectedFirstElement, users.getFirst());
            
            User expectedLastElement = new Planner("jon", "jon@jon.it", "jon", "athan", null);
            assertEquals(expectedLastElement, users.getLast());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    @Test
    public void testQuarySearchedUser()
    {
        try
        {
            // Test queryViewOneUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test existing user
            String username = "finneas";
            LinkedList<User> user = instance.queryViewOneUser(username);
            User expectedUser = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", null);
            assertEquals(user.size(), 1);
            assertEquals(expectedUser, user.getFirst());
            
            // Test unvailable user
            String unvailable_username = "unvailable";
            user = instance.queryViewOneUser(unvailable_username);
            assertEquals(0, user.size());
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
}
