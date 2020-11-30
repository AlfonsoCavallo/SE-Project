/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static se.project.storage.DatabaseConnection.*;
import se.project.storage.repos.interfaces.RepoInterface;

/**
 *
 * @author Utente
 */
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
        PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
        return preparedStatement.execute();
    }
}
