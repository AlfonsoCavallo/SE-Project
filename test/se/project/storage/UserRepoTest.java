/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.User.Role.*;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.DatabaseTesting.resetDatabase;

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
        resetDatabase();
    }
    
    @After
    public void tearDown()
    {
    }

    // TESTS FOR QUERY

    @Test
    public void testQueryCurrentUser() 
    {
        try
        {
            // Tests query for an SA user
            UserRepo systemAdministratorRepo = new UserRepo();
            connect("finneas", "finneas".toCharArray());
            assertEquals(systemAdministratorRepo.queryCurrentUser(), new User(SYSTEM_ADMINISTRATOR, "finneas", null));
            closeConnection();
            
            // Test query for a Planner user
            UserRepo plannerRepo = new UserRepo();
            connect("jon", "jon".toCharArray());
            assertEquals(plannerRepo.queryCurrentUser(), new User(PLANNER, "jon", null));
            closeConnection();
        }
        catch(ClassNotFoundException | SQLException | IOException ex)
        {
            fail();
        }
    }
    
    @Test(expected = NullPointerException.class)
    public void testQueryWithNoConnectionCurrentUser() throws SQLException, IOException
    {
        // Test for Repo not yet connected
        UserRepo instance = new UserRepo();
        instance.queryCurrentUser();
    }
    
    @Test(expected = NullPointerException.class)
    public void testQueryWithClosedConnectionCurrentUser() throws ClassNotFoundException, SQLException, IOException
    {
        // Test for Repo with closed connection
        UserRepo instance = new UserRepo();
        connect("finneas", "finneas".toCharArray());
        closeConnection();
        instance.queryCurrentUser();
    }
    
}
