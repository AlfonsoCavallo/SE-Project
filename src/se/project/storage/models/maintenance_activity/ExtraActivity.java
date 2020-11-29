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
public class ExtraActivity extends UnplannedActivity
{
    private String standardProcedure;
    private String planned;
    private String ewo;
    
    public ExtraActivity(int IDActivity, String activityName, int timeNedeed, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNedeed, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "no";
    }
    
    public ExtraActivity(String activityName, int timeNedeed, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNedeed, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "no";
    }

    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(),
            isInterruptible(), getTypology().getValue(), getActivityDescription(), 
            getWeek(), isPlanned(), isEWO(), getStandardProcedure()};
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

    @Override
    public String getStandardProcedure()
    {
        return standardProcedure;
    }
    
}
