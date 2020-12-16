package se.project.business_logic.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import se.project.presentation.views.UserAccessesView;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.models.UserAccess;
import se.project.storage.repo_proxy.UserAccessProxyRepo;
import se.project.storage.repos.interfaces.UserAccessRepoInterface;

/**
 * Manages the business logic behind an UserAccessesView.
 * 
 */
public class UserAccessesController extends AbstractController
{

    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not get user accesses from database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    
    private final UserAccessesView userAccessesView;
    private final UserAccessRepoInterface userAccessesRepo = new UserAccessProxyRepo(getConnection());

    /**
     * 
     * Creates a new UserAccessesController.
     */
    public UserAccessesController()
    {
        this.userAccessesView = new UserAccessesView();
        initListeners();
        updateAccesses();
    }
    
    /***
     * 
     * @return userAccessesView.
     */
    @Override
    public UserAccessesView getView()
    {
        return userAccessesView;
    }
    
    /**
     * 
     *  Initializes the listeners of saHomepageView.
     */
    private void initListeners()
    {
        userAccessesView.getjSearchLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                updateAccesses();
            }
        });
        
        userAccessesView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackSystemAdministratorHomepage();
                userAccessesView.dispose();
            }
        });
        
        userAccessesView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
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
                userAccessesView.dispose();
                MainController.openLoginPage();
            }
        });
        
        userAccessesView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }

    /**
     * Update the table in the page inserting the accesses of all the users or those of a specific user.
     */
    private void updateAccesses()
    {
        LinkedList<UserAccess> userAccesses;
        DefaultTableModel tableModel = userAccessesView.getTableModel();
        
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
    
    /**
     * 
     * Opens the system administrator page instantiating its controller.
     */
    public void goBackSystemAdministratorHomepage()
    {
        ControllerFactory.createController(ControllerType.SAHOMEPAGE);
    }
}
