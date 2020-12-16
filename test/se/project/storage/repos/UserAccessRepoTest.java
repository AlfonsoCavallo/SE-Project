package se.project.storage.repos;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.repos.DatabaseTesting.*;
import se.project.storage.models.UserAccess;
import se.project.storage.repos.UserAccessRepo;


public class UserAccessRepoTest
{
    
    public UserAccessRepoTest()
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
     * Verify the query of all user accesses.
     * @Result The accesses of the two users logged are correctly checked.
     */
    @Test
    public void testQueryAllUserAccesses()
    {
        // Query for all user accesses
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo(getConnection());
            LinkedList<UserAccess> userAccesses = instance.queryAllUserAccesses();
            
            // Tests expected elements
            UserAccess expectedFirstElement = new UserAccess(1, "finneas", LocalDateTime.of(2020, Month.NOVEMBER, 26, 15, 30, 2, 0));
            assertEquals(expectedFirstElement, userAccesses.getFirst());
            
            UserAccess expectedLastElement = new UserAccess(2, "jon", LocalDateTime.of(2020, Month.NOVEMBER, 25, 15, 00, 0, 0));
            assertEquals(expectedLastElement, userAccesses.getLast());
            
            closeConnection();
        }
        catch(IOException | SQLException | ClassNotFoundException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Return a specific user accesses.
     * @Result First user access is correctly checked; the second user is unavailable so he has no accesses.
     */
    @Test
    public void testQueryUserAccesses()
    {
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo(getConnection());
            LinkedList<UserAccess> userAccesses = instance.queryUserAccesses("finneas");
            
            // Tests expected elements with an available user
            UserAccess expectedFirstElement = new UserAccess(1, "finneas", LocalDateTime.of(2020, Month.NOVEMBER, 26, 15, 30, 2, 0));
            assertEquals(userAccesses.size(), 1);
            assertEquals(expectedFirstElement, userAccesses.getFirst());
            
            // Tests unavailable user
            userAccesses = instance.queryUserAccesses("unavailable_user");
            assertEquals(0, userAccesses.size());
            closeConnection();
        }
        catch(SQLException | ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Store the acesses of an available user.
     * @Result The access of the specific user is correctly inserted and checked.
     */
    @Test
    public void testStoreUserAccess()
    {
        // Inserts a new access of an existent user
        try
        {
            connect(getTestUser());
            UserAccessRepo instance = new UserAccessRepo(getConnection());
            UserAccess modelToStore = new UserAccess(3, "finneas", LocalDateTime.of(2020, Month.DECEMBER, 2, 18, 15, 0, 0));
            
            
            // Tests correct insertion
            instance.storeUserAccess(modelToStore);
            LinkedList<UserAccess> userAccesses = instance.queryUserAccesses("finneas");
            assertEquals(2, userAccesses.size());
            assertEquals(modelToStore, userAccesses.getLast());
            
            closeConnection();
        }
        catch(SQLException | ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Try to store the access of a non-existent user.
     * @Result The attempt to store fails and exceptions are thrown.
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Test(expected = SQLException.class)
    public void testStoreNotExistingUser() throws IOException, SQLException, ClassNotFoundException
    {
        // Inserts a new access of a non-existent user
        connect(getTestUser());
        UserAccessRepo instance = new UserAccessRepo(getConnection());
        UserAccess modelToStore = new UserAccess(3, "mark", LocalDateTime.of(2020, Month.DECEMBER, 2, 18, 15, 0, 0));
            
            
        // Tests the insertion
        instance.storeUserAccess(modelToStore);
          
        closeConnection();
    }
    
}
