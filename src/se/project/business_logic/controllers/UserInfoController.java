/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.presentation.views.AddUserView;
import se.project.presentation.views.DeleteUserView;
import se.project.presentation.views.SAHomepageView;
import se.project.presentation.views.UpdateUserView;
import se.project.presentation.views.UserInfoView;
import se.project.presentation.views.ViewUsersView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;

/**
 *
 * @author Giorgio
 */
public class UserInfoController 
{
    private final UserInfoView userInfoView;
    
    public UserInfoController(UserInfoView userInfoView)
    {
        this.userInfoView = userInfoView;
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
        
        userInfoView.getjDeleteUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openDeleteUserPage();
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
    
    public static JFrame openAddUserPage()
    {
        AddUserView addUserView = new AddUserView();
        AddUserController addUserController = new AddUserController(/*addUserView*/);
        return addUserView;
    }
    
    public static JFrame openViewUserPage()
    {
        ViewUsersView viewUserView = new ViewUsersView();
        ViewUsersController viewUsersController = new ViewUsersController(viewUserView);
        return viewUserView;
    }
    public static JFrame openDeleteUserPage()
    {
        DeleteUserView deleteUserView = new DeleteUserView();
        return deleteUserView;
    }
    
    public static JFrame openUpdateUserPage()
    {
        UpdateUserView updateUserView = new UpdateUserView();
        return updateUserView;
    }
    
    public static JFrame goBackSystemAdministratorHomepage()
    {
        SAHomepageView saHomepageView = new SAHomepageView();
        SAHomepageController saHomepageController = new SAHomepageController(saHomepageView);
        return saHomepageView;
    }
}
