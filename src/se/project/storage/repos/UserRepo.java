/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.repos;

import se.project.storage.models.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static se.project.business_logic.utilities.FileUtilities.*;
import static se.project.storage.models.User.Role.*;
import se.project.storage.models.User.Role;

/**
 *
 * @author Utente
 */
public class UserRepo extends AbstractRepo
{    
    private final String QUERY_CURRENT_USER_PATH = "/se/project/assets/query/QueryCurrentUser.sql";

    public UserRepo()
    {
    }

    public User queryCurrentUser() throws SQLException, IOException
    {
        // Return a model of the current user
        String query = getStringFromFile(QUERY_CURRENT_USER_PATH);
        ResultSet resultSet = super.queryDatabase(query);
        resultSet.next();

        Role role = null;
        String username = resultSet.getString("username");
        if (resultSet.getString("userrole").equals(SYSTEM_ADMINISTRATOR.getValue()))
        {
            role = SYSTEM_ADMINISTRATOR;
        } else if (resultSet.getString("userrole").equals(PLANNER.getValue()))
        {
            role = PLANNER;
        }
        User user = new User(role, username, null);
        return user;
    }
}
