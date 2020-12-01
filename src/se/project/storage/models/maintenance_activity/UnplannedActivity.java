package se.project.storage.models.maintenance_activity;


public abstract class UnplannedActivity extends MaintenanceActivity
{

    /**
     * 
     * Creates a new Unplanned Activity
     * @param IDActivity is the IDActivity of the Unplanned Activity
     * @param activityName is the name of the Unplanned Activity
     * @param timeNeeded is the time needed for the Unplanned Activity
     * @param interruptible is the type of the Unplanned Activity
     * @param typology is the typology of the Unplanned Activity
     * @param activityDescription is the activity description of the Unplanned Activity
     * @param week is the week dedicated to the Unplanned Activity
     */
    public UnplannedActivity(int IDActivity, String activityName, int timeNeeded, 
            boolean interruptible, Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
    }

    /**
     * 
     * Creates a new Unplanned Activity without considering the ID
     * @param activityName is the name of the Unplanned Activity
     * @param timeNeeded is the time needed for the Unplanned Activity
     * @param interruptible is the type of the Unplanned Activity
     * @param typology is the typology of the Unplanned Activity
     * @param activityDescription is the activity description of the Unplanned Activity
     * @param week is the week dedicated to the Unplanned Activity
     */
    public UnplannedActivity(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, interruptible, typology, activityDescription, week);
    }
    
    
}
