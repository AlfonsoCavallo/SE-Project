package se.project.storage.models;


public class Planner extends User
{
    private String role;
    
    /**
     * 
     * @param username
     * @param email
     * @param name
     * @param surname
     * @param password
     * @param role 
     */
    public Planner(String username, String email, String name, String surname, String password, String role)
    {
        super(username, email, name, surname, password);
        this.role = role;
    }

    public String getRole()
    {
        return role;
    }
    
    public Object[] getDataModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole()};
    }
    
    public Object[] getDataPasswordModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole(), getPassword()};
    }
    
}
