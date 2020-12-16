package se.project.storage.repo_proxy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;


/***
 * A proxy for MaintenanceActivityRepoInterface that instatiate it only when necessary .
 */
public class MaintenanceActivityProxyRepo implements MaintenanceActivityRepoInterface
{
    private MaintenanceActivityRepoInterface repo;
    private final Connection connection;
    
    /**
    * Instantiates the proxy.
    * @param connection is the connection established with the database.
    */
    public MaintenanceActivityProxyRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    /***
     * Instatiates the repo only when a service is called.
     */
    private void instantiateRepo()
    {
        if(this.repo == null)
        {
            repo = new MaintenanceActivityRepo(connection);
        }
    }
    
    @Override
    public LinkedList<MaintenanceActivity> queryAllMaintenanceActivity() throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryAllMaintenanceActivity();
    }

    @Override
    public LinkedList<MaintenanceActivity> queryOneMaintenanceActivity(String activityName) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryOneMaintenanceActivity(activityName);
    }

    @Override
    public void deleteMaintenanceActivity(String activityName) throws IOException, SQLException
    {
        instantiateRepo();
        repo.deleteMaintenanceActivity(activityName);
    }

    @Override
    public void addMaintenanceActivity(MaintenanceActivity maintenanceActivity) throws IOException, SQLException
    {
        instantiateRepo();
        repo.addMaintenanceActivity(maintenanceActivity);
    }

    @Override
    public void updateMaintenanceActivity(MaintenanceActivity maintenanceActivity, String activityToUpdate) throws IOException, SQLException
    {
        instantiateRepo();
        repo.updateMaintenanceActivity(maintenanceActivity, activityToUpdate);
    }

    @Override
    public LinkedList<PlannedActivity> queryMaintenanceActivityInWeek(int weekSearched) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryMaintenanceActivityInWeek(weekSearched);
    }

    @Override
    public void assignMaintenanceActivity(MaintenanceActivity maintenanceActivity, Maintainer maintainer, DayOfWeek day, WeeklyAvailability.WorkTurn turn, int minutesAvailable) throws IOException, SQLException
    {
        instantiateRepo();
        repo.assignMaintenanceActivity(maintenanceActivity, maintainer, day, turn, minutesAvailable);
    }
    
}
