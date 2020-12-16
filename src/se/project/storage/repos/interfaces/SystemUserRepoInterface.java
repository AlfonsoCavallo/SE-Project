package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.SystemUser;

/**
* Is a DAO interface that provides method to manipulate System USer models.
* 
*/
public interface SystemUserRepoInterface
{
    /**
     * Queries the database for the current user.
     * @return a SystemUser (that's the model of the current user).
     * @throws SQLException
     * @throws IOException 
     */
    public SystemUser queryCurrentUser() throws SQLException, IOException;
    
    /**
     * Queries the database for all the users.
     * @return a LinkedList of SystemUser that are in the system.
     * @throws IOException 
     */
    public LinkedList<SystemUser> queryAllUsers() throws IOException;
}
