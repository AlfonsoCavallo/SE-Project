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



public class DatabaseTesting
{
    public static boolean resetDatabase()
    {
        String ADMIN_USERNAME = "test_admin";
        String ADMIN_PASSWORD = "test_admin";
        
        try
        {
            Connection connection = connect(ADMIN_USERNAME, ADMIN_PASSWORD.toCharArray());
            String reset = getStringFromFile("/se/project/storage/test_files/codiceDB.sql");
            
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
}
