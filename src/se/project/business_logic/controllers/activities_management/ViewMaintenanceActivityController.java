package se.project.business_logic.controllers.activities_management;

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
import se.project.business_logic.controllers.SingletonControllerFactory;
import se.project.presentation.views.activities_management.ViewMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.repo_proxy.MaintenanceActivityProxyRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
 * Manages the business logic behind an ViewMaintenanceActivityView.
 * 
 */
public class ViewMaintenanceActivityController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get maintenance activities from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query."; 
    private final String CONFIRM_DELETION_MESSAGE = "Are you sure to delete \" activity_name_param \"?";
    private final String SELECT_DELETION_MESSAGE = "Please, select a maintenance activity before deleting!";
    
    private final ViewMaintenanceActivityView viewMaintenanceActivityView;
    private final MaintenanceActivityRepoInterface maintenanceActivityRepo = new MaintenanceActivityProxyRepo(getConnection());
    
    /**
     * 
     * Creates a new ViewMaintenanceActivityController.
     */
    public ViewMaintenanceActivityController()
    {
        this.viewMaintenanceActivityView = new ViewMaintenanceActivityView();
        initListeners();
        viewMaintenanceActivities();
    }
    
    /***
     * 
     * @return viewMaintenanceActivityView.
     */
    @Override
    public ViewMaintenanceActivityView getView()
    {
        return viewMaintenanceActivityView;
    } 
    
    /**
     * 
     *  Initializes the listeners of viewMaintenanceActivityView.
     */
    private void initListeners()
    {
        viewMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                viewMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });

        viewMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage();
                viewMaintenanceActivityView.dispose();
            }  
        });

       viewMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
       });
       
       viewMaintenanceActivityView.getjSearchLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               viewMaintenanceActivities();
           }        
       });
       
       viewMaintenanceActivityView.getjDeleteLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               deleteMaintenanceActivity();
               viewMaintenanceActivities();
           }        
       }); 
        
    }
    
    /**
     * 
     * Opens the maintenance activity page instantiating its controller.
     */
    public static void goBackMaintenanceActivityPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.MAINTENANCE_ACTIVITY);
    }
    
    /**
     * Updates the table in the page inserting the all the maintenance activities or a specific one
     */
    private void viewMaintenanceActivities()
    {
        DefaultTableModel tableModel = viewMaintenanceActivityView.getTableModel();
        LinkedList<MaintenanceActivity> maintenanceActivities;
        try
        {
            String nameToSearch = viewMaintenanceActivityView.getActivityName();
            if(!nameToSearch.equals(""))
            {
                maintenanceActivities = maintenanceActivityRepo.queryOneMaintenanceActivity(nameToSearch);
            }
            else
            {
                maintenanceActivities = maintenanceActivityRepo.queryAllMaintenanceActivity();
            }
            
            // Clear the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterator over maintenance activities
            for(MaintenanceActivity maintenanceActivity : maintenanceActivities)
            {
                tableModel.addRow(maintenanceActivity.getDataModel());
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
     * Deletes the selected maintenance activity.
     */
    public void deleteMaintenanceActivity()
    {
        try
        {
            int row = viewMaintenanceActivityView.getjTable().getSelectedRow();
            String nameToDelete = viewMaintenanceActivityView.getjTable().getValueAt(row, 1).toString();
            if(!nameToDelete.equals(""))
            {
                String confirmMessage = CONFIRM_DELETION_MESSAGE.replaceAll("activity_name_param", nameToDelete);
                int input = JOptionPane.showConfirmDialog(null, confirmMessage);
                if(input == 0)
                {
                    maintenanceActivityRepo.deleteMaintenanceActivity(nameToDelete);
                    viewMaintenanceActivityView.resetNameField();
                }    
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
        catch (ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_DELETION_MESSAGE);
        }
    }        
    
}
