/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integration_tests;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import se.project.business_logic.controllers.LoginController;
import se.project.presentation.views.LoginView;

/**
 *
 * @author Utente
 */
public class ITLoginTest
{
    
    public ITLoginTest()
    {
    }
    
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
