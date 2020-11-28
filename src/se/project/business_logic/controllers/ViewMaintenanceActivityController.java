/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.presentation.views.MaintenanceActivityView;
import se.project.presentation.views.ViewMaintenanceActivityView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;
import se.project.storage.repos.MaintenanceActivityRepo;

/**
 *
 * @author delso
 */
public class ViewMaintenanceActivityController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get maintenance activities from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query."; 
    private final String CONFIRM_DELETION_MESSAGE = "Are you sure to delete \" activity_name_param \"?";
    
    private final ViewMaintenanceActivityView viewMaintenanceActivityView;
    private MaintenanceActivityRepo maintenanceActivityRepo = null;
    
    public ViewMaintenanceActivityController(ViewMaintenanceActivityView viewMaintenanceActivityView)
    {
        this.viewMaintenanceActivityView = viewMaintenanceActivityView;
        this.maintenanceActivityRepo = new MaintenanceActivityRepo();
        initListeners();
        viewMaintenanceActivities();
    }
    
    public void initListeners()
    {
        viewMaintenanceActivityView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                viewMaintenanceActivityView.dispose();
                MainController.openLoginPage();
            }
        });

        viewMaintenanceActivityView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackMaintenanceActivityPage(null);
                viewMaintenanceActivityView.dispose();
            }  
        });

       viewMaintenanceActivityView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
       });
       
       viewMaintenanceActivityView.getjSearchLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               viewMaintenanceActivities();
           }        
       });
       
       viewMaintenanceActivityView.getjDeleteLabel().addMouseListener(new java.awt.event.MouseAdapter()
       {
           public void mouseClicked(java.awt.event.MouseEvent evt)
           {
               deleteMaintenanceActivity();
               viewMaintenanceActivities();
           }        
       }); 
        
    }
    
    public static JFrame goBackMaintenanceActivityPage(Connection connection)
    {
        MaintenanceActivityView maintenanceActivityView = new MaintenanceActivityView();
        MaintenanceActivityController maintenanceActivityController = new MaintenanceActivityController(maintenanceActivityView);
        return maintenanceActivityView;
    }
    
    public void viewMaintenanceActivities()
    {
        DefaultTableModel tableModel = viewMaintenanceActivityView.getTableModel();
        LinkedList<MaintenanceActivity> maintenanceActivities;
        try
        {
            String nameToSearch = viewMaintenanceActivityView.getName();
            if(!nameToSearch.equals(""))
            {
                maintenanceActivities = maintenanceActivityRepo.queryViewOneMaintenanceActivity(nameToSearch);
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
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
    }
    
    public void deleteMaintenanceActivity()
    {
        try
        {
            String nameToDelete = viewMaintenanceActivityView.getName();
            if(!nameToDelete.equals(""))
            {
                String confirmMessage = CONFIRM_DELETION_MESSAGE.replaceAll("activity_name_param", nameToDelete);
                int input = JOptionPane.showConfirmDialog(null, confirmMessage);
                if(input == 0)
                {
                    maintenanceActivityRepo.queryDeleteMaintenanceActivity(nameToDelete);
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
    }        
    
}
