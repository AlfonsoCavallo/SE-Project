package se.project.business_logic.controllers.activities_assignment;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.ActivityAssignmentView;
import static se.project.storage.DatabaseConnection.closeConnection;


public class ActivityAssignmentController extends AbstractController
{
    private final ActivityAssignmentView activityAssignmentView;
    
    /**
     * Creates a new ActivityAssignmentController
     */
    public ActivityAssignmentController()
    {
        this.activityAssignmentView = new ActivityAssignmentView();
        initListeners();
    }
    
    /**
     * Initializes the listeners of ActivityAssignmentView
     */
    public void initListeners()
    {
        activityAssignmentView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                activityAssignmentView.dispose();
                MainController.openLoginPage();
            }        
        });

        activityAssignmentView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }        
        });

       activityAssignmentView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               goBackMaintenanceActivityInfoPage();
               activityAssignmentView.dispose();
           }        
       });
       
       
        
    }        
    
    /**
     * Opens the Maintenance Activity Info page using its controller
     */
    public static void goBackMaintenanceActivityInfoPage()
    {
        //new MaintenanceActivityInfoController();
    }        
    
}
