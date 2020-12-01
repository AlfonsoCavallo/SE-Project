package se.project.business_logic.controllers;


public class MainController
{
    public static void main(String args[])
    {
        openLoginPage();
    }
    
    public static void openLoginPage()
    {
        LoginController loginController = new LoginController();
    }
}
