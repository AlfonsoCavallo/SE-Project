package se.project.business_logic.controllers;

import se.project.presentation.views.AbstractView;


public abstract class AbstractController implements Controller
{
    /**
     * 
     * @return an AbstractView linked to this controller
     */
    @Override
    public abstract AbstractView getView();
}
