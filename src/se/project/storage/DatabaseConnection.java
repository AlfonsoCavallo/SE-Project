/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Utente
 */
public class DatabaseConnection
{
    static Connection connection;
    static private final String DATABASE_URL = "jdbc:postgresql://localhost/gruppo8_se"; 
    static private String ALREADY_CONNECTED_MESSAGE = "Connection already established. Close connection before establishing another one.";
    
    public static Connection getConnection()
    {
        // Return the singleton instance of connection established at the start of the session
        return connection;
    }
    
    static public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        // Establishes the singleton connection with database
        if(connection != null)
        {
            throw new SQLException(ALREADY_CONNECTED_MESSAGE);
        }
        //Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, username, String.valueOf(password));
        return connection;
    }
    
    static public void closeConnection() throws SQLException
    {
        //Close the singleton connection to the database
        if(connection != null)
        {
            connection.close();
            connection = null;
        }
    }
    
}
