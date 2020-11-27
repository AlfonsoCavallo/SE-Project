/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static se.project.business_logic.utilities.FileUtilities.getStringFromFile;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.models.SystemUser;



public class DatabaseTesting
{
    private static String reset = null;    
    private static final String ADMIN_USERNAME = "test_admin";
    private static final String ADMIN_PASSWORD = "test_admin";
    
    public static boolean resetDatabase()
    {
        
        try
        {
            Connection connection = connect(getTestUser());
            
            if(reset == null)
            {
                reset = getStringFromFile("/se/project/storage/test_files/codiceDB.sql");
            }
            
            PreparedStatement preparedStatement = getConnection().prepareStatement(reset);
            preparedStatement.execute();
            
            closeConnection();
            return true;
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            return false;
        }
    }
    
    public static SystemUser getTestUser()
    {
        return new SystemUser(null, ADMIN_USERNAME, ADMIN_PASSWORD.toCharArray());
    }
}
