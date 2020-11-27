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

/**
 *
 * @author Utente
 */
public interface SystemUserRepoInterface
{
    public SystemUser queryCurrentUser() throws SQLException, IOException;
    // Return a model of the current user
    
    public LinkedList<SystemUser> queryAllUsers() throws IOException;
    // Return all the users to the system
}
