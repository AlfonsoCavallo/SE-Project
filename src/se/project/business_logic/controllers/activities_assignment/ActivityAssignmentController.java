package se.project.business_logic.controllers.activities_assignment;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.ActivityAssignmentView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.WeeklyAvailabilityRepo;
import se.project.storage.repos.interfaces.WeeklyAvailabilityRepoInterface;


public class ActivityAssignmentController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get weekly availabilities from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    
    private final ActivityAssignmentView activityAssignmentView;
    private PlannedActivity plannedActivity;
    private ArrayList<String>  skillsNeeded;
    private List<WeeklyAvailability> weeklyAvailabilities;
    private WeeklyAvailabilityRepoInterface weeklyAvailabilityRepo = null;
    private DayOfWeek dayOfWeek;
    
    /**
     * Creates a new ActivityAssignmentController
     */
    public ActivityAssignmentController(PlannedActivity plannedActivity)
    {
        this.activityAssignmentView = new ActivityAssignmentView();
        this.plannedActivity = plannedActivity;
        this.skillsNeeded = plannedActivity.getSkills();
        this.weeklyAvailabilityRepo = new WeeklyAvailabilityRepo(getConnection());
        initListeners();
        viewAvailability(plannedActivity);
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
               goBackMaintenanceActivityInfoPage(plannedActivity);
               activityAssignmentView.dispose();
           }        
       });
       
       
        
    }        
    
    /**
     * 
     * @param maintenanceActivity 
     */
    public static void goBackMaintenanceActivityInfoPage(PlannedActivity plannedActivity)
    {
        new MaintenanceActivityInfoController(plannedActivity);
    }
    
    /*
    public static void goToSeletectAvailabilityTimePage()
    {
        new SeletectAvailabilityTime();
    }        
    */
    
    public void viewAvailability(MaintenanceActivity maintenanceActivity)
    {
        DefaultTableModel tableModel = activityAssignmentView.getDefaultTableModelAvailability();
        DefaultListModel listModel = activityAssignmentView.getDefaultListModelSkills();
        
        try
        {
            List<String> competenciesSerched = maintenanceActivity.getSkills();
            int weekSearched = maintenanceActivity.getWeek();
            int IDActivity = maintenanceActivity.getIdActivity();
            String branchOffice = maintenanceActivity.getBrachOffice();
            String department = maintenanceActivity.getDepartment();
            Typology typology = maintenanceActivity.getTypology();
            int timeNeeded = maintenanceActivity.getTimeNeeded();
            
            this.weeklyAvailabilities = weeklyAvailabilityRepo.queryAllWeeklyAvailabilities(competenciesSerched, weekSearched);
            
            activityAssignmentView.getjWeekNumberLabel().setText(String.valueOf(weekSearched));
            activityAssignmentView.getjActivityToAssignLabel().setText(String.valueOf(IDActivity) + " - " + 
                                   branchOffice + " " + department + " - " + typology.getValue() + " - " + 
                                   String.valueOf(timeNeeded));
            
            // Clears the list model
            while(!listModel.isEmpty())
            {
                listModel.removeAllElements();
            }    
            
            // Iterates over the skills
            for(String skills : skillsNeeded)
            {
                listModel.addElement(skills);
            }    
            
            // Clears the table model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            } 
            
            // Iterates over maintenance activities
            for(WeeklyAvailability availability : weeklyAvailabilities)
            {    
                tableModel.addRow(availability.getDataForAssignment());
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
