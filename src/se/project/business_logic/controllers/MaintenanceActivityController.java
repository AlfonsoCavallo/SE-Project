/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.AddMaintenanceActivityView;

/**
 *
 * @author delso
 */
public class MaintenanceActivityController
{
    public static JFrame openAddMaintenanceActivityPage(Connection connection)
    {
        AddMaintenanceActivityView addMaintenanceActivityView = new AddMaintenanceActivityView();
        return addMaintenanceActivityView;
    }
    
}
