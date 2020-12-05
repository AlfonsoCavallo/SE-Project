/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseTesting.resetDatabase;
import se.project.storage.models.Maintainer;
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
    public void testQueryMaintainerAvailability_String_int() throws Exception
    {
        System.out.println("queryMaintainerAvailability");
        String username = "";
        int week = 0;
        WeeklyAvailabilityRepo instance = null;
        WeeklyAvailability expResult = null;
        WeeklyAvailability result = instance.queryMaintainerAvailability(username, week);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of queryMaintainerAvailability method, of class WeeklyAvailabilityRepo.
     */
    @Test
    public void testQueryMaintainerAvailability_Maintainer_int() throws Exception
    {
        System.out.println("queryMaintainerAvailability");
        Maintainer maintainer = null;
        int week = 0;
        WeeklyAvailabilityRepo instance = null;
        WeeklyAvailability expResult = null;
        WeeklyAvailability result = instance.queryMaintainerAvailability(maintainer, week);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
