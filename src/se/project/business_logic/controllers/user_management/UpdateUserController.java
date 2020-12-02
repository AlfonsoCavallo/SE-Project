package se.project.business_logic.controllers.user_management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import se.project.business_logic.controllers.AbstractController;
import static se.project.business_logic.controllers.MainController.openLoginPage;
import se.project.presentation.views.user_management.UpdateUserView;
import static se.project.storage.DatabaseConnection.closeConnection;
import static se.project.storage.DatabaseConnection.getConnection;
import se.project.storage.models.Planner;
import se.project.storage.models.SystemAdministrator;
import se.project.storage.models.User;
import se.project.storage.repos.UserRepo;
import se.project.storage.repos.interfaces.UserRepoInterface;


public class UpdateUserController extends AbstractController
{
    private final String QUERY_ACCESSES_FAILED_MESSAGE = "Could not update user in database.";
    private final String CANNOT_READ_FILE_MESSAGE = "Unable to access system query.";
    private final String UPDATED_MESSAGE = "User \"username_param\" has been updated successfully!";
    private final String QUERY_NULL_POINTER_MESSAGE = "All the fields must be filled!";
    private final String SELECT_USER_MESSAGE = "Please, select a user before updating!";
    
    private final UpdateUserView updateUserView;
    private UserRepoInterface userRepo;
    private LinkedList<String> usernameList;
    private int columnNumber;

    /**
     * 
     * Creates a new UpdateUserController
     */
    public UpdateUserController()
    {
        this.updateUserView = new UpdateUserView();
        this.userRepo = new UserRepo(getConnection());
        this.usernameList = new LinkedList<>();
        this.columnNumber = this.updateUserView.getTable().getColumnCount();
        initListeners();
        viewUsers(false);
    }
    
    /**
     * 
     *  Initializes the listeners of updateUserView
     */
    private void initListeners()
    {
        updateUserView.getjUpdateUserPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                updateUser();
                viewUsers(false);
            }
        });
        
        updateUserView.getjShowPasswordPanel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                showPassword();
            }
        });
        
        updateUserView.getjGoBackLabel().addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                goBackUserInfoPage();
                updateUserView.dispose();
            }
        });
        
        updateUserView.getjCloseConnectionLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
                updateUserView.dispose();
                openLoginPage();
            }
        });
        
        updateUserView.getjExitLabel().addMouseListener(new java.awt.event.MouseAdapter()
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
       new UserInfoController();
    }
    
    /**
     * 
     *  Executes the update of the selected user
     */
    public void updateUser()
    {
        int row = -1;
        String username = null;
        String name = null;
        String surname = null;
        String email = null;
        String role = null;
        String password = null;
        try
        {
            row = updateUserView.getTable().getSelectedRow();
            username = updateUserView.getTable().getValueAt(row, 0).toString();
            name = updateUserView.getTable().getValueAt(row, 1).toString();
            surname = updateUserView.getTable().getValueAt(row, 2).toString();
            email = updateUserView.getTable().getValueAt(row, 3).toString();
            role = updateUserView.getTable().getValueAt(row, 4).toString();
            password = updateUserView.getTable().getValueAt(row, 5).toString();
        }
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_NULL_POINTER_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), SELECT_USER_MESSAGE);
        }
        User user = null;
        try
        {
            if(role.equals("system_administrator"))
            {
                user = new SystemAdministrator(username, email, name, surname, password, role);
            }
            else if(role.equals("planner"))
            {
                user = new Planner(username, email, name, surname, password, role);
            }
            String oldUsername = this.usernameList.get(row);
            userRepo.updateUser(user, oldUsername);
            String updatedMessage = UPDATED_MESSAGE.replaceAll("username_param", username);
            JOptionPane.showMessageDialog(null, updatedMessage);
        } 
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
        catch (NullPointerException ex)
        {
        }
    }
    
    /**
     * This method shows in a table the users in the database 
     * @param showPassword indicates if the passwords must be shown
     */
    public void viewUsers(boolean showPassword)
    {
        DefaultTableModel tableModel = updateUserView.getTableModel();
        try
        {
            LinkedList<User> users = userRepo.queryAllUsers();
            usernameList.clear();
           
            // Clears the model
            while(tableModel.getRowCount() > 0)
            {
                tableModel.removeRow(0);
            }
            
            // Iterates over users
            for(User user : users)
            {
                // Verifies if it must show password
                if(!showPassword)
                {
                    tableModel.addRow(user.getDataModel());
                }
                else
                {
                    tableModel.addRow(user.getDataPasswordModel());
                }
                this.usernameList.add(user.getUsername());
            }
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), CANNOT_READ_FILE_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), QUERY_ACCESSES_FAILED_MESSAGE);
        }
    }
    
    /**
     * This method changes the show password button and modify the View
     */
    public void showPassword()
    {
        String buttonMessage = updateUserView.getjShowPasswordLabel().getText();
        if(buttonMessage.equals("Hide Passwords"))
        {               
            updateUserView.getjShowPasswordLabel().setText("Show Passwords");
            viewUsers(false);
        }
        else
        {
            updateUserView.getjShowPasswordLabel().setText("Hide Passwords");
            viewUsers(true);
        }
    }
}
