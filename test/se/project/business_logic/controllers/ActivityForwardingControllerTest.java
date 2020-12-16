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
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import se.project.business_logic.controllers.activities_assignment.ActivityForwardingController;
import se.project.presentation.views.activities_assignment.ActivityForwardingView;
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

    
    /**
     * Initializes Mock
     * @return a ActivityForwardingView representig a mock of a real view
     */
    private ActivityForwardingView simulateView()
    {
        ActivityForwardingView mock = mock(ActivityForwardingView.class, RETURNS_DEEP_STUBS);

        when(mock.getjMaintainerTimeAvailabilityTable().getSelectedRow()).thenReturn(0);
        when(mock.getjMaintainerTimeAvailabilityTable().getSelectedColumn()).thenReturn(6);
        
        when(mock.getjMaintainerTimeAvailabilityTable().getColumnName(6)).thenReturn("14:00 - 15:00");
        when(mock.getjMaintainerTimeAvailabilityTable().getValueAt(0, 6)).thenReturn("30 min");
        
        return mock;
    } 
    
    /**
     * Check that the maintainer is available in the selected workshift.
     * @Result The availability of the maintainer is "30 min", so the activity is correctly assigned to him in the selected workshift.
     */
    @Test
    public void testForwardingActivity()
    {
        try
        {
            connect(getTestUser());
            
            String username = "gio";
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", 
                    "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            PlannedActivity plannedActivity = new PlannedActivity(2, "activity2", 30, 30, true,
                    HYDRAULIC, "riparazione turbina 5", 3, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            
            String dayOfWeek = "Wednesday";
            int dayOfMonth = 15;
            String maintainerPercentage = "42%";
            
            WeeklyAvailability weeklyAvailability = new WeeklyAvailability(username);
            weeklyAvailability.setNumberOfCompetences(1);
            weeklyAvailability.setAvailabilities(DayOfWeek.SUNDAY, 25, 0, 60, 30, 45, 0, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.MONDAY, 15, 0, 60, 30, 30, 50, 10);
            weeklyAvailability.setAvailabilities(DayOfWeek.TUESDAY, 0, 0, 60, 10, 30, 50, 60);
            weeklyAvailability.setAvailabilities(DayOfWeek.WEDNESDAY, 25, 0, 60, 0, 30, 50, 15);
            weeklyAvailability.setAvailabilities(DayOfWeek.THURSDAY, 15, 0, 60, 30, 0, 50, 15);
            weeklyAvailability.setAvailabilities(DayOfWeek.FRIDAY, 0, 0, 60, 30, 20, 50, 0);
            weeklyAvailability.setAvailabilities(DayOfWeek.SATURDAY, 40, 0, 20, 40, 30, 50, 60);
            
            ActivityForwardingController controller = new ActivityForwardingController(simulateView());
            controller.setAvailabilityModels(plannedActivity, weeklyAvailability, dayOfWeek, dayOfMonth, maintainerPercentage);
            
            boolean open = controller.forwardActivity(plannedActivity, weeklyAvailability);
            assertTrue(open);
            
            closeConnection();
            
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        } 
        
    }        
    
}
