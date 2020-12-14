package se.project.business_logic.controllers.activities_assignment;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.business_logic.controllers.PlannerHomepageController;
import se.project.business_logic.utilities.MailSender;
import se.project.presentation.views.activities_assignment.ActivityForwardingView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import static se.project.storage.models.WeeklyAvailability.WorkTurn.fromString;
import se.project.storage.models.Maintainer;
import se.project.storage.models.User;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.UserRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;
import se.project.storage.repos.interfaces.UserRepoInterface;


public class ActivityForwardingController extends AbstractController
{
    private final String NOT_VALID_MESSAGE = "At this time the maintainer is not available for the current activity!";
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not execute the statement on database";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String SELECT_TURN_MESSAGE = "Please, select a turn first!";
    
    private final ActivityForwardingView activityForwardingView;
    private MaintenanceActivityRepoInterface maintenanceActivityRepo = null;
    private UserRepoInterface userRepo = null;
    private PlannedActivity plannedActivity = null;
    private WeeklyAvailability weeklyAvailability = null;
    private String dayOfWeek;
    private int dayOfMonth;
    private String maintainerPercentage;
    private LinkedList<User> maintainer;
    
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
        try
        {
            this.maintainer = this.userRepo.queryOneUser(this.weeklyAvailability.getUsername());
        } 
        catch (IOException | SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
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
                try
                {
                    int column = activityForwardingView.getjMaintainerTimeAvailabilityTable().getSelectedColumn();
                    boolean added = forwardActivity(plannedActivity, weeklyAvailability);
                    if(added)
                    {
                        MailSender mailSender = new MailSender(plannedActivity, dayOfWeek + " " + String.valueOf(dayOfMonth),
                                                activityForwardingView.getjMaintainerTimeAvailabilityTable().getColumnName(column));
                        mailSender.notifyMaintainerActivity((Maintainer) maintainer.get(0));
                        int input = JOptionPane.showConfirmDialog(null ,"The activity has been assigned and the e-mail has been sent!", "E-mail correctly sent.", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if(input == 0)
                        {
                            goBackPlannerHomepage();
                            activityForwardingView.dispose();
                        } 
                    }    
                       
                } 
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
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
    
    /**
     * Opens the Planner Homepage view using its controller
     */
    public void goBackPlannerHomepage()
    {
        new PlannerHomepageController();
    }        
    
    /**
     * Updates the table in the page inserting the time availability of the maintainer
     * @param plannedActivity is the planned activity to assign
     * @param weeklyAvailability is the weekly availability of the maintainer
     */
    public void viewTimeAvailability(PlannedActivity plannedActivity, WeeklyAvailability weeklyAvailability)
    {
        DefaultTableModel tableModel = activityForwardingView.getDefaultTableModelTimeAvailability();
        
        try
        {
            int weekSelected = plannedActivity.getWeek();
            int IDActivity = plannedActivity.getIdActivity();
            String branchOffice = plannedActivity.getBrachOffice();;
            String department = plannedActivity.getDepartment();
            Typology typology = plannedActivity.getTypology();
            int timeNeeded = plannedActivity.getRemainingTime();
            String maintainerName = weeklyAvailability.getUsername();
            
            // Represents the informations on the view
            activityForwardingView.getjWeekNumberLabel().setText(String.valueOf(weekSelected));
            activityForwardingView.getjDayOfWeekLabel().setText(dayOfWeek);
            activityForwardingView.getjDayOfWeekNumberLabel().setText(String.valueOf(dayOfMonth));
            activityForwardingView.getjActivityToAssignLabel().setText(String.valueOf(IDActivity) + " - " + 
                                   branchOffice + " " + department + " - " + typology.getValue() + " - " + 
                                   String.valueOf(timeNeeded) + "'");
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
            
        }
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        
    }
    
    /**
     * Updates the DataModel adding more informations and some new strings
     * @param dataModel is the DataModel that you want to update
     * @return the updated DataModel with the new adds
     */
    public Object[] updateDataModel(Object[] dataModel)
    {
        int maxSkills = this.plannedActivity.getSkills().size();
         
        dataModel[1] = dataModel[1] + "/" + maxSkills;
        for(int i= 2; i < activityForwardingView.getjMaintainerTimeAvailabilityTable().getColumnCount(); i++)
        {
            this.changeTable(activityForwardingView.getjMaintainerTimeAvailabilityTable(), i);
            dataModel[i] = dataModel[i] + " min";  
        }
        return dataModel;
     }
     
    /**
     * Assigns and forwards the maintenance activity to the maintainer in the selected day and turn
     * @param plannedActivity is the planned activity to assign
     * @param weeklyAvailability is the weekly availability of the maintainer
     * @return true if the maintainer is available in the specified turn, false otherwise
     */
    public boolean forwardActivity(PlannedActivity plannedActivity, WeeklyAvailability weeklyAvailability)
    {
        try
        {
            DayOfWeek day = DayOfWeek.valueOf(this.dayOfWeek.toUpperCase());
            
            int row = activityForwardingView.getjMaintainerTimeAvailabilityTable().getSelectedRow();
            int column = activityForwardingView.getjMaintainerTimeAvailabilityTable().getSelectedColumn();
            String workTurn = activityForwardingView.getjMaintainerTimeAvailabilityTable().getColumnName(column);
            String minutesSelected = activityForwardingView.getjMaintainerTimeAvailabilityTable().getValueAt(row, column).toString();
            String[] minutes = minutesSelected.split(" ");
            
            if(minutesSelected.equals("0 min"))
            {
                JOptionPane.showMessageDialog(null, NOT_VALID_MESSAGE);
                return false;
            }    
            this.maintenanceActivityRepo.assignMaintenanceActivity(plannedActivity, (Maintainer) this.maintainer.get(0), day, fromString(workTurn), parseInt(minutes[0]));
            
            return true;
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
            JOptionPane.showMessageDialog(new JFrame(), SELECT_TURN_MESSAGE);
        }
        return false;
    } 

    /**
     * Getter used for tests
     * @return the ActivityForwardingView
     */
    public ActivityForwardingView getActivityForwardingView()
    {
        this.activityForwardingView.dispose();
        return activityForwardingView;
    }
    
    /**
     * 
     * Change the color of the cell in the table according to their values.
     * @param table is the table in the page.
     * @param column is a specific column of the table.
     */
    public void changeTable(JTable table, int column)
    {
            table.getColumnModel().getColumn(column).setCellRenderer(new DefaultTableCellRenderer()
            {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
                {
                    final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    int cellValue = Integer.parseInt(table.getValueAt(row, column).toString().split(" ")[0]);
                    if ((cellValue <= 60) && (cellValue >= 50))
                    {
                        component.setBackground(Color.green);
                    }
                    else if (cellValue == 0)
                    {
                        component.setBackground(Color.red);
                    }
                    else if ((cellValue > 0) && (cellValue <= 15))
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
