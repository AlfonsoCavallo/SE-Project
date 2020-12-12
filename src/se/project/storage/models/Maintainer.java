package se.project.storage.models;


public class Maintainer extends User
{
    private String role;
    
    public Maintainer(String username, String email, String name, String surname, String password, String role)
    {
        super(username, email, name, surname, password);
        this.role = role;
    }

    /**
     * 
     * @return a String containing the role of this user
     */
    public String getRole()
    {
        return this.role;
    }

    /**
     * 
     * @return the data model of a maintainer
     */
    public Object[] getDataModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole()};
    }

    /**
     * 
     * @return the data model of a maintainer including the password
     */
    public Object[] getDataPasswordModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole(), getPassword()};
    }
    
}
