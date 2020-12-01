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
    public LinkedList<MaintenanceActivity> queryViewOneMaintenanceActivity(String activityName) throws IOException, SQLException;

    /**
     * 
     * Delete a specific maintenance activity
     * @param activityName is the name of the activity that has to be deleted
     * @throws IOException
     * @throws SQLException 
     */
    public void queryDeleteMaintenanceActivity(String activityName) throws IOException, SQLException;
    
    /**
     * 
     * Add a new maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be added
     * @throws IOException
     * @throws SQLException 
     */
    public void queryAddMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException;
    
    /**
     * 
     * Update a specific maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be updated
     * @param activityToUpdate is the previous name of the activity that has to be updated
     * @throws IOException
     * @throws SQLException 
     */
    public void queryUpdateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException;
    
}
