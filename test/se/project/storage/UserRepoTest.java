/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Utente
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
    }
    
    @After
    public void tearDown()
    {
    }
    
    // TESTS FOR CONNECT
    
    @Test(expected = Exception.class)
    public void testConnectUnavailableCredentials() throws ClassNotFoundException, SQLException
    {
        // Test for Username and Password not available
        UserRepo instance = new UserRepo();
        instance.connect("Unavailable User", "Unavailable Password".toCharArray());        
    }
    
    @Test(expected = Exception.class)
    public void testConnectWrongPassword() throws ClassNotFoundException, SQLException
    {
        // Test for Username and wrong password
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "wrong password".toCharArray());       
    }
    
    @Test(expected = Exception.class)
    public void testConnectWrongUsername() throws ClassNotFoundException, SQLException
    {
        // Test for password and wrong username
        UserRepo instance = new UserRepo();
        instance.connect("wrong username", "finneas".toCharArray());        
    }
    
    @Test
    public void testConnectCorrectCredentials() 
    {
        // Test for correct user name and password
        UserRepo instance = new UserRepo();
        try
        {
            assertTrue(instance.connect("finneas", "finneas".toCharArray()) instanceof Connection);
            instance.closeConnection();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            fail();
        }
    }

    // TESTS FOR QUERY

    @Test
    public void testQueryCurrentUser() 
    {
        try
        {
            // Tests query for an SA user
            UserRepo systemAdministratorRepo = new UserRepo();
            systemAdministratorRepo.connect("finneas", "finneas".toCharArray());
            assertEquals(systemAdministratorRepo.queryCurrentUser(), new User(User.Role.SYSTEM_ADMINISTRATOR, "finneas", null));
            systemAdministratorRepo.closeConnection();
            
            // Test query for a Planner user
            UserRepo plannerRepo = new UserRepo();
            plannerRepo.connect("jon", "jon".toCharArray());
            assertEquals(plannerRepo.queryCurrentUser(), new User(User.Role.PLANNER, "jon", null));
            plannerRepo.closeConnection();
        }
        catch(ClassNotFoundException | SQLException ex2)
        {
            fail();
        }
    }
    
    @Test(expected = Exception.class)
    public void testQueryWithNoConnectionCurrentUser() throws SQLException
    {
        // Test for Repo not yet connected
        UserRepo instance = new UserRepo();
        instance.queryCurrentUser();
    }
    
    @Test(expected = Exception.class)
    public void testQueryWithClosedConnectionCurrentUser() throws ClassNotFoundException, SQLException
    {
        // Test for Repo with closed connection
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "finneas".toCharArray());
        instance.closeConnection();
        instance.queryCurrentUser();
    }

    // TESTS FOR CLOSE CONNECTION
    
    @Test
    public void testCloseOnClosedConnection() throws ClassNotFoundException, SQLException
    {
        // tests CloseConnection on a connection already closed
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "finneas".toCharArray());
        instance.closeConnection();
        instance.closeConnection();
    }
    
    @Test
    public void testCloseConnection()
    {
        try
        {
            // test CloseConnection on a working connection
            UserRepo instance = new UserRepo();
            instance.connect("finneas", "finneas".toCharArray());
            instance.closeConnection();
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            fail();
        }
    }
    
}
