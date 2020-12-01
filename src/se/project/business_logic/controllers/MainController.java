/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

/**
 *
 * @author Utente
 */
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
