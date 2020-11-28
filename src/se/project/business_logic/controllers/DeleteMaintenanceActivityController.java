/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.presentation.views.DeleteMaintenanceActivityView;
import se.project.presentation.views.MaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author delso
 */
public class DeleteMaintenanceActivityController
{
    private final DeleteMaintenanceActivityView deleteMaintenanceActivityView;
    
    public DeleteMaintenanceActivityController(DeleteMaintenanceActivityView deleteMaintenanceActivityView)
    {
        this.deleteMaintenanceActivityView = deleteMaintenanceActivityView;
        initListeners();
    }
    
    public void initListeners()
    {
        deleteMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                deleteMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });
        
        deleteMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage(null);
                deleteMaintenanceActivityView.dispose();
            }        
        });        
        
        deleteMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
