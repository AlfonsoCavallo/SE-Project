/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import se.project.presentation.views.LoginView;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.models.User;
import se.project.storage.repos.UserAccessRepo;
import se.project.storage.repos.UserRepo;

/**
 *
 * @author Utente
 */
public class LoginController
{

    private final LoginView loginView;
    private UserRepo userRepo;
    private UserAccessRepo userAccessRepo;

    private final String LOGIN_FAILED_MESSAGE = "Login failed.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";

    public LoginController(LoginView loginView)
    {
        this.loginView = loginView;
    }

    public JFrame login()
    {
        String username = loginView.getUsername();
        char[] password = loginView.getPassword();

        userRepo = new UserRepo();
        userAccessRepo = new UserAccessRepo();
        
        try
        {
            connect(username, password);
            User currentUser = userRepo.queryCurrentUser();
            userAccessRepo.storeCurrentUserAccess(currentUser.getUsername());
            return openUserPage(currentUser.getRole());
        }
        catch (ClassNotFoundException | SQLException ex)
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
        if (null == role)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
        } 
        else // Opens the homepage for the current user
        {
            switch (role)
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
        }
        return null;
    }
}
