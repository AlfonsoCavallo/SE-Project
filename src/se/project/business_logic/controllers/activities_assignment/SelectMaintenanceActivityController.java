package se.project.business_logic.controllers.activities_assignment;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.PlannerHomepageController;
import se.project.presentation.views.activities_assignment.SelectMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;


public class SelectMaintenanceActivityController extends AbstractController
{
    private final SelectMaintenanceActivityView selectMaintenanceActivityView;
    private MaintenanceActivity maintenanceActivity; 
    
    /**
     * 
     * Creates a new ViewMaintenanceActivityController
     */
    public SelectMaintenanceActivityController()
    {
        this.selectMaintenanceActivityView = new SelectMaintenanceActivityView();
        initListeners();
    }
    
    /**
     * 
     *  Initializes the listeners of selectMaintenanceActivityView
     */
    public void initListeners()
    {
        selectMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                selectMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });

        selectMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackPlannerHomepage();
                selectMaintenanceActivityView.dispose();
            }  
        });

       selectMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
       });
       
       selectMaintenanceActivityView.getjViewInfoPanel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               openMaintenanceActivityInfoView();
           }        
       });
        
    }
    
    /**
     * 
     * Opens the planner homepage using its controller
     */
    public static void goBackPlannerHomepage()
    {
        new PlannerHomepageController();
    }
    
    /**
     * 
     * Opens the maintenance activity info view using its controller
     */
    public void openMaintenanceActivityInfoView()
    {
        new MaintenanceActivityInfoController(this.maintenanceActivity);
    }
}