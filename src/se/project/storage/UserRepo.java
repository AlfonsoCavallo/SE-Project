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
    
    private String url;
    private String username;
    private char[] password;
    
    public UserRepo(String username, char[] password)
    {
        this.url = "jdbc:postgres://localhost/gruppo8_se";
        this.username = username;
        this.password = password;
    }
    
    public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        //Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, username, String.valueOf(password));
        JOptionPane.showMessageDialog(null,"Connection Established!");
        return connection;
    }        
    
    public User queryCurrentUser() throws SQLException
    {
        // Return a model of the current user
        String query = "SELECT r1.rolname as userrole "
                +       "FROM pg_catalog.pg_roles r "
                +       "JOIN pg_catalog.pg_auth_members m " 
                +       "ON (m.member = r.oid) " 
                +       "JOIN pg_roles r1 ON (m.roleid = r1.oid) "
                +       "WHERE r.rolcanlogin and current_user = '" + this.username + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Role role = null;
        if (resultSet.getString("userrole").equals("SystemAdministrator"))
            role = User.Role.SYSTEM_ADMINISTRATOR;
        else if (resultSet.getString("userrole").equals("Planner")) 
            role = User.Role.PLANNER;
        User user = new User(role, this.username, this.password);
        return user;
    }
    
    public void closeConnection() throws SQLException
    {
        //Close the connection to the database
        this.connection.close();
        JOptionPane.showMessageDialog(null,"Connection Closed!");
    }        
    
}
