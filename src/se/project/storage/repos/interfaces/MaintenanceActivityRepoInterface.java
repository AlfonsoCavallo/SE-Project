/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;

/**
 *
 * @author Utente
 */
public interface MaintenanceActivityRepoInterface
{
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException;
    // Return all the maintenance activities in the system
    
    public LinkedList<MaintenanceActivity> queryViewOneMaintenanceActivity(String activity_name) throws IOException, SQLException;
    // Return a specific maintenance activity
    
    public void queryDeleteMaintenanceActivity(String activity_name) throws IOException, SQLException;
    // Delete a specific maintenance activity
    
    public void queryAddMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException;
    // Add a new maintenance activity
    
    public void queryUpdateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException;
    // Update a specific maintenance activity
}
