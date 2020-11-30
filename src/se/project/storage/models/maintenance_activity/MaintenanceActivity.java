/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.models.maintenance_activity;

import java.util.Objects;

/**
 *
 * @author delso
 */
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
        
        public String getValue()
        {
            return typology;
        }
        
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
    
   public int getIdActivity()
   {
       return IDActivity;
   }
   
   public String getActivityName()
   {
       return activityName;
   }
   
   public int getTimeNeeded()
   {
       return timeNeeded;
   }        
   
   public String isInterruptible()
   {
       String output;
       
       if(this.interruptible == true)
          output = "yes";
       else
           output = "no";
       return output;
   }        
   
   public Typology getTypology()
   {
       return typology;
   }
   
   public String getActivityDescription()
   {
       return activityDescription;
   }        
           
   public int getWeek()
   {
       return week;
   }
   
   public abstract String isPlanned();
   
   public abstract String isEWO();
   
   public abstract String getStandardProcedure();
   
   public abstract Object[] getDataModel();
           
   public boolean isValidWeek(int week)
   {
       return week >= 1 && week <= 52; 
   }        

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
