package se.project.storage.repos;

import se.project.storage.models.SystemUser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import static se.project.business_logic.utilities.FileUtilities.*;
import static se.project.storage.models.SystemUser.Role.*;
import se.project.storage.models.SystemUser.Role;
import se.project.storage.repos.interfaces.SystemUserRepoInterface;


public class SystemUserRepo extends AbstractRepo implements SystemUserRepoInterface
{    
    private final String QUERY_CURRENT_USER_PATH = "/se/project/assets/query/QueryCurrentUser.sql";

    /**
     * Creates a new SystemUserRepo
     * @param connection is the current connection
     */
    public SystemUserRepo(Connection connection)
    {
        super(connection);
    }

    /**
     * 
     * @return a SystemUser (that's the model of the current user)
     * @throws SQLException
     * @throws IOException 
     */
    public SystemUser queryCurrentUser() throws SQLException, IOException
    {
        String query = getStringFromFile(QUERY_CURRENT_USER_PATH);
        ResultSet resultSet = super.queryDatabase(query);
        resultSet.next();

        Role role = null;
        String username = resultSet.getString("username");
        if (resultSet.getString("userrole").equals(SYSTEM_ADMINISTRATOR.getValue()))
        {
            role = SYSTEM_ADMINISTRATOR;
        } else if (resultSet.getString("userrole").equals(PLANNER.getValue()))
        {
            role = PLANNER;
        }
        SystemUser user = new SystemUser(role, username, null);
        return user;
    }

    /**
     * 
     * @return a LinkedList of SystemUser that are in the system
     * @throws IOException 
     */
    @Override
    public LinkedList<SystemUser> queryAllUsers() throws IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
