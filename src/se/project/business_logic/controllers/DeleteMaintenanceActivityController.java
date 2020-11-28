/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import se.project.presentation.views.DeleteMaintenanceActivityView;

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
        //deleteMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        
    }
}
