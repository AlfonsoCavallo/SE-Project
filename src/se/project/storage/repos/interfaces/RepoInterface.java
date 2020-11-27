/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Utente
 */
public interface RepoInterface
{
    public ResultSet queryDatabase(String query) throws SQLException;
    // Returns the result of a query on the database
    
    public boolean executeStatement(String statement) throws SQLException;
    // Executes a statement on the database
}
