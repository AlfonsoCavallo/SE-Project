package se.project.storage;

import java.io.IOException;
import java.sql.Connection;
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
    
    /**
     * Reset the Database
     * @return True if the reset was successful, False otherwise
     */
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
            getConnection().commit();
            
            closeConnection();
            return true;
        } 
        catch (ClassNotFoundException | SQLException | IOException ex)
        {
            return false;
        }
    }
    
    /**
     * Getter of the test user
     * @return The user to test the system
     */
    public static SystemUser getTestUser()
    {
        return new SystemUser(null, ADMIN_USERNAME, ADMIN_PASSWORD.toCharArray());
    }
    
}
