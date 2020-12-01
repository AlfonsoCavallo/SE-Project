package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.UserAccess;


public interface UserAccessRepoInterface
{

    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException;
    // Return all the user accesses to the system

    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException;
    // Return all the access of a determined user
    
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException;
    // Stores a user access

    public void storeCurrentUserAccess(String username) throws IOException, SQLException;
    // Stores a user access at current LocalDateTime

}
