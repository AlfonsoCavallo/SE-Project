package se.project.storage.repo_proxy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.SystemUser;
import se.project.storage.repos.SystemUserRepo;
import se.project.storage.repos.interfaces.SystemUserRepoInterface;


/***
 * A proxy for SystemUserActivityRepoInterface that instatiate it only when necessary 
 */
public class SystemUserProxyRepo implements SystemUserRepoInterface
{
    private SystemUserRepoInterface repo;
    private final Connection connection;

    public SystemUserProxyRepo(Connection connection)
    {
        this.connection = connection;
    }
    
    /***
     * Instatiates the repo only when a service is called
     */
    private void instantiateRepo()
    {
        if(this.repo == null)
        {
            repo = new SystemUserRepo(connection);
        }
    }
    
    @Override
    public SystemUser queryCurrentUser() throws SQLException, IOException
    {
        instantiateRepo();
        return repo.queryCurrentUser();
    }

    @Override
    public LinkedList<SystemUser> queryAllUsers() throws IOException
    {
        instantiateRepo();
        return repo.queryAllUsers();
    }
    
}
