/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import se.project.storage.models.UserAccess;

/**
 *
 * @author Utente
 */
public class UserAccessRepo extends AbstractRepo
{
    private final String QUERY_ALL_USER_ACCESSES_PATH = "/se/project/assets/query/QueryAllUserAccesses.sql";
    
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException
    {
        // Return all the user accesses to the system
        String query = getStringFromFile(QUERY_ALL_USER_ACCESSES_PATH);
        ResultSet resultSet = super.queryDatabase(query);

        // Models construction
        LinkedList<UserAccess> output = new LinkedList<>();
        
        while(resultSet.next())
        {
            int ID = resultSet.getInt("id_access");
            String username = resultSet.getString("username_access_ref");
            LocalDateTime accessTime = resultSet.getTimestamp("access_time").toLocalDateTime();
            
            output.add(new UserAccess(ID, username, accessTime));
        }
        
        return output;
    }
    
    public List queryUserAccesses(String username)
    {
        // Return all the access of a determined user
        return null;
    }
    
    public void storeUserAccess(UserAccess userAccess)
    {
        // Stores a user access
    }
    
    public void storeCurrentUserAccess(String username)
    {
        // Stores a user access at current LocalTime
    }
}
