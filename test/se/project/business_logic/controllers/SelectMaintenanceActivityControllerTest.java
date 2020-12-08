package se.project.business_logic.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import se.project.presentation.views.activities_assignment.SelectMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.HYDRAULIC;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.business_logic.controllers.activities_assignment.SelectMaintenanceActivityController;

public class SelectMaintenanceActivityControllerTest
{
    
    public SelectMaintenanceActivityControllerTest()
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

    private static SelectMaintenanceActivityView simulateView()
    {
        // Initializes Mock
        SelectMaintenanceActivityView mock = mock(SelectMaintenanceActivityView.class);
        when(mock.getWeek()).thenReturn(3);
        when(mock.getjTable().getSelectedRow()).thenReturn(0);
        return mock;
    }
    
    /*@Test
    public void testSelectMaintenanceActivity()
    {
        try
        {
            connect(getTestUser());
            SelectMaintenanceActivityController controller = new SelectMaintenanceActivityController();
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedFirstElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3,"Fisciano", "Printing", expectedSkills, "4... 5... 6...");
            
            
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }*/
    
}
