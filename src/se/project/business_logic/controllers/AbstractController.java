/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

import se.project.presentation.views.AbstractView;

/**
 *
 * @author Utente
 */
public abstract class AbstractController
{
    protected AbstractView view;

    public AbstractView getView()
    {
        return view;
    }    
}
