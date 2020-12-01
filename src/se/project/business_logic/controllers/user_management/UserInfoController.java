/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers.user_management;

import se.project.business_logic.controllers.user_management.ViewUsersController;
import se.project.business_logic.controllers.user_management.UpdateUserController;
import se.project.business_logic.controllers.user_management.AddUserController;
import java.sql.SQLException;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.SAHomepageController;
import se.project.presentation.views.user_management.UserInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;

/**
 *
 * @author Giorgio
 */
public class UserInfoController  extends AbstractController
{
    private final UserInfoView userInfoView;
    
    public UserInfoController()
    {
        this.userInfoView = new UserInfoView();
        initListeners();
    }
    
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
    
    public static void openAddUserPage()
    {
        new AddUserController();
    }
    
    public static void openViewUserPage()
    {
        new ViewUsersController();
    }
    
    public static void openUpdateUserPage()
    {
        new UpdateUserController();
    }
    
    public static void goBackSystemAdministratorHomepage()
    {
        new SAHomepageController();
    }
}
