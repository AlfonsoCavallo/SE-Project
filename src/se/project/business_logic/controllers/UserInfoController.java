/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.Connection;
import javax.swing.JFrame;
import se.project.presentation.views.AddUserView;
import se.project.presentation.views.SAHomepageView;

/**
 *
 * @author Giorgio
 */
public class UserInfoController
{
    public static JFrame openAddUserPage(Connection connection)
    {
        AddUserView addUserView = new AddUserView();
        return addUserView;
    }
    
    public static JFrame goBackSystemAdministratorHomepage(Connection connection)
    {
        SAHomepageView saHomepageView = new SAHomepageView();
        return saHomepageView;
    }
}
