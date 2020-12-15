/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models.adapters;

import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 *
 * @author Utente
 */
public class MaintenanceActivityForAssignment implements RepresentableMaintenanceActivity
{
    private RepresentableMaintenanceActivity adaptee;
    
    public MaintenanceActivityForAssignment(RepresentableMaintenanceActivity maintenanceActivity)
    {
        this.adaptee = maintenanceActivity;
    }
    
    @Override
    public Object[] getDataModel()
    {
        Object[] dataModel = adaptee.getDataModel();        
        return new Object[]{dataModel[0], dataModel[9] + " - " + dataModel[10], dataModel[5], dataModel[2]};
    }    
}
