/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
