package se.project.business_logic.controllers;

import se.project.presentation.views.AbstractView;


public abstract class AbstractController
{
    protected AbstractView view;

    /**
     * 
     * @return an AbstractView
     */
    public AbstractView getView()
    {
        return view;
    }    
}
