/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;
import javax.swing.JFrame;
import se.project.presentation.views.LoginView;

/**
 *
 * @author Utente
 */
public class MainController
{
    public static void main(String args[])
    {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
    }
    
    public static JFrame openSystemAdministratorHomePage()
    {
        // Opens System Administrator homepage
        return null;
    }
    
    public static JFrame openPlannerHomePage()
    {
        // Opens System Planner homepage
        return null;
    }
}
