/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.getStringFromFile;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;
import se.project.storage.repos.interfaces.UserRepoInterface;

/**
 *
 * @author Giorgio
 */
public class UserRepo extends AbstractRepo implements UserRepoInterface
{
    private final String QUERY_ALL_USERS_PATH = "/se/project/assets/query/QueryAllUsers.sql";
    private final String QUERY_VIEW_ONE_USER_PATH = "/se/project/assets/query/QueryViewOneUser.sql";
    private final String QUERY_DELETE_USER_PATH = "/se/project/assets/query/QueryDeleteUser.sql";
    private final String QUERY_ADD_USER_PATH = "/se/project/assets/query/QueryAddUser.sql";
    private final String QUERY_UPDATE_USER_PATH = "/se/project/assets/query/QueryUpdateUser.sql";

    /**
     * Constructor
     * @param connection 
     */
    public UserRepo(Connection connection)
    {
        super(connection);
    }
    
    /**
     * 
     * @return a LinkedList of User containing all the users in the database
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<User> queryAllUsers() throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ALL_USERS_PATH);
        return queryUserList(query);
    }
    
    /**
     * 
     * @param username is the username of the searched user
     * @return a LinkedList of User containing the user with username equals to username
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<User> queryViewOneUser(String username) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_VIEW_ONE_USER_PATH);
        query = query.replaceAll("username_param", username);
        return queryUserList(query);
    }
    
    /**
     * Execute the query that delete user on database
     * @param username is the username of the user that has to be deleted
     * @throws IOException
     * @throws SQLException 
     */
    public void queryDeleteUser(String username) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_DELETE_USER_PATH);
        query = query.replaceAll("username_param", username);
        executeStatement(query);
    }
    
    /**
     * Execute the query that add user on database
     * @param user is the user that has to be added to the database
     * @throws IOException
     * @throws SQLException 
     */
    public void queryAddUser(User user) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_ADD_USER_PATH);
        String username = user.getUsername();
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String role = user.getRole();
        String password = user.getPassword();
        query = query.replaceAll("username_param", username);
        query = query.replaceAll("surname_param", surname);
        query = query.replaceAll("name_param", name);
        query = query.replaceAll("email_param", email);
        query = query.replaceAll("role_param", role);
        query = query.replaceAll("password_param", password);
        executeStatement(query);
    }
    
    /**
     * Execute the update query on the database
     * @param user is the user that has to be updated in the database
     * @param userToUpdate is the original username of user
     * @throws IOException
     * @throws SQLException 
     */
    public void queryUpdateUser(User user, String userToUpdate) throws IOException, SQLException
    {
        String query = getStringFromFile(QUERY_UPDATE_USER_PATH);
        String username = user.getUsername();
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String role = user.getRole();
        String password = user.getPassword();
        String oldUsername = userToUpdate;
        query = query.replaceAll("username_param", username);
        query = query.replaceAll("surname_param", surname);
        query = query.replaceAll("name_param", name);
        query = query.replaceAll("email_param", email);
        query = query.replaceAll("role_param", role);
        query = query.replaceAll("password_param", password);
        query = query.replaceAll("user_param", oldUsername);
        executeStatement(query);
    }
    
    /**
     * 
     * @param query is the query from which to extract data to build the model
     * @return a LinkedList of User that are in the database
     * @throws SQLException 
     */
    private LinkedList<User> queryUserList(String query) throws SQLException
    {
        // Query a filtered list of Users
        ResultSet resultSet = super.queryDatabase(query);

        // Model's construction
        LinkedList<User> output = new LinkedList<>();
        
        while(resultSet.next())
        {
            String username = resultSet.getString("username");
            String name = resultSet.getString("name_user");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String password = resultSet.getString("pass");
            String role = resultSet.getString("user_role");
            if(role.equals("system_administrator"))
                output.add(new SystemAdministrator(username, email, name, surname, password, role));
            else if(role.equals("planner"))
                output.add(new Planner(username, email, name, surname, password, role));
        }
        
        return output;        
    }
}