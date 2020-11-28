/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import se.project.presentation.views.AddMaintenanceActivityView;

/**
 *
 * @author delso
 */
public class AddMaintenanceActivityController
{
    private final AddMaintenanceActivityView addMaintenanceActivityView;
    
    public AddMaintenanceActivityController(AddMaintenanceActivityView addMaintenanceActivityView)
    {
        this.addMaintenanceActivityView = addMaintenanceActivityView;
        initListeners();
    }
    
    public void initListeners()
    {
        //addMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        
    }
}
