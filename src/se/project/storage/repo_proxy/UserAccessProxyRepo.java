package se.project.storage.repo_proxy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.UserAccess;
import se.project.storage.repos.UserAccessRepo;
import se.project.storage.repos.interfaces.UserAccessRepoInterface;


/***
 * A proxy for UserAccessRepoInterface that instatiate it only when necessary.
 */
public class UserAccessProxyRepo implements UserAccessRepoInterface
{
    private UserAccessRepoInterface repo;
    private final Connection connection;

    
    /**
    * Instantiates the proxy.
    * @param connection is the connection established with the database.
    */
    public UserAccessProxyRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    /***
     * Instatiates the repo only when a service is called.
     */
    private void instantiateRepo()
    {
        if(this.repo == null)
        {
            repo = new UserAccessRepo(connection);
        }
    }

    @Override
    public LinkedList<UserAccess> queryAllUserAccesses() throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryAllUserAccesses();
    }

    @Override
    public LinkedList<UserAccess> queryUserAccesses(String username) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryUserAccesses(username);
    }

    @Override
    public void storeUserAccess(UserAccess userAccess) throws IOException, SQLException
    {
        instantiateRepo();
        repo.storeUserAccess(userAccess);
    }

    @Override
    public void storeCurrentUserAccess(String username) throws IOException, SQLException
    {
        instantiateRepo();
        repo.storeCurrentUserAccess(username);
    }
    
    
}
