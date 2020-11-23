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
import java.sql.ResultSet;
import java.sql.SQLException;
import static se.project.business_logic.utilities.FileUtilities.*;
import static se.project.storage.User.Role.*;
import se.project.storage.User.Role;

/**
 *
 * @author Utente
 */
public class UserRepo
{

    private Connection connection = null;

    private final String DATABASE_URL = "jdbc:postgresql://localhost/gruppo8_se";
    private final String QUERY_CURRENT_USER_PATH = "/se/project/assets/query/QueryCurrentUser.sql";

    public UserRepo()
    {

    }

    public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        //Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, username, String.valueOf(password));
        return connection;
    }

    public User queryCurrentUser() throws SQLException, IOException
    {
        // Return a model of the current user
        String query = getStringFromFile(QUERY_CURRENT_USER_PATH);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
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

    public void closeConnection() throws SQLException
    {
        //Close the connection to the database
        this.connection.close();
    }

}
