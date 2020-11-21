/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

/**
 *
 * @author Utente
 */
public class User 
{
    public enum Role
    {
        SYSTEM_ADMINISTRATOR,
        PLANNER
    }
    
    public User(Role role, String username, char[] password)
    {
    }
    
    public Role getRole()
    {
        // Returns the role of the User
        return null;
    }
    
    public String getUsername()
    {
        // Returns username
        return null;
    }
    
    public char[] getPassword()
    {
        // Returns password
        return null;
    }
}
