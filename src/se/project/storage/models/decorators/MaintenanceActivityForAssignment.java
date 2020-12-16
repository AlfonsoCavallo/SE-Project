package se.project.storage.models.decorators;

import se.project.storage.models.decorators.abstracts.AbstractMaintenanceActivityForAssignment;
import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 * A decorator for post-processing of MaintenanceActivity data model.
 * 
 */
public class MaintenanceActivityForAssignment extends AbstractMaintenanceActivityForAssignment
{
    private final RepresentableMaintenanceActivity component;
    
    /**
    * Instantiate the a adapter.
    * @param maintenanceActivity is the model to adapt
    */
    public MaintenanceActivityForAssignment(RepresentableMaintenanceActivity maintenanceActivity)
    {
        this.component = maintenanceActivity;
    }
    
    @Override
    public Object[] getDataModel()
    {
        Object[] dataModel = component.getDataModel();        
        return new Object[]{dataModel[0], dataModel[9] + " - " + dataModel[10], dataModel[5], dataModel[2]};
    }    
}
