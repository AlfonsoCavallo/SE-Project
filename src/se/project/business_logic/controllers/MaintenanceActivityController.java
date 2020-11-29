/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.presentation.views.AddMaintenanceActivityView;
import se.project.presentation.views.MaintenanceActivityView;
import se.project.presentation.views.PlannerHomepageView;
import se.project.presentation.views.UpdateMaintenanceActivityView;
import se.project.presentation.views.ViewMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author delso
 */
public class MaintenanceActivityController
{
    private final MaintenanceActivityView maintenanceActivityView;
    
    public MaintenanceActivityController(MaintenanceActivityView maintenanceActivityView)
    {
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
                goBackPlannerHomepage(null);
                maintenanceActivityView.dispose();
            }
        });        

        maintenanceActivityView.getjAddMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openAddMaintenanceActivityPage(null);
                maintenanceActivityView.dispose();
            }        
            
        });        
        
        maintenanceActivityView.getjUpdateMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUpdateMaintenanceActivityPage(null);
                maintenanceActivityView.dispose();
            }
        });        
            
        maintenanceActivityView.getjViewMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openViewMaintenanceActivityPage(null);
                maintenanceActivityView.dispose();
            }
        });          
                
    }        
    
    public static JFrame openAddMaintenanceActivityPage(Connection connection)
    {
        AddMaintenanceActivityView addMaintenanceActivityView = new AddMaintenanceActivityView();
        AddMaintenanceActivityController addMaintenanceActivityController = new AddMaintenanceActivityController(addMaintenanceActivityView);
        return addMaintenanceActivityView;
    }
    
    public static JFrame openUpdateMaintenanceActivityPage(Connection connection)
    {
        UpdateMaintenanceActivityView updateMaintenanceActivityView = new UpdateMaintenanceActivityView();
        UpdateMaintenanceActivityController updateMaintenanceActivityController = new UpdateMaintenanceActivityController(updateMaintenanceActivityView);
        return updateMaintenanceActivityView;
    }
    
    public static JFrame openViewMaintenanceActivityPage(Connection connection)
    {
        ViewMaintenanceActivityView viewMaintenanceActivityView = new ViewMaintenanceActivityView();
        ViewMaintenanceActivityController viewMaintenanceActivityController = new ViewMaintenanceActivityController(viewMaintenanceActivityView);
        return viewMaintenanceActivityView;
    }
    
    public static JFrame goBackPlannerHomepage(Connection connection)
    {
        PlannerHomepageView plannerHomepageView = new PlannerHomepageView();
        PlannerHomepageController plannerHomepageController = new PlannerHomepageController(plannerHomepageView);
        return plannerHomepageView;
    }
}
