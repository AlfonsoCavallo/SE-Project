/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;
import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.LoginView;
import se.project.presentation.views.PlannerHomepageView;
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
        PlannerHomepageView plannerHomepageView = new PlannerHomepageView();
        PlannerHomepageController plannerHomepageController = new PlannerHomepageController(plannerHomepageView);
        return plannerHomepageView;
    }
}
