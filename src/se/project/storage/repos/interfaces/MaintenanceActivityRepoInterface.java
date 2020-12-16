package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.PlannedActivity;

/**
* Is a DAO interface that provides method to manipulate Maintenance Activity models.
* 
*/
public interface MaintenanceActivityRepoInterface
{
    /**
     * 
     * @return a LinkedList of the MaintenanceActivity in the system.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException;
    
    /**
     * 
     * @param activityName is the name of the activity that has to be shown.
     * @return a LinkedList of MaintenanceActivity in which there is a specific maintenance activity.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<MaintenanceActivity> queryOneMaintenanceActivity(String activityName) throws IOException, SQLException;

    /**
     * 
     * Delete a specific maintenance activity.
     * @param activityName is the name of the activity that has to be deleted.
     * @throws IOException
     * @throws SQLException 
     */
    public void deleteMaintenanceActivity(String activityName) throws IOException, SQLException;
    
    /**
     * 
     * Add a new maintenance activity.
     * @param maintenanceActivity is the maintenance activity that has to be added.
     * @throws IOException
     * @throws SQLException 
     */
    public void addMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException;
    
    /**
     * 
     * Update a specific maintenance activity.
     * @param maintenanceActivity is the maintenance activity that has to be updated.
     * @param activityToUpdate is the previous name of the activity that has to be updated.
     * @throws IOException
     * @throws SQLException 
     */
    public void updateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException;
    
    /**
     * 
     * @param weekSearched is the week in which to search activities.
     * @return a LinkedList of PlannedActivity containing the activities in a specific week.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<PlannedActivity> queryMaintenanceActivityInWeek(int weekSearched) throws IOException, SQLException;
    
    /**
     * Assign a Maintenance activity to a maintainer.
     * @param maintenanceActivity is the activity to be assigned.
     * @param maintainer is the maintainer who'll work on the activity.
     * @param day is the day in which the Maintainer will work on that task.
     * @param turn is the turn in which the Maintainer will work on that task.
     * @param minutesAvailable are the minutes available for that maintainer.
     * @throws IOException
     * @throws SQLException
     */
    public void assignMaintenanceActivity(MaintenanceActivity maintenanceActivity, Maintainer maintainer, 
            DayOfWeek day, WeeklyAvailability.WorkTurn turn, int minutesAvailable) throws IOException, SQLException;
}
