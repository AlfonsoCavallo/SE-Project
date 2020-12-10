package se.project.business_logic.controllers;

import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import se.project.business_logic.controllers.activities_assignment.MaintenanceActivityInfoController;
import se.project.presentation.views.activities_assignment.MaintenanceActivityInfoView;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.HYDRAULIC;
import se.project.storage.models.maintenance_activity.PlannedActivity;


public class MaintenanceActivityInfoControllerTest
{
    
    public MaintenanceActivityInfoControllerTest()
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

    private static MaintenanceActivityInfoView simulateView()
    {
        // Initializes Mock
        MaintenanceActivityInfoView mock = mock(MaintenanceActivityInfoView.class);
        ArrayList<String> skills = new ArrayList<>(Arrays.asList("Electrical Maintenance", "Knowledge of Workstation 23", "Knowledge of Workstation 35", "English Knowledge"));
        PlannedActivity plannedActivity = new PlannedActivity(2, "activity2", 30, TRUE, HYDRAULIC, "riparazione turbina 5", 3, 
                "Fisciano", "Printing", skills, "4... 5... 6...");
        MaintenanceActivityInfoController maintenanceActivityInfoController = new MaintenanceActivityInfoController(plannedActivity, mock);
        
        when(plannedActivity.getWeek()).thenReturn(3);
        // when(mock.getjTable().getSelectedRow()).thenReturn(0);
        return mock;
    }
    
}
