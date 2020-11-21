/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

import javax.swing.JFrame;
import junit.framework.TestCase;
import org.mockito.Mockito;
import se.project.presentation.views.LoginView;

/**
 *
 * @author Utente
 */

public class LoginControllerTest extends TestCase
{
    
    public LoginControllerTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of login method, of class LoginController.
     */
    public void testLogin()
    {
        System.out.println("login");
        
        // Mock for login view class
        LoginView mock = Mockito.mock(LoginView.class);
        Mockito.when(mock.getUsername()).thenReturn(null);
        Mockito.when(mock.getPassword()).thenReturn(null);
        
        // Instance LoginController
        LoginController instance = new LoginController(mock);
        
        // Test
        assertEquals(instance.login().getClass(), JFrame.class);
    }
    
}
