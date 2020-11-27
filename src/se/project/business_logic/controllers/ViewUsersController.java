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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.presentation.views.ViewUsersView;
import se.project.presentation.views.UserInfoView;
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
    
    private final ViewUsersView viewUsersView;
    private UserRepo userRepo = null;
    
    public ViewUsersController(ViewUsersView viewUsersView)
    {
        this.viewUsersView = viewUsersView;
        this.userRepo = new UserRepo();
    }
    
    public static JFrame goBackUserInfoPage(Connection connection)
    {
       UserInfoView userInfoView = new UserInfoView();
       return userInfoView;
    }
    
    public void viewUsers()
    {
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
           
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        }
    }
}