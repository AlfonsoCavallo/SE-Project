/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.awt.List;

/**
 *
 * @author Utente
 */
public class UserAccessRepo extends AbstractRepo
{
    public List queryAllUserAccesses()
    {
        // Return all the user accesses to the system
        return null;
    }
    
    public List queryUserAccesses(String username)
    {
        // Return all the access of a determined user
        return null;
    }
    
    public void storeUserAccess(UserAccess userAccess)
    {
        // Stores a user access
    }
    
    public void storeCurrentUserAccess(String username)
    {
        // Stores a user access at current LocalTime
    }
}
