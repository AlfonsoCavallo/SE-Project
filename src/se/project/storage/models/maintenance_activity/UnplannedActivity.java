package se.project.storage.models.maintenance_activity;

import java.util.ArrayList;


public abstract class UnplannedActivity extends MaintenanceActivity
{

    /**
     * 
     * Creates a new UnplannedActivity
     * @param IDActivity is the IDActivity of the Unplanned Activity
     * @param activityName is the name of the Unplanned Activity
     * @param timeNeeded is the time needed for the Unplanned Activity
     * @param remainingTime is the time remained for the completition of the Activity
     * @param interruptible is the type of the Unplanned Activity
     * @param typology is the typology of the Unplanned Activity
     * @param activityDescription is the activity description of the Unplanned Activity
     * @param week is the week dedicated to the Unplanned Activity
     */
    public UnplannedActivity(int IDActivity, String activityName, int timeNeeded, int remainingTime, 
            boolean interruptible, Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
    }

    /**
     * 
     * Creates a new UnplannedActivity without considering the ID
     * @param activityName is the name of the Unplanned Activity
     * @param timeNeeded is the time needed for the Unplanned Activity
     * @param remainingTime is the time remained for the completition of the Activity
     * @param interruptible is the type of the Unplanned Activity
     * @param typology is the typology of the Unplanned Activity
     * @param activityDescription is the activity description of the Unplanned Activity
     * @param week is the week dedicated to the Unplanned Activity
     */
    public UnplannedActivity(String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
    }
    
    /**
     * 
     * Creates a new UnplannedActivity with the skills needed and the afferent site
     * @param IDActivity is the IDActivity of the Planned Activity
     * @param activityName is the name of the Planned Activity
     * @param timeNeeded is the time needed for the Planned Activity
     * @param remainingTime is the time remained for the completition of the Activity
     * @param interruptible is the type of the Planned Activity
     * @param typology is the typology of the Planned Activity
     * @param activityDescription is the activity description of the Planned Activity
     * @param week is the week dedicated to the Planned Activity
     * @param brachOffice is the brach office in which the acrivity must be done
     * @param department is the department in which the acrivity must be done
     * @param skills is an array of skills needed fot that activity
     */
    public UnplannedActivity(int IDActivity, String activityName, int timeNeeded, int remainingTime, 
            boolean interruptible, Typology typology, String activityDescription, int week, 
            String brachOffice, String department, ArrayList<String>  skills)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week, brachOffice, department,skills);
    }
}
