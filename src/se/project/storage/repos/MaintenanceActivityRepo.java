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
import se.project.storage.models.maintenance_activity.EWO;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.*;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
 *
 * @author delso
 */
public class MaintenanceActivityRepo extends AbstractRepo implements MaintenanceActivityRepoInterface     
{
    private String QUERY_ALL_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAllMaintenanceActivity.sql";
    private String QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryViewOneMaintenanceActivity.sql";
    private String QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryDeleteMaintenanceActivity.sql";
    
    @Override
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException
    {
        // Return all the maintenance activities in the system
        String query = getStringFromFile(QUERY_ALL_MAINTENANCE_ACTIVITY_PATH);
        return queryMaintenanceActivityList(query);
    }

    @Override
    public LinkedList<MaintenanceActivity> queryViewOneMaintenanceActivity(String activity_name) throws IOException, SQLException
    {
        // Return a specific maintenance activity
        String query = getStringFromFile(QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH);
        query = query.replaceAll("activity_name_param", activity_name);
        return queryMaintenanceActivityList(query);
    }
    
    @Override
    public void queryDeleteMaintenanceActivity(String activity_name) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH);
        query = query.replaceAll("activity_name_param", activity_name);
        executeStatement(query);
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
            Typology typology = fromString(resultSet.getString("typology"));
            String activityDescription = resultSet.getString("activity_description");
            int week = resultSet.getInt("week");
            String planned = resultSet.getString("planned");
            String ewo = resultSet.getString("ewo");
            String standardProcedure = resultSet.getString("standard_procedure");
            
            if(planned.equals("yes"))
                output.add(new PlannedActivity(IDActivity, activityName, timeNedeed, interruptible, 
                            typology, activityDescription, week, standardProcedure));
            else if(ewo.equals("yes"))
                output.add(new EWO(IDActivity, activityName, timeNedeed, interruptible, 
                            typology, activityDescription, week));
            else if(ewo.equals("no"))
                output.add(new ExtraActivity(IDActivity, activityName, timeNedeed, interruptible, 
                            typology, activityDescription, week));
        }
        return output;
    }        

}
