/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.repos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
 *
 * @author delso
 */
public class MaintenanceActivityRepo extends AbstractRepo implements MaintenanceActivityRepoInterface     
{
    private String QUERY_ALL_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAllMaintenanceActivity.sql";

    @Override
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException
    {
        // Return all the maintenance activities in the system
        String query = getStringFromFile(QUERY_ALL_MAINTENANCE_ACTIVITY_PATH);
        return queryMaintenanceActivityList(query);
    }

    @Override
    public LinkedList<MaintenanceActivity> queryUserMaintenanceActivity(String username) throws IOException, SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private LinkedList<MaintenanceActivity> queryMaintenanceActivityList(String query) throws SQLException
    {
        ResultSet resultSet = super.queryDatabase(query);
        LinkedList<MaintenanceActivity> output = new LinkedList<>();
        
        while(resultSet.next())
        {
            int IDActivity = resultSet.getInt("id_activity");
            String activityName = resultSet.getString("activity_name");
            int timeNedeed = resultSet.getInt("time_needed");
            boolean interruptible = resultSet.getBoolean("interruptible");
            String typology = resultSet.getString("typology");
            String activityDescription = resultSet.getString("activity_description");
            int week = resultSet.getInt("week");
           
            //output.add(new MaintenanceActivity(IDActivity, activityName, timeNedeed, interruptible, typology, activityDescription, week));
        }
        
        return output;
    }        
    
}
