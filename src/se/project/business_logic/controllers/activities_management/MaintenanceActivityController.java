/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers.activities_management;

import se.project.business_logic.controllers.activities_management.AddMaintenanceActivityController;
import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.PlannerHomepageController;
import se.project.presentation.views.activities_management.AddMaintenanceActivityView;
import se.project.presentation.views.activities_management.MaintenanceActivityView;
import se.project.presentation.views.PlannerHomepageView;
import se.project.presentation.views.activities_management.UpdateMaintenanceActivityView;
import se.project.presentation.views.activities_management.ViewMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author delso
 */
public class MaintenanceActivityController extends AbstractController
{
    private final MaintenanceActivityView maintenanceActivityView;
    
    public MaintenanceActivityController(MaintenanceActivityView maintenanceActivityView)
    {
       this.view = maintenanceActivityView;
       this.maintenanceActivityView = maintenanceActivityView;
       initListeners();
    }  
    
    private void initListeners()
    {
        maintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                try
                {
                    closeConnection();
                }
                catch (SQLException ex)
                {
                    System.err.println(ex.getMessage());
                }
                maintenanceActivityView.dispose();
                MainController.openLoginPage();
            }        
        });

        maintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }        
        });
        
        maintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackPlannerHomepage();
                maintenanceActivityView.dispose();
            }
        });        

        maintenanceActivityView.getjAddMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openAddMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }        
            
        });        
        
        maintenanceActivityView.getjUpdateMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUpdateMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }
        });        
            
        maintenanceActivityView.getjViewMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openViewMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }
        });          
                
    }        
    
    public static JFrame openAddMaintenanceActivityPage()
    {
        AddMaintenanceActivityView addMaintenanceActivityView = new AddMaintenanceActivityView();
        AddMaintenanceActivityController addMaintenanceActivityController = new AddMaintenanceActivityController(addMaintenanceActivityView);
        return addMaintenanceActivityView;
    }
    
    public static JFrame openUpdateMaintenanceActivityPage()
    {
        UpdateMaintenanceActivityView updateMaintenanceActivityView = new UpdateMaintenanceActivityView();
        UpdateMaintenanceActivityController updateMaintenanceActivityController = new UpdateMaintenanceActivityController(updateMaintenanceActivityView);
        return updateMaintenanceActivityView;
    }
    
    public static JFrame openViewMaintenanceActivityPage()
    {
        ViewMaintenanceActivityView viewMaintenanceActivityView = new ViewMaintenanceActivityView();
        ViewMaintenanceActivityController viewMaintenanceActivityController = new ViewMaintenanceActivityController(viewMaintenanceActivityView);
        return viewMaintenanceActivityView;
    }
    
    public static JFrame goBackPlannerHomepage()
    {
        PlannerHomepageView plannerHomepageView = new PlannerHomepageView();
        PlannerHomepageController plannerHomepageController = new PlannerHomepageController(plannerHomepageView);
        return plannerHomepageView;
    }
}
