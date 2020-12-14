package se.project.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import se.project.storage.models.SystemUser;


public class DatabaseConnection
{
    static Connection connection;
    static private final String DATABASE_URL = "jdbc:postgresql://localhost/gruppo8_se"; 
    static private String ALREADY_CONNECTED_MESSAGE = "Connection already established. Close connection before establishing another one.";
    
    /**
     * 
     * @return the singleton instance of connection established at the start of the session
     */
    public synchronized static Connection getConnection()
    { 
        return connection;
    }
    
    /**
     * 
     * @param username is the username of the System User trying to log in
     * @param password is the password of the System User trying to log in
     * @return the singleton instance of connection with database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    static synchronized public Connection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    { 
        if(connection != null)
        {
            throw new SQLException(ALREADY_CONNECTED_MESSAGE);
        }
        // Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, username, String.valueOf(password));
        connection.setAutoCommit(false);
        return connection;
    }
    
    /**
     * 
     * @param user is the SystemUser trying to connect with the database
     * @return the singleton instance of connection with database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    static synchronized public Connection connect(SystemUser user) throws ClassNotFoundException, SQLException
    {
        return connect(user.getUsername(), user.getPassword());
    }
    
    /**
     * 
     * closes the singleton connection to the database
     * @throws SQLException 
     */
    static synchronized public void closeConnection() throws SQLException
    {
        if(connection != null)
        {
            connection.close();
            connection = null;
        }
    }
    
}
