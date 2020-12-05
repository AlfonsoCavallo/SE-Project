/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.repos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import se.project.storage.models.WeeklyAvailability;
import se.project.storage.models.Maintainer;

/**
 *
 * @author Utente
 */
public interface WeeklyAvailabilityRepoInterface
{
    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param username is the username of the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work
     * @throws IOException
     * @throws SQLException 
     */
    public WeeklyAvailability queryMaintainerAvailability(String username, int week) throws IOException, SQLException;
    
    /***
     * Gets an instance with infos about the availability of a certain Maintainer
     * @param maintainer is the Maintainer you want to search
     * @param week is the week to check the availability
     * @return an Availability object with all the informations about the Maintainer work
     * @throws IOException
     * @throws SQLException 
     */
    public WeeklyAvailability queryMaintainerAvailability(Maintainer maintainer, int week) throws IOException, SQLException;
}
