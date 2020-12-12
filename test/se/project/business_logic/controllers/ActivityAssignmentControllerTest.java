/*package se.project.business_logic.controllers;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.project.business_logic.controllers.activities_assignment.ActivityAssignmentController;
import static org.junit.Assert.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import se.project.presentation.views.activities_assignment.ActivityAssignmentView;
import static se.project.storage.DatabaseConnection.closeConnection;


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

    private ActivityAssignmentView simulateView()
    {
        ActivityAssignmentView mock = mock(ActivityAssignmentView.class, RETURNS_DEEP_STUBS);
        when(mock.getjMaintainerAvailabilityTable().getSelectedRow()).thenReturn(0);
        return mock;
    }        
    
}
*/