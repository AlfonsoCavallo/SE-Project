package se.project.storage.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import se.project.storage.repos.interfaces.RepoInterface;

/**
* Provedes methods to execute statements on database and query it.
* 
*/
public abstract class AbstractRepo implements RepoInterface
{   
    private final Connection connection;
    
    /**
     * 
     * @param connection is the current connection.
     */
    public AbstractRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    /**
     * 
     * @param query is the query to execute.
     * @return a ResultSet with the result of the query on the database.
     * @throws SQLException
     */
    @Override
    public ResultSet queryDatabase(String query) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet;        
           
        try
        {           
            resultSet = preparedStatement.executeQuery();
            connection.commit();
        }
        catch(SQLException ex)
        {
            preparedStatement.cancel();
            connection.rollback();
            throw ex;
        }
        
        return resultSet;
    }
    
    /**
     * 
     * @param statement is the statement that has to be execute.
     * @return true if the statement is execute successfully, false otherwise.
     * @throws SQLException 
     */
    @Override
    public boolean executeStatement(String statement) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        
        try
        {           
            preparedStatement.execute();
            connection.commit();
        }
        catch(SQLException ex)
        {
            preparedStatement.cancel();
            connection.rollback();
            throw ex;
        }        
        return true;
    }
    
    /**
     * 
     * @param query is the query that has to be execute during the transaction.
     * @return a String containing the instructions for the transaction.
     */
    private String getTransaction(String query)
    {
        String output = "begin;\n" +
                query + "\n" +
                "commit;";
        return output;
    }
}
