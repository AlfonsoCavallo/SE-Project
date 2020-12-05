/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models;

import java.util.List;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class WeeklyAvailability
{
    private List<int[]> availabilityPercentage = new ArrayList<>(7);
    
    /***
     * HX -> Work hour starting at X:00
     */
    public enum WorkTurn
    {
        H8,
        H9,
        H10,
        H11,
        H14,
        H15,
        H16;
    }
    
    public WeeklyAvailability()
    {
        for(int i = 0; i < 7; i++)
        {
            availabilityPercentage.add(null);
        }
    }
    
    /***
     * Sets the minutes of availability in a specific day
     * @param day is the day whose availability are going to be setted
     * @param h8 are the minutes available between 8:00 and 9:00
     * @param h9 are the minutes available between 9:00 and 10:00
     * @param h10 are the minutes available between 10:00 and 10:00
     * @param h11 are the minutes available between 11:00 and 12:00
     * @param h14 are the minutes available between 14:00 and 15:00
     * @param h15 are the minutes available between 15:00 and 16:00
     * @param h16 are the minutes available between 16:00 and 17:00
     */
    public void setAvailabilities(DayOfWeek day, int h8, int h9, int h10, int h11, 
            int h14, int h15, int h16)
    {
        int[] availability = {h8, h9, h10, h11, h14, h15, h16};
        
        availabilityPercentage.set(day.ordinal(), availability);        
    }
    
    /***
     * Return the minutes available for one turn
     * @param day is the day to check
     * @param turn is the turn to check for availabile minutes
     * @return the number of minutes available
     */
    public int getMinutesAvailable(DayOfWeek day, WorkTurn turn)
    {
        if(availabilityPercentage.get(day.ordinal()) == null)
        {
            return 0;
        }
        return availabilityPercentage.get(day.ordinal())[turn.ordinal()];
    }
    
    /***
     * Return the percentage of availability in a day of the week
     * @param day is the day to check
     * @return a percentage of how much availability proportioned to a full work day
     */
    public int getPercentageAvailability(DayOfWeek day)
    {
        int output = 0;
        int[] availabilityMinutes = availabilityPercentage.get(day.ordinal());
        
        if(availabilityMinutes == null)
        {
            return 0;
        }
        
        for(int minutes : availabilityMinutes)
        {
            output += minutes;
        }
        
        output = (output * 100)  / (availabilityMinutes.length * 60);
        
        return output;
    }   
}
