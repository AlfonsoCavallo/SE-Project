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
    private Role role;
    private String username;
    private char[] password; 
    
    public enum Role
    {
        SYSTEM_ADMINISTRATOR,
        PLANNER
    }
    
    public User(Role role, String username, char[] password)
    {
        this.role = role;
        this.username = username;
        this.password = password;
    }
    
    public Role getRole()
    {
        // Returns the role of the User
        return role;
    }
    
    public String getUsername()
    {
        // Returns username
        return username;
    }
    
    public char[] getPassword()
    {
        // Returns password
        return password;
    }
}
