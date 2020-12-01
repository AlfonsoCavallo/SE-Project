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
    
    public AbstractRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    @Override
    public ResultSet queryDatabase(String query) throws SQLException
    {
        // Returns the result of a query on the database
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    
    @Override
    public boolean executeStatement(String statement) throws SQLException
    {
        // Executes a statement on the database
        PreparedStatement preparedStatement = getConnection().prepareStatement(getTransaction(statement));
        return preparedStatement.execute();
    }
    
    private String getTransaction(String query)
    {
        String output = "begin;\n" +
                query + "\n" +
                "commit;";
        return output;
    }
}
