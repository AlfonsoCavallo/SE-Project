package se.project.business_logic.controllers.activities_assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.SingletonControllerFactory;
import se.project.presentation.views.activities_assignment.MaintenanceActivityInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.maintenance_activity.PlannedActivity;

/**
 * Manages the business logic behind an MaintenanceActivityInfoView.
 * 
 */
public class MaintenanceActivityInfoController extends AbstractController
{
    private final MaintenanceActivityInfoView maintenanceActivityInfoView;
    private PlannedActivity plannedActivity;

    /**
     * 
     * Creates a new MaintenanceActivityInfoController.
     */
    public MaintenanceActivityInfoController()
    {
        this.maintenanceActivityInfoView = new MaintenanceActivityInfoView();
        initListeners();
    }
    
    /***
     * Sets the model of PlannedActivity to display on the view.
     * @param plannedActivity is the activity with informations to display.
     */
    public void setPlannedActivityModel(PlannedActivity plannedActivity)
    {        
        this.plannedActivity = plannedActivity;
        viewInfo();
    }
    
    /***
     * 
     * @return maintenanceActivityInfoView.
     */
    @Override
    public MaintenanceActivityInfoView getView()
    {
        return maintenanceActivityInfoView;
    }    
    
    /**
     * 
     * Initializes the listeners of MaintenanceActivityInfoView.
     */
    private void initListeners()
    {
        maintenanceActivityInfoView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
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
            @Override
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
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openActivityAssignmentPage();
                maintenanceActivityInfoView.dispose();
            }        
        });                       
    }        
    
    /**
     * 
     * Opens the Activity Assignment page instantiating instantiating its controller.
     */
    public void openActivityAssignmentPage()
    {
        new ActivityAssignmentController().setPlannedActivityModel(this.plannedActivity);
    }
    
    /**
     * 
     * Opens the Select Maintenance Activity View instantiating its controller.
     */
    public static void goBackSelectMaintenanceActivityView()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.SELECT_MAINTENANCE_ACTIVITY);
    }
    
    /**
     * Reloads all the informations from the model and shows them on the view.
     */
    public void viewInfo()
    {
        int week = this.plannedActivity.getWeek();
        String activityToAssign = String.valueOf(this.plannedActivity.getIdActivity()) + " - " + 
                                  this.plannedActivity.getBrachOffice() + " , " +
                                  this.plannedActivity.getDepartment() + " - " +
                                  this.plannedActivity.getTypology().getValue() + " - " +
                                  String.valueOf(this.plannedActivity.getRemainingTime()) + "'";
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

