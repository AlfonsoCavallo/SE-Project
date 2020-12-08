package se.project.storage.repos;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.*;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.WeeklyAvailability;


public class WeeklyAvailabilityRepoTest
{
    
    public WeeklyAvailabilityRepoTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        resetDatabase();
    }
    
    @After
    public void tearDown()
    {
        try
        {
            resetDatabase();
            closeConnection();
        }
        catch (SQLException ex)
        {
            
        }
    }

    /**
     * 
     * Test of queryMaintainerAvailability method, of class WeeklyAvailabilityRepo.
     */
    @Test
    public void testQueryMaintainerAvailability_String_int()
    {
        try
        {
            connect(getTestUser());
            WeeklyAvailabilityRepo instance = new WeeklyAvailabilityRepo(getConnection());
            
            WeeklyAvailability weeklyAvailability = instance.queryMaintainerAvailability("gio", 1);            
            // Check on correct availability acquisition
            
            // Minutes
            assertEquals(15, weeklyAvailability.getMinutesAvailable(DayOfWeek.MONDAY, WeeklyAvailability.WorkTurn.H8));
            assertEquals(0, weeklyAvailability.getMinutesAvailable(DayOfWeek.TUESDAY, WeeklyAvailability.WorkTurn.H9));
            assertEquals(60, weeklyAvailability.getMinutesAvailable(DayOfWeek.WEDNESDAY, WeeklyAvailability.WorkTurn.H10));
            // Percentages
            assertEquals(46, weeklyAvailability.getPercentageAvailability(DayOfWeek.MONDAY));
            
            // Check on values without a correspondence on database
            weeklyAvailability = instance.queryMaintainerAvailability("donald", 1);      
            assertEquals(0, weeklyAvailability.getMinutesAvailable(DayOfWeek.SATURDAY, WeeklyAvailability.WorkTurn.H8));
            assertEquals(0, weeklyAvailability.getPercentageAvailability(DayOfWeek.SUNDAY));
        }
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    
    /**
     * 
     * Test of queryMaintainerAvailability method, of class WeeklyAvailabilityRepo.
     */
    @Test
    public void testQueryMaintainerAvailability_Maintainer_int() throws Exception
    {
        // TO implement
    }
    
    /**
     * 
     * Test of queryMaintainerAvailability on an unavailable user
     */
    @Test
    public void testQueryMaintainerAvailabilityUnavailableUser()
    {
        try
        {
            connect(getTestUser());
            WeeklyAvailabilityRepo instance = new WeeklyAvailabilityRepo(getConnection());
            
            // With unavailable user
            WeeklyAvailability weeklyAvailability = instance.queryMaintainerAvailability("unavailable_user", 1);
            assertNull(weeklyAvailability);
            
            // With non-maintainer user
            weeklyAvailability = instance.queryMaintainerAvailability("finneas", 1);
            assertNull(weeklyAvailability);
            
            closeConnection();
        }
        catch (ClassNotFoundException | IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * 
     * Test of queryAllWeeklyAvailabilities on an unavailable user
     */
    @Test
    public void testQueryAllWeeklyAvailabilities()
    {
        try
        {
            connect(getTestUser());
            WeeklyAvailabilityRepo instance = new WeeklyAvailabilityRepo(getConnection());
            
            List<String> testCompetencies = new ArrayList<>();
            testCompetencies.add("English Knowledge");
            testCompetencies.add("German Knowledge");
            
            // Test case with specific competencies
            List<WeeklyAvailability> weeklyAvailabilities = instance.queryAllWeeklyAvailabilities(testCompetencies, 1);
            assertEquals(19, weeklyAvailabilities.size());
            
            assertEquals("gio", weeklyAvailabilities.get(0).getUsername());            
            assertEquals(2, weeklyAvailabilities.get(0).getNumberOfCompetences());
            
            assertEquals("donald", weeklyAvailabilities.get(weeklyAvailabilities.size() -1).getUsername());
            assertEquals(0, weeklyAvailabilities.get((weeklyAvailabilities.size() -1)).getNumberOfCompetences());
            
            // Test case with no competencies
            weeklyAvailabilities = instance.queryAllWeeklyAvailabilities(null, 1);            
            assertEquals(19, weeklyAvailabilities.size());
            
            assertEquals("gio", weeklyAvailabilities.get(0).getUsername());            
            assertEquals(4, weeklyAvailabilities.get(0).getNumberOfCompetences());
            
            assertEquals("phil", weeklyAvailabilities.get(weeklyAvailabilities.size() -1).getUsername());
            assertEquals(3, weeklyAvailabilities.get((weeklyAvailabilities.size() -1)).getNumberOfCompetences());
            
            // Test with the same method with empty list parameter
            List<WeeklyAvailability> expectedWithEmptyList = instance.queryAllWeeklyAvailabilities(new LinkedList<String>(), 1);
            assertEquals(expectedWithEmptyList, weeklyAvailabilities);
            
            closeConnection();
        }
        catch (ClassNotFoundException | IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
}
