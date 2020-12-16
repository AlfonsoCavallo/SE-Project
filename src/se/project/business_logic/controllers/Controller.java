package se.project.business_logic.controllers;

import se.project.presentation.views.AbstractView;


/**
 *
 * Manages the logic behind an AbstractView instance
 */
public interface Controller
{
    /***
     * 
     * @return the view attached to this controller 
     */
    AbstractView getView();
}
