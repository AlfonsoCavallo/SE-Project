/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class SystemUser 
{
    private Role role;
    private String username;
    private char[] password; 
    
    public enum Role
    {
        SYSTEM_ADMINISTRATOR ("system_administrator"),
        PLANNER ("planner");
        
        private String role;
        
        Role(String role)
        {
            this.role = role;
        }
        
        public String getValue()
        {
            return role;
        }
    }
    
    public SystemUser(Role role, String username, char[] password)
    {
        this.role = role;
        this.username = username;
        this.password = password;
    }
    
    public Role getRole()
    {
        // Returns the role of the SystemUser
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
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        
        final SystemUser other = (SystemUser) obj;
        if(this.role != other.role)
        {
            return false;
        }
        if(!Objects.equals(this.username, other.username))
        {
            return false;
        }
        if(!Arrays.equals(this.password, other.password))
        {
            return false;
        }
        return true;
    }

    
    
    
}
