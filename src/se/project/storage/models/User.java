package se.project.storage.models;

import java.util.Objects;


public abstract class User
{
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

    public User(String username, String email, String name, String surname, String password)
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
    
    public abstract String getRole();
    
    public abstract Object[] getDataModel();
    
    public abstract Object[] getDataPasswordModel();
    
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
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }
    
    
}
