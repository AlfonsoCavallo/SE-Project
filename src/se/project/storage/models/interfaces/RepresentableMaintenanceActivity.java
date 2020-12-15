/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models.interfaces;

/**
 * A model to represent informations about a Maintenance Activity.
 */

public interface RepresentableMaintenanceActivity
{
    /***
     * 
     * @return an array of informations capable of being configured on a JTable
     */    
    Object[] getDataModel();
}
