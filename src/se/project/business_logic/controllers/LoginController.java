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
import se.project.storage.models.SystemUser;
import se.project.storage.repos.SystemUserRepo;
import se.project.storage.repos.UserAccessRepo;
import se.project.storage.repos.interfaces.SystemUserRepoInterface;
import se.project.storage.repos.interfaces.UserAccessRepoInterface;

/**
 *
 * @author Utente
 */
public class LoginController extends AbstractController
{

    private final LoginView loginView;
    private SystemUserRepoInterface userRepo;
    private UserAccessRepoInterface userAccessRepo;

    private final String LOGIN_FAILED_MESSAGE = "Login failed.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";

    public LoginController(LoginView loginView)
    {
        this.view = loginView;
        this.loginView = loginView;
        initListeners();
    }
    
    private void initListeners()
    {
        loginView.getjUsernameTextField().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                loginView.getjUsernameTextField().setText("");
            }
        });
        
        loginView.getjPasswordField().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                loginView.getjPasswordField().setText("");
            }
        });
        
        loginView.getjLoginLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                login();
            }
        });
        
        loginView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }

    public JFrame login()
    {
        String username = loginView.getUsername();
        char[] password = loginView.getPassword();

        userRepo = new SystemUserRepo(getConnection());
        userAccessRepo = new UserAccessRepo(getConnection());
        
        try
        {
            connect(username, password);
            SystemUser currentUser = userRepo.queryCurrentUser();
            userAccessRepo.storeCurrentUserAccess(currentUser.getUsername());
            return openUserPage(currentUser.getRole());
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
            System.out.println(ex.getMessage());
            return null;
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
            return null;
        }
    }

    private JFrame openUserPage(SystemUser.Role role)
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
