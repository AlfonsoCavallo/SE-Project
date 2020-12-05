/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import se.project.storage.models.Maintainer;

public interface MaintainerRepoInterface
{
    /***
     * Gets all the maintainers in the database.
     * @return a list of Maintainers
     * @throws IOException
     * @throws SQLException 
     */
    public List<Maintainer> queryAllMaintainers() throws IOException, SQLException;
    
    /***
     * Gets a single maintainer in the database
     * @param username is the username of the maintainers to search for.
     * @return
     * @throws IOException
     * @throws SQLException 
     */
    public Maintainer queryOneMaintainer(String username) throws IOException, SQLException;
}
