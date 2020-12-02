package integration_tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import se.project.presentation.views.LoginView;


public class ITLoginTest
{
    
    public ITLoginTest()
    {
    }
    
    /**
     * Mock inizialization.
     * @param username is user's username necessary to log.
     * @param password is user's password necessary to log.
     * @return a simulated LoginView.
     */
    private static LoginView simulateView(String username, char[] password)
    {
        // Initializes Mock
        LoginView mock = mock(LoginView.class);
        when(mock.getUsername()).thenReturn("finneas");
        when(mock.getPassword()).thenReturn("finneas".toCharArray());
        return mock;
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
    
    @Test
    public void testLoginForSystemAdministrator()
    {
        // Test for SA Login
    }
    
    @Test
    public void testLoginForPlanner()
    {
        // Test for Planner login
    }
    
    /*
    @Test(expected = Exception.class)
    public void testLoginUnavailableCredentials()
    {
        // Test for unavailable username and password
    }
    
    @Test(expected = Exception.class)
    public void testLoginWrongPassword()
    {
        // Test for wrong password and correct username
    }
    
    @Test(expected = Exception.class)
    public void testLoginWrongUsername()
    {
        // Test for wrong username and correct password
    }
    */
       
}
