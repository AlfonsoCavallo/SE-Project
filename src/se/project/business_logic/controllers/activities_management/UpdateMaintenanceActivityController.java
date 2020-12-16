package se.project.business_logic.controllers.activities_management;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.SingletonControllerFactory;
import se.project.presentation.views.activities_management.UpdateMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.fromString;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repo_proxy.MaintenanceActivityProxyRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
 * Manages the business logic behind an UpdateMaintenanceActivityView.
 * 
 */
public class UpdateMaintenanceActivityController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not update maintenance activity in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String UPDATED_MESSAGE = "Maintenance activity \"activity_name_param\" has been updated successfully.";
    private final String QUERY_NULL_POINTER_MESSAGE = "All the fields must be filled.";
    private final String SELECT_ACTIVITY_MESSAGE = "Please, select an element before updating.";
    private final String FIELD_NOT_PROPERLY_FILLED_MESSAGE = "Fill proprely the fields.";
    
    private final UpdateMaintenanceActivityView updateMaintenanceActivityView;
    private final MaintenanceActivityRepoInterface maintenanceActivityRepo = new MaintenanceActivityProxyRepo(getConnection());
    private final LinkedList<String> activityNameList;
    private final int columnNumber;
    
    /**
     * 
     * Creates a new UpdateMaintenanceActivityController.
     */
    public UpdateMaintenanceActivityController()
    {
        this.updateMaintenanceActivityView = new UpdateMaintenanceActivityView();
        this.activityNameList = new LinkedList<>();
        this.columnNumber = this.updateMaintenanceActivityView.getjTable().getColumnCount();
        initListeners();
        viewMaintenanceActivity();
    }
    
    /***
     * 
     * @return updateMaintenanceActivityView.
     */
    @Override
    public UpdateMaintenanceActivityView getView()
    {
        return updateMaintenanceActivityView;
    }  
    
    /**
     * 
     *  Initializes the listeners of updateMaintenanceActivityView.
     */
    private void initListeners()
    {
        updateMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                updateMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });
        
        updateMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage();
                updateMaintenanceActivityView.dispose();
            }  
        });
        
        updateMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
        
        updateMaintenanceActivityView.getjUpdateMaintenanceProcedurePanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
          @Override
          public void mouseClicked(java.awt.event.MouseEvent evt)
          {
              updateMaintenanceActivity();
              viewMaintenanceActivity();
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
     * 
     * Updates the selected maintenance activity.
     */
    public void updateMaintenanceActivity()
    {
        MaintenanceActivity maintenanceActivity = null;
        
        int row;
        String activityName;
        String timeNeeded;
        String remainingTime;
        String interruptibleString;
        String typology;
        String activityDescription;
        String week;
        String planned;
        String branchOffice;
        String department;
        String standardProcedure;
        
        try
        {
            row = updateMaintenanceActivityView.getjTable().getSelectedRow();
            activityName = updateMaintenanceActivityView.getjTable().getValueAt(row, 1).toString();
            timeNeeded = updateMaintenanceActivityView.getjTable().getValueAt(row, 2).toString();
            remainingTime = updateMaintenanceActivityView.getjTable().getValueAt(row, 3).toString();
            interruptibleString = updateMaintenanceActivityView.getjTable().getValueAt(row, 4).toString();
            typology = updateMaintenanceActivityView.getjTable().getValueAt(row, 5).toString();
            activityDescription = updateMaintenanceActivityView.getjTable().getValueAt(row, 6).toString();
            week = updateMaintenanceActivityView.getjTable().getValueAt(row, 7).toString();
            branchOffice = updateMaintenanceActivityView.getjTable().getValueAt(row, 8).toString();
            department = updateMaintenanceActivityView.getjTable().getValueAt(row, 9).toString();
            standardProcedure = updateMaintenanceActivityView.getjTable().getValueAt(row, 10).toString();
            planned = updateMaintenanceActivityView.getjTable().getValueAt(row, 11).toString();
        }    
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_NULL_POINTER_MESSAGE);
            return;
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_ACTIVITY_MESSAGE);
            return;
        }
        
        boolean interruptible;
        
        interruptible = interruptibleString.equals("yes");
        
        try
        {
            if(!checkFields(timeNeeded, remainingTime, interruptibleString, 
                    typology, week, planned))
            {
                JOptionPane.showMessageDialog(new JFrame(), FIELD_NOT_PROPERLY_FILLED_MESSAGE);
                return;
            }
            
            // Change planned activity value.
            switch (planned)
            {
                case "yes":
                    maintenanceActivity = new PlannedActivity(-1, activityName, parseInt(timeNeeded), parseInt(remainingTime), interruptible,
                            fromString(typology), activityDescription, parseInt(week), branchOffice, department, new ArrayList<>(), standardProcedure);
                    break;
                case "no":
                    maintenanceActivity = new ExtraActivity(-1, activityName, parseInt(timeNeeded), parseInt(remainingTime), interruptible,
                            fromString(typology), activityDescription, parseInt(week), branchOffice, department, new ArrayList<>());
                    break;
            }
            
            String oldActivityName = this.activityNameList.get(row);
            maintenanceActivityRepo.updateMaintenanceActivity(maintenanceActivity, oldActivityName);
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
    
    /**
     * 
     * Shows in the table all the maintenance activities.
     */
    private void viewMaintenanceActivity(){
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
    
    /***
     * Checks if the field are properly filled.
     * @param timeNeeded must be a number.
     * @param remainingTime must be a number less than timeNeeded.
     * @param interruptibleString must be "yes" or "no".
     * @param typology must be a real typology.
     * @param week must  be a number.
     * @param planned must be "yes" or "no".
     * @return true if all the fields are properly filled.
     */
    private boolean checkFields(String timeNeeded, String remainingTime, 
            String interruptibleString, String typology, 
        String week, String planned)
        {
            // Check planned
            if(planned != "yes" && planned != "no")
            {
                return false;
            }
            
            // Check interruptible
            if(interruptibleString != "yes" && interruptibleString != "no")
            {
                return false;
            }
            
            // Check typology
            boolean correctTypology = false;
            
            for(Typology realTypology : Typology.values())
            {
                if(realTypology.getValue() == typology)
                {
                    correctTypology = true;
                }
            }
            
            if(!correctTypology)
            {
                return false;
            }
            
            // Check type
            try
            {
               parseInt(timeNeeded);
               parseInt(remainingTime);
               parseInt(week);
            }
            catch (NumberFormatException ex)
            {
                return false;
            }
            
            // Check remainingTime is less than
            if(parseInt(remainingTime) > parseInt(timeNeeded))
            {
                return false;
            }
            
            return true;
        }
}
