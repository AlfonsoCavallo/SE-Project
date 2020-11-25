/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.DatabaseTesting.*;

/**
 *
 * @author Utente
 */

public class DatabaseConnectionTest
{
    
    public DatabaseConnectionTest()
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
        } catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getConnection method, of class DatabaseConnection.
     */
    // TESTS FOR CONNECT
    
    @Test(expected = SQLException.class)
    public void testConnectUnavailableCredentials() throws ClassNotFoundException, SQLException
    {
        // Test for Username and Password not available
        DatabaseConnection.connect("Unavailable User", "Unavailable Password".toCharArray());        
    }
    
    @Test(expected = SQLException.class)
    public void testConnectWrongPassword() throws ClassNotFoundException, SQLException
    {
        // Test for Username and wrong password
        connect("finneas", "wrong password".toCharArray());       
    }
    
    @Test(expected = SQLException.class)
    public void testConnectWrongUsername() throws ClassNotFoundException, SQLException
    {
        // Test for password and wrong username
        connect("wrong username", "finneas".toCharArray());        
    }
    
    @Test
    public void testConnectCorrectCredentials() 
    {
        // Test for correct user name and password
        try
        {
            assertTrue(connect("finneas", "finneas".toCharArray()) instanceof Connection);
            closeConnection();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            fail();
        }
    }
    
    @Test(expected = SQLException.class)
    public void testConnectAlreadyConnected() throws ClassNotFoundException, SQLException 
    {
        // Test for correct user name and password
        connect("finneas", "finneas".toCharArray());
        connect("finneas", "finneas".toCharArray());
        closeConnection();
    }   
    

    // TESTS FOR CLOSE CONNECTION
    
    @Test
    public void testCloseOnClosedConnection() throws ClassNotFoundException, SQLException
    {
        // tests CloseConnection on a connection already closed
        closeConnection();
        connect("finneas", "finneas".toCharArray());
        closeConnection();
        closeConnection();
    }
    
    @Test
    public void testCloseConnection()
    {
        try
        {
            // test CloseConnection on a working connection
            connect("finneas", "finneas".toCharArray());
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            fail();
        }
    }
    
}
