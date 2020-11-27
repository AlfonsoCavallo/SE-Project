/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.AddMaintenanceActivityView;
import se.project.presentation.views.MaintenanceActivityView;

/**
 *
 * @author delso
 */
public class MaintenanceActivityController
{
    private MaintenanceActivityView maintenanceActivityView;
    
    public MaintenanceActivityController(MaintenanceActivityView maintenanceActivityView)
    {
       this.maintenanceActivityView = maintenanceActivityView;
    }  
    
    public static JFrame openAddMaintenanceActivityPage(Connection connection)
    {
        AddMaintenanceActivityView addMaintenanceActivityView = new AddMaintenanceActivityView();
        return addMaintenanceActivityView;
    }
    
}
