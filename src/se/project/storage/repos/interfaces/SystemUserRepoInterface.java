package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.SystemUser;


public interface SystemUserRepoInterface
{
    /**
     * 
     * @return a SystemUser (that's the model of the current user)
     * @throws SQLException
     * @throws IOException 
     */
    public SystemUser queryCurrentUser() throws SQLException, IOException;
    
    /**
     * 
     * @return a LinkedList of SystemUser that are in the system
     * @throws IOException 
     */
    public LinkedList<SystemUser> queryAllUsers() throws IOException;
}
