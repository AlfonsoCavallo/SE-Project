package se.project.storage.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class UserAccess
{
    private int ID = -1; // null ID
    private String username;
    private LocalDateTime accessTime;

    /**
     * 
     * Create a new access
     * @param ID is the ID of the access
     * @param username is the username of the logged in user
     * @param accessTime is the timestamp of the access
     */
    public UserAccess(int ID, String username, LocalDateTime accessTime)
    {
        this.ID = ID;
        this.username = username;
        this.accessTime = accessTime;
    }
    
    /**
     * 
     * Create a new access without ID
     * @param username is the username of the logged in user
     * @param accessTime is the timestamp of the access 
     */
    public UserAccess(String username, LocalDateTime accessTime)
    {
        this.username = username;
        this.accessTime = accessTime;
    }

    /**
     * 
     * @return the ID of the access
     */
    public int getID()
    {
        return ID;
    }

    /**
     * 
     * @return the username corresponding to the access
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @return the timestamp of the access
     */
    public LocalDateTime getAccessTime()
    {
        return accessTime;
    }
    
    /**
     * 
     * @return the data model of a user access 
     */
    public Object[] getDataModel()
    {
        return new Object[]{ID, username, accessTime};
    }
    
    /**
     * 
     * @param obj is the object to compare
     * @return true if the compared objects are equals, otherwise false
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
        final UserAccess other = (UserAccess) obj;
        if(this.ID != other.ID)
        {
            return false;
        }
        if(!Objects.equals(this.username, other.username))
        {
            return false;
        }
        if(!Objects.equals(this.accessTime, other.accessTime))
        {
            return false;
        }
        return true;
    }
    
    
}
