package se.project.business_logic.controllers.activities_management;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.PlannerHomepageController;
import se.project.presentation.views.activities_management.MaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;


public class MaintenanceActivityController extends AbstractController
{
    private final MaintenanceActivityView maintenanceActivityView;
    
    /**
     * 
     * Creates a new MaintenanceActivityController
     */
    public MaintenanceActivityController()
    {
       this.maintenanceActivityView = new MaintenanceActivityView();
       initListeners();
    }
    
    /***
     * 
     * @return maintenanceActivityView
     */
    @Override
    public MaintenanceActivityView getView()
    {
        return maintenanceActivityView;
    }    
    
    /**
     * 
     *  Initializes the listeners of addMaintenanceActivityView
     */
    private void initListeners()
    {
        maintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                maintenanceActivityView.dispose();
                MainController.openLoginPage();
            }        
        });

        maintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }        
        });
        
        maintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackPlannerHomepage();
                maintenanceActivityView.dispose();
            }
        });        

        maintenanceActivityView.getjAddMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openAddMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }        
            
        });        
        
        maintenanceActivityView.getjUpdateMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUpdateMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }
        });        
            
        maintenanceActivityView.getjViewMaintenancePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openViewMaintenanceActivityPage();
                maintenanceActivityView.dispose();
            }
        });          
                
    }        
    
    /**
     * 
     * Opens the add maintenance activity page using its controller
     */
    public static void openAddMaintenanceActivityPage()
    {
        ControllerFactory.createController(ControllerType.ADD_MAINTENANCE_ACTIVITY);
    }
    
    /**
     * 
     * Opens the update maintenance activity page using its controller
     */
    public static void openUpdateMaintenanceActivityPage()
    {
        ControllerFactory.createController(ControllerType.UPDATE_MAINTENANCE_ACTIVITY);
    }
    
    /**
     * 
     * Opens the view and delete maintenance activity page using its controller
     */
    public static void openViewMaintenanceActivityPage()
    {
        ControllerFactory.createController(ControllerType.VIEW_MAINTENANCE_ACTIVITY);
    }
    
    /**
     * 
     * Opens the planner homepage using its controller
     */
    public static void goBackPlannerHomepage()
    {
        ControllerFactory.createController(ControllerType.PLANNER_HOMEPAGE);
    }
}
