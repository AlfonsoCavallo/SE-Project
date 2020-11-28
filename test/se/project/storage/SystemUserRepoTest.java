/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import se.project.storage.repos.SystemUserRepo;
import se.project.storage.models.SystemUser;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.models.SystemUser.Role.*;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.DatabaseTesting.resetDatabase;

/**
 *
 * @author Utente
 */
public class SystemUserRepoTest
{
    
    public SystemUserRepoTest()
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

    // TESTS FOR QUERY

    @Test
    public void testQueryCurrentUser() 
    {
        try
        {
            // Tests query for an SA user
            SystemUserRepo systemAdministratorRepo = new SystemUserRepo();
            connect("finneas", "finneas".toCharArray());
            assertEquals(new SystemUser(SYSTEM_ADMINISTRATOR, "finneas", null), systemAdministratorRepo.queryCurrentUser());
            closeConnection();
            
            // Test query for a Planner user
            SystemUserRepo plannerRepo = new SystemUserRepo();
            connect("jon", "jon".toCharArray());
            assertEquals(new SystemUser(PLANNER, "jon", null), plannerRepo.queryCurrentUser());
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
        SystemUserRepo instance = new SystemUserRepo();
        instance.queryCurrentUser();
    }
    
    @Test(expected = NullPointerException.class)
    public void testQueryWithClosedConnectionCurrentUser() throws ClassNotFoundException, SQLException, IOException
    {
        // Test for Repo with closed connection
        SystemUserRepo instance = new SystemUserRepo();
        connect("finneas", "finneas".toCharArray());
        closeConnection();
        instance.queryCurrentUser();
    }
    
    
}
