package se.project.storage.models;

import java.util.Arrays;
import java.util.Objects;

/**
 * A model with the informations about credentials of a user.
 * 
 */
public class SystemUser 
{
    private final Role role;
    private final String username;
    private final char[] password; 
    
    /**
    * An enumeration of all roles defined in the database
    * 
    */
    public enum Role
    {
        SYSTEM_ADMINISTRATOR ("system_administrator"),
        PLANNER ("planner"),
        MAINTAINER ("maintainer");
        
        private final String role;
        
        /**
         * 
         * @param role is the role to assign to the system user.
         */
        Role(String role)
        {
            this.role = role;
        }
        
        /**
         * 
         * @return role's value.
         */
        public String getValue()
        {
            return role;
        }
    }
    
    /**
     * 
     * Creates a new system user.
     * @param role is the role of the system user.
     * @param username is the username of the system user.
     * @param password is the password of the system user.
     */
    public SystemUser(Role role, String username, char[] password)
    {
        this.role = role;
        this.username = username;
        this.password = password;
    }
    
    /**
     * 
     * @return the Role of the system user.
     */
    public Role getRole()
    {
        return role;
    }
    
    /**
     * 
     * @return a String representing the system user's username.
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * 
     * @return a char vector representing the system user's password.
     */
    public char[] getPassword()
    {
        return password;
    }
    
    /**
     * 
     * @param obj is the object to compare.
     * @return true if the compared objects are equals, otherwise false.
     */
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

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.role);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Arrays.hashCode(this.password);
        return hash;
    }

    
    
    
}
