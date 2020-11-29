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
    private final String QUERY_NULL_POINTER_MESSAGE = "All the fields must be filled!";
    
    private final UpdateUserView updateUserView;
    private UserRepo userRepo;
    private LinkedList<String> usernameList;
    private int columnNumber;

    public UpdateUserController(UpdateUserView updateUserView)
    {
        this.updateUserView = updateUserView;
        this.userRepo = new UserRepo();
        this.usernameList = new LinkedList<>();
        this.columnNumber = this.updateUserView.getTable().getColumnCount();
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
                showPassword();
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
        String username = null;
        String name = null;
        String surname = null;
        String email = null;
        String role = null;
        String password = null;
        try
        {
            username = updateUserView.getTable().getValueAt(row, 0).toString();
            name = updateUserView.getTable().getValueAt(row, 1).toString();
            surname = updateUserView.getTable().getValueAt(row, 2).toString();
            email = updateUserView.getTable().getValueAt(row, 3).toString();
            role = updateUserView.getTable().getValueAt(row, 4).toString();
            password = updateUserView.getTable().getValueAt(row, 5).toString();
        }
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_NULL_POINTER_MESSAGE);
        }
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
            String updatedMessage = UPDATED_MESSAGE.replaceAll("username_param", username);
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
    
    public void viewUsers(boolean showPassword)
    {
        DefaultTableModel tableModel = updateUserView.getTableModel();
        try
        {
            LinkedList<User> users = userRepo.queryAllUsers();
            usernameList.clear();
           
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Verifies if it must show password
            /*if(!showPassword)
            {               
                
                updateUserView.getTable().getColumnModel().removeColumn(updateUserView.getTable().getColumnModel().getColumn(columnNumber - 1));
            }
            else
            {
                updateUserView.getTable().getColumnModel().addColumn(updateUserView.getTable().getColumnModel().getColumn(columnNumber - 1));
            }*/
            
            // Iterates over users
            for(User user : users)
            {
                if(!showPassword)
                {
                    tableModel.addRow(user.getDataModel());
                }
                else
                {
                    tableModel.addRow(user.getDataPasswordModel());
                }
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
    
    public void showPassword()
    {
        String buttonMessage = updateUserView.getjShowPasswordLabel().getText();
        if(buttonMessage.equals("Hide Passwords"))
        {               
            updateUserView.getjShowPasswordLabel().setText("Show Passwords");
            viewUsers(false);
        }
        else
        {
            updateUserView.getjShowPasswordLabel().setText("Hide Passwords");
            viewUsers(true);
        }
    }
}
