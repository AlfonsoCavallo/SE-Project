/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
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

/**
 *
 * @author Utente
 */
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
            closeConnection();
        }
        catch (SQLException ex)
        {
            
        }
    }

    /**
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
        }
    }

    
    /**
     * Test of queryMaintainerAvailability method, of class WeeklyAvailabilityRepo.
     */
    @Test
    public void testQueryMaintainerAvailability_Maintainer_int() throws Exception
    {
        // TO implement
    }
    
    /**
     * Test of queryMaintainerAvailability on an unavailable user
     */
    @Test
    public void testQueryMaintainerAvailabilityUnavailableUser()
    {
        try
        {
            connect(getTestUser());
            WeeklyAvailabilityRepo instance = new WeeklyAvailabilityRepo(getConnection());
            
            WeeklyAvailability weeklyAvailability = instance.queryMaintainerAvailability("unavailable_user", 1);
            assertEquals(null, weeklyAvailability);
            
            closeConnection();
        }
        catch (ClassNotFoundException | IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
