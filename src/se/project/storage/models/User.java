package se.project.storage.models;

import java.util.Objects;

/**
 * A model with the informations about a user.
 * 
 */
public abstract class User
{
    private final String username;
    private final String password;
    private final String email;
    private final String name;
    private final String surname;

    /**
     * 
     * Creates a new user.
     * @param username is the user's username.
     * @param email is the user's email.
     * @param name is the user's name.
     * @param surname is the user's surname.
     * @param password is the user's password.
     */
    public User(String username, String email, String name, String surname, String password)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    /**
     * 
     * @return a String containing the user's username.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @return a String containing the user's password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * 
     * @return a String containing the user's email.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * 
     * @return a String containing the user's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @return a String containing the user's surname.
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * 
     * @return a String containing the user's role (must be implemented in the sub-classes).
     */
    public abstract String getRole();
    
    /**
     * 
     * @return the data model of a user (must be implemented in the sub-classes).
     */
    public abstract Object[] getDataModel();
    
    /**
     * 
     * @return the data model of a user including the password (must be implemented in the sub-classes).
     */
    public abstract Object[] getDataPasswordModel();
    
    /**
     * 
     * @param obj is the object to compare.
     * @return true if the compared objects are equals, otherwise false.
     */
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

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.username);
        hash = 19 * hash + Objects.hashCode(this.password);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.surname);
        return hash;
    }
    
    
}
