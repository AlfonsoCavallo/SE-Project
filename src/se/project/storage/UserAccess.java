/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage;

import java.time.LocalDateTime;

/**
 *
 * @author Utente
 */
public class UserAccess
{
    private int ID; // null ID
    private String username;
    private LocalDateTime accessTime;

    public UserAccess(int ID, String username, LocalDateTime accessTime)
    {
        this.ID = ID;
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
}
