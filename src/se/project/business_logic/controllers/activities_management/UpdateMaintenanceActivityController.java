package se.project.business_logic.controllers.activities_management;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_management.UpdateMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.EWO;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.fromString;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;


public class UpdateMaintenanceActivityController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not update maintenance activity in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String UPDATED_MESSAGE = "Maintenance activity \"activity_name_param\" has been updated successfully!";
    private final String QUERY_NULL_POINTER_MESSAGE = "All the fields must be filled!";
    private final String SELECT_ACTIVITY_MESSAGE = "Please, select a  before updating!";
    
    private final UpdateMaintenanceActivityView updateMaintenanceActivityView;
    private MaintenanceActivityRepoInterface maintenanceActivityRepo;
    private LinkedList<String> activityNameList;
    private int columnNumber;
    
    public UpdateMaintenanceActivityController()
    {
        this.updateMaintenanceActivityView = new UpdateMaintenanceActivityView();
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        this.activityNameList = new LinkedList<>();
        this.columnNumber = this.updateMaintenanceActivityView.getjTable().getColumnCount();
        initListeners();
        viewMaintenanceActivity();
    }
    
    public void initListeners()
    {
        updateMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                updateMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });
        
        updateMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage();
                updateMaintenanceActivityView.dispose();
            }  
        });
        
        updateMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
        
        updateMaintenanceActivityView.getjUpdateMaintenanceProcedurePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
          public void mouseClicked(java.awt.event.MouseEvent evt)
          {
              updateMaintenanceActivity();
              viewMaintenanceActivity();
          }        
        });        
        
    }
    
    public static void goBackMaintenanceActivityPage()
    {
        new MaintenanceActivityController();
    }
    
    public void updateMaintenanceActivity()
    {
        MaintenanceActivity maintenanceActivity = null;
        
        int row = -1;
        String activityName = null;
        String timeNeeded = null;
        String interruptibleString = null;
        String typology = null;
        String activityDescription = null;
        String week = null;
        String planned = null;
        String ewo = null;
        String standardProcedure = null;
        
        try
        {
            row = updateMaintenanceActivityView.getjTable().getSelectedRow();
            activityName = updateMaintenanceActivityView.getjTable().getValueAt(row, 1).toString();
            timeNeeded = updateMaintenanceActivityView.getjTable().getValueAt(row, 2).toString();
            interruptibleString = updateMaintenanceActivityView.getjTable().getValueAt(row, 3).toString();
            typology = updateMaintenanceActivityView.getjTable().getValueAt(row, 4).toString();
            activityDescription = updateMaintenanceActivityView.getjTable().getValueAt(row, 5).toString();
            week = updateMaintenanceActivityView.getjTable().getValueAt(row, 6).toString();
            planned = updateMaintenanceActivityView.getjTable().getValueAt(row, 7).toString();
            ewo = updateMaintenanceActivityView.getjTable().getValueAt(row, 8).toString();
            standardProcedure = updateMaintenanceActivityView.getjTable().getValueAt(row, 9).toString();
        }    
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_NULL_POINTER_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_ACTIVITY_MESSAGE);
        }
        
        boolean interruptible;
        
        if(interruptibleString.equals("yes"))
        {
            interruptible = true;
        }
        else
        {
            interruptible = false;
        }
        
        try
        {
            if(planned.equals("yes"))
            {
                maintenanceActivity = new PlannedActivity(activityName, parseInt(timeNeeded), interruptible, 
                fromString(typology), activityDescription, parseInt(week), standardProcedure);
            }
            else
            {
                if(ewo.equals("yes"))
                {
                    maintenanceActivity = new EWO(activityName, parseInt(timeNeeded), interruptible, 
                    fromString(typology), activityDescription, parseInt(week));
                }
                else
                {
                    maintenanceActivity = new ExtraActivity(activityName, parseInt(timeNeeded), interruptible, 
                    fromString(typology), activityDescription, parseInt(week));
                } 
            }
           String oldActivityName = this.activityNameList.get(row);
           maintenanceActivityRepo.queryUpdateMaintenanceActivity(maintenanceActivity, oldActivityName);
           String updatedMessage = UPDATED_MESSAGE.replaceAll("activity_name_param", activityName);
           JOptionPane.showMessageDialog(null, updatedMessage);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
        catch (NullPointerException ex)
        {
        }   
    }
    
    public void viewMaintenanceActivity(){
        DefaultTableModel tableModel = updateMaintenanceActivityView.getDefaultTableModel();
        try
        {
            LinkedList<MaintenanceActivity> maintenanceActivities = maintenanceActivityRepo.queryAllMaintenanceActivity();
            activityNameList.clear();
            
            // Clear the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterator over maintenance activities
            for(MaintenanceActivity maintenanceActivity : maintenanceActivities)
            {
                tableModel.addRow(maintenanceActivity.getDataModel());
                this.activityNameList.add(maintenanceActivity.getActivityName());
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
}
