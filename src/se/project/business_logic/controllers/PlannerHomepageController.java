/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.business_logic.controllers;

import java.sql.SQLException;
import javax.swing.JFrame;
import se.project.presentation.views.MaintenanceActivityView;
import se.project.presentation.views.PlannerHomepageView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.business_logic.controllers.MainController.openLoginPage;

/**
 *
 * @author Giacomo
 */
public class PlannerHomepageController
{
    private final PlannerHomepageView plannerHomepageView;

    public PlannerHomepageController(PlannerHomepageView plannerHomepageView)
    {
        this.plannerHomepageView = plannerHomepageView;
        initListeners();
    }
    
    private void initListeners()
    {
        plannerHomepageView.getjMaintenanceActivityPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                openMaintenanceActivityPage();
                plannerHomepageView.dispose();
            }
        });
        
        plannerHomepageView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                plannerHomepageView.dispose();
                openLoginPage();
            }
        });
        
        plannerHomepageView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    public static JFrame openMaintenanceActivityPage()
    {
        MaintenanceActivityView maintenanceActivityView = new MaintenanceActivityView();
        MaintenanceActivityController maintenanceActivityController = new MaintenanceActivityController(maintenanceActivityView);
        return maintenanceActivityView;
    }

}
