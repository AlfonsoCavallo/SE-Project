package se.project.storage.repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import se.project.storage.models.maintenance_activity.EWO;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.*;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;


public class MaintenanceActivityRepo extends AbstractRepo implements MaintenanceActivityRepoInterface     
{
    private final String QUERY_ALL_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAllMaintenanceActivity.sql";
    private final String QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryViewOneMaintenanceActivity.sql";
    private final String QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryDeleteMaintenanceActivity.sql";
    private final String QUERY_ADD_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAddMaintenanceActivity.sql";
    private final String QUERY_UPDATE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryUpdateMaintenanceActivity.sql";
    private final String QUERY_MAINTENANCE_ACTIVITY_IN_WEEK_PATH = "/se/project/assets/query/QueryMaintenanceActivityInWeek.sql";
    private final String QUERY_SKILLS_NEEDED_PATH = "/se/project/assets/query/QuerySkillsNeeded.sql";
    
    /**
     * 
     * Creates a new MaintenanceActivityRepo
     * @param connection is the current connection
     */
    public MaintenanceActivityRepo(Connection connection)
    {
        super(connection);
    }
    
    /**
     * 
     * @return a LinkedList of the MaintenanceActivity in the system
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ALL_MAINTENANCE_ACTIVITY_PATH);
        return queryMaintenanceActivityList(query);
    }

    /**
     * 
     * @param activityName is the name of the activity that has to be shown
     * @return a LinkedList of the MaintenanceActivity in which there is a specific maintenance activity
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public LinkedList<MaintenanceActivity> queryOneMaintenanceActivity(String activityName) throws IOException, SQLException
    {
        // Return a specific maintenance activity
        String query = getStringFromFile(QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH);
        query = query.replaceAll("activity_name_param", activityName);
        return queryMaintenanceActivityList(query);
    }
    
    /**
     * 
     * Delete a specific maintenance activity
     * @param activityName is the name of the activity that has to be deleted
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public void deleteMaintenanceActivity(String activityName) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH);
        query = query.replaceAll("activity_name_param", activityName);
        executeStatement(query);
    }
    
    /**
     * 
     * Add a new maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be added
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public void addMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException
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
    
    /**
     * 
     * Update a specific maintenance activity
     * @param maintenanceActivity is the maintenance activity that has to be updated
     * @param activityToUpdate is the previous name of the activity that has to be updated
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public void updateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_UPDATE_MAINTENANCE_ACTIVITY_PATH);
        
        String activityName = maintenanceActivity.getActivityName();
        int timeNeeded = maintenanceActivity.getTimeNeeded();
        String interruptible = maintenanceActivity.isInterruptible();
        String typology = maintenanceActivity.getTypology().getValue();
        String activityDescription = maintenanceActivity.getActivityDescription();
        int week = maintenanceActivity.getWeek();
        String planned = maintenanceActivity.isPlanned();
        String ewo = maintenanceActivity.isEWO();
        String standardProcedure = maintenanceActivity.getStandardProcedure();
        String oldActivityName = activityToUpdate;
        
        query = query.replaceAll("activity_name_param", activityName);
        query = query.replaceAll("time_needed_param", String.valueOf(timeNeeded));
        query = query.replaceAll("interruptible_param", interruptible);
        query = query.replaceAll("typology_param", String.valueOf(typology));
        query = query.replaceAll("activity_description_param", activityDescription);
        query = query.replaceAll("week_param", String.valueOf(week));
        query = query.replaceAll("planned_param", planned);
        query = query.replaceAll("ewo_param", ewo);
        query = query.replaceAll("standard_param", standardProcedure);
        query = query.replaceAll("activity_param", oldActivityName);
        executeStatement(query);
    }
    
    /**
     * 
     * @param query is the query from which to extract data to build the model
     * @return a LinkedList of MaintenanceActivity that are in the database
     * @throws SQLException 
     */
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
    
    /**
     * 
     * @param weekSearched is the week in which to search activities
     * @return a LinkedList of PlannedActivity containing the activities in a specific week
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public LinkedList<PlannedActivity> queryMaintenanceActivityInWeek(int weekSearched) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_MAINTENANCE_ACTIVITY_IN_WEEK_PATH);
        query = query.replaceAll("week_param", String.valueOf(weekSearched));
        return queryMaintenanceActivityListWithSite(query);
    }
    
    /**
     * 
     * @param query is the query from which to extract data to build the model
     * @return a LinkedList of PlannedActivity that are in the database in a specific week
     * @throws SQLException
     * @throws IOException 
     */
    private LinkedList<PlannedActivity> queryMaintenanceActivityListWithSite(String query) throws SQLException, IOException
    {
        ResultSet resultSet = super.queryDatabase(query);
        LinkedList<PlannedActivity> output = new LinkedList<>();
        
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
            String branchOffice = resultSet.getString("branch_office_ref");
            String department = resultSet.getString("department_ref");
            ArrayList<String> skills = querySkillsNeeded(IDActivity);
            
            
            output.add(new PlannedActivity(IDActivity, activityName, timeNeeded, interruptible, 
                        typology, activityDescription, week, branchOffice, department, skills, standardProcedure));
            
        }
        return output;
    }
    
    /**
     * 
     * @param IDActivity is the id of the searched activity
     * @return an ArrayList contining the skills needed fot that activity
     * @throws IOException
     * @throws SQLException
     * @throws NullPointerException 
     */
    public ArrayList<String> querySkillsNeeded(int IDActivity) throws IOException, SQLException, NullPointerException
    {
        String query = getStringFromFile(QUERY_SKILLS_NEEDED_PATH);
        query = query.replaceAll("id_param", String.valueOf(IDActivity));
        ResultSet resultSet = super.queryDatabase(query);
        ArrayList<String> skills = new ArrayList<>();
        while(resultSet.next())
        {
            skills.add(resultSet.getString("competence_name_needed_ref"));
        }
        return skills;
    }
}
