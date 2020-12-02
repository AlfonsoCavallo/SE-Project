package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;


public interface MaintenanceActivityRepoInterface
{
    /**
     * 
     * @return a LinkedList of the MaintenanceActivity in the system
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException;
    
    /**
     * 
     * @param activityName is the name of the activity that has to be shown
     * @return a LinkedList of MaintenanceActivity in which there is a specific maintenance activity
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<MaintenanceActivity> queryOneMaintenanceActivity(String activityName) throws IOException, SQLException;

    /**
     * 
     * Delete a specific maintenance activity
     * @param activityName is the name of the activity that has to be deleted
     * @throws IOException
     * @throws SQLException 
     */
    public void deleteMaintenanceActivity(String activityName) throws IOException, SQLException;
    
    /**
     * 
     * Add a new maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be added
     * @throws IOException
     * @throws SQLException 
     */
    public void addMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException;
    
    /**
     * 
     * Update a specific maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be updated
     * @param activityToUpdate is the previous name of the activity that has to be updated
     * @throws IOException
     * @throws SQLException 
     */
    public void updateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException;
    
}
