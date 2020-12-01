package se.project.business_logic.controllers;

import se.project.business_logic.controllers.user_management.UserInfoController;
import java.sql.SQLException;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.SAHomepageView;
import static se.project.storage.DatabaseConnection.closeConnection;


public class SAHomepageController extends AbstractController
{
    private final SAHomepageView saHomepageView;
    
    /**
     * 
     * Creates a new SAHomepageController
     */
    public SAHomepageController()
    {
        this.saHomepageView = new SAHomepageView();
        initListeners();
    }
    
    /**
     * 
     *  Initializes the listeners of saHomepageView
     */
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
    
    /**
     * 
     * Opens the user info page using its controller
     */
    public void openUserInfoPage()
    {
        new UserInfoController();
    }
    
    /**
     * 
     * Opens the user access records page using its controller
     */
    public void openRecordAccessPage()
    {
        new UserAccessesController();
    }
    
}
