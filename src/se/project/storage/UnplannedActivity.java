/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.storage;

/**
 *
 * @author delso
 */
public abstract class UnplannedActivity extends MaintenanceActivity
{
    
    public UnplannedActivity(int IDActivity, String activityName, int timeNedeed, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNedeed, interruptible, typology, activityDescription, week);
    }
    
}
