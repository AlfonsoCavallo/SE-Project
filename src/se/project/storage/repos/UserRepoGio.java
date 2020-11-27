/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.repos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.getStringFromFile;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.UserGio;

/**
 *
 * @author Giorgio
 */
public class UserRepoGio extends AbstractRepo
{
    private final String QUERY_ALL_USERS_PATH = "/se/project/assets/query/QueryAllUsers.sql";
    private final String QUERY_VIEW_ONE_USER_PATH = "/se/project/assets/query/QueryViewOneUser.sql";
    
    public LinkedList<UserGio> queryAllUsers() throws IOException, SQLException
    {
        // Return all the users to the system
        String query = getStringFromFile(QUERY_ALL_USERS_PATH);
        return queryUserList(query);
    }
    
    public LinkedList<UserGio> queryViewOneUser(String username) throws IOException, SQLException
    {
        // Return the user with username equals to username
        String query = getStringFromFile(QUERY_VIEW_ONE_USER_PATH);
        return queryUserList(query);
    }
    
    private LinkedList<UserGio> queryUserList(String query) throws SQLException
    {
        // Query a filtered list of Users
        ResultSet resultSet = super.queryDatabase(query);

        // Models construction
        LinkedList<UserGio> output = new LinkedList<>();
        
        while(resultSet.next())
        {
            String username = resultSet.getString("username");
            String name = resultSet.getString("name_user");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String password = resultSet.getString("pass");
            String role = resultSet.getString("user_role");
            if(role.equals("system_administrator"))
                output.add(new SystemAdministrator(username, email, name, surname, password));
            else if(role.equals("planner"))
                output.add(new Planner(username, email, name, surname, password));
        }
        
        return output;        
    }
}