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
    private final String QUERY_ALL_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAllMaintenanceActivity.sql";
    private final String QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryViewOneMaintenanceActivity.sql";
    private final String QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryDeleteMaintenanceActivity.sql";
    private final String QUERY_ADD_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAddMaintenanceActivity.sql";
    
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
    
    @Override
    public void queryAddMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ADD_MAINTENANCE_ACTIVITY_PATH);
        
        String activityName = maintenanceActivity.getActivityName();
        int timeNeeded = maintenanceActivity.getTimeNeeded();
        String interruptible = maintenanceActivity.isInterruptible();
        String typology = maintenanceActivity.getTypology().getValue();
        String activityDescription = maintenanceActivity.getActivityDescription();
        int week = maintenanceActivity.getWeek();
        String planned = maintenanceActivity.isPlanned();
        String ewo = maintenanceActivity.isEWO();
        String standardProcedure = maintenanceActivity.getStandardProcedure();
        
        query = query.replaceAll("activity_name_param", activityName);
        query = query.replaceAll("time_needed_param", String.valueOf(timeNeeded));
        query = query.replaceAll("interruptible_param", interruptible);
        query = query.replaceAll("typology_param", String.valueOf(typology));
        query = query.replaceAll("activity_description_param", activityDescription);
        query = query.replaceAll("week_param", String.valueOf(week));
        query = query.replaceAll("planned_param", planned);
        query = query.replaceAll("ewo_param", ewo);
        query = query.replaceAll("standard_param", standardProcedure);
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
            int timeNeeded = resultSet.getInt("time_needed");
            boolean interruptible = resultSet.getBoolean("interruptible");
            Typology typology = fromString(resultSet.getString("typology"));
            String activityDescription = resultSet.getString("activity_description");
            int week = resultSet.getInt("week");
            String planned = resultSet.getString("planned");
            String ewo = resultSet.getString("ewo");
            String standardProcedure = resultSet.getString("standard_procedure");
            
            if(planned.equals("yes"))
                output.add(new PlannedActivity(IDActivity, activityName, timeNeeded, interruptible, 
                            typology, activityDescription, week, standardProcedure));
            else if(ewo.equals("yes"))
                output.add(new EWO(IDActivity, activityName, timeNeeded, interruptible, 
                            typology, activityDescription, week));
            else if(ewo.equals("no"))
                output.add(new ExtraActivity(IDActivity, activityName, timeNeeded, interruptible, 
                            typology, activityDescription, week));
        }
        return output;
    }        

}
