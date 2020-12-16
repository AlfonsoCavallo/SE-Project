package se.project.storage.repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.WeeklyAvailability.WorkTurn;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.*;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
* Is a DAO that provides method to manipulate Maintenance Activity models.
* 
*/
public class MaintenanceActivityRepo extends AbstractRepo implements MaintenanceActivityRepoInterface     
{
    private final String QUERY_ALL_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAllMaintenanceActivity.sql";
    private final String QUERY_VIEW_ONE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryViewOneMaintenanceActivity.sql";
    private final String QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryDeleteMaintenanceActivity.sql";
    private final String QUERY_ADD_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAddMaintenanceActivity.sql";
    private final String QUERY_UPDATE_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryUpdateMaintenanceActivity.sql";
    private final String QUERY_MAINTENANCE_ACTIVITY_IN_WEEK_PATH = "/se/project/assets/query/QueryMaintenanceActivityInWeek.sql";
    private final String QUERY_SKILLS_NEEDED_PATH = "/se/project/assets/query/QuerySkillsNeeded.sql";
    private final String QUERY_ASSIGN_MAINTENANCE_ACTIVITY_PATH = "/se/project/assets/query/QueryAssignMaintenanceActivity.sql";
    
    /**
     * 
     * Creates a new MaintenanceActivityRepo.
     * @param connection is the current connection.
     */
    public MaintenanceActivityRepo(Connection connection)
    {
        super(connection);
    }
    
    /**
     * 
     * @return a LinkedList of the MaintenanceActivity in the system.
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
     * @param activityName is the name of the activity that has to be shown.
     * @return a LinkedList of the MaintenanceActivity in which there is a specific maintenance activity.
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
    
    @Override
    public void deleteMaintenanceActivity(String activityName) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_DELETE_MAINTENANCE_ACTIVITY_PATH);
        query = query.replaceAll("activity_name_param", activityName);
        executeStatement(query);
    }
    
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
        String branchOffice = maintenanceActivity.getBrachOffice();
        String department = maintenanceActivity.getDepartment();
        String standardProcedure = maintenanceActivity.getStandardProcedure();
        
        query = query.replaceAll("activity_name_param", activityName);
        query = query.replaceAll("time_needed_param", String.valueOf(timeNeeded));
        query = query.replaceAll("interruptible_param", interruptible);
        query = query.replaceAll("typology_param", String.valueOf(typology));
        query = query.replaceAll("activity_description_param", activityDescription);
        query = query.replaceAll("week_param", String.valueOf(week));
        query = query.replaceAll("planned_param", planned);
        query = query.replaceAll("ewo_param", ewo);
        query = query.replaceAll("office_param", branchOffice);
        query = query.replaceAll("department_param", department);
        query = query.replaceAll("standard_param", standardProcedure);
        executeStatement(query);
    }
    
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
        String branchOffice = maintenanceActivity.getBrachOffice();
        String department = maintenanceActivity.getDepartment();
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
        query = query.replaceAll("office_param", branchOffice);
        query = query.replaceAll("department_param", department);
        query = query.replaceAll("standard_param", standardProcedure);
        query = query.replaceAll("activity_param", oldActivityName);
        executeStatement(query);
    }
    
    /**
     * Query a list of maintenance activities.
     * @param query is the statement from which to extract data to build the model.
     * @return a LinkedList of MaintenanceActivity that are in the database.
     * @throws SQLException 
     */
    private LinkedList<MaintenanceActivity> queryMaintenanceActivityList(String query) throws SQLException, IOException
    {
        ResultSet resultSet = super.queryDatabase(query);
        LinkedList<MaintenanceActivity> output = new LinkedList<>();
        
        while(resultSet.next())
        {
            int IDActivity = resultSet.getInt("id_activity");
            String activityName = resultSet.getString("activity_name");
            int timeNeeded = resultSet.getInt("time_needed");
            int remainingTime = resultSet.getInt("remaining_time");
            boolean interruptible = resultSet.getBoolean("interruptible");
            Typology typology = fromString(resultSet.getString("typology"));
            String activityDescription = resultSet.getString("activity_description");
            int week = resultSet.getInt("week");
            String planned = resultSet.getString("planned");
            String branchOffice = resultSet.getString("activity_branch_office");
            String department = resultSet.getString("activity_department");
            String standardProcedure = resultSet.getString("standard_procedure");
            
            if(planned.equals("yes"))
            {
                output.add(new PlannedActivity(IDActivity, activityName, timeNeeded, remainingTime, interruptible, 
                            typology, activityDescription, week, branchOffice, department, querySkillsNeeded(IDActivity), standardProcedure));
            }
            else
            {
                output.add(new ExtraActivity(IDActivity, activityName, timeNeeded, remainingTime, interruptible, 
                            typology, activityDescription, week, branchOffice, department, querySkillsNeeded(IDActivity)));
            }
        }
        return output;
    } 
    
    @Override
    public LinkedList<PlannedActivity> queryMaintenanceActivityInWeek(int weekSearched) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_MAINTENANCE_ACTIVITY_IN_WEEK_PATH);
        query = query.replaceAll("week_param", String.valueOf(weekSearched));
        return queryMaintenanceActivityListWithSite(query);
    }
    
    /**
     * Query a planned activity list with site informations.
     * @param query is the statement from which to extract data to build the model.
     * @return a LinkedList of PlannedActivity that are in the database in a specific week.
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
            int remainingTime = resultSet.getInt("remaining_time");
            boolean interruptible = resultSet.getBoolean("interruptible");
            Typology typology = fromString(resultSet.getString("typology"));
            String activityDescription = resultSet.getString("activity_description");
            int week = resultSet.getInt("week");
            String planned = resultSet.getString("planned");
            String ewo = resultSet.getString("ewo");
            String standardProcedure = resultSet.getString("standard_procedure");
            String branchOffice = resultSet.getString("activity_branch_office");
            String department = resultSet.getString("activity_department");
            ArrayList<String> skills = querySkillsNeeded(IDActivity);
            
            
            output.add(new PlannedActivity(IDActivity, activityName, timeNeeded, remainingTime, interruptible, 
                        typology, activityDescription, week, branchOffice, department, skills, standardProcedure));
            
        }
        return output;
    }
    
    /**
     * Query the sills needed for an activity.
     * @param IDActivity is the id of the searched activity.
     * @return an ArrayList contining the skills needed fot that activity.
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
    
    /**
     * Assign a Maintenance activity to a maintainer.
     * @param maintenanceActivity is the activity to be assigned.
     * @param maintainer is the maintainer who'll work on the activity.
     * @param day is the day in which the Maintainer will work on that task.
     * @param turn is the turn in which the Maintainer will work on that task.
     * @param minutes are the number of minutes the maintainer is available.
     * @throws IOException
     * @throws SQLException
     */
    public void assignMaintenanceActivity(MaintenanceActivity maintenanceActivity, Maintainer maintainer, DayOfWeek day, WeeklyAvailability.WorkTurn turn, int minutes) throws IOException, SQLException
    {
        String statement = getStringFromFile(QUERY_ASSIGN_MAINTENANCE_ACTIVITY_PATH);
        
        int remainingTime = maintenanceActivity.getRemainingTime();
        
        int newRemainingTime = maintenanceActivity.getRemainingTime();
        int newAvailableMinutes = 0;
        
        // No assignment for 0 minutes 
        if(minutes == 0)
        {
            return;
        }
        
        // Update the values of availability for maintainer and remaining time for activity
        if(remainingTime >= minutes)
        {
            newRemainingTime -= minutes;
        }
        else
        {
            newRemainingTime = 0;
            newAvailableMinutes = minutes - remainingTime;
        }
        
        // Edits the statement
        statement = statement.replaceAll("id_param", String.valueOf(maintenanceActivity.getIdActivity()));
        statement = statement.replaceAll("assignment_username_param", maintainer.getUsername());
        
        String dayName = day.name().substring(0, 1) + day.name().substring(1).toLowerCase();
        String turnName = WorkTurn.getValue(turn);
        
        // Create a new assignment entity
        statement = statement.replaceAll("assignment_day_param", dayName);
        statement = statement.replaceAll("assignment_time_param", turnName);
        statement = statement.replaceAll("assignment_turn_param", turnName);
        
        // Update workshift for that user
        statement = statement.replaceAll("turn_param", String.valueOf("\"" + turnName + "\""));
        statement = statement.replaceAll("new_turn_value_param", String.valueOf(newAvailableMinutes));
        statement = statement.replaceAll("week_param", String.valueOf(maintenanceActivity.getWeek()));
        
        // Update maintenance activity remaining time
        statement = statement.replaceAll("new_remaining_time_param", String.valueOf(newRemainingTime));
        
        super.executeStatement(statement);        
    }
}
