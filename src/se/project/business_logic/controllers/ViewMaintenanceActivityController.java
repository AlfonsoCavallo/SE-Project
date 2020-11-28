/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import se.project.presentation.views.ViewMaintenanceActivityView;

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
        //viewMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        
    }
}
