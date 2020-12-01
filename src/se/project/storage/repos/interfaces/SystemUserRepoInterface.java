package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.SystemUser;


public interface SystemUserRepoInterface
{
    public SystemUser queryCurrentUser() throws SQLException, IOException;
    // Return a model of the current user
    
    public LinkedList<SystemUser> queryAllUsers() throws IOException;
    // Return all the users to the system
}
