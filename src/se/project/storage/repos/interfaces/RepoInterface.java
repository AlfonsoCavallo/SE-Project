package se.project.storage.repos.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
* Is a Repo interface that provides method to interact with database.
* 
*/
public interface RepoInterface
{
    /**
     * Queries the database.
     * @param query is the query for the database.
     * @return a ResultSet that contains the result of a query on the database.
     * @throws SQLException 
     */
    public ResultSet queryDatabase(String query) throws SQLException;
    
    /**
     * Executes a statement on the database.
     * @param statement is the statement that has to be executed.
     * @return true if the statement is executed succesfully, false otherwise.
     * @throws SQLException 
     */
    public boolean executeStatement(String statement) throws SQLException;
}
