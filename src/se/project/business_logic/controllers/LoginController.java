package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.presentation.views.LoginView;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.models.SystemUser;
import se.project.storage.repos.SystemUserRepo;
import se.project.storage.repos.UserAccessRepo;
import se.project.storage.repos.interfaces.SystemUserRepoInterface;
import se.project.storage.repos.interfaces.UserAccessRepoInterface;


public class LoginController extends AbstractController
{

    private final LoginView loginView;
    private SystemUserRepoInterface userRepo;
    private UserAccessRepoInterface userAccessRepo;

    private final String LOGIN_FAILED_MESSAGE = "Login failed.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";

    /**
     * 
     * Creates a new LoginController
     */
    public LoginController()
    {
        this.loginView = new LoginView();
        initListeners();
    }
    
    /***
     * 
     * @return loginView 
     */
    @Override
    public LoginView getView()
    {
        return loginView;
    }
    
    /**
     * 
     *  Initializes the listeners of loginView
     */
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

    /**
     * 
     *  Makes the log in
     */
    public void login()
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
            openUserPage(currentUser.getRole());
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        }
    }

    /**
     * 
     * Opens the page corresponding to the specific role
     * @param role is the role of the system user that has logged in
     */
    private void openUserPage(SystemUser.Role role)
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
                    ControllerFactory.createController(ControllerType.SAHOMEPAGE);
                    loginView.dispose();
                    break;
                case PLANNER:
                    ControllerFactory.createController(ControllerType.PLANNER_HOMEPAGE);
                    loginView.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(new JFrame(), LOGIN_FAILED_MESSAGE);
                    break;
            }
        }
    }
}
