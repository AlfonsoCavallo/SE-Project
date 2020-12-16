package se.project.business_logic.controllers;

import java.sql.SQLException;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.PlannerHomepageView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 * Manages the business logic behind a PlannerHomepageView.
 */
public class PlannerHomepageController extends AbstractController
{
    private final PlannerHomepageView plannerHomepageView;

    /**
     * 
     * Creates a new PlannerHomepageController.
     */
    public PlannerHomepageController()
    {
        this.plannerHomepageView = new PlannerHomepageView();
        initListeners();
    }
    
    /***
     * 
     * @return plannerHomepageView.
     */
    @Override
    public PlannerHomepageView getView()
    {
        return plannerHomepageView;
    }
    
    /**
     * 
     *  Initializes the listeners of plannerHomepageView.
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
        
        plannerHomepageView.getjActivityAssigmentPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openSelectMaintenanceActivityPage();
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
     * Opens the maintenance activity page instantiating its controller.
     */
    public static void openMaintenanceActivityPage()
    {
        ControllerFactory.createController(ControllerType.MAINTENANCE_ACTIVITY);
    }

    /**
     * 
     * Opens the select maintenance activity page to assign it to a maintainer instantiating its controller.
     */
    public static void openSelectMaintenanceActivityPage()
    {
        ControllerFactory.createController(ControllerType.SELECT_MAINTENANCE_ACTIVITY);
    }
}
