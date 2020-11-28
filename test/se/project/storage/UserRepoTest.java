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
            User expectedFirstElement = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", null, "system_administrator");
            assertEquals(users.getFirst(), expectedFirstElement);
            
            User expectedLastElement = new Planner("jon", "jon@jon.it", "jon", "athan", null, "planner");
            assertEquals(users.getLast(), expectedLastElement);
            
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
            User expectedUser = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", null, "system_administrator");
            assertEquals(1, user.size());
            assertEquals(expectedUser, user.getFirst());
            
            // Test unvailable user
            String unvailableUsername = "unvailable";
            user = instance.queryViewOneUser(unvailableUsername);
            assertEquals(0, user.size());
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    @Test
    public void testQueryDeleteUser()
    {
        try
        {
            // Test queryDeleteUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test an available username
            String username = "jon";
            LinkedList<User> users = instance.queryAllUsers();
            int usersSize = users.size();
            instance.queryDeleteUser(username);
            LinkedList<User> usersAfterDelete = instance.queryAllUsers();
            int newUsersSize = usersAfterDelete.size();
            assertEquals(usersSize - 1, newUsersSize);
            
            // Test an unvailable name
            String unvailableUsername = "unvailable";
            instance.queryDeleteUser(unvailableUsername);
            usersAfterDelete = instance.queryAllUsers();
            assertEquals(newUsersSize, usersAfterDelete.size());
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
        
    }
    
    @Test
    public void testAddQuery()
    {
       try
        {
            // Test queryAddUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test adding a system administrator 
            SystemAdministrator saUser = new SystemAdministrator("front", "front@front.com", "front", "man", "front", "system_administrator");
            LinkedList<User> users = instance.queryAllUsers();
            int usersSize = users.size();
            instance.queryAddUser(saUser);
            LinkedList<User> usersAfterAdd = instance.queryAllUsers();
            assertEquals(usersSize + 1, usersAfterAdd.size());
            
            String username = saUser.getUsername();
            LinkedList<User> user = instance.queryViewOneUser(username);
            assertEquals(1, user.size());
            
            // Test adding a planner
            Planner planner = new Planner("black", "black@black.com", "black", "jack", "black", "planner");
            users = instance.queryAllUsers();
            usersSize = users.size();
            instance.queryAddUser(planner);
            usersAfterAdd = instance.queryAllUsers();
            assertEquals(usersSize + 1, usersAfterAdd.size());
            
            username = planner.getUsername();
            user = instance.queryViewOneUser(username);
            assertEquals(1, user.size());
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        } 
    }
    
    @Test(expected = AssertionError.class)
    public void testAddExistingUser()
    {
        try
        {
            // Test queryAddUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test queryAddUser method adding an existing username
            Planner planner = new Planner("jon", "black@black.com", "black", "jack", "black", "planner");
            instance.queryAddUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    @Test(expected = AssertionError.class)
    public void testAddExistingEmail()
    {
        try
        {
            // Test queryAddUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test queryAddUser method adding an existing email
            Planner planner = new Planner("black", "jon@jon.it", "black", "jack", "black", "planner");
            instance.queryAddUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddEmptyField()
    {
        try
        {
            // Test queryAddUser method
            connect(getTestUser());
            UserRepo instance = new UserRepo();
            
            // Test queryAddUser method adding a user with an empty mandatory field
            Planner planner = new Planner("black", "jon@jon.it", null , "jack", "black", "planner");
            instance.queryAddUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
}
