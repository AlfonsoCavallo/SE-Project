/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import se.project.business_logic.controllers.user_management.UserInfoController;
import java.sql.SQLException;
import javax.swing.JFrame;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.SAHomepageView;
import se.project.presentation.views.UserAccessesView;
import se.project.presentation.views.UserInfoView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 *
 * @author Giacomo
 */
public class SAHomepageController extends AbstractController
{
    private final SAHomepageView saHomepageView;
    
    public SAHomepageController(SAHomepageView saHomepageView)
    {
        this.view = saHomepageView;
        this.saHomepageView = saHomepageView;
        initListeners();
    }
    
    private void initListeners()
    {
        saHomepageView.getjUserInfoPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUserInfoPage();
                saHomepageView.dispose();
            }
        });
        
        saHomepageView.getjAccessRecordPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openRecordAccessPage();
                saHomepageView.dispose();
            }
        });
        
        
        saHomepageView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                saHomepageView.dispose();
                openLoginPage();
            }
        });
        
        saHomepageView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    public static JFrame openUserInfoPage()
    {
        UserInfoView userInfoView = new UserInfoView();
        UserInfoController userInfoController = new UserInfoController(userInfoView);
        return userInfoView;
    }
    
    public static JFrame openRecordAccessPage()
    {
        UserAccessesView userAccessesView = new UserAccessesView();
        UserAccessesController userAccessesController = new UserAccessesController(userAccessesView);
        return userAccessesView;
    }
}
