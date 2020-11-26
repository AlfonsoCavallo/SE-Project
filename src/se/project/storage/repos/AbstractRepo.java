/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static se.project.storage.DatabaseConnection.*;

/**
 *
 * @author Utente
 */
public abstract class AbstractRepo
{    
    public ResultSet queryDatabase(String query) throws SQLException
    {
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    
    public boolean executeStatement(String statement) throws SQLException
    {
        PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
        return preparedStatement.execute();
    }
}
