/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.SystemUser;
import se.project.storage.models.UserGio;

/**
 *
 * @author Utente
 */
public interface UserRepoInterface
{
    public SystemUser queryCurrentUser() throws SQLException, IOException;
    // Return a model of the current user
    
    public LinkedList<UserGio> queryAllUsers() throws IOException;
    // Return all the users to the system
}
