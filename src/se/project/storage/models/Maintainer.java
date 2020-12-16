package se.project.storage.models;

/**
 * A model with the informations about a Maintainer user.
 * 
 */
public class Maintainer extends User
{
    private String role;
    
    /**
     * 
     * Creates a new Maintainer.
     * @param username is the username of the Maintainer.
     * @param email is the email of the Maintainer.
     * @param name is the name of the Maintainer.
     * @param surname is the surname of the Maintainer.
     * @param password is the password of the Maintainer.
     * @param role is the role.
     */
    public Maintainer(String username, String email, String name, String surname, String password, String role)
    {
        super(username, email, name, surname, password);
        this.role = role;
    }

    /**
     * 
     * @return a String containing the role of this user.
     */
    public String getRole()
    {
        return this.role;
    }

    /**
     * 
     * @return the data model of a maintainer.
     */
    public Object[] getDataModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole()};
    }

    /**
     * 
     * @return the data model of a maintainer including the password.
     */
    public Object[] getDataPasswordModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole(), getPassword()};
    }
    
}
