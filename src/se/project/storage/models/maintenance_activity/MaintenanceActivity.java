package se.project.storage.models.maintenance_activity;

import java.util.Objects;


public abstract class MaintenanceActivity
{
    private int IDActivity = -1;
    private String activityName;
    private int timeNeeded;
    private boolean interruptible;
    private Typology typology;
    private String activityDescription;
    private int week;
    
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
         * @return a String containing the value of the typology
         */
        public String getValue()
        {
            return typology;
        }
        
        /**
         * 
         * @param string is the string from which regain the Typology
         * @return the Typology corresponding to string
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
     * Creates a new MaintenanceActivity
     * @param IDActivity is the ID of the Maintenance Activity
     * @param activityName is the name of the Maintenance Activity
     * @param timeNeeded is the time needed for the Maintenance Activity
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise
     * @param typology is the typology of the Maintenance Activity
     * @param activityDescription is the description of the Maintenance Activity
     * @param week is the week in which the Maintenance Activity must be done
     */
    public MaintenanceActivity(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        this.IDActivity = IDActivity;
        this.activityName = activityName;
        this.timeNeeded = timeNeeded;
        this.interruptible = interruptible;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
    }
    
    /**
     * 
     * Creates a new MaintenanceActivity without considering the ID
     * @param activityName is the name of the Maintenance Activity
     * @param timeNeeded is the time needed for the Maintenance Activity
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise
     * @param typology is the typology of the Maintenance Activity
     * @param activityDescription is the description of the Maintenance Activity
     * @param week is the week in which the Maintenance Activity must be done
     */
    public MaintenanceActivity(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        this.activityName = activityName;
        this.timeNeeded = timeNeeded;
        this.interruptible = interruptible;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
    }
    
    /**
     * 
     * @return an int representing the ID activity
     */
   public int getIdActivity()
   {
       return IDActivity;
   }
   
   /**
    * 
    * @return a String representing the name of the maintenance activity
    */
   public String getActivityName()
   {
       return activityName;
   }
   
   /**
    * 
    * @return an int representing the time needed for the maintenance activity
    */
   public int getTimeNeeded()
   {
       return timeNeeded;
   }        
   
   /**
    * 
    * @return a String, it's "yes" if interruptible is true, "no" otherwise
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
    * @return the Typology of the maintenance activity
    */
   public Typology getTypology()
   {
       return typology;
   }
   
   /**
    * 
    * @return a String representing the description of the maintenance activity
    */
   public String getActivityDescription()
   {
       return activityDescription;
   }        
   
   /**
    * 
    * @return an int corresponding to the week in which the maintenance activity must be done
    */
   public int getWeek()
   {
       return week;
   }
   
   /**
    * 
    * @return "yes" if the maintenance activity is planned, "no" otherwise (must be implemented in the sub-classes)
    */
   public abstract String isPlanned();
   
   /**
    * 
    * @return "yes" if the maintenance activity is an EWO, "no" otherwise (must be implemented in the sub-classes)
    */
   public abstract String isEWO();
   
   /**
    * 
    * @return a String representing the standard procedure of the maintenance activity (must be implemented in the sub-classes)
    */
   public abstract String getStandardProcedure();
   
   /**
    * 
    * @return an Object array representing the data model of the maintenance activity (must be implemented in the sub-classes)
    */
   public abstract Object[] getDataModel();
           
   /**
    * 
    * @param week is the week in which the maintenance activity must be done
    * @return true if week is a valid week, false otherwise
    */
   public boolean isValidWeek(int week)
   {
       return week >= 1 && week <= 52; 
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
        return true;
    }
   
   
   
}
