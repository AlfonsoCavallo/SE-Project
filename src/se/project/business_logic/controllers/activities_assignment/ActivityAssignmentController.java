package se.project.business_logic.controllers.activities_assignment;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_assignment.ActivityAssignmentView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.adapters.WeeklyAvailabilityForAssignment;
import se.project.storage.models.interfaces.RepresentableWeeklyAvailability;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repo_proxy.WeeklyAvailabilityProxyRepo;
import se.project.storage.repos.interfaces.WeeklyAvailabilityRepoInterface;


public class ActivityAssignmentController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get weekly availabilities from database.";
    private final String NOT_VALID_MESSAGE = "In this day the maintainer is not available for the current activity!";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String CONFIRM_ASSIGNMENT_MESSAGE = "Are you sure to assign this activity to the maintainer \" maintainer_name_param \"?";
    
    private final ActivityAssignmentView activityAssignmentView;
    private PlannedActivity plannedActivity = null;
    private ArrayList<String> skillsNeeded;
    private List<WeeklyAvailability> weeklyAvailabilities = null;
    private final WeeklyAvailabilityRepoInterface weeklyAvailabilityRepo = new WeeklyAvailabilityProxyRepo(getConnection());
    
    /**
     * 
     * Creates a new ActivityAssignmentController
     */
    public ActivityAssignmentController()
    {
        this.activityAssignmentView = new ActivityAssignmentView();
        initListeners();
    }
    
    /***
     * Sets the model of PlannedActivity to display on the view
     * @param plannedActivity is the activity with informations to display
     */
    public void setPlannedActivityModel(PlannedActivity plannedActivity)
    {        
        this.plannedActivity = plannedActivity;        
        this.skillsNeeded = plannedActivity.getSkills();
        viewAvailability(plannedActivity);
    }
    
    /***
     * 
     * @return activityAssignmentView
     */
    @Override
    public ActivityAssignmentView getView()
    {
        return activityAssignmentView;
    }
    
    /**
     * 
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
               goBackMaintenanceActivityInfoPage();
               activityAssignmentView.dispose();
           }        
       });
       
       activityAssignmentView.getjMaintainerAvailabilityTable().addMouseListener(new java.awt.event.MouseAdapter()        
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               boolean open = executeTransitionToForwardingPage();
               if(open)
               {    
                    activityAssignmentView.dispose();
               }
           }        
       });
               
    }        
    
    /**
     * 
     * Opens the Maintenance Activity Info view using its controller
     */
    public void goBackMaintenanceActivityInfoPage()
    {
        new MaintenanceActivityInfoController().setPlannedActivityModel(this.plannedActivity);
    }
    
    /**
     * Opens the Activity Forwarding view using its controller
     * @param plannedActivity is the planned Acvitity
     * @param selectedAvailability is the selected Availability
     * @param selectedDayOfTheWeek is the day to check availability
     * @param dayOfMonth is the number of the day to check
     * @param maintainerPercentage is the percentage of availability
     * @return true if the selected maintainer is confirmed in the "Confirm Message" window, false otherwise 
     */
    private boolean openActivityForwardingPage(PlannedActivity plannedActivity, 
            WeeklyAvailability selectedAvailability, String selectedDayOfWeek,
            int dayOfMonth, String maintainerPercentage)
    {
        new ActivityForwardingController().
                setAvailabilityModels(plannedActivity, 
                        selectedAvailability, selectedDayOfWeek, 
                        dayOfMonth, maintainerPercentage);
        return true;
    }
    
    /***
     * Prepares the transition for forwarding page
     * @return true if the transition has correctly occurred
     */
    private boolean executeTransitionToForwardingPage()
    {
        int row = activityAssignmentView.getjMaintainerAvailabilityTable().getSelectedRow();
        int column = activityAssignmentView.getjMaintainerAvailabilityTable().getSelectedColumn();
        
        String maintainerName = this.weeklyAvailabilities.get(row).getUsername();
        String maintainerPercentage = activityAssignmentView.getjMaintainerAvailabilityTable().getValueAt(row, column).toString();
        WeeklyAvailability selectedAvailability = this.weeklyAvailabilities.get(row);
        String selectedDayOfWeek = activityAssignmentView.getjMaintainerAvailabilityTable().getColumnName(column);
        
        DayOfWeek selectedDay = DayOfWeek.valueOf(selectedDayOfWeek.toUpperCase());
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setWeekDate(2020, this.plannedActivity.getWeek(), selectedDay.getValue());
        int dayOfMonth = calendarDate.get(Calendar.DAY_OF_MONTH) + 1;
        
        if(maintainerPercentage.equals("0%"))
        {
            JOptionPane.showMessageDialog(null, NOT_VALID_MESSAGE);
            return false;
        }    

        String confirmMessage = CONFIRM_ASSIGNMENT_MESSAGE.replaceAll("maintainer_name_param", maintainerName);
        int input = JOptionPane.showConfirmDialog(null, confirmMessage, "Confirm Message", YES_NO_OPTION);
        
        if(input == 0)
        {
            openActivityForwardingPage(plannedActivity, selectedAvailability, selectedDayOfWeek,
                    dayOfMonth, maintainerPercentage);
        }
        return false;
    }
    
    /**
     * 
     * Updates the table in the page inserting all the availabilities in the specified week
     * @param plannedActivity is the planned activity from which you obtain the informations to check the weekly availability
     */
    public void viewAvailability(PlannedActivity plannedActivity)
    {
        DefaultTableModel tableModel = activityAssignmentView.getDefaultTableModelAvailability();
        DefaultListModel listModel = activityAssignmentView.getDefaultListModelSkills();
        
        try
        {
            List<String> competenciesSearched = plannedActivity.getSkills();
            int weekSearched = plannedActivity.getWeek();
            int IDActivity = plannedActivity.getIdActivity();
            String branchOffice = plannedActivity.getBrachOffice();
            String department = plannedActivity.getDepartment();
            Typology typology = plannedActivity.getTypology();
            int timeNeeded = plannedActivity.getRemainingTime();
            
            this.weeklyAvailabilities = weeklyAvailabilityRepo.queryAllWeeklyAvailabilities(competenciesSearched, weekSearched);
            
            activityAssignmentView.getjWeekNumberLabel().setText(String.valueOf(weekSearched));
            activityAssignmentView.getjActivityToAssignLabel().setText(String.valueOf(IDActivity) + " - " + 
                                   branchOffice + " " + department + " - " + typology.getValue() + " - " + 
                                   String.valueOf(timeNeeded) + "'");
            
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
                int maxSkills = this.plannedActivity.getSkills().size();
                RepresentableWeeklyAvailability adapter = new WeeklyAvailabilityForAssignment(availability, maxSkills);
                
                // Colors Table
                for(int i = 2; i < activityAssignmentView.getjMaintainerAvailabilityTable().getColumnCount(); i++)
                {
                    this.colorTable(activityAssignmentView.getjMaintainerAvailabilityTable(), i);
                }    
                
                Object[] model = adapter.getPercentageDataModel();
                tableModel.addRow(model);                
            }  
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
            System.err.println(ex.getMessage());
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
            System.err.println(ex.getMessage());
            
        }
    }

    /**
     * Getter used for tests
     * @return the ActivityAssignmentView
     */
    public ActivityAssignmentView getActivityAssignmentView()
    {
        this.activityAssignmentView.dispose();
        return activityAssignmentView;
    }
    
    /**
     * 
     * Change the color of the cell in the table according to their values.
     * @param table is the table in the page.
     * @param column is a specific column of the table.
     */
    public void colorTable(JTable table, int column)
    {
            table.getColumnModel().getColumn(column).setCellRenderer(new DefaultTableCellRenderer()
            {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
                {
                    final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    int cellValue = Integer.parseInt(table.getValueAt(row, column).toString().split("%")[0]);
                    if ((cellValue <= 100) && (cellValue >= 70))
                    {
                        component.setBackground(Color.green);
                    }
                    else if (cellValue == 0)
                    {
                        component.setBackground(Color.red);
                    }
                    else if ((cellValue > 0) && (cellValue <= 20))
                    {
                        component.setBackground(Color.orange);
                    }
                    else
                    {
                        component.setBackground(Color.yellow);
                    }
                    return component;
                }
            });
    }
    
}
