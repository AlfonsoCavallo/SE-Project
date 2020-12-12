package se.project.business_logic.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.project.business_logic.controllers.activities_assignment.ActivityAssignmentController;
import static org.junit.Assert.*;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.WeeklyAvailability;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.HYDRAULIC;
import se.project.storage.models.maintenance_activity.PlannedActivity;


public class ActivityAssignmentControllerTest
{
    
    public ActivityAssignmentControllerTest()
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
            String username = "donald";
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            PlannedActivity plannedActivity = new PlannedActivity(2, "activity2", 30, 30, true, 
                                                  HYDRAULIC, "riparazione turbina 5", 3, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            
            connect(getTestUser());
            
            WeeklyAvailability weeklyAvailability = new WeeklyAvailability(username);
            ActivityAssignmentController istance = new ActivityAssignmentController(plannedActivity);
            
            Object[] availabilityModel = weeklyAvailability.getDataForAssignment();
            Object[] modelUpdated = istance.UpdateDataModel(availabilityModel);
            
            Object[] expectedUpdatedModel = new Object[]{"donald", "3/4", "100%", "100%", "100%", "100%", "100%", "0%", "0%"};
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