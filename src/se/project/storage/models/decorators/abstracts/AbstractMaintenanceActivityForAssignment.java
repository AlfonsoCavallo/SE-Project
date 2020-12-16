/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models.decorators.abstracts;

import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 * A decorator for post-processing of MaintenanceActivity data model.
 * 
 */
public abstract class AbstractMaintenanceActivityForAssignment implements RepresentableMaintenanceActivity
{
    
    protected final RepresentableMaintenanceActivity component;
    
    /**
    * Instantiate the a adapter.
    * @param component is the model to adapt
    */
    public AbstractMaintenanceActivityForAssignment(RepresentableMaintenanceActivity component)
    {
        this.component = component;
    }
    
    /**
     * Processes data model to be represented on assignment view.
     * @return the processed data model.
     */
    public abstract Object[] getDataModel();
}
