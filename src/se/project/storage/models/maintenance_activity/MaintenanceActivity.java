package se.project.storage.models.maintenance_activity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A model providing informations about a Maintenance Activity.
 * 
 */
public abstract class MaintenanceActivity
{
    private int IDActivity = -1;
    private String activityName;
    private int timeNeeded;
    private int remainingTime;
    private boolean interruptible;
    private Typology typology;
    private String activityDescription;
    private int week;
    private String brachOffice;
    private String department;
    private ArrayList<String> skills;
    
    /**
    * An enum with all typologies of maintenance activity.
    * 
    */
    public enum Typology
    {
        ELECTRICAL ("electrical"),
        ELECTRONIC ("electronic"),
        HYDRAULIC ("hydraulic"),
        MECHANICAL ("mechanical");
        
        private String typology;
        
        Typology(String typology)
        {
            this.typology = typology;
        }
        
        /**
         * 
         * @return a String containing the value of the typology.
         */
        public String getValue()
        {
            return typology;
        }
        
        /**
         * 
         * @param string is the string from which regain the Typology.
         * @return the Typology corresponding to string.
         */
        public static Typology fromString(String string)
        {
            for(Typology typology : Typology.values())
            {
                if(typology.typology.equalsIgnoreCase(string))
                    return typology;
            }
            return null;
        }        
       
    }

    /**
     * 
     * Creates a new MaintenanceActivity.
     * @param IDActivity is the ID of the Maintenance Activity.
     * @param activityName is the name of the Maintenance Activity.
     * @param timeNeeded is the time needed for the Maintenance Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise.
     * @param typology is the typology of the Maintenance Activity.
     * @param activityDescription is the description of the Maintenance Activity.
     * @param week is the week in which the Maintenance Activity must be done.
     */
    public MaintenanceActivity(int IDActivity, String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        this.IDActivity = IDActivity;
        this.activityName = activityName;
        this.timeNeeded = timeNeeded;
        this.remainingTime = remainingTime;
        this.interruptible = interruptible;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
    }
    
    /**
     * 
     * Creates a new MaintenanceActivity without considering the ID.
     * @param activityName is the name of the Maintenance Activity.
     * @param timeNeeded is the time needed for the Maintenance Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise.
     * @param typology is the typology of the Maintenance Activity.
     * @param activityDescription is the description of the Maintenance Activity.
     * @param week is the week in which the Maintenance Activity must be done.
     */
    public MaintenanceActivity(String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        this.activityName = activityName;
        this.timeNeeded = timeNeeded;
        this.interruptible = interruptible;
        this.remainingTime = remainingTime;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
    }

    /**
     * 
     * Creates a new MaintenanceActivity with the skills needed and the afferent site.
     * @param IDActivity is the IDActivity of the Planned Activity.
     * @param activityName is the name of the Planned Activity.
     * @param timeNeeded is the time needed for the Planned Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is the type of the Planned Activity.
     * @param typology is the typology of the Planned Activity.
     * @param activityDescription is the activity description of the Planned Activity.
     * @param week is the week dedicated to the Planned Activity.
     * @param brachOffice is the brach office in which the acrivity must be done.
     * @param department is the department in which the acrivity must be done.
     * @param skills is an array of skills needed fot that activity.
     */
    public MaintenanceActivity(int IDActivity, String activityName, int timeNeeded, int remainingTime,
            boolean interruptible, Typology typology, String activityDescription, int week, 
            String brachOffice, String department, ArrayList<String> skills)
    {
        this.IDActivity = IDActivity;
        this.activityName = activityName;
        this.timeNeeded = timeNeeded;
        this.remainingTime = remainingTime;
        this.interruptible = interruptible;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
        this.brachOffice = brachOffice;
        this.department = department;
        this.skills = skills;
    }
    
    /**
     * 
     * @return an int representing the ID activity.
     */
   public int getIdActivity()
   {
       return IDActivity;
   }
   
   /**
    * 
    * @return a String representing the name of the maintenance activity.
    */
   public String getActivityName()
   {
       return activityName;
   }
   
   /**
    * 
    * @return an int representing the time needed for the maintenance activity.
    */
   public int getTimeNeeded()
   {
       return timeNeeded;
   }        
   
   /***
    * 
    * @return an int representing the time remained for the maintenance activity completition.
    */
   public int getRemainingTime()
   {
       return remainingTime;
   }
   
   
   /**
    * 
    * @return a String, it's "yes" if interruptible is true, "no" otherwise.
    */
   public String isInterruptible()
   {
       String output;
       
       if(this.interruptible == true)
          output = "yes";
       else
           output = "no";
       return output;
   }        
   
   /**
    * 
    * @return the Typology of the maintenance activity.
    */
   public Typology getTypology()
   {
       return typology;
   }
   
   /**
    * 
    * @return a String representing the description of the maintenance activity.
    */
   public String getActivityDescription()
   {
       return activityDescription;
   }        
   
   /**
    * 
    * @return an int corresponding to the week in which the maintenance activity must be done.
    */
   public int getWeek()
   {
       return week;
   }

   /**
    * 
    * @return a String containing the branch office.
    */
    public String getBrachOffice()
    {
        return brachOffice;
    }

    /**
     * 
     * @return a String containing the department.
     */
    public String getDepartment()
    {
        return department;
    }

    /**
     * 
     * @return an ArrayList of String containing all the skills needed for a specific activity.
     */
    public ArrayList<String> getSkills()
    {
        return skills;
    }
   
   /**
    * 
    * @return "yes" if the maintenance activity is planned, "no" otherwise (must be implemented in the sub-classes).
    */
   public abstract String isPlanned();
   
   /**
    * 
    * @return "yes" if the maintenance activity is an EWO, "no" otherwise (must be implemented in the sub-classes).
    */
   public abstract String isEWO();
   
   /**
    * 
    * @return a String representing the standard procedure of the maintenance activity (must be implemented in the sub-classes).
    */
   public abstract String getStandardProcedure();
   
   /**
    * 
    * @return an Object array representing the data model of the maintenance activity (must be implemented in the sub-classes).
    */
   public Object[] getDataModel()
   {
       return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(), getRemainingTime(),
            isInterruptible(), getTypology().getValue(), getActivityDescription(), getWeek(), getBrachOffice(), getDepartment(), getStandardProcedure(), isPlanned()};
   }
           
   /**
    * 
    * @param week is the week in which the maintenance activity must be done.
    * @return true if week is a valid week, false otherwise.
    */
   public boolean isValidWeek(int week)
   {
       return week >= 1 && week <= 52; 
   }        

   /**
    * 
    * @return an Object array representing the data model of the maintenance activity.
    * with util info for the assignment (must be implemented in the sub-classes).
    */
   public Object[] getDataForAssignment()
   {
       return new Object[]{getIdActivity(), getBrachOffice() + " - " + getDepartment(), getTypology().getValue(), getTimeNeeded()};
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
        final MaintenanceActivity other = (MaintenanceActivity) obj;
        if (this.IDActivity != other.IDActivity)
        {
            return false;
        }
        if (!Objects.equals(this.activityName, other.activityName))
        {
            return false;
        }
        if (this.timeNeeded != other.timeNeeded)
        {
            return false;
        }
        if (this.remainingTime != other.remainingTime)
        {
            return false;
        }
        if (this.interruptible != other.interruptible)
        {
            return false;
        }
        if (this.typology != other.typology)
        {
            return false;
        }
        if (!Objects.equals(this.activityDescription, other.activityDescription))
        {
            return false;
        }
        if (this.week != other.week)
        {
            return false;
        }
        if (!Objects.equals(this.brachOffice, other.brachOffice))
        {
            return false;
        }
        if (!Objects.equals(this.department, other.department))
        {
            return false;
        }
        if (!Objects.equals(this.skills, other.skills))
        {
            return false;
        }
        return true;
    }
   
   
   
}
