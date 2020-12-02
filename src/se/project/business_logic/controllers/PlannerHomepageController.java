package se.project.business_logic.controllers;

import se.project.business_logic.controllers.activities_management.MaintenanceActivityController;
import java.sql.SQLException;
import se.project.presentation.views.PlannerHomepageView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;


public class PlannerHomepageController extends AbstractController
{
    private final PlannerHomepageView plannerHomepageView;

    /**
     * 
     * Creates a new PlannerHomepageController
     */
    public PlannerHomepageController()
    {
        this.plannerHomepageView = new PlannerHomepageView();
        initListeners();
    }
    
    /**
     * 
     *  Initializes the listeners of plannerHomepageView
     */
    private void initListeners()
    {
        plannerHomepageView.getjMaintenanceActivityPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openMaintenanceActivityPage();
                plannerHomepageView.dispose();
            }
        });
        
        plannerHomepageView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                plannerHomepageView.dispose();
                openLoginPage();
            }
        });
        
        plannerHomepageView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    /**
     * 
     * Opens the maintenance activity page using its controller
     */
    public static void openMaintenanceActivityPage()
    {
        new MaintenanceActivityController();
    }

}
