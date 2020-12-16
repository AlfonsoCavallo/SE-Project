package se.project.storage.models;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import se.project.storage.models.interfaces.RepresentableWeeklyAvailability;

/**
 * A model with the informations about the availability of a user during the week.
 * 
 */
public class WeeklyAvailability implements RepresentableWeeklyAvailability
{
    private final List<int[]> availabilityPercentage = new ArrayList<>(7);
    private final String username;
    private int numberOfCompetences = 0;
    
    /***
     * An enumeration about all the work turns.
     * HX - Work hour starting at X:00.
     */
    public enum WorkTurn
    {
        H8 ("08:00 - 09:00"),
        H9 ("09:00 - 10:00"),
        H10 ("10:00 - 11:00"),
        H11 ("11:00 - 12:00"),
        H14 ("14:00 - 15:00"),
        H15 ("15:00 - 16:00"),
        H16 ("16:00 - 17:00");
        
        private final String workTurn;
        
        WorkTurn(String workTurn)
        {
            this.workTurn = workTurn;
        }        
        
        /**
         * 
         * @param turn is the turn from which regain its corresponding string.
         * @return the string corresponding to the given turn.
         */
        public static String getValue(WorkTurn turn)
        {
            switch(turn)
            {
                case H8: return "8_9";
                case H9: return "9_10";
                case H10: return "10_11";
                case H11: return "11_12";
                case H14: return "14_15";
                case H15: return "15_16";
                case H16: return "16_17";
            }
            return null;
        }
        
        /**
         * Gets a workturn from a String value.
         * @param string is the string from which regain the WorkTurn.
         * @return the WorkTurn corresponding to the given string.
         */
        public static WorkTurn fromString(String string)
        {
            for(WorkTurn workTurn : WorkTurn.values())
            {
                if(workTurn.workTurn.equalsIgnoreCase(string))
                {
                    return workTurn;
                }    
            }
            return null;
        }        
        
    }
    
    /**
     * Construct a WeeklyAvailability instance.
     * @param username is the username of the Maintainer associated to the availability.
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
     * @return the username of the Maintainer.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @return the number of competences of the Maintainer among the desired ones.
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
     * Sets the minutes of availability in a specific day.
     * @param day is the day whose availability are going to be setted.
     * @param h8 are the minutes available between 8:00 and 9:00.
     * @param h9 are the minutes available between 9:00 and 10:00.
     * @param h10 are the minutes available between 10:00 and 10:00.
     * @param h11 are the minutes available between 11:00 and 12:00.
     * @param h14 are the minutes available between 14:00 and 15:00.
     * @param h15 are the minutes available between 15:00 and 16:00.
     * @param h16 are the minutes available between 16:00 and 17:00.
     */
    public void setAvailabilities(DayOfWeek day, int h8, int h9, int h10, int h11, 
            int h14, int h15, int h16)
    {
        int[] availability = {h8, h9, h10, h11, h14, h15, h16};
        
        availabilityPercentage.set(day.ordinal(), availability);        
    }
    
    /**
     * 
     * Return the minutes available for one turn.
     * @param day is the day to check.
     * @param turn is the turn to check for availabile minutes.
     * @return the number of minutes available.
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
     * Return the percentage of availability in a day of the week.
     * @param day is the day to check.
     * @return a percentage of how much availability proportioned to a full work day.
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
     * @param obj is the object to compare.
     * @return true if the compared objects are equals, otherwise false.
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

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.availabilityPercentage);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + this.numberOfCompetences;
        return hash;
    }
    
    /**
     * 
     * @return the data model to assign a WeeklyAvailability.
     */
    @Override
    public Object[] getPercentageDataModel()
    {
        EnumSet<DayOfWeek> daysOfWeek = EnumSet.allOf(DayOfWeek.class);
        
        LinkedList<Object> output = new LinkedList<>(Arrays.asList(getUsername(), getNumberOfCompetences()));
        
        for(DayOfWeek day : daysOfWeek)
        {
            output.add(getPercentageAvailability(day));
        }
        
        return output.toArray();
    }
    
    /**
     * 
     * @param dayOfWeek is the day of the week in which the maintainer has to work to the assigned activity.
     * @return the data model to forward a WeeklyAvailability.
     */
    @Override
    public Object[] getMinutesAvailableDataModel(String dayOfWeek)
    {
        EnumSet<WorkTurn> workTurns = EnumSet.allOf(WorkTurn.class);
        
        LinkedList<Object> output = new LinkedList<>(Arrays.asList(getUsername(), getNumberOfCompetences()));
        
        DayOfWeek selectedDay = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
        
        for(WorkTurn workTurn : workTurns)
        {
            output.add(getMinutesAvailable(selectedDay, workTurn));
        }
        
        return output.toArray();
    }        
    
    
}
