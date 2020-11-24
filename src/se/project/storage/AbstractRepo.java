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

/**
 *
 * @author Utente
 */
public class AbstractRepo
{    

    private Connection connection = null;
    private final String DATABASE_URL = "jdbc:postgresql://localhost/gruppo8_se";    
    
    private String ALREADY_CONNECTED_MESSAGE = "Connection already established. Close connection before establishing another one.";
    
    public AbstractRepo()
    {
        
    }
    
    public AbstractRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        if(connection != null)
        {
            throw new SQLException(ALREADY_CONNECTED_MESSAGE);
        }
        //Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, username, String.valueOf(password));
        return connection;
    }    
    
    public void closeConnection() throws SQLException
    {
        //Close the connection to the database
        this.connection.close();
    }
    
    public ResultSet queryDatabase(String query) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet;
    }
    
    public Connection getConnection()
    {
        return this.connection;
    }
    
}
