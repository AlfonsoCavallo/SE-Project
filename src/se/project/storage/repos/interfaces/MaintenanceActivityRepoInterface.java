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
    
    public LinkedList<MaintenanceActivity> queryUserMaintenanceActivity(String username) throws IOException, SQLException;
    // Return all the maintenance activities associated to a specific user
}
