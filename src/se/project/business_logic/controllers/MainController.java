/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;
import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.LoginView;
import se.project.presentation.views.MaintenanceActivityView;
import se.project.presentation.views.SAHomepageView;

/**
 *
 * @author Utente
 */
public class MainController
{
    public static void main(String args[])
    {
        openLoginPage();
    }
    
    public static LoginView openLoginPage()
    {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        loginView.setController(loginController);
        return loginView;
    }
    
    public static JFrame openSystemAdministratorHomePage(Connection connection)
    {
        SAHomepageView saHomepageView = new SAHomepageView();
        SAHomepageController saHomepageController = new SAHomepageController(saHomepageView);
        return saHomepageView;
    }
    
    public static JFrame openPlannerHomePage(Connection connection)
    {
        MaintenanceActivityView maintenanceActivityView = new MaintenanceActivityView();
        MaintenanceActivityController maintenanceActivityController = new MaintenanceActivityController(maintenanceActivityView);
        maintenanceActivityView.setController(maintenanceActivityController);
        return maintenanceActivityView;
    }
}
