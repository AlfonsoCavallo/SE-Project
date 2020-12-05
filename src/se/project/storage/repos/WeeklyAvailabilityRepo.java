/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import se.project.storage.models.Maintainer;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.repos.interfaces.WeeklyAvailabilityRepoInterface;

/**
 *
 * @author Utente
 */
public class WeeklyAvailabilityRepo extends AbstractRepo implements WeeklyAvailabilityRepoInterface
{

    /**
     * 
     * Creates a new WeeklyAvailabilityRepo
     * @param connection is the current connection
     */
    public WeeklyAvailabilityRepo(Connection connection)
    {
        super(connection);
    }

    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param username is the username of the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param maintainer is the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work
     * @throws IOException
     * @throws SQLException 
     */
    @Override
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
