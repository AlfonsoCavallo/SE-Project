/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;
import static se.project.business_logic.utilities.FileUtilities.getStringFromFile;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.repos.interfaces.WeeklyAvailabilityRepoInterface;

/**
 *
 * @author Utente
 */
public class WeeklyAvailabilityRepo extends AbstractRepo implements WeeklyAvailabilityRepoInterface
{
    
    private final String QUERY_ONE_WEEKLY_AVAILABILITY = "/se/project/assets/query/QueryOneWeeklyAvailability.sql";
    private final String QUERY_ALL_WEEKLY_AVAILABILITIES = "/se/project/assets/query/QueryAllWeeklyAvailabilities.sql";

    /**
     * 
     * Creates a new WeeklyAvailabilityRepo
     * @param connection is the current connection
     */
    public WeeklyAvailabilityRepo(Connection connection)
    {
        super(connection);
    }

    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param username is the username of the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work (null if there are no infos)
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ONE_WEEKLY_AVAILABILITY);
        query = query.replaceAll("username_param", username);
        
        ResultSet result = super.queryDatabase(query);
        
        WeeklyAvailability weeklyAvailability = null;
        
        while(result.next())
        {
            if(weeklyAvailability == null)
            {
                weeklyAvailability = new WeeklyAvailability(username);
            }
            
            DayOfWeek day = DayOfWeek.valueOf(result.getString("day_of_week").toUpperCase());
            int h8 = result.getInt("8_9");
            int h9 = result.getInt("9_10");
            int h10 = result.getInt("10_11");
            int h11 = result.getInt("11_12");
            int h14 = result.getInt("14_15");
            int h15 = result.getInt("15_16");
            int h16 = result.getInt("16_17");
            weeklyAvailability.setAvailabilities(day, h8, h9, h10, h11, h14, h15, h16);
        }
        
        return weeklyAvailability;
    }

    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param maintainer is the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work (null if there are no infos)
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException
    {
        return queryMaintainerAvailability(maintainer.getUsername(), week); 
    }

    /***
     * Get a list of availability for a certain list of required competencies
     * @param competencies are the required competencies (can be null or empty)
     * @return a list of availability of Maintainers
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public List<WeeklyAvailability> queryAllWeeklyAvailabilities(List<String> competencies, int week) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ALL_WEEKLY_AVAILABILITIES);
        String condition = "";
        
        // Groups every maintainer with those competencies if there is any
        if(competencies != null && competencies.size() > 0)
        {
            for(String competence: competencies)
            {
                if(!condition.equals(""))
                {
                    condition += " or ";
                }
                else
                {
                    condition += "and (";
                }
                condition += "u.competence_name_ref = '" + competence + "'";
            }
            condition += ")";
        }
        
        query = query.replaceAll("condition_param", condition);
        
        ResultSet result = super.queryDatabase(query);
        
        List<WeeklyAvailability> weeklyAvailabilities = new LinkedList<>();
        
        while(result.next())
        {
            WeeklyAvailability weeklyAvailability = new WeeklyAvailability(result.getString("worker_username"));
            
            weeklyAvailability.setNumberOfCompetences(result.getInt("competencies"));
            DayOfWeek day = DayOfWeek.valueOf(result.getString("day_of_week").toUpperCase());
            int h8 = result.getInt("8_9");
            int h9 = result.getInt("9_10");
            int h10 = result.getInt("10_11");
            int h11 = result.getInt("11_12");
            int h14 = result.getInt("14_15");
            int h15 = result.getInt("15_16");
            int h16 = result.getInt("16_17");
            weeklyAvailability.setAvailabilities(day, h8, h9, h10, h11, h14, h15, h16);
            
            weeklyAvailabilities.add(weeklyAvailability);
        }
        
        return weeklyAvailabilities;
    }
}
