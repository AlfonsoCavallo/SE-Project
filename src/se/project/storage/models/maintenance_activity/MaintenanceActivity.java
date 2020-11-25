/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.models.maintenance_activity;

/**
 *
 * @author delso
 */
public abstract class MaintenanceActivity
{
    private int IDActivity;
    private String activityName;
    private int timeNedeed;
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
    }

    public MaintenanceActivity(int IDActivity, String activityName, int timeNedeed, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        this.IDActivity = IDActivity;
        this.activityName = activityName;
        this.timeNedeed = timeNedeed;
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
   
   public int getTimeNedeed()
   {
       return timeNedeed;
   }        
   
   public boolean isInterruptible()
   {
       return interruptible;
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
           
   public boolean isValidWeek(int week)
   {
       return week >= 1 && week <= 52; 
   }        
   
}
