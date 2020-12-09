package se.project.business_logic.controllers.activities_assignment;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.MaintenanceActivityInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;


public class MaintenanceActivityInfoController extends AbstractController
{
    private final MaintenanceActivityInfoView maintenanceActivityInfoView;
    private MaintenanceActivity maintenanceActivity;

    /**
     * 
     * Creates a new MaintenanceActivityInfoController
     */
    public MaintenanceActivityInfoController(MaintenanceActivity maintenanceActivity)
    {
        this.maintenanceActivityInfoView = new MaintenanceActivityInfoView();
        this.maintenanceActivity = maintenanceActivity;
        initListeners();
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
                openActivityAssignmentPage(maintenanceActivity);
                maintenanceActivityInfoView.dispose();
            }        
        });                       
    }        
    
    /**
     * 
     * Opens the Activity Assignment page using its controller
     */
    public static void openActivityAssignmentPage(MaintenanceActivity maintenanceActivity)
    {
        new ActivityAssignmentController(maintenanceActivity);
    }
    
    /**
     * 
     * Opens the Select Maintenance Activity View using its controller
     */
    public static void goBackSelectMaintenanceActivityView()
    {
        new SelectMaintenanceActivityController();
    }
}

