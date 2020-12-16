package se.project.storage.models.interfaces;

/**
 * A model to represent informations about a Maintenance Activity.
 */
public interface RepresentableMaintenanceActivity
{
    /***
     * Get the data model in percentages of availability.
     * @return an array of informations capable of being configured on a JTable
     */    
    Object[] getDataModel();
}
