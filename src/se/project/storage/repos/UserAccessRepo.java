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

    /**
     * 
     * Creates a new UserAccessRepo
     * @param connection is the current connection
     */
    public UserAccessRepo(Connection connection)
    {
        super(connection);
    }
    
    /**
     * 
     * @return a LinkedList of the UserAccess in the system
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ALL_USER_ACCESSES_PATH);
        return queryUserList(query);
    }
    
    /**
     * 
     * @param username is the username of the user whose accesses has to be shown
     * @return a LinkedList of UserAccess in which there are the accesses of a specific user 
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_USER_ACCESSES_PATH);
        query = query.replaceAll("username_param", username);
        return queryUserList(query);
    }
    
    /**
     * 
     * Add a new access from a user to the database
     * @param userAccess is the userAccess that has to be added in the database
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException
    {
        // Stores a user access
        String statement = getStringFromFile(STORE_USER_ACCESS_PATH);
        statement = statement.replaceAll("username_param", userAccess.getUsername());
        statement = statement.replaceAll("accessTime_param", "'" + java.sql.Timestamp.valueOf(userAccess.getAccessTime()).toString() + "'");
        super.executeStatement(statement);  
    }
    
    /**
     * 
     * Stores a user access at current LocalDateTime
     * @param username is the username of the user that has logged in in that moment
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public void storeCurrentUserAccess(String username) throws IOException, SQLException
    {
        String statement = getStringFromFile(STORE_USER_ACCESS_PATH);
        statement = statement.replaceAll("username_param", username);
        statement = statement.replaceAll("accessTime_param", "current_timestamp");
        super.executeStatement(statement);  
    }
    
    // PRIVATE USEFUL METHODS
    
    /**
     * 
     * @param query is the query from which to extract data to build the model
     * @return a LinkedList of UserAccess that are in the database
     * @throws SQLException 
     */
    private LinkedList<UserAccess> queryUserList(String query) throws SQLException
    {
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
