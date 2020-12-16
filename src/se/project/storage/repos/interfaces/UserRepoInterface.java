package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.User;

/**
* Is a DAO interface that provides method to manipulate User models.
* 
*/
public interface UserRepoInterface
{
    /**
     * Queries the database for all the users.
     * @return a LinkedList of the User in the system.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<User> queryAllUsers() throws IOException, SQLException;
    
    /**
     * Queries the database for a specific user.
     * @param username is the username of the user that has to be shown.
     * @return a LinkedList of User in which there is a specific user.
     * @throws IOException
     * @throws SQLException 
     */
    public LinkedList<User> queryOneUser(String username) throws IOException, SQLException;
    
    /**
     * 
     * Delete a specific user from the database.
     * @param username is the username of the user that has to be deleted.
     * @throws IOException
     * @throws SQLException 
     */
    public void deleteUser(String username) throws IOException, SQLException;
    
    /**
     * 
     * Add a new user to the database.
     * @param user is the user that has to be added.
     * @throws IOException
     * @throws SQLException 
     */
    public void addUser(User user) throws IOException, SQLException;
    
    /**
     * 
     * Update a specific usar in the database.
     * @param user is the that has to be updated.
     * @param userToUpdate is the previous username of the user that has to be updated.
     * @throws IOException
     * @throws SQLException 
     */
    public void updateUser(User user, String userToUpdate) throws IOException, SQLException;
}
