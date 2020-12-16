package se.project.business_logic.controllers.user_management;

import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.business_logic.controllers.SingletonControllerFactory;
import se.project.presentation.views.user_management.UserInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 * Manages the business logic behind an UserInfoView.
 * 
 */
public class UserInfoController  extends AbstractController
{
    private final UserInfoView userInfoView;
    
    /**
     * 
     * Creates a new UserInfoController.
     */
    public UserInfoController()
    {
        this.userInfoView = new UserInfoView();
        initListeners();
    }
    
    /***
     * 
     * @return userInfoView.
     */
    @Override
    public UserInfoView getView()
    {
        return userInfoView;
    } 
    
    /**
     * 
     *  Initializes the listeners of viewMaintenanceActivityView.
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
     * Opens the add user page instantiating its controller.
     */
    public static void openAddUserPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.ADD_USER);
    }
    
    /**
     * 
     * Opens the view and delete user page instantiating its controller.
     */
    public static void openViewUserPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.VIEW_USERS);
    }
    
    /**
     * 
     * Opens the update user page instantiating its controller.
     */
    public static void openUpdateUserPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.UPDATE_USER);
    }
    
    /**
     * 
     * Opens the system administrator homepage instantiating its controller.
     */
    public static void goBackSystemAdministratorHomepage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.SAHOMEPAGE);
    }
}
