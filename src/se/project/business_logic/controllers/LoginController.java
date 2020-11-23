/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import se.project.presentation.views.LoginView;
import se.project.storage.User;
import se.project.storage.UserRepo;

/**
 *
 * @author Utente
 */
public class LoginController
{
    private MainController mainController;
    private final LoginView loginView;
    private UserRepo userRepo;
    
    private final String LOGIN_FAILED_MESSAGE = "Login failed.";
    
    public LoginController(LoginView loginView)
    {
        this.mainController = mainController;
        this.loginView = loginView;
    }

    public JFrame login()
    {
        String username = loginView.getUsername();
        char[] password = loginView.getPassword();
        
        userRepo = new UserRepo();
        try
        {
            userRepo.connect(username, password);
            User currentUser = userRepo.queryCurrentUser();
            return openUserPage(currentUser.getRole());
        } 
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
            return null;
        }
    }
    
    private JFrame openUserPage(User.Role role)
    {
        // Opens the homepage for the current user
        if(role == User.Role.SYSTEM_ADMINISTRATOR)
        {        
            loginView.dispose();
            return MainController.openSystemAdministratorHomePage();
        }
        else if(role == User.Role.PLANNER)
        {
            loginView.dispose();
            return MainController.openPlannerHomePage();
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
        }
        return null;
    }
    
    
    
}
