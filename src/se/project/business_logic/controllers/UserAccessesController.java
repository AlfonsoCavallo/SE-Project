/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.presentation.views.SAHomepageView;
import se.project.presentation.views.UserAccessesView;
import se.project.storage.models.UserAccess;
import se.project.storage.repos.UserAccessRepo;

/**
 *
 * @author Utente
 */
public class UserAccessesController
{

    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could net get user accesses from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    
    private final UserAccessesView userAccessesView;
    private UserAccessRepo userAccessesRepo = null;

    public UserAccessesController(UserAccessesView userAccessesView)
    {
        this.userAccessesView = userAccessesView;
    }

    public void updateAccesses()
    {
        LinkedList<UserAccess> userAccesses;
        DefaultTableModel tableModel = userAccessesView.getTableModel();
        this.userAccessesRepo = new UserAccessRepo();
        
        try
        {
            String usernameToSearch = userAccessesView.getUsernameField();
            if(!usernameToSearch.equals(""))
            {
                userAccesses = userAccessesRepo.queryUserAccesses(usernameToSearch);
            }
            else
            {
                userAccesses = userAccessesRepo.queryAllUserAccesses();
            }
            
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterates over userAccesses
            for(UserAccess userAccess : userAccesses)
            {
                tableModel.addRow(userAccess.getDataModel());
            }
        } 
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        }
    }
    
    public SAHomepageView backToHomepage()
    {
        SAHomepageView saHomepageView = new SAHomepageView();
        return saHomepageView;        
    }
}
