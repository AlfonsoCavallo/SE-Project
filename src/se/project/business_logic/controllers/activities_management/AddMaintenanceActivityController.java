package se.project.business_logic.controllers.activities_management;

import java.awt.event.ItemEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.MainController;
import se.project.presentation.views.activities_management.AddMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.EWO;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.fromString;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;


public class AddMaintenanceActivityController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not add maintenance activity in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String ADDED_MESSAGE = "Maintenance activity \"activity_name_param\" has been added successfully!";
    
    private final AddMaintenanceActivityView addMaintenanceActivityView;
    private MaintenanceActivityRepoInterface maintenanceActivityRepo = null;
            
    /**
     * 
     * Crates a new AddMaintenanceActivityController
     */
    public AddMaintenanceActivityController()
    {
        this.addMaintenanceActivityView = new AddMaintenanceActivityView();
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        clearFields();
        initListeners();
    }
    
    /**
     * 
     *  Initializes the listeners of addMaintenanceActivityView
     */
    public void initListeners()
    {
        addMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                addMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });

        addMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage();
                addMaintenanceActivityView.dispose();
            }       
        });

        addMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });

        addMaintenanceActivityView.getjAddPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                addMaintenanceActivity();
                clearFields();
            }        
        });

        addMaintenanceActivityView.getjClearPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                clearFields();
            }        
        });        
        
        addMaintenanceActivityView.getjPlannedComboBox().addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                if (evt.getStateChange() == ItemEvent.SELECTED)
                {
                    if(addMaintenanceActivityView.getIsPlannedValue().equals("no"))
                    {
                        addMaintenanceActivityView.getjEWOComboBox().setEnabled(true);
                        addMaintenanceActivityView.getjStandardProcedureTextField().setText("-");
                        addMaintenanceActivityView.getjStandardProcedureTextField().setEnabled(false);
                    }
                    else
                    {
                        addMaintenanceActivityView.getjEWOComboBox().setEnabled(false);
                        addMaintenanceActivityView.resetjEWOComboBox();
                        addMaintenanceActivityView.resetjStandardProcedureTextField();
                        addMaintenanceActivityView.getjStandardProcedureTextField().setEnabled(true);
                    }
                }
            }              
        });

    }
    
    /**
     * 
     * Opens the maintenance activity page using its controller
     */
    public static void goBackMaintenanceActivityPage()
    {
        new MaintenanceActivityController();
    }
    
    /**
     * 
     * Add a new maintenanance activity using data from the page and method from the repo
     */
    public void addMaintenanceActivity()
    {
        MaintenanceActivity maintenanceActivity = null;
        
        String activityName = addMaintenanceActivityView.getStringActivityName();
        String timeNeeded = addMaintenanceActivityView.getStringTimeNeeded();
        String interruptibleString = addMaintenanceActivityView.getIsInterruptibleValue();
        String typology = addMaintenanceActivityView.getStringTypology();
        String activityDescription = addMaintenanceActivityView.getStringActivityDescription();
        String week = addMaintenanceActivityView.getStringWeek();
        String planned = addMaintenanceActivityView.getIsPlannedValue();
        String ewo = addMaintenanceActivityView.getIsEWOValue();
        String standardProcedure = addMaintenanceActivityView.getStringStandardProcedure();
        
        boolean interruptible = interruptibleString.equals("yes");    
        
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
        try
        {
            maintenanceActivityRepo.queryAddMaintenanceActivity(maintenanceActivity);
            String addedMessage = ADDED_MESSAGE.replaceAll("activity_name_param", activityName);
            JOptionPane.showMessageDialog(null, addedMessage);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
            System.err.println(ex.getMessage());
        }
    } 
    
    /**
     * 
     * Clears all the fields in the page
     */
    public void clearFields()
    {
        addMaintenanceActivityView.resetjDescriptionTextArea();
        addMaintenanceActivityView.resetjEWOComboBox();
        addMaintenanceActivityView.resetjInterruptibleComboBox();
        addMaintenanceActivityView.resetjNameTextField();
        addMaintenanceActivityView.resetjPlannedComboBox();
        addMaintenanceActivityView.resetjStandardProcedureTextField();
        addMaintenanceActivityView.resetjTimeTextField();
        addMaintenanceActivityView.resetjTypologyComboBox();
        addMaintenanceActivityView.resetjWeekComboBox();
    }        
    
}