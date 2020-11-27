/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
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
public class SAHomepageController
{
    private final SAHomepageView saHomepageView;
    
    public SAHomepageController(SAHomepageView saHomepageView)
    {
        this.saHomepageView = saHomepageView;
        initListeners();
    }
    
    private void initListeners()
    {
        saHomepageView.getjUserInfoPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUserInfoPage(null);
                saHomepageView.dispose();
            }
        });
        
        saHomepageView.getjAccessRecordPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openRecordAccessPage(null);
                saHomepageView.dispose();
            }
        });
        
        saHomepageView.getjMaintenanceProceduresPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openMaintenanceProceduresPage(null);
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
    
    public static JFrame openUserInfoPage(Connection connection)
    {
        UserInfoView userInfoView = new UserInfoView();
        return userInfoView;
    }
    
    public static JFrame openRecordAccessPage(Connection connection)
    {
        UserAccessesView userAccessesView = new UserAccessesView();
        UserAccessesController userAccessesController = new UserAccessesController(userAccessesView);
        return userAccessesView;
    }
    
    public static JFrame openMaintenanceProceduresPage(Connection connection)
    {
        return null;
    } 
    
}
