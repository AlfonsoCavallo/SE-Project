/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
//import se.project.presentation.views.ViewUserView;
import se.project.presentation.views.UserInfoView;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;

/**
 *
 * @author Giorgio
 */
public class ViewUserController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get users from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query."; 
    
    //private final ViewUserView viewUserView;
    private UserRepo userRepo = null;
    
    /*public ViewUserController(ViewUserView viewUserView)
    {
        this.viewUserView = viewUserView;
        this.userRepo = new UserRepo();
    }*/
    
    public static JFrame goBackUserInfoPage(Connection connection)
    {
       UserInfoView userInfoView = new UserInfoView();
       return userInfoView;
    }
    
    public void viewUsers()
    {
        LinkedList<User> users;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Object columns[] = {"Username", "Name", "Surname", "E-mail", "Role", "Password"};
        defaultTableModel.setColumnIdentifiers(columns);
        //this.viewUserView.jTable.setModel(defaultTableModel);
        /*try
        {
            
        }
        catch
        {
            
        }*/
    }
}