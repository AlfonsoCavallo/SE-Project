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
* Is a DAO that provides method to manipulate Weekly Availability models.
* 
*/
public class WeeklyAvailabilityRepo extends AbstractRepo implements WeeklyAvailabilityRepoInterface
{
    
    private final String QUERY_ONE_WEEKLY_AVAILABILITY = "/se/project/assets/query/QueryOneWeeklyAvailability.sql";
    private final String QUERY_ALL_WEEKLY_AVAILABILITIES = "/se/project/assets/query/QueryAllWeeklyAvailabilities.sql";

    /**
     * 
     * Creates a new WeeklyAvailabilityRepo.
     * @param connection is the current connection.
     */
    public WeeklyAvailabilityRepo(Connection connection)
    {
        super(connection);
    }

    @Override
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ONE_WEEKLY_AVAILABILITY);
        query = query.replaceAll("username_param", username);
        query = query.replaceAll("week_param", String.valueOf(week));
        
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

    @Override
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException
    {
        return queryMaintainerAvailability(maintainer.getUsername(), week); 
    }

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
        query = query.replaceAll("week_param", String.valueOf(week));
        
        ResultSet result = super.queryDatabase(query);
        
        LinkedList<WeeklyAvailability> weeklyAvailabilities = new LinkedList<>();        
        
        while(result.next())
        {            
            String username = result.getString("worker_username");
            
            if(weeklyAvailabilities.size() == 0 || !weeklyAvailabilities.getLast().getUsername().equals(username))
            {
                weeklyAvailabilities.add(new WeeklyAvailability(username));
            }
                
            weeklyAvailabilities.getLast().setNumberOfCompetences(result.getInt("competencies"));
            DayOfWeek day = DayOfWeek.valueOf(result.getString("day_of_week").toUpperCase());
            int h8 = result.getInt("8_9");
            int h9 = result.getInt("9_10");
            int h10 = result.getInt("10_11");
            int h11 = result.getInt("11_12");
            int h14 = result.getInt("14_15");
            int h15 = result.getInt("15_16");
            int h16 = result.getInt("16_17");
            weeklyAvailabilities.getLast().setAvailabilities(day, h8, h9, h10, h11, h14, h15, h16);
        }
        
        return weeklyAvailabilities;
    }
}
