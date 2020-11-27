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
import se.project.storage.models.UserGio;
import se.project.storage.repos.UserRepoGio;

/**
 *
 * @author Giorgio
 */
public class UserRepoTestGio
{
    
    public UserRepoTestGio()
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
            // Test queryAllUsers
            connect(getTestUser());
            UserRepoGio instance = new UserRepoGio();
            LinkedList<UserGio> users = instance.queryAllUsers();
            
            // Tests expected elements
            /*UserGio expectedFirstElement = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", "finneas");
            assertEquals(users.getFirst(), expectedFirstElement);
            
            UserGio expectedLastElement = new Planner("jon", "jon@jon.it", "jon", "athan", "jon");
            assertEquals(users.getFirst(), expectedLastElement);*/
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            fail();
        }
    }
}