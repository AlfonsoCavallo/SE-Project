package se.project.storage.models.decorators;

import se.project.storage.models.decorators.abstracts.AbstractMaintenanceActivityForAssignment;
import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 * A decorator for post-processing of MaintenanceActivity data model.
 * 
 */
public class MaintenanceActivityForAssignment extends AbstractMaintenanceActivityForAssignment
{
    
    /**
    * Instantiate the a adapter.
    * @param maintenanceActivity is the model to adapt
    */
    public MaintenanceActivityForAssignment(RepresentableMaintenanceActivity maintenanceActivity)
    {
        super(maintenanceActivity);
    }
    
    @Override
    public Object[] getDataModel()
    {
        Object[] dataModel = super.getDataModel();        
        return new Object[]{dataModel[0], dataModel[8] + " - " + dataModel[9], dataModel[5], dataModel[2]};
    }    
}
