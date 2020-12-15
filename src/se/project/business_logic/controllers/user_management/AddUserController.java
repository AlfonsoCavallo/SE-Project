package se.project.business_logic.controllers.user_management;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import se.project.business_logic.controllers.AbstractController;
import se.project.business_logic.controllers.ControllerFactory;
import se.project.business_logic.controllers.ControllerFactory.ControllerType;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.user_management.AddUserView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.Maintainer;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;
import se.project.storage.repo_proxy.UserProxyRepo;
import se.project.storage.repos.UserRepo;
import se.project.storage.repos.interfaces.UserRepoInterface;


public class AddUserController extends AbstractController
{
    private final String QUERY_ADD_FAILED_MESSAGE = "Could not add user in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String ADDED_MESSAGE = "User \"username_param\" has been added successfully!";
    private final String NULL_FIELD_MESSAGE = "Please, fill all the fields.";
    
    private final AddUserView addUserView;
    private final UserRepoInterface userRepo = new UserProxyRepo(getConnection());
    
    /**
     * 
     * Creates a new AddUserController
     */
    public AddUserController()
    {
        this.addUserView = new AddUserView();
        clearFields();
        initListeners();
    }
    
    /***
     * 
     * @return addUserView
     */
    @Override
    public AddUserView getView()
    {
        return addUserView;
    } 
    
    /**
     * 
     *  Initializes the listeners of addUserView
     */
    private void initListeners()
    {
        addUserView.getjAddPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                boolean clear = addUser();
                if(clear)
                {
                   clearFields(); 
                } 
            }
        });
        
        addUserView.getjClearPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                clearFields();
            }
        });
        
        addUserView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackUserInfoPage();
                addUserView.dispose();
            }
        });
        
        addUserView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                try
                {
                    closeConnection();
                }
                catch (SQLException ex)
                {
                    System.err.println(ex.getMessage());
                }
                addUserView.dispose();
                openLoginPage();
            }
        });
        
        addUserView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                System.exit(0);
            }
        });
    }
    
    /**
     * 
     * Opens the user info page using its controller
     */
    public static void goBackUserInfoPage()
    {
        ControllerFactory.createController(ControllerType.USER_INFO);
    }
    
    /**
     * 
     * Add a new user using data from the page and method from the repo
     * @return true if the addition has been succesfull, false otherwise
     */
    public boolean addUser()
    {
        String username = addUserView.getUsername();
        String name = addUserView.getNameUser();
        String surname = addUserView.getSurname();
        String email = addUserView.getEmail();
        String role = addUserView.getRole();
        String password = String.valueOf(addUserView.getPassword());
        User user = null;
        
        try
        {
            if(username.equals("") || name.equals("") || surname.equals("") || email.equals("") || password.equals(""))
            {
                JOptionPane.showMessageDialog(null, NULL_FIELD_MESSAGE);
            }
            else
            {
                if(role.equals("system_administrator"))
                {
                    user = new SystemAdministrator(username, email, name, surname, password, role);
                }
                else if(role.equals("planner"))
                {
                    user = new Planner(username, email, name, surname, password, role);
                }
                else if(role.equals("maintainer"))
                {
                    user = new Maintainer(username, email, name, surname, password, role);
                }
                userRepo.addUser(user);
                String addedMessage = ADDED_MESSAGE.replaceAll("username_param", username);
                JOptionPane.showMessageDialog(null, addedMessage);
                return true;
            } 
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ADD_FAILED_MESSAGE);
        }
        return false;
    }
    
    /**
     * 
     * Clears aòò the fields in the page
     */
    public void clearFields()
    {
        addUserView.resetjUsernameTextField();
        addUserView.resetjEmailTextField();
        addUserView.resetjNameTextField();
        addUserView.resetjSurnameTextField();
        addUserView.resetjPasswordField();
        addUserView.resetjRoleComboBox();
    }
}
