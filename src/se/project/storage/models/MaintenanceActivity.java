/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.models;

/**
 *
 * @author delso
 */
public class MaintenanceActivity
{
    private int ID_ACTIVITY;
    private String activityName;
    private int timeNedeed;
    private String interruptible;
    private Typology typology;
    private String activityDescription;
    private int week;
    private String planned;
    private String standardProcedure;
    
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
        
        public String getTypology()
        {
            return typology;
        }        
    }

    public MaintenanceActivity(int ID_ACTIVITY, String activityName, int timeNedeed, String interruptible, Typology typology, String activityDescription, int week, String planned, String standardProcedure)
    {
        this.ID_ACTIVITY = ID_ACTIVITY;
        this.activityName = activityName;
        this.timeNedeed = timeNedeed;
        this.interruptible = interruptible;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.week = week;
        this.planned = planned;
        this.standardProcedure = standardProcedure; 
    }
    
   public int getIdActivity()
   {
       return ID_ACTIVITY;
   }
   
   public String getActivityName()
   {
       return activityName;
   }
   
   public int getTimeNedeed()
   {
       return timeNedeed;
   }        
   
   public String getInterruptible()
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
           
   public String getPlanned()
   {
       return planned;
   }  
   
   public String getStandardProcedure()
   {
       return standardProcedure;
   }
   
}
