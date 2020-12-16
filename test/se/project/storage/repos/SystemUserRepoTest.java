package se.project.storage.repos;

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
import static se.project.storage.repos.DatabaseTesting.resetDatabase;


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

    
    /**
     * Connect correctly the current user based on his own role.
     * @Result Both connections are done correctly: firstly as a System Administrator, secondly as a Planner.
     */
    @Test
    public void testQueryCurrentUser() 
    {
        try
        {
            // Test query for a System Administrator user
            SystemUserRepo systemAdministratorRepo = new SystemUserRepo(getConnection());
            connect("finneas", "finneas".toCharArray());
            assertEquals(new SystemUser(SYSTEM_ADMINISTRATOR, "finneas", null), systemAdministratorRepo.queryCurrentUser());
            closeConnection();
            
            // Test query for a Planner user
            SystemUserRepo plannerRepo = new SystemUserRepo(getConnection());
            connect("jon", "jon".toCharArray());
            assertEquals(new SystemUser(PLANNER, "jon", null), plannerRepo.queryCurrentUser());
            closeConnection();
        }
        catch(ClassNotFoundException | SQLException | IOException ex)
        {
            fail();
        }
    }
    
    /**
     * Try to get the current user without first connecting to the system (Repo not yet connected).
     * @Result Query fails and exceptions are thrown.
     * @throws SQLException
     * @throws IOException 
     */
    @Test(expected = NullPointerException.class)
    public void testQueryWithNoConnectionCurrentUser() throws SQLException, IOException
    {
        SystemUserRepo instance = new SystemUserRepo(getConnection());
        instance.queryCurrentUser();
    }
    
    /**
     * Try to get the current user after having already closed the connection to the system (Repo with closed connection).
     * @Result Query fails and exceptions are thrown.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException 
     */
    @Test(expected = NullPointerException.class)
    public void testQueryWithClosedConnectionCurrentUser() throws ClassNotFoundException, SQLException, IOException
    {
        SystemUserRepo instance = new SystemUserRepo(getConnection());
        connect("finneas", "finneas".toCharArray());
        closeConnection();
        instance.queryCurrentUser();
    }
    
}
