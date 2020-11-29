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
public class PlannedActivity extends MaintenanceActivity
{
    
    private String standardProcedure;
    private String planned;
    private String ewo;
    
    public PlannedActivity(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week, String standardProcedure)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = standardProcedure;
        this.planned = "yes";
        this.ewo = "no";
    }
    
    public PlannedActivity(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week, String standardProcedure)
    {
        super(activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = standardProcedure;
        this.planned = "yes";
        this.ewo = "no";
    }

    @Override
    public String getStandardProcedure()
    {
        return standardProcedure;
    }
    
    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(),
            isInterruptible(), getTypology().getValue(), getActivityDescription(), getWeek(), isPlanned(), isEWO(), getStandardProcedure()};
    }

    @Override
    public String isPlanned()
    {
        return this.planned;
    }

    @Override
    public String isEWO()
    {
        return this.ewo;
    }
}
