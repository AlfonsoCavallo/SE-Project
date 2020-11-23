/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.sql.Connection;
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
    public void testConnectUnavailableCredentials()
    {
        // Test for Username and Password not available
        UserRepo instance = new UserRepo();
        instance.connect("Unavailable User", "Unavailable Password".toCharArray());        
    }
    
    @Test(expected = Exception.class)
    public void testConnectWrongPassword()
    {
        // Test for Username and wrong password
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "wrong password".toCharArray());       
    }
    
    @Test(expected = Exception.class)
    public void testConnectWrongUsername()
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
        assertEquals(instance.connect("finneas", "finneas".toCharArray()), Connection.class);
        instance.closeConnection();
    }

    // TESTS FOR QUERY

    @Test
    public void testQueryCurrentUser()
    {
        // Tests query for an SA user
        UserRepo systemAdministratorRepo = new UserRepo("finneas", "finneas".toCharArray());
        assertEquals(systemAdministratorRepo.queryCurrentUser(), new User(User.Role.SYSTEM_ADMINISTRATOR, "finneas", "finneas".toCharArray()));
        systemAdministratorRepo.closeConnection();
        
        // Test query for a Planner user
        UserRepo plannerRepo = new UserRepo("jon", "jon".toCharArray());
        assertEquals(systemAdministratorRepo.queryCurrentUser(), new User(User.Role.PLANNER, "jon", "jon".toCharArray()));
        plannerRepo.closeConnection();
    }
    
    @Test(expected = Exception.class)
    public void testQueryWithNoConnectionCurrentUser()
    {
        // Test for Repo not yet connected
        UserRepo instance = new UserRepo();
        instance.queryCurrentUser();
    }
    
    @Test(expected = Exception.class)
    public void testQueryWithClosedConnectionCurrentUser()
    {
        // Test for Repo with closed connection
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "finneas".toCharArray());
        instance.closeConnection();
        instance.queryCurrentUser();
    }

    // TESTS FOR CLOSE CONNECTION
    
    @Test(expected = Exception.class)
    public void testCloseOnClosedConnection()
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
        // test CloseConnection on a working connection
        UserRepo instance = new UserRepo();
        instance.connect("finneas", "finneas".toCharArray());
        instance.closeConnection();
    }
    
}
