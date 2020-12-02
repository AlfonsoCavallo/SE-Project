package se.project.storage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseConnection.getConnection;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;


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
            resetDatabase();
            closeConnection();
        }
        catch (SQLException ex)
        {
            
        }
    }

    /**
     * Verify the presence of all users in the system.
     * @Result The two users recorded in the system are both correctly checked.
     */
    @Test
    public void testQueryAllUsers()
    {
        try
        {
            // Tests queryAllUsers method
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
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
    
    /**
     * Verify the presence of a specific user.
     * @Result First user is available and checked but the second one is unavailable.
     */
    @Test
    public void testQuerySearchedUser()
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            // Tests existing user
            String username = "finneas";
            LinkedList<User> user = instance.queryOneUser(username);
            User expectedUser = new SystemAdministrator("finneas", "finneas@finneas.it", "fin", "neas", null, "system_administrator");
            assertEquals(1, user.size());
            assertEquals(expectedUser, user.getFirst());
            
            // Tests unvailable user
            String unvailableUsername = "unvailable";
            user = instance.queryOneUser("unavailable_username");
            assertEquals(0, user.size());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Delete a specific user.
     * @Result The first user is correctly deleted; the second user is unavailable so there is no delete on him.
     */
    @Test
    public void testDeleteUser()
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            // Tests an available username
            String username = "jon";
            LinkedList<User> users = instance.queryAllUsers();
            int usersSize = users.size();
            instance.deleteUser(username);
            LinkedList<User> usersAfterDelete = instance.queryAllUsers();
            int newUsersSize = usersAfterDelete.size();
            assertEquals(usersSize - 1, newUsersSize);
            
            // Tests an unavailable username
            String unvailableUsername = "unvailable";
            instance.deleteUser("unavailableUsername");
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
    
    /**
     * Add a new user to the system.
     * @Result Both users are added correctly in the system: firstly as a System Administrator, secondly as a Planner.
     */
    @Test
    public void testAddQuery()
    {
       try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            // Test adding a System Administrator 
            SystemAdministrator saUser = new SystemAdministrator("front", "front@front.com", "front", "man", "front", "system_administrator");
            LinkedList<User> users = instance.queryAllUsers();
            int usersSize = users.size();
            instance.addUser(saUser);
            LinkedList<User> usersAfterAdd = instance.queryAllUsers();
            assertEquals(usersSize + 1, usersAfterAdd.size());
            
            String username = saUser.getUsername();
            LinkedList<User> user = instance.queryOneUser(username);
            assertEquals(1, user.size());
            
            // Test adding a Planner
            Planner planner = new Planner("black", "black@black.com", "black", "jack", "black", "planner");
            users = instance.queryAllUsers();
            usersSize = users.size();
            instance.addUser(planner);
            usersAfterAdd = instance.queryAllUsers();
            assertEquals(usersSize + 1, usersAfterAdd.size());
            
            username = planner.getUsername();
            user = instance.queryOneUser(username);
            assertEquals(1, user.size());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        } 
    }
    
    /**
     * Try to add an existing username.
     * @Result The attempt to add an existing username fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testAddExistingUser() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner planner = new Planner("jon", "black@black.com", "black", "jack", "black", "planner");
            instance.addUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    /**
     * Try to add an existing email.
     * @Result The attempt to add an existing email fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testAddExistingEmail() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner planner = new Planner("black", "jon@jon.it", "black", "jack", "black", "planner");
            instance.addUser(planner);
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    /**
     * Try to add a user with an empty mandatory field.
     * @Result The attempt to add a user with an empty mandatory field (name) fails and exceptions are thrown.
     */
    @Test(expected = NullPointerException.class)
    public void testAddEmptyField()
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner planner = new Planner("black", "jon@jon.it", null , "jack", "black", "planner");
            instance.addUser(planner);
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    /**
     * Try to add a user with an empty string field.
     * @Result The attempt to add a user with an empty string field (name) fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testAddEmptyString() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner planner = new Planner("black", "black@jon.it", "" , "jack", "black", "planner");
            instance.addUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    /**
     * Try to add a user with an invalid role.
     * @Result The attempt to add a user with an invalid role fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testAddInvalidRole() throws SQLException
    {
        try
        {

            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner planner = new Planner("black", "black@black.it", "black" , "jack", "black", "invalid_role");
            instance.addUser(planner);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }        
    }
    
    /**
     * Update the username and the email of a specific user.
     * @Result All updates (two username and one email) were successful.
     */
    @Test
    public void testUpdateUser()
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            // Test updating a Planner username
            Planner user = new Planner("jonathan", "jon@jon.it", "jon", "athan", "jon", "planner");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            String username = user.getUsername();
            LinkedList<User> userSearched = instance.queryOneUser(username);
            assertEquals(1, userSearched.size());
            
            // Test updating a System Administrator username
            SystemAdministrator saUser = new SystemAdministrator("fin", "finneas@finneas.it", "fin", "neas", "finneas", "system_administrator");
            oldUsername = "finneas";
            instance.updateUser(saUser, oldUsername);
            username = saUser.getUsername();
            userSearched = instance.queryOneUser(username);
            assertEquals(1, userSearched.size());
            
            
            // Test updating a Planner attribute (email)
            user = new Planner("jonathan", "newEmail@jon.com", "jon", "athan", "jon", "planner");
            oldUsername = "jonathan";
            instance.queryOneUser(username);
            username = user.getUsername();
            String email = user.getEmail();
            userSearched = instance.queryOneUser(username);
            assertEquals(1, userSearched.size());
            assertEquals("newEmail@jon.com", email);
            
            closeConnection();    
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
        
    }
    
    /**
     * Try to update a user with an already existing username.
     * @Result The attempt to update a user with an already existing username fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testUpdateWithExistingUsername() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner user = new Planner("finneas", "jon@jon.it", "jon", "athan", "jon", "planner");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
            
    }
    
    /**
     * Try to update a user with an already existing email.
     * @Result The attempt to update a user with an already existing email fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testUpdateWithExistingEmail() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner user = new Planner("jon", "finneas@finneas.it", "jon", "athan", "jon", "planner");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
            
    }
    
    /**
     * Try to update a user with an invalid role.
     * @Result The attempt to update a user with an invalid role fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testUpdateInvalidRole() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner user = new Planner("jon", "jon@jon.it", "jon", "athan", "jon", "invalid_role");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
            
    }
    
    /**
     * Try to update a user with an empty string field.
     * @Result The attempt to update a user with an empty string field (surname) fails and exceptions are thrown.
     * @throws SQLException 
     */
    @Test(expected = SQLException.class)
    public void testUpdateEmptyString() throws SQLException
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner user = new Planner("jon", "jon@jon.it", "jon", "", "jon", "planner");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            closeConnection();
        } 
        catch (ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
            
    }
    
    /**
     * Try to update a user with an empty mandatory field.
     * @Result The attempt to update a user with an empty mandatory field (surname) fails and exceptions are thrown.
     */
    @Test(expected = NullPointerException.class)
    public void testUpdateNullField()
    {
        try
        {
            connect(getTestUser());
            UserRepo instance = new UserRepo(getConnection());
            
            Planner user = new Planner("jon", "jon@jon.it", "jon", null, "jon", "planner");
            String oldUsername = "jon";
            instance.updateUser(user, oldUsername);
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
            
    }
}
