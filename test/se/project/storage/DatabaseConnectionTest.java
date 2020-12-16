package se.project.storage;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.repos.DatabaseTesting.*;
import se.project.storage.models.SystemUser;


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
        }
        catch (SQLException ex)
        {
            
        }
    }
    
   
    // TESTS FOR CONNECT
    
    /**
     * Try to connect with Username and Password both not available.
     * @Result The connection is not established and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testConnectUnavailableCredentials() throws ClassNotFoundException, SQLException
    {
        DatabaseConnection.connect("Unavailable User", "Unavailable Password".toCharArray());        
    }
    
    /**
     * Try to connect with Username available but Password not available.
     * @Result The connection is not established and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testConnectWrongPassword() throws ClassNotFoundException, SQLException
    {
        connect("finneas", "wrong password".toCharArray());       
    }
    
    /**
     * Try to connect with Username not available but Password available.
     * @Result The connection is not established and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testConnectWrongUsername() throws ClassNotFoundException, SQLException
    {
        connect("wrong username", "finneas".toCharArray());        
    }
    
    /**
     * Connect with Username and Password both available.
     * @Result The connection is established.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void testConnectCorrectCredentials() throws ClassNotFoundException, SQLException 
    {
        try
        {
            // With parameters
            assertTrue(connect("finneas", "finneas".toCharArray()) instanceof Connection);
            closeConnection();
            
            // With user
            assertTrue(connect(new SystemUser(null, "finneas", "finneas".toCharArray())) instanceof Connection);
            closeConnection();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Try to connect with Username and Password both available but alredy connected.
     * @Result The new connection is not established and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testConnectAlreadyConnected() throws ClassNotFoundException, SQLException 
    {
        connect("finneas", "finneas".toCharArray());
        connect("finneas", "finneas".toCharArray());
        closeConnection();
    }   
    

    // TESTS FOR CLOSE CONNECTION
    
    /**
     * Try to close a connection on a connection already close.
     * @Result The connection can not be closed again and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Test
    public void testCloseOnClosedConnection() throws ClassNotFoundException, SQLException
    {
        closeConnection();
        connect("finneas", "finneas".toCharArray());
        closeConnection();
        closeConnection();
    }
    
    /**
     * Close a working connection.
     * @Result The connection is correctly closed.
     */
    @Test
    public void testCloseConnection()
    {
        try
        {
            connect("finneas", "finneas".toCharArray());
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
}
