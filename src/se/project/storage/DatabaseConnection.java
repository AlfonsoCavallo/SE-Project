package se.project.storage;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import se.project.storage.models.SystemUser;

/**
 * A Singleton that provides a common instance of connection to the Database.
 * 
 */
public class DatabaseConnection implements Connection
{
    // Singleton
    static private DatabaseConnection dbConnection;
    
    // Class attributes
    Connection connection;
    
    static private final String DATABASE_URL = "jdbc:postgresql://localhost/gruppo8_se"; 
    private static final String ALREADY_CONNECTED_MESSAGE = "Connection already established. Close connection before establishing another one.";
    
    /**
     * 
     * @return the singleton instance of connection established at the start of the session.
     */
    public synchronized static DatabaseConnection getConnection()
    {
        if(dbConnection == null)
        {
            dbConnection = new DatabaseConnection();
        }
        return dbConnection;
    }
    
    /**
     * Instantiate a Database Connection object.
     */
    private DatabaseConnection()
    {
    }
    
    /**
     * Establishes a connection with the Database for a specified user.
     * @param username is the username of the System User trying to log in.
     * @param password is the password of the System User trying to log in.
     * @return the singleton instance of connection with database.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    static synchronized public DatabaseConnection connect(String username, char[] password) throws ClassNotFoundException, SQLException
    {
        getConnection();
        
        // Open the connection to PostreSQL Database
        Class.forName("org.postgresql.Driver");
        if(dbConnection.connection == null)
        {
            dbConnection.connection = DriverManager.getConnection(DATABASE_URL, username, String.valueOf(password));
            dbConnection.setAutoCommit(false);
        }
        else
        {
            throw new SQLException("Already connected");
        }
        
        return dbConnection;
    }
    
    /**
     * Establishes a connection with the Database for a specified user.
     * @param user is the SystemUser trying to connect with the database.
     * @return the singleton instance of connection with database.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    static synchronized public Connection connect(SystemUser user) throws ClassNotFoundException, SQLException
    {
        return connect(user.getUsername(), user.getPassword());
    }
    
    /**
     * 
     * closes the singleton connection to the database.
     * @throws SQLException 
     */
    static synchronized public void closeConnection() throws SQLException
    {
        if(dbConnection != null && dbConnection != null)
        {
            dbConnection.close();
            dbConnection = null;
        }
    }

    @Override
    public Statement createStatement() throws SQLException
    {
        return connection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String string) throws SQLException
    {
        return connection.prepareStatement(string);
    }

    @Override
    public CallableStatement prepareCall(String string) throws SQLException
    {
        return connection.prepareCall(string);
    }

    @Override
    public String nativeSQL(String string) throws SQLException
    {
        return connection.nativeSQL(string);
    }

    @Override
    public void setAutoCommit(boolean bln) throws SQLException
    {
        connection.setAutoCommit(bln);
    }

    @Override
    public boolean getAutoCommit() throws SQLException
    {
        return connection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException
    {
        connection.commit();
    }

    @Override
    public void rollback() throws SQLException
    {
        connection.rollback();
    }

    @Override
    public void close() throws SQLException
    {
        if(connection != null)
        {
            connection.close();
        }
    }

    @Override
    public boolean isClosed() throws SQLException
    {
        return connection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException
    {
        return connection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean bln) throws SQLException
    {
        connection.setReadOnly(bln);
    }

    @Override
    public boolean isReadOnly() throws SQLException
    {
        return connection.isReadOnly();
    }

    @Override
    public void setCatalog(String string) throws SQLException
    {
        connection.setCatalog(string);
    }

    @Override
    public String getCatalog() throws SQLException
    {
        return connection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int i) throws SQLException
    {
        connection.setTransactionIsolation(i);
    }

    @Override
    public int getTransactionIsolation() throws SQLException
    {
        return connection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException
    {
        return connection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException
    {
        connection.clearWarnings();
    }

    @Override
    public Statement createStatement(int i, int i1) throws SQLException
    {
        return connection.createStatement(i, i1);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int i, int i1) throws SQLException
    {
        return connection.prepareStatement(string, i, i1);
    }

    @Override
    public CallableStatement prepareCall(String string, int i, int i1) throws SQLException
    {
        return connection.prepareCall(string, i, i1);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException
    {
        return connection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException
    {
        connection.setTypeMap(map);
    }

    @Override
    public void setHoldability(int i) throws SQLException
    {
        connection.setHoldability(i);
    }

    @Override
    public int getHoldability() throws SQLException
    {
        return connection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException
    {
        return connection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String string) throws SQLException
    {
        return connection.setSavepoint(string);
    }

    @Override
    public void rollback(Savepoint svpnt) throws SQLException
    {
        connection.rollback();
    }

    @Override
    public void releaseSavepoint(Savepoint svpnt) throws SQLException
    {
        connection.releaseSavepoint(svpnt);
    }

    @Override
    public Statement createStatement(int i, int i1, int i2) throws SQLException
    {
        return connection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String string, int i, int i1, int i2) throws SQLException
    {
        return connection.prepareCall(string, i, i1, i2);
    }

    @Override
    public CallableStatement prepareCall(String string, int i, int i1, int i2) throws SQLException
    {
        return connection.prepareCall(string, i, i1, i2);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int i) throws SQLException
    {
        return connection.prepareStatement(string, i);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int[] ints) throws SQLException
    {
        return connection.prepareStatement(string, ints);
    }

    @Override
    public PreparedStatement prepareStatement(String string, String[] strings) throws SQLException
    {
        return connection.prepareStatement(string, strings);
    }

    @Override
    public Clob createClob() throws SQLException
    {
        return connection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException
    {
        return connection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException
    {
        return connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException
    {
        return connection.createSQLXML();
    }

    @Override
    public boolean isValid(int i) throws SQLException
    {
        return connection.isValid(i);
    }

    @Override
    public void setClientInfo(String string, String string1) throws SQLClientInfoException
    {
        connection.setClientInfo(string, string1);
    }

    @Override
    public void setClientInfo(Properties prprts) throws SQLClientInfoException
    {
        connection.setClientInfo(prprts);
    }

    @Override
    public String getClientInfo(String string) throws SQLException
    {
        return connection.getClientInfo(string);
    }

    @Override
    public Properties getClientInfo() throws SQLException
    {
        return connection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String string, Object[] os) throws SQLException
    {
        return connection.createArrayOf(string, os);
    }

    @Override
    public Struct createStruct(String string, Object[] os) throws SQLException
    {
        return connection.createStruct(string, os);
    }

    @Override
    public void setSchema(String string) throws SQLException
    {
        connection.setSchema(string);
    }

    @Override
    public String getSchema() throws SQLException
    {
        return connection.getSchema();
    }

    @Override
    public void abort(Executor exctr) throws SQLException
    {
        connection.abort(exctr);
    }

    @Override
    public void setNetworkTimeout(Executor exctr, int i) throws SQLException
    {
        connection.setNetworkTimeout(exctr, i);
    }

    @Override
    public int getNetworkTimeout() throws SQLException
    {
        return connection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> type) throws SQLException
    {
        return connection.unwrap(type);
    }

    @Override
    public boolean isWrapperFor(Class<?> type) throws SQLException
    {
        return connection.isWrapperFor(type);
    }
    
}
