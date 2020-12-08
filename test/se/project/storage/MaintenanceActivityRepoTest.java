package se.project.storage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.connect;
import static se.project.storage.DatabaseConnection.getConnection;
import static se.project.storage.DatabaseTesting.getTestUser;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.*;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;


public class MaintenanceActivityRepoTest
{

    public MaintenanceActivityRepoTest()
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
     * Verify the presence of all maintenance activities in the system.
     * @Result The two maintenance activities recorded in the system are both correctly checked.
     */
    @Test
    public void testQueryAllMaintenanceActivity()
    {
        try
        {
            // Gets all (two) the maintenance activities in the system
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            LinkedList<MaintenanceActivity> maintenanceActivities = instance.queryAllMaintenanceActivity();
            
            // Tests expected elements
            assertEquals(2, maintenanceActivities.size());
            
            MaintenanceActivity expectedFirstElement = new PlannedActivity(1, "activity1", 45, true, ELECTRICAL, "riparazione turbina 3", 2, "1... 2... 3...");
            assertEquals(expectedFirstElement, maintenanceActivities.getFirst());
            
            MaintenanceActivity expectedSecondElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3, "4... 5... 6...");
            assertEquals(expectedSecondElement, maintenanceActivities.get(1));
            
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Verify the presence of a specific maintenance activity.
     * @Result First maintenance activity is available and checked but the second one is unavailable.
     */
    @Test
    public void testQueryViewOneMaintenanceActivity()
    {
        try
        {            
            // Gets an existent activity and an unavailable activity
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            LinkedList<MaintenanceActivity> maintenanceActivities = instance.queryOneMaintenanceActivity("activity2");
            LinkedList<MaintenanceActivity> noActivity = instance.queryOneMaintenanceActivity("unavailable_activity");
            
            // Test expected elements
            MaintenanceActivity expectedElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3, "4... 5... 6...");
            assertEquals(expectedElement, maintenanceActivities.getFirst());
            assertEquals(1, maintenanceActivities.size());
            
            assertEquals(0, noActivity.size());
            
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Delete a specific maintenance activity.
     * @Result The activity selected is correctly deleted.
     */
    @Test
    public void testDeleteExistentMaintenanceActivity()
    {
        try
        {
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            
            // Deletes activity1
            instance.deleteMaintenanceActivity("activity1");
            
            // Checks element was correctly deleted
            LinkedList<MaintenanceActivity> maintenanceActivities = instance.queryAllMaintenanceActivity();
            MaintenanceActivity expectedElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3, "4... 5... 6...");
            
            assertEquals(1, maintenanceActivities.size());
            assertEquals(expectedElement, maintenanceActivities.getFirst());
            
            closeConnection();
        }
        catch(ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * Try deleting a non-existent maintenance activity.
     * @Result Throws an exception.
     * @throws SQLException 
     */
    @Test
    public void testDeleteOnNonExistentMaintenanceActivity() throws SQLException
    {
        try
        {            
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            
            // Deletes no activity
            instance.deleteMaintenanceActivity("unavailable_activity");
        }
        catch(ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * 
     * Verify the presence of all maintenance activities in the system in a specific week.
     * @Result The two maintenance activities recorded in the system in the third week are both correctly checked.
     */
    @Test
    public void testQueryMaintenanceActivityInWeek()
    {
        try
        {
            // Gets all (two) the maintenance activities in the system in the week 3 in different sites
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            LinkedList<PlannedActivity> maintenanceActivities = instance.queryMaintenanceActivityInWeek(3);
            
            // Tests expected elements
            assertEquals(2, maintenanceActivities.size());
            
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            MaintenanceActivity expectedFirstElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3,"Fisciano", "Printing", expectedSkills, "4... 5... 6...");
            assertEquals(expectedFirstElement, maintenanceActivities.getFirst());
            
            MaintenanceActivity expectedSecondElement = new PlannedActivity(2, "activity2", 30, true, HYDRAULIC, "riparazione turbina 5", 3,"Fisciano", "Cleaning", expectedSkills, "4... 5... 6...");
            assertEquals(expectedSecondElement, maintenanceActivities.get(1));
            
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    /**
     * 
     * Verify the presence of all the skills needed for a specific activity in the system.
     * @Result The four skills recorded for activity 2 are correctly checked.
     */
    @Test
    public void testQuerySkillsNeeded()
    {
        try
        {
            // Gets all the skills needed for a specific activity in the system
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            ArrayList<String> skillsNeeded = instance.querySkillsNeeded(2);
            
            // Tests expected elements
            assertEquals(4, skillsNeeded.size());
            
            ArrayList<String> expectedSkills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
            assertEquals(expectedSkills, skillsNeeded);
            
            String expectedSecondElement =  "Knowledge of Workstation 23";
            assertEquals(expectedSecondElement, skillsNeeded.get(1));
            
            closeConnection();
        }
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }
    
    

}
