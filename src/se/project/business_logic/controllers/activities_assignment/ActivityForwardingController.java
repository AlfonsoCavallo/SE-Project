package se.project.business_logic.controllers.activities_assignment;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.ActivityForwardingView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import static se.project.storage.models.WeeklyAvailability.WorkTurn.fromString;
import se.project.storage.models.Maintainer;
import se.project.storage.models.User;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.WeeklyAvailability.WorkTurn;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.UserRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;
import se.project.storage.repos.interfaces.UserRepoInterface;


public class ActivityForwardingController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get time availabily from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    
    private final ActivityForwardingView activityForwardingView;
    private MaintenanceActivityRepoInterface maintenanceActivityRepo = null;
    private UserRepoInterface userRepo = null;
    private PlannedActivity plannedActivity = null;
    private WeeklyAvailability weeklyAvailability = null;
    private String dayOfWeek;
    private int dayOfMonth;
    private String maintainerPercentage;
    
    public ActivityForwardingController(PlannedActivity plannedActivity, WeeklyAvailability weeklyAvailability, String dayOfWeek, int dayOfMonth, String maintainerPercentage)
    {
        this.activityForwardingView = new ActivityForwardingView();
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        this.userRepo = new UserRepo(getConnection());
        this.plannedActivity = plannedActivity;
        this.weeklyAvailability = weeklyAvailability;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.maintainerPercentage = maintainerPercentage;
        initListeners();
        viewTimeAvailability(plannedActivity, weeklyAvailability);
    }
    
    /**
     * Initializes the listeners of ActivityForwardingView
     */
    public void initListeners()
    {
        activityForwardingView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                activityForwardingView.dispose();
                MainController.openLoginPage();    
            }        
        });
        
        activityForwardingView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }        
        });

        activityForwardingView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackActivityAssignmentPage();
                activityForwardingView.dispose();
            }        
        });  
        
        activityForwardingView.getjSendPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                forwardActivity(plannedActivity, weeklyAvailability);
            }        
        });        

        
    } 
    
    /**
     * Opens the Activity Assignment view using its controller
     */
    public void goBackActivityAssignmentPage()
    {
        new ActivityAssignmentController(this.plannedActivity);
    }
    
    public void viewTimeAvailability(PlannedActivity plannedActivity, WeeklyAvailability weeklyAvailability)
    {
        DefaultTableModel tableModel = activityForwardingView.getDefaultTableModelTimeAvailability();
        
        //try
        //{
            int weekSelected = plannedActivity.getWeek();
            int IDActivity = plannedActivity.getIdActivity();
            String branchOffice = plannedActivity.getBrachOffice();;
            String department = plannedActivity.getDepartment();
            Typology typology = plannedActivity.getTypology();
            int timeNeeded = plannedActivity.getTimeNeeded();
            String dayOfWeek = this.dayOfWeek;
            int dayOfMonth = this.dayOfMonth;
            String maintainerName = weeklyAvailability.getUsername();
            String maintainerPercentage = this.maintainerPercentage;
            
            activityForwardingView.getjWeekNumberLabel().setText(String.valueOf(weekSelected));
            activityForwardingView.getjDayOfWeekLabel().setText(dayOfWeek);
            activityForwardingView.getjDayOfWeekNumberLabel().setText(String.valueOf(dayOfMonth));
            activityForwardingView.getjActivityToAssignLabel().setText(String.valueOf(IDActivity) + " - " + 
                                   branchOffice + " " + department + " - " + typology.getValue() + " - " + 
                                   String.valueOf(timeNeeded));
            activityForwardingView.getjMaintainerNameAvailabilityLabel().setText("Availability " + maintainerName + 
                                    " : " + maintainerPercentage);
            
            // Clears the table model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Adds the DataModel to the table
            Object[] model = updateDataModel(weeklyAvailability.getDataForForwarding(dayOfWeek));
            tableModel.addRow(model);
        /*    
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }*/
    }
    
    public Object[] updateDataModel(Object[] dataModel)
    {
        int maxSkills = this.plannedActivity.getSkills().size();
         
        dataModel[1] = dataModel[1] + "/" + maxSkills;
        for(int i= 2; i<=8; i++)
        {
            dataModel[i] = dataModel[i] + " min";  
        }
        
        return dataModel;
     
    }
     
    public void forwardActivity(PlannedActivity plannedActivity, WeeklyAvailability weeklyAvailability)
    {
        try
        {
            DayOfWeek day = DayOfWeek.valueOf(this.dayOfWeek.toUpperCase());
            LinkedList<User> maintainer = this.userRepo.queryOneUser(weeklyAvailability.getUsername());
            
            int row = activityForwardingView.getjMaintainerTimeAvailabilityTable().getSelectedRow();
            int column = activityForwardingView.getjMaintainerTimeAvailabilityTable().getSelectedColumn();
            String workTurn = activityForwardingView.getjMaintainerTimeAvailabilityTable().getColumnName(column);
            String minutesSelected = activityForwardingView.getjMaintainerTimeAvailabilityTable().getValueAt(row, column).toString();
            String[] minutes = minutesSelected.split(" ");
            
            this.maintenanceActivityRepo.assignMaintenanceActivity(plannedActivity, (Maintainer) maintainer.getFirst(), day, fromString(workTurn), parseInt(minutes[0]));
            
        } 
        catch (IOException ex)
        {
            Logger.getLogger(ActivityForwardingController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ActivityForwardingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }        
    
}
