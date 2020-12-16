package se.project.storage.models;

/**
 * A model with the informations about a Planner user.
 * 
 */
public class Planner extends User
{
    private final String role;
    
    /**
     * 
     * Creates a new Planner.
     * @param username is the username of the planner.
     * @param email is the email of the planner.
     * @param name is the name of the planner.
     * @param surname is the surname of the planner.
     * @param password is the password of the planner.
     * @param role is the role.
     */
    public Planner(String username, String email, String name, String surname, String password, String role)
    {
        super(username, email, name, surname, password);
        this.role = role;
    }

    /**
     * 
     * @return a String containing the role of this user.
     */
    @Override
    public String getRole()
    {
        return role;
    }
    
    /**
     * 
     * @return the data model of a planner.
     */
    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole()};
    }
    
    /**
     * 
     * @return the data model of a planner including the password.
     */
    @Override
    public Object[] getDataPasswordModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole(), getPassword()};
    }
    
}
