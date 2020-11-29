/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import se.project.presentation.views.ViewUsersView;
import se.project.presentation.views.UserInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;

/**
 *
 * @author Giorgio
 */
public class ViewUsersController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get users from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query."; 
    private final String CONFIRM_DELETION_MESSAGE = "Are you sure to delete \"username_param\"?";
    private final String DELETED_MESSAGE = "User \"username_param\" has been removed successfully!";
    private final String SELECT_USER_MESSAGE = "Please, select a user before deleting!";
    
    private final ViewUsersView viewUsersView;
    private UserRepo userRepo = null;
    
    public ViewUsersController(ViewUsersView viewUsersView)
    {
        this.viewUsersView = viewUsersView;
        this.userRepo = new UserRepo();
        viewUsers();
        initListeners();
    }
    
    private void initListeners()
    {
        viewUsersView.getjSearchLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                viewUsers();
            }
        });
        
        viewUsersView.getjDeleteLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                deleteUser();
                viewUsers();
            }
        });
        
        viewUsersView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackUserInfoPage();
                viewUsersView.dispose();
            }
        });
        
        viewUsersView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                viewUsersView.dispose();
                MainController.openLoginPage();
            }
        });
        
        viewUsersView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
    
    public void viewUsers()
    {
        DefaultTableModel tableModel = viewUsersView.getTableModel();
        LinkedList<User> users;
        try
        {
            String usernameToSearch =  viewUsersView.getUsername();
            if(!usernameToSearch.equals(""))
            {
                users = userRepo.queryViewOneUser(usernameToSearch);
            }
            else
            {
                users = userRepo.queryAllUsers();
            }
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterates over users
            for(User user : users)
            {
                tableModel.addRow(user.getDataModel());
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
    
    public void deleteUser()
    {
        try
        {
            int row = viewUsersView.getTable().getSelectedRow();
            String usernameToDelete = viewUsersView.getTable().getValueAt(row, 0).toString();
            if(!usernameToDelete.equals(""))
            {
                String confirmMessage = CONFIRM_DELETION_MESSAGE.replaceAll("username_param", usernameToDelete);
                int input = JOptionPane.showConfirmDialog(null, confirmMessage, "Confirm Message", YES_NO_OPTION);
                if(input == 0)
                {
                   userRepo.queryDeleteUser(usernameToDelete);
                   String deletedMessage = DELETED_MESSAGE.replaceAll("username_param", usernameToDelete);
                   JOptionPane.showMessageDialog(null, deletedMessage);
                   viewUsersView.resetUsernameField();
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
        catch (ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_USER_MESSAGE);
        }
    }
}
