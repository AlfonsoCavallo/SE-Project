/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.awt.event.ItemEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import se.project.presentation.views.AddMaintenanceActivityView;
import se.project.presentation.views.MaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.maintenance_activity.EWO;
import se.project.storage.models.maintenance_activity.ExtraActivity;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import static se.project.storage.models.maintenance_activity.MaintenanceActivity.Typology.fromString;
import se.project.storage.models.maintenance_activity.PlannedActivity;
import se.project.storage.repos.MaintenanceActivityRepo;
import se.project.storage.repos.interfaces.MaintenanceActivityRepoInterface;

/**
 *
 * @author delso
 */
public class AddMaintenanceActivityController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not add maintenance activity in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String ADDED_MESSAGE = "Maintenance activity \"activity_name_param\" has been added successfully!";
    
    private final AddMaintenanceActivityView addMaintenanceActivityView;
    private MaintenanceActivityRepoInterface maintenanceActivityRepo = null;
            
    public AddMaintenanceActivityController(AddMaintenanceActivityView addMaintenanceActivityView)
    {
        this.addMaintenanceActivityView = addMaintenanceActivityView;
        this.maintenanceActivityRepo = new MaintenanceActivityRepo(getConnection());
        clearFields();
        initListeners();
    }
    
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
                goBackMaintenanceActivityPage(null);
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
                    
                    System.out.println(addMaintenanceActivityView.getIsPlannedValue());
                    addMaintenanceActivityView.getjEWOComboBox().setVisible(!addMaintenanceActivityView.getIsPlannedValue().equals("yes"));  
                }
            }              
        });        
    }
    
    public static JFrame goBackMaintenanceActivityPage(Connection connection)
    {
        MaintenanceActivityView maintenanceActivityView = new MaintenanceActivityView();
        MaintenanceActivityController maintenanceActivityController = new MaintenanceActivityController(maintenanceActivityView);
        return maintenanceActivityView;
    }
    
    public void addMaintenanceActivity()
    {
        MaintenanceActivity maintenanceActivity = null;
        
        String activityName = addMaintenanceActivityView.getjNameTextField();
        String timeNeeded = addMaintenanceActivityView.getjTimeTextField();
        String interruptibleString = addMaintenanceActivityView.getjInterruptibleComboBox();
        String typology = addMaintenanceActivityView.getjTypologyComboBox();
        String activityDescription = addMaintenanceActivityView.getjDescriptionTextArea();
        String week = addMaintenanceActivityView.getjWeekComboBox();
        String planned = addMaintenanceActivityView.getIsPlannedValue();
        String ewo = addMaintenanceActivityView.getIsEWOValue();
        String standardProcedure = addMaintenanceActivityView.getjStandardProcedureTextField();
        
        boolean interruptible;
        
        if(interruptibleString.equals("yes"))
        {
            interruptible = true;
        }
        else
        {
            interruptible = false;
        }    
        
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
