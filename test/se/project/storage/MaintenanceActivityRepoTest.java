/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage;

import java.io.IOException;
import java.sql.SQLException;
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

/**
 *
 * @author delso
 */
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
            closeConnection();
        }
        catch (SQLException ex)
        {

        }
    }

    // Tests for Query
    @Test
    public void testQueryAllMaintenanceActivity()
    {
        // Tests Query of all Maintenance Activities
        try
        {
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

    // Return all the maintenance activities in the system
    @Test
    public void testQueryViewOneMaintenanceActivity()
    {
        // Return a specific maintenance activity (available and unavailable)
        try
        {            
            // Tests Query on existent activity
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            LinkedList<MaintenanceActivity> maintenanceActivities = instance.queryViewOneMaintenanceActivity("activity2");
            LinkedList<MaintenanceActivity> noActivity = instance.queryViewOneMaintenanceActivity("unavailable_activity");
            
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

    @Test
    public void testQueryDeleteExistentMaintenanceActivity()
    {
        // Delete a specific maintenance activity
        try
        {
            
            // Tests delete on existent activity
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            
            // Deletes activity1
            instance.queryDeleteMaintenanceActivity("activity1");
            
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
    
    @Test
    public void testQueryDeleteOnNonExistentMaintenanceActivity() throws SQLException
    {
        // Delete a specific maintenance activity
        try
        {            
            // Tests delete on existent activity
            connect(getTestUser());
            MaintenanceActivityRepo instance = new MaintenanceActivityRepo(getConnection());
            
            // Deletes no activity
            instance.queryDeleteMaintenanceActivity("unavailable_activity");
        }
        catch(ClassNotFoundException | IOException ex)
        {
            System.err.println(ex.getMessage());
            fail();
        }
    }

}
