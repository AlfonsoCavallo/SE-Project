package se.project.storage.models;


public class SystemAdministrator extends User
{
    private String role;
    
    /**
     * 
     * Creates a new System Administrator
     * @param username is the system administrator's username
     * @param email is the system administrator's email
     * @param name is the system administrator's name
     * @param surname is the system administrator's surname
     * @param password is the system administrator's password
     * @param role is the user's role
     */
    public SystemAdministrator(String username, String email, String name, String surname, String password, String role)
    {
        super(username, email, name, surname, password);
        this.role = role;
    }
    
    /**
     * 
     * @return a Stiring containing the user's role 
     */
    public String getRole()
    {
        return role;
    }
    
    /**
     * 
     * @return the data model of a system administrator
     */
    public Object[] getDataModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole()};
    }
    
    /**
     * 
     * @return the data model of a system administrator including the password
     */
    public Object[] getDataPasswordModel()
    {
        return new Object[]{getUsername(), getName(), getSurname(), getEmail(), getRole(), getPassword()};
    }
}
