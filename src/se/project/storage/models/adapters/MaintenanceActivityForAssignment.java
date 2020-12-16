package se.project.storage.models.adapters;

import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 * An adapter for the rapresentation of MaintenanceActivity in MaintenanceAssignmentView.
 * 
 */
public class MaintenanceActivityForAssignment implements RepresentableMaintenanceActivity
{
    private RepresentableMaintenanceActivity adaptee;
    
    /**
    * Instantiate the a adapter.
    * @param maintenanceActivity is the model to adapt
    */
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
