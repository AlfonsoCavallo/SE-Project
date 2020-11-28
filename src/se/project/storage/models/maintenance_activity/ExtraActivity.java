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
    
    public ExtraActivity(int IDActivity, String activityName, int timeNedeed, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNedeed, interruptible, typology, activityDescription, week);
    }

    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(), isInterruptible(), getTypology(), getActivityDescription(), getWeek()};
    }
    
}
