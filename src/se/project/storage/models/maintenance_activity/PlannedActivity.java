/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage.models.maintenance_activity;

import se.project.storage.models.maintenance_activity.MaintenanceActivity;

/**
 *
 * @author delso
 */
public class PlannedActivity extends MaintenanceActivity
{
    
    private String standardProcedure;
    
    public PlannedActivity(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week, String standardProcedure)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = standardProcedure;
    }

    public String getStandardProcedure()
    {
        return standardProcedure;
    }
    
    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(),
            isInterruptible(), getTypology().getValue(), getActivityDescription(), getWeek(), "yes", "no", getStandardProcedure()};
    }
    
}
