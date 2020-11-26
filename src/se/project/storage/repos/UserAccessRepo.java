/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

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
    private final String QUERY_USER_ACCESSES_PATH = "/se/project/assets/query/QueryUserAccesses.sql";
    private final String STORE_USER_ACCESS_PATH = "/se/project/assets/query/StoreUserAccess.sql";
    
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException
    {
        // Return all the user accesses to the system
        String query = getStringFromFile(QUERY_ALL_USER_ACCESSES_PATH);
        return queryUserList(query);
    }
    
    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException
    {
        // Return all the access of a determined user
        String query = getStringFromFile(QUERY_USER_ACCESSES_PATH);
        query = query.replaceAll("username_param", username);
        return queryUserList(query);
    }
    
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException
    {
        // Stores a user access
        String statement = getStringFromFile(STORE_USER_ACCESS_PATH);
        statement = statement.replaceAll("username_param", userAccess.getUsername());
        statement = statement.replaceAll("accessTime_param", java.sql.Timestamp.valueOf(userAccess.getAccessTime()).toString());
        super.executeStatement(statement);  
    }
    
    public void storeCurrentUserAccess(String username) throws IOException, SQLException
    {
        // Stores a user access at current LocalDateTime
        String statement = getStringFromFile(STORE_USER_ACCESS_PATH);
        statement = statement.replaceAll("username_param", username);
        statement = statement.replaceAll("accessTime_param", "current_timestamp");
        super.executeStatement(statement);  
    }
    
    // PRIVATE USEFUL METHODS
    
    private LinkedList<UserAccess> queryUserList(String query) throws SQLException
    {
        // Query a filtered list of Users
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
}
