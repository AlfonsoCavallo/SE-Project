package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;

/**
* Is a DAO interface that provides method to manipulate Weekly Availability models.
* 
*/
public interface WeeklyAvailabilityRepoInterface
{
    /**
     * 
     * Queries the database for an instance with infos about the availability of a certain Maintainer.
     * @param username is the username of the Maintainer you want to search.
     * @param week is the week to check the availability.
     * @return an Availability object with all the informations about the Maintainer work.
     * @throws IOException
     * @throws SQLException 
     */
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException;
    
    /**
     * 
     * Queries the database for an instance with infos about the availability of a certain Maintainer.
     * @param maintainer is the Maintainer you want to search.
     * @param week is the week to check the availability.
     * @return an Availability object with all the informations about the Maintainer work.
     * @throws IOException
     * @throws SQLException 
     */
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException;
    
    /**
     *
     * Queries the database for a list of availability for a certain list of required competencies.
     * @param competencies are the required competencies.
     * @param week is the specific week of interest.
     * @return a list of availability of Maintainers.
     * @throws IOException
     * @throws SQLException 
     */
    public List<WeeklyAvailability> queryAllWeeklyAvailabilities(List<String> competencies, int week) throws IOException, SQLException;
}
