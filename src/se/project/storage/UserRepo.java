/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import se.project.storage.User.Role;

/**
 *
 * @author Utente
 */
public class UserRepo
{
    private Connection connection = null;
    
    private String URL = "jdbc:postgres://localhost/gruppo8_se";
    
    public UserRepo()
    {
        
    }
    
    public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        //Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, username, String.valueOf(password));
        return connection;
    }        
    
    public User queryCurrentUser() throws SQLException
    {
        // Return a model of the current user
        String query = "SELECT r.rolname as username, r1.rolname as userrole "
                +      "FROM pg_catalog.pg_roles r "
                +      "JOIN pg_catalog.pg_auth_members m " 
                +      "ON (m.member = r.oid) " 
                +      "JOIN pg_roles r1 ON (m.roleid = r1.oid) "
                +      "WHERE r.rolcanlogin and r.rolname = current_user";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        Role role = null;
        String username = resultSet.getString("username");
        if(resultSet.getString("userrole").equals("SystemAdministrator"))
            role = User.Role.SYSTEM_ADMINISTRATOR;
        else if(resultSet.getString("userrole").equals("Planner")) 
            role = User.Role.PLANNER;
        User user = new User(role, username, null);
        return user;
    }
    
    public void closeConnection() throws SQLException
    {
        //Close the connection to the database
        this.connection.close();
    }        
    
}
