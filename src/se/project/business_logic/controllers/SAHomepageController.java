package se.project.business_logic.controllers;

import java.sql.SQLException;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.SAHomepageView;
import static se.project.storage.DatabaseConnection.closeConnection;

/**
 * Manages the business logic behind an SAHomepageView.
 * 
 */
public class SAHomepageController extends AbstractController
{
    private final SAHomepageView saHomepageView;
    
    /**
     * 
     * Creates a new SAHomepageController.
     */
    public SAHomepageController()
    {
        this.saHomepageView = new SAHomepageView();
        initListeners();
    }
    
    /***
     * 
     * @return plannerHomepageView.
     */
    @Override
    public SAHomepageView getView()
    {
        return saHomepageView;
    }
    
    /**
     * 
     *  Initializes the listeners of saHomepageView.
     */
    private void initListeners()
    {
        saHomepageView.getjUserInfoPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openUserInfoPage();
                saHomepageView.dispose();
            }
        });
        
        saHomepageView.getjAccessRecordPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openRecordAccessPage();
                saHomepageView.dispose();
            }
        });
        
        
        saHomepageView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                saHomepageView.dispose();
                openLoginPage();
            }
        });
        
        saHomepageView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    /**
     * 
     * Opens the user info page instantiating its controller.
     */
    public void openUserInfoPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.USER_INFO);
    }
    
    /**
     * 
     * Opens the user access records page instatiating its controller.
     */
    public void openRecordAccessPage()
    {
        SingletonControllerFactory.getInstance().createController(ControllerType.USER_ACCESSES);
    }
    
}
