package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.UserAccess;

/**
* Is a DAO interface that provides method to manipulate User Access models.
* 
*/
public interface UserAccessRepoInterface
{

    /**
     * Queries the database for all the accesses.
     * @return a LinkedList of the UserAccess in the system.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException;

    /**
     * Queries the database for all the accesses of a specific user.
     * @param username is the username of the user whose accesses has to be shown.
     * @return a LinkedList of UserAccess in which there are the accesses of a specific user.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException;
    
    /**
     * 
     * Add a new access from a user to the database.
     * @param userAccess is the userAccess that has to be added in the database.
     * @throws IOException
     * @throws SQLException 
     */
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException;

    /**
     * 
     * Stores a user access at current LocalDateTime.
     * @param username is the username of the user that has logged in in that moment.
     * @throws IOException
     * @throws SQLException 
     */
    public void storeCurrentUserAccess(String username) throws IOException, SQLException;

}
