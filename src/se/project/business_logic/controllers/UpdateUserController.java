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
import se.project.presentation.views.UpdateUserView;
import se.project.presentation.views.UserInfoView;
import se.project.storage.repos.UserRepo;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;

/**
 *
 * @author Giorgio
 */
public class UpdateUserController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not update user in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String UPDATED_MESSAGE = "User \"username_param\" has been updated successfully!";
    
    private final UpdateUserView updateUserView;
    private UserRepo userRepo;
    private LinkedList<String> usernameList;

    public UpdateUserController(UpdateUserView updateUserView)
    {
        this.updateUserView = updateUserView;
        this.userRepo = new UserRepo();
        this.usernameList = new LinkedList<>();
        initListeners();
        viewUsers(false);
    }
    
    private void initListeners()
    {
        updateUserView.getjUpdateUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                updateUser();
                viewUsers(false);
            }
        });
        
        updateUserView.getjShowPasswordPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                viewUsers(true);
            }
        });
        
        updateUserView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackUserInfoPage();
                updateUserView.dispose();
            }
        });
        
        updateUserView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                updateUserView.dispose();
                openLoginPage();
            }
        });
        
        updateUserView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    public static JFrame goBackUserInfoPage()
    {
       UserInfoView userInfoView = new UserInfoView();
       UserInfoController userInfoController = new UserInfoController(userInfoView);
       return userInfoView;
    }
    
    public void updateUser()
    {
        int row = updateUserView.getTable().getSelectedRow();
        String username = updateUserView.getTable().getValueAt(row, 0).toString();
        String name = updateUserView.getTable().getValueAt(row, 1).toString();
        String surname = updateUserView.getTable().getValueAt(row, 2).toString();
        String email = updateUserView.getTable().getValueAt(row, 3).toString();
        String role = updateUserView.getTable().getValueAt(row, 4).toString();
        String password = updateUserView.getTable().getValueAt(row, 5).toString();
        User user = null;
        if(role.equals("system_administrator"))
        {
            user = new SystemAdministrator(username, email, name, surname, password, role);
        }
        else if(role.equals("planner"))
        {
            user = new Planner(username, email, name, surname, password, role);
        }
        try
        {
            String oldUsername = this.usernameList.get(row);
            userRepo.queryUpdateUser(user, oldUsername);
            JOptionPane.showMessageDialog(null, UPDATED_MESSAGE);
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
    
    public void viewUsers(boolean showPassword)
    {
        DefaultTableModel tableModel = updateUserView.getTableModel();
        LinkedList<User> users;
        int columnNumber = this.updateUserView.getTable().getColumnCount();
        try
        {
            users = userRepo.queryAllUsers();
            usernameList.clear();
           
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Verifies if it must show password
            if(!showPassword)
            {               
                updateUserView.getjShowPasswordLabel().setText("Show Passwords");
                //this.updateUserView.getTable().removeColumn(updateUserView.getTable().getColumnModel().getColumn(columnNumber - 1));
            }
            else
            {
                updateUserView.getjShowPasswordLabel().setText("Hide Passwords");
            }
            
            // Iterates over users
            for(User user : users)
            {
                tableModel.addRow(user.getDataPasswordModel());
                this.usernameList.add(user.getUsername());
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
    
    public void showPassword(boolean showPassword)
    {
        if(!showPassword)
            {               
                updateUserView.getjShowPasswordLabel().setText("Show Passwords");
            }
            else
            {
                updateUserView.getjShowPasswordLabel().setText("Hide Passwords");
            }
    }
}
