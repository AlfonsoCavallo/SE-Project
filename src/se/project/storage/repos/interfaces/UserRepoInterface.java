/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.User;

/**
 *
 * @author Utente
 */
public interface UserRepoInterface
{
    public User queryCurrentUser() throws SQLException, IOException;
    // Return a model of the current user
    
    public LinkedList<User> queryAllUsers() throws IOException;
    // Return all the users to the system
}
