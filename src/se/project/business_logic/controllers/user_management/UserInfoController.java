package se.project.business_logic.controllers.user_management;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.SAHomepageController;
import se.project.presentation.views.user_management.UserInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;


public class UserInfoController  extends AbstractController
{
    private final UserInfoView userInfoView;
    
    /**
     * 
     * Creates a new UserInfoController
     */
    public UserInfoController()
    {
        this.userInfoView = new UserInfoView();
        initListeners();
    }
    
    /**
     * 
     *  Initializes the listeners of viewMaintenanceActivityView
     */
    private void initListeners()
    {
        userInfoView.getjAddUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openAddUserPage();
                userInfoView.dispose();
            }
        });
        
        userInfoView.getjViewUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openViewUserPage();
                userInfoView.dispose();
            }
        });
        
        userInfoView.getjUpdateUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUpdateUserPage();
                userInfoView.dispose();
            }
        });
        
        userInfoView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackSystemAdministratorHomepage();
                userInfoView.dispose();
            }
        });
        
        userInfoView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                userInfoView.dispose();
                openLoginPage();
            }
        });
        
        userInfoView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    /**
     * 
     * Opens the add user page using its controller
     */
    public static void openAddUserPage()
    {
        new AddUserController();
    }
    
    /**
     * 
     * Opens the view and delete user page using its controller
     */
    public static void openViewUserPage()
    {
        new ViewUsersController();
    }
    
    /**
     * 
     * Opens the update user page using its controller
     */
    public static void openUpdateUserPage()
    {
        new UpdateUserController();
    }
    
    /**
     * 
     * Opens the system administrator homepage using its controller
     */
    public static void goBackSystemAdministratorHomepage()
    {
        new SAHomepageController();
    }
}
