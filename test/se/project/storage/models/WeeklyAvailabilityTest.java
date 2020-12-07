/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models;

import java.time.DayOfWeek;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utente
 */
public class WeeklyAvailabilityTest
{
    
    public WeeklyAvailabilityTest()
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
    }

    /**
     * Test of getMinutesAvailable method, of class WeeklyAvailability.
     */
    @Test
    public void testGetMinutesAvailable()
    {
        WeeklyAvailability instance = generateInstance();
        
        assertEquals(10, instance.getMinutesAvailable(DayOfWeek.MONDAY, WeeklyAvailability.WorkTurn.H8));
        assertEquals(20, instance.getMinutesAvailable(DayOfWeek.MONDAY, WeeklyAvailability.WorkTurn.H9));
        assertEquals(0, instance.getMinutesAvailable(DayOfWeek.WEDNESDAY, WeeklyAvailability.WorkTurn.H16));
        assertEquals(60, instance.getMinutesAvailable(DayOfWeek.TUESDAY, WeeklyAvailability.WorkTurn.H16));
        assertEquals(0, instance.getMinutesAvailable(DayOfWeek.SUNDAY, WeeklyAvailability.WorkTurn.H16));
    }
    
    /**
     * Test of getAvailabilityPercentage method, of class WeeklyAvailability.
     */
    @Test
    public void testGetAvailabilityPercentage()
    {
        WeeklyAvailability instance = generateInstance();
        
        assertEquals(50, instance.getPercentageAvailability(DayOfWeek.MONDAY));
        assertEquals(100, instance.getPercentageAvailability(DayOfWeek.TUESDAY));
        assertEquals(0, instance.getPercentageAvailability(DayOfWeek.SUNDAY));
        assertEquals(0, instance.getPercentageAvailability(DayOfWeek.SATURDAY));
        
    }
    
    /***
     * Generates a test instance
     * @return a test instance
     */
    private WeeklyAvailability generateInstance()
    {
        WeeklyAvailability instance = new WeeklyAvailability("test_username");
        instance.setAvailabilities(DayOfWeek.MONDAY, 10, 20, 30, 40, 50, 60, 0);
        instance.setAvailabilities(DayOfWeek.TUESDAY, 60, 60, 60, 60, 60, 60, 60);
        instance.setAvailabilities(DayOfWeek.WEDNESDAY, 10, 20, 30, 40, 50, 60, 0);
        instance.setAvailabilities(DayOfWeek.THURSDAY, 10, 20, 30, 40, 50, 60, 0);
        instance.setAvailabilities(DayOfWeek.FRIDAY, 10, 20, 30, 40, 50, 60, 0);
        instance.setAvailabilities(DayOfWeek.SATURDAY, 0, 0, 0, 0, 0, 0, 0);
        
        return instance;
    }
    
}
