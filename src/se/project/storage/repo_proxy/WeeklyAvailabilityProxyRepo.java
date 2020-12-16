package se.project.storage.repo_proxy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.repos.WeeklyAvailabilityRepo;
import se.project.storage.repos.interfaces.WeeklyAvailabilityRepoInterface;


/***
 * A proxy for WeeklyAvailabilityRepoInterface that instatiate it only when necessary.
 */
public class WeeklyAvailabilityProxyRepo implements WeeklyAvailabilityRepoInterface
{    
    private WeeklyAvailabilityRepoInterface repo;
    private final Connection connection;

    /**
    * Instantiates the proxy.
    * @param connection is the connection established with the database.
    */
    public WeeklyAvailabilityProxyRepo(Connection connection)
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
            repo = new WeeklyAvailabilityRepo(connection);
        }
    }

    @Override
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryMaintainerAvailability(username, week);
    }

    @Override
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryMaintainerAvailability(maintainer, week);
    }

    @Override
    public List<WeeklyAvailability> queryAllWeeklyAvailabilities(List<String> competencies, int week) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryAllWeeklyAvailabilities(competencies, week);
    }
}
