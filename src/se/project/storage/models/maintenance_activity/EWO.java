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
public class EWO extends UnplannedActivity
{
    
    public EWO(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
    }

    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(), isInterruptible(), getTypology(), getActivityDescription(), getWeek()};
    }
    
}
