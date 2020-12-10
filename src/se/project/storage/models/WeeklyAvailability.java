package se.project.storage.models;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class WeeklyAvailability
{
    private List<int[]> availabilityPercentage = new ArrayList<>(7);
    private String username;
    private int numberOfCompetences = 0;
    
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
    
    /**
     * Construct a WeeklyAvailability instance.
     * @param username is the username of the Maintainer associated to the availability
     */
    public WeeklyAvailability(String username)
    {
        this.username = username;
        
        for(int i = 0; i < 7; i++)
        {
            availabilityPercentage.add(null);
        }
    }

    /**
     * 
     * @return the username of the Maintainer 
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @return the number of competences of the Maintainer among the desired ones
     */
    public int getNumberOfCompetences()
    {
        return numberOfCompetences;
    }

    /**
     * 
     * @param numberOfCompetences the number of competences owned by the Maintainer. 
     */
    public void setNumberOfCompetences(int numberOfCompetences)
    {
        this.numberOfCompetences = numberOfCompetences;
    }
    
    /**
     * 
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
    
    /**
     * 
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
    
    /**
     * 
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

    /**
     * 
     * @param obj is the object to compare
     * @return true if the compared objects are equals, otherwise false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final WeeklyAvailability other = (WeeklyAvailability) obj;
        if(true)
        {
            for(int i = 0; i < availabilityPercentage.size(); i++)
            {
                if(availabilityPercentage.get(i) == null || other.availabilityPercentage.get(i) == null)
                {
                    if(!(availabilityPercentage.get(i) == null && other.availabilityPercentage.get(i) == null))
                    {
                        return false;
                    }
                }
                else
                {
                    for(int j = 0; j < availabilityPercentage.get(i).length; j++)
                    {
                        if(availabilityPercentage.get(i)[j] != other.availabilityPercentage.get(i)[j])
                        {
                           return false;
                        }
                    }
                }
            }
        }
        if (!Objects.equals(this.username, other.username))
        {
            return false;
        }
        if (this.numberOfCompetences != other.numberOfCompetences)
        {
            return false;
        }
        return true;
    }
    
    public Object[] getDataForAssignment()
    {
        EnumSet<DayOfWeek> daysOfWeek = EnumSet.allOf(DayOfWeek.class);
        
        LinkedList<Object> output = new LinkedList<>(Arrays.asList(getUsername(), getNumberOfCompetences()));
        
        for(DayOfWeek day : daysOfWeek)
        {
            output.add(getPercentageAvailability(day));
        }    
        
        return output.toArray();
    }        
    
    
}
