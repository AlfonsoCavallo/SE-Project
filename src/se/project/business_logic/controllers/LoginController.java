/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import se.project.presentation.views.LoginView;
import se.project.storage.User;
import se.project.storage.UserRepo;
import static se.project.storage.User.Role.*;
import static se.project.storage.DatabaseConnection.*;

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
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    
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
            connect(username, password);
            User currentUser = userRepo.queryCurrentUser();
            return openUserPage(currentUser.getRole());
        } 
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
            return null;
        } 
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
            return null;
        }
    }
    
    private JFrame openUserPage(User.Role role)
    {
        if(null == role)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
        }
        else // Opens the homepage for the current user
            
        switch(role)
        {
            case SYSTEM_ADMINISTRATOR:
                loginView.dispose();
                return MainController.openSystemAdministratorHomePage(getConnection());
            case PLANNER:
                loginView.dispose();
                return MainController.openPlannerHomePage(getConnection());
            default:
                JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
                break;
        }
        return null;
    }
    
    
    
}
