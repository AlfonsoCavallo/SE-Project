package se.project.storage.models.decorators.abstracts;

import se.project.storage.models.interfaces.RepresentableMaintenanceActivity;

/**
 * A decorator for post-processing of MaintenanceActivity data model.
 * 
 */
public abstract class AbstractMaintenanceActivityForAssignment implements RepresentableMaintenanceActivity
{
    
    private final RepresentableMaintenanceActivity component;
    
    /**
    * Instantiate the a adapter.
    * @param component is the model to adapt
    */
    public AbstractMaintenanceActivityForAssignment(RepresentableMaintenanceActivity component)
    {
        this.component = component;
    }
    
    @Override
    public Object[] getDataModel()
    {
        return component.getDataModel();
    }
}
