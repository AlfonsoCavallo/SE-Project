package se.project.business_logic.controllers.activities_assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.MaintenanceActivityInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.maintenance_activity.PlannedActivity;


public class MaintenanceActivityInfoController extends AbstractController
{
    private final MaintenanceActivityInfoView maintenanceActivityInfoView;
    private PlannedActivity plannedActivity;

    /**
     * 
     * Creates a new MaintenanceActivityInfoController
     */
    public MaintenanceActivityInfoController(PlannedActivity plannedActivity)
    {
        this.maintenanceActivityInfoView = new MaintenanceActivityInfoView();
        this.plannedActivity = plannedActivity;
        initListeners();
        viewInfo();
    }
    
    /**
     * 
     * Initializes the listeners of MaintenanceActivityInfoView
     */
    private void initListeners()
    {
        maintenanceActivityInfoView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                try
                {
                    closeConnection();
                }
                catch (SQLException ex)
                {
                    System.err.println(ex.getMessage());
                }
                maintenanceActivityInfoView.dispose();
                MainController.openLoginPage();
            }        
        });
        
        maintenanceActivityInfoView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }        
        });
        
        maintenanceActivityInfoView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackSelectMaintenanceActivityView();
                maintenanceActivityInfoView.dispose();
            }
        });        

        maintenanceActivityInfoView.getjForwardPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openActivityAssignmentPage();
                maintenanceActivityInfoView.dispose();
            }        
        });                       
    }        
    
    /**
     * 
     * Opens the Activity Assignment page using its controller
     */
    public static void openActivityAssignmentPage()
    {
        // new ActivityAssignmentController(this.plannedActivity);
    }
    
    /**
     * 
     * Opens the Select Maintenance Activity View using its controller
     */
    public static void goBackSelectMaintenanceActivityView()
    {
        new SelectMaintenanceActivityController();
    }
    
    public void viewInfo()
    {
        int week = this.plannedActivity.getWeek();
        String activityToAssign = String.valueOf(this.plannedActivity.getIdActivity()) + " - " + 
                                  this.plannedActivity.getBrachOffice() + " , " +
                                  this.plannedActivity.getDepartment() + " - " +
                                  this.plannedActivity.getTypology().getValue() + " - " +
                                  String.valueOf(this.plannedActivity.getTimeNeeded()) + "'";
        String description = this.plannedActivity.getActivityDescription();
        String SMP = this.plannedActivity.getStandardProcedure();
        ArrayList<String> skills = this.plannedActivity.getSkills();
        
        this.maintenanceActivityInfoView.getjWeekLabel().setText(String.valueOf(week));
        this.maintenanceActivityInfoView.getjInfoLabel().setText(activityToAssign);
        this.maintenanceActivityInfoView.getjSMPTextArea().setText(SMP);
        this.maintenanceActivityInfoView.getjInterventionDescriptionTextArea().setText(description);
        for(String skill : skills)
        {
            this.maintenanceActivityInfoView.getDefaultListModel().addElement(skill);
        }
    }
}

