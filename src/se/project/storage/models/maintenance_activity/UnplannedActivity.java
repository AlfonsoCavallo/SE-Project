package se.project.storage.models.maintenance_activity;


public abstract class UnplannedActivity extends MaintenanceActivity
{

    public UnplannedActivity(int IDActivity, String activityName, int timeNeeded, 
            boolean interruptible, Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
    }

    public UnplannedActivity(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, interruptible, typology, activityDescription, week);
    }
    
    
}
