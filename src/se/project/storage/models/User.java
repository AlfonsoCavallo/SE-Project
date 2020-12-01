package se.project.storage.models;

import java.util.Objects;


public abstract class User
{
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

    /**
     * 
     * Creates a new user 
     * @param username is the user's username
     * @param email is the user's email
     * @param name is the user's name
     * @param surname is the user's surname
     * @param password is the user's password
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
     * @return a String containing the user's username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @return a String containing the user's password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * 
     * @return a String containing the user's email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * 
     * @return a String containing the user's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @return a String containing the user's surname
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * 
     * @return a String containing the user's role (must be implemented in the sub-classes)
     */
    public abstract String getRole();
    
    /**
     * 
     * @return the data model of a user (must be implemented in the sub-classes)
     */
    public abstract Object[] getDataModel();
    
    /**
     * 
     * @return the data model of a user including the password (must be implemented in the sub-classes)
     */
    public abstract Object[] getDataPasswordModel();
    
    /**
     * 
     * @param obj is the object to compare
     * @return true if the compared objects are equals, otherwise false
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
    
    
}
