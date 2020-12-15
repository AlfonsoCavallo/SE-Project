/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models.interfaces;

/**
 * A model to represent informations about a Weekly Availability.
 */
public interface RepresentableWeeklyAvailability
{
    /***
     * 
     * @return an array of percentages capable of being configured on a JTable
     */    
    Object[] getPercentageDataModel();
    
    /***
     * 
     * @param day is the day to check the minutes available.
     * @return an array of percentages capable of being configured on a JTable
     */    
    Object[] getMinutesAvailableDataModel(String day);
}
