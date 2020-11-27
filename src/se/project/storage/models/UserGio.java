/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.models;

import java.util.Objects;

/**
 *
 * @author Giorgio
 */
public abstract class UserGio
{
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

    public UserGio(String username, String email, String name, String surname, String password)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final UserGio other = (UserGio) obj;
        return Objects.equals(this.username, other.username);
    }
    
    
}