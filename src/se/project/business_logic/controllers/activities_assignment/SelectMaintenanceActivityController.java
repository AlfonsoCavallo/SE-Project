package se.project.business_logic.controllers.activities_assignment;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.PlannerHomepageController;
import se.project.presentation.views.activities_assignment.SelectMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;


public class SelectMaintenanceActivityController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get activities from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String SELECT_ACTIVITY_MESSAGE = "Please, select an element to view its info!";
    
    private final SelectMaintenanceActivityView selectMaintenanceActivityView;
    private PlannedActivity plannedActivity = null; 
    private MaintenanceActivityRepoInterface maintenanceActivityRepo = null;
    private LinkedList<PlannedActivity> plannedActivities;
    
    /**
     * 
     * Creates a new ViewMaintenanceActivityController
     */
    public SelectMaintenanceActivityController()
    {
        this.selectMaintenanceActivityView = new SelectMaintenanceActivityView();
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        initListeners();
        viewActivities();
    }
    
    /***
     * 
     * @return selectMaintenanceActivityView
     */
    @Override
    public SelectMaintenanceActivityView getView()
    {
        return selectMaintenanceActivityView;
    }    
    
    /**
     * 
     * Creates a new ViewMaintenanceActivityController (used for tests)
     * @param selectMaintenanceActivityView is the view to open
     */
    public SelectMaintenanceActivityController(SelectMaintenanceActivityView selectMaintenanceActivityView)
    {
        this.selectMaintenanceActivityView = selectMaintenanceActivityView;
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        //initListeners();
        viewActivities();
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
               boolean open = selectMaintenaceActivity();
               if(open)
               {
                  openMaintenanceActivityInfoView();
                  selectMaintenanceActivityView.dispose(); 
               }
           }        
       });
       
       selectMaintenanceActivityView.getjComboBox().addItemListener(new java.awt.event.ItemListener()
       {
           public void itemStateChanged(java.awt.event.ItemEvent evt)
           {
               if (evt.getStateChange() == ItemEvent.SELECTED)
               {
                   viewActivities();
               }
           }
       });
        
    }
    
    /**
     * 
     * Opens the planner homepage using its controller
     */
    public static void goBackPlannerHomepage()
    {
        ControllerFactory.createController(ControllerType.PLANNER_HOMEPAGE);
    }
    
    /**
     * 
     * Opens the maintenance activity info view using its controller
     */
    public void openMaintenanceActivityInfoView()
    {
        new MaintenanceActivityInfoController().setPlannedActivityModel(this.plannedActivity);
    }
    
    /**
     * 
     * Updates the table in the page inserting the all the planned activities in a specific week
     */
    public void viewActivities()
    {
        DefaultTableModel tableModel = selectMaintenanceActivityView.getDefaultTableModel();
        
        try
        {
            int weekSearched =  selectMaintenanceActivityView.getWeek();
            this.plannedActivities = maintenanceActivityRepo.queryMaintenanceActivityInWeek(weekSearched);
            
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterates over maintenance activities
            for(PlannedActivity activity : plannedActivities)
            {
                tableModel.addRow(activity.getDataForAssignment());
            }
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
    }
    
    /**
     * 
     * Sets plannedActivity to the activity selected in the table
     * @return a boolean indicating if an element has been selected from the table
     */
    public boolean selectMaintenaceActivity()
    {
        int row;
        try
        {
            row = selectMaintenanceActivityView.getjTable().getSelectedRow();
            this.plannedActivity = this.plannedActivities.get(row);
        }
        catch (IndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_ACTIVITY_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 
     * @return a PlannedActivity representing the plannedActivity of the class
     */
    public PlannedActivity getPlannedActivity()
    {
        return this.plannedActivity;
    }
}