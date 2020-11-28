/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.presentation.views.MaintenanceActivityView;
import se.project.presentation.views.ViewMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author delso
 */
public class ViewMaintenanceActivityController
{
    private final ViewMaintenanceActivityView viewMaintenanceActivityView;
    
    public ViewMaintenanceActivityController(ViewMaintenanceActivityView viewMaintenanceActivityView)
    {
        this.viewMaintenanceActivityView = viewMaintenanceActivityView;
        initListeners();
    }
    
    public void initListeners()
    {
        viewMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                viewMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });

        viewMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage(null);
                viewMaintenanceActivityView.dispose();
            }  
        });

       viewMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
       });   
        
    }
    
    public static JFrame goBackMaintenanceActivityPage(Connection connection)
    {
        MaintenanceActivityView maintenanceActivityView = new MaintenanceActivityView();
        MaintenanceActivityController maintenanceActivityController = new MaintenanceActivityController(maintenanceActivityView);
        return maintenanceActivityView;
    }
    
}
