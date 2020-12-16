package se.project.storage.repo_proxy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;
import se.project.storage.repos.interfaces.UserRepoInterface;


/***
 * A proxy for UserRepoInterface that instatiate it only when necessary 
 */
public class UserProxyRepo implements UserRepoInterface
{
    private UserRepoInterface repo;
    private final Connection connection;

    public UserProxyRepo(Connection connection)
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
            repo = new UserRepo(connection);
        }
    }

    @Override
    public LinkedList<User> queryAllUsers() throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryAllUsers();
    }

    @Override
    public LinkedList<User> queryOneUser(String username) throws IOException, SQLException
    {
        instantiateRepo();
        return repo.queryOneUser(username);
    }

    @Override
    public void deleteUser(String username) throws IOException, SQLException
    {
        instantiateRepo();
        repo.deleteUser(username);
    }

    @Override
    public void addUser(User user) throws IOException, SQLException
    {
        instantiateRepo();
        repo.addUser(user);
    }

    @Override
    public void updateUser(User user, String userToUpdate) throws IOException, SQLException
    {
        instantiateRepo();
        repo.updateUser(user, userToUpdate);
    }
}
