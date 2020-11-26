/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class UserAccess
{
    private int ID = -1; // null ID
    private String username;
    private LocalDateTime accessTime;

    public UserAccess(int ID, String username, LocalDateTime accessTime)
    {
        this.ID = ID;
        this.username = username;
        this.accessTime = accessTime;
    }
    
    public UserAccess(String username, LocalDateTime accessTime)
    {
        this.username = username;
        this.accessTime = accessTime;
    }

    public int getID()
    {
        return ID;
    }

    public String getUsername()
    {
        return username;
    }

    public LocalDateTime getAccessTime()
    {
        return accessTime;
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
