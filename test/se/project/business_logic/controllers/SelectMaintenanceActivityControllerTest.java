package se.project.business_logic.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.AssertionFailedError;
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
    }
    
    @After
    public void tearDown()
    {
        try
        {
            closeConnection();
        }
        catch (SQLException ex)
        {
            
        }
        
    }

    /**
     * 
     * Initializes Mock
     * @return a SelectMaintenanceActivityView representig a mock of a real view
     */
    private SelectMaintenanceActivityView simulateView()
    {
        SelectMaintenanceActivityView mock = mock(SelectMaintenanceActivityView.class, RETURNS_DEEP_STUBS);
        when(mock.getWeek()).thenReturn(3);
        when(mock.getjTable().getSelectedRow()).thenReturn(0);
        return mock;
    }
    
    /**
     * 
     * Check if the activity in the first row of the table in the third week is equal to the aspected one.
     * @Result The two planned activities are correctly checked.
     */
    @Test
    public void testSelectMaintenanceActivity()
    {
        try
        {
            connect(getTestUser());
        
            SelectMaintenanceActivityController controller = new SelectMaintenanceActivityController(simulateView());
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedActivity = new PlannedActivity(2, "activity2", 30, 30, true, HYDRAULIC, "riparazione turbina 5", 3, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            boolean open = controller.selectMaintenaceActivity();
            assertEquals(expectedActivity, controller.getPlannedActivity());
            assertTrue(open);
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Check if the activity in the first row of the table in the third week is equal to an actvity with another department.
     * @Result The check on the two planned activities fails and exceptions are thrown.
     * @throws AssertionError 
     */
    @Test(expected = AssertionError.class)
    public void testSelectMaintenanceActivityWrongDepartment()
    {
        try
        {
            connect(getTestUser());
        
            SelectMaintenanceActivityController controller = new SelectMaintenanceActivityController(simulateView());
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedActivity = new PlannedActivity(2, "activity2", 30, 30, true, HYDRAULIC, "riparazione turbina 5", 3, "Fisciano", "Molding", expectedSkills, "4... 5... 6...");
            controller.selectMaintenaceActivity();
            assertEquals(expectedActivity, controller.getPlannedActivity());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Check if the activity in the first row of the table in the third week is equal to an actvity with another week.
     * @Result The check on the two planned activities fails and exceptions are thrown.
     * @throws AssertionError 
     */
    @Test(expected = AssertionError.class)
    public void testSelectMaintenanceActivityWrongWeek()
    {
        try
        {
            connect(getTestUser());
        
            SelectMaintenanceActivityController controller = new SelectMaintenanceActivityController(simulateView());
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedActivity = new PlannedActivity(2, "activity2", 30, 30, true, HYDRAULIC, "riparazione turbina 5", 2, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            controller.selectMaintenaceActivity();
            assertEquals(expectedActivity, controller.getPlannedActivity());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Check if the activity in the first row of the table in the third week is equal to an actvity with another ID.
     * @Result The check on the two planned activities fails and exceptions are thrown.
     * @throws AssertionError 
     */
    @Test(expected = AssertionError.class)
    public void testSelectMaintenanceActivityWrongID()
    {
        try
        {
            connect(getTestUser());
        
            SelectMaintenanceActivityController controller = new SelectMaintenanceActivityController(simulateView());
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedActivity = new PlannedActivity(1, "activity2", 30, 30, true, HYDRAULIC, "riparazione turbina 5", 3, "Lauria", "Molding", expectedSkills, "4... 5... 6...");
            controller.selectMaintenaceActivity();
            assertEquals(expectedActivity, controller.getPlannedActivity());
            
            closeConnection();
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
}
