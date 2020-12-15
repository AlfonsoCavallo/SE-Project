/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.project.business_logic.controllers.MainController;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.repos.SystemUserRepo;
import se.project.storage.repos.interfaces.SystemUserRepoInterface;

/**
 *
 * @author Utente
 */
public class SEProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        
        
        SystemUserRepoInterface userRepo = new SystemUserRepo(getConnection());
        try
        {
            Class.forName("org.postgresql.Driver");
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/gruppo8_se", "finneas", "finneas");
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
