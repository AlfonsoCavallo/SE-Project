/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.UserAccessesView;
import se.project.presentation.views.UserInfoView;

/**
 *
 * @author Giacomo
 */
public class SAHomepageController
{
    
    public static JFrame openUserInfoPage(Connection connection)
    {
        UserInfoView userInfoView = new UserInfoView();
        return userInfoView;
    }
    
    public static JFrame openRecordAccessPage(Connection connection)
    {
        UserAccessesView userAccessesView = new UserAccessesView();
        UserAccessesController userAccessesController = new UserAccessesController(userAccessesView);
        userAccessesView.setController(userAccessesController);
        return userAccessesView;
    }
    
    public static JFrame openMaintenanceProceduresPage(Connection connection)
    {
        return null;
    } 
    
}
