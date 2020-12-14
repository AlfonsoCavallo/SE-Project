package se.project.business_logic.controllers;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.project.business_logic.controllers.activities_assignment.ActivityForwardingController;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.WeeklyAvailability;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.HYDRAULIC;
import se.project.storage.models.maintenance_activity.PlannedActivity;


public class ActivityForwardingControllerTest
{
    
    public ActivityForwardingControllerTest()
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

    
    @Test
    public void testUpdateDataModel() 
    {
        try
        {
            connect(getTestUser());
            
            String username = "donald";
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            PlannedActivity plannedActivity = new PlannedActivity(2, "activity2", 30, 30, true, 
                                                  HYDRAULIC, "riparazione turbina 5", 3, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            
            String dayOfWeek = "Friday";
            int dayOfMonth = 17;
            String maintainerPercentage = "100%";
            
            WeeklyAvailability weeklyAvailability = new WeeklyAvailability(username);
            weeklyAvailability.setNumberOfCompetences(3);
            weeklyAvailability.setAvailabilities(DayOfWeek.SUNDAY, 0, 0, 0, 0, 0, 0, 0);
            weeklyAvailability.setAvailabilities(DayOfWeek.MONDAY, 60, 60, 60, 60, 60, 60, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.TUESDAY, 60, 60, 60, 60, 60, 60, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.WEDNESDAY, 60, 60, 60, 60, 60, 60, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.THURSDAY, 60, 60, 60, 60, 60, 60, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.FRIDAY, 60, 60, 60, 60, 60, 60, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.SATURDAY, 0, 0, 0, 0, 0, 0, 0);
            
            ActivityForwardingController istance = new ActivityForwardingController(plannedActivity, weeklyAvailability, dayOfWeek, dayOfMonth, maintainerPercentage);
            istance.getActivityForwardingView();
            
            Object[] availabilityModel = weeklyAvailability.getDataForForwarding(dayOfWeek);
            Object[] modelUpdated = istance.updateDataModel(availabilityModel);
            
            Object[] expectedUpdatedModel = new Object[]{"donald", "3/4", "60 min", "60 min", "60 min", "60 min", "60 min", "60 min", "60 min"};
            assertEquals(expectedUpdatedModel, modelUpdated);
            
            closeConnection();
            
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        } 
        
    }
}
