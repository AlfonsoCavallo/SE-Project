package se.project.business_logic.controllers;

/**
 * Boots the program and run the main thread.
 * 
 */
public class MainController
{
    /**
     * Runs the program by opening a Login Page.
     * @param args is not require.
     */
    public static void main(String args[])
    {
        openLoginPage();
    }
    
    /**
     * 
     * Opens the Login page instatiating its controller.
     */
    public static void openLoginPage()
    {
        LoginController loginController = new LoginController();
    }
}
