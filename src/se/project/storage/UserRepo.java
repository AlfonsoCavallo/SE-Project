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
public class UserRepo
{
    private String DATABASE_SERVER_ADDRESS;
    private String username;
    private char[] password;
    
    public UserRepo(String username, char[] password)
    {
        //connection to db
        this.username = username;
        this.password = password;
    }
    
    public User queryCurrentUser()
    {
        // Return a model of the current user
        return null;
    }
    
    public void closeConnection()
    {
        //close 
    }        
    
}
