package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.User;


public interface UserRepoInterface
{
    public LinkedList<User> queryAllUsers() throws IOException, SQLException;
    // Querys all users in the database
    
    public LinkedList<User> queryViewOneUser(String username) throws IOException, SQLException;
    // Querys a specific user in the database
    
    public void queryDeleteUser(String username) throws IOException, SQLException;
    // Deletes a user in the database
    
    public void queryAddUser(User user) throws IOException, SQLException;
    // Adds a user in the database
    
    public void queryUpdateUser(User user, String userToUpdate) throws IOException, SQLException;
    // Update a user in database
}
