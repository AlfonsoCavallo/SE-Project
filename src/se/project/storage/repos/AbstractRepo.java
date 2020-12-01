package se.project.storage.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.repos.interfaces.RepoInterface;


public abstract class AbstractRepo implements RepoInterface
{   
    private final Connection connection;
    
    /**
     * 
     * @param connection is the current connection
     */
    public AbstractRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    /**
     * 
     * @param query is the query to execute
     * @return a ResultSet with the result of the query on the database
     * @throws SQLException 
     */
    @Override
    public ResultSet queryDatabase(String query) throws SQLException
    {
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    
    /**
     * 
     * @param statement is the statement that has to be execute
     * @return true if the statement is execute successfully, false otherwise
     * @throws SQLException 
     */
    @Override
    public boolean executeStatement(String statement) throws SQLException
    {
        PreparedStatement preparedStatement = getConnection().prepareStatement(getTransaction(statement));
        return preparedStatement.execute();
    }
    
    /**
     * 
     * @param query is the query that has to be execute during the transaction
     * @return a String containing the instructions for the transaction
     */
    private String getTransaction(String query)
    {
        String output = "begin;\n" +
                query + "\n" +
                "commit;";
        return output;
    }
}
