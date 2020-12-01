package se.project.storage.repos;

import se.project.storage.repos.interfaces.UserAccessRepoInterface;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import se.project.storage.models.UserAccess;


public class UserAccessRepo extends AbstractRepo implements UserAccessRepoInterface
{
    private final String QUERY_ALL_USER_ACCESSES_PATH = "/se/project/assets/query/QueryAllUserAccesses.sql";
    private final String QUERY_USER_ACCESSES_PATH = "/se/project/assets/query/QueryUserAccesses.sql";
    private final String STORE_USER_ACCESS_PATH = "/se/project/assets/query/StoreUserAccess.sql";

    public UserAccessRepo(Connection connection)
    {
        super(connection);
    }
    
    @Override
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException
    {
        // Return all the user accesses to the system
        String query = getStringFromFile(QUERY_ALL_USER_ACCESSES_PATH);
        return queryUserList(query);
    }
    
    @Override
    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException
    {
        // Return all the access of a determined user
        String query = getStringFromFile(QUERY_USER_ACCESSES_PATH);
        query = query.replaceAll("username_param", username);
        return queryUserList(query);
    }
    
    @Override
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException
    {
        // Stores a user access
        String statement = getStringFromFile(STORE_USER_ACCESS_PATH);
        statement = statement.replaceAll("username_param", userAccess.getUsername());
        statement = statement.replaceAll("accessTime_param", "'" + java.sql.Timestamp.valueOf(userAccess.getAccessTime()).toString() + "'");
        super.executeStatement(statement);  
    }
    
    @Override
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
