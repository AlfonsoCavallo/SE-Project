package se.project.storage.models.maintenance_activity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A model providing informations about an Extra activity.
 * 
 */
public class ExtraActivity extends UnplannedActivity
{
    private String standardProcedure;
    private String planned;
    private String ewo;
    
    /**
     * 
     * Creates a new ExtraActivity.
     * @param IDActivity is the ID of the Maintenance Activity.
     * @param activityName is the name of the Maintenance Activity.
     * @param timeNeeded is the time needed for the Maintenance Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise.
     * @param typology is the typology of the Maintenance Activity.
     * @param activityDescription is the description of the Maintenance Activity.
     * @param week is the week in which the Maintenance Activity must be done.
     */
    public ExtraActivity(int IDActivity, String activityName, int timeNeeded,int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "no";
    }
    
    /**
     * 
     * Creates a new ExtraActivity without considering the ID.
     * @param activityName is the name of the Maintenance Activity.
     * @param timeNeeded is the time needed for the Maintenance Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is true if the Maintenance Activity is interruprible, false otherwise.
     * @param typology is the typology of the Maintenance Activity.
     * @param activityDescription is the description of the Maintenance Activity.
     * @param week is the week in which the Maintenance Activity must be done.
     */
    public ExtraActivity(String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "no";
    }

    /**
     * 
     * Creates a new ExtraActivity with with the skills needed and the afferent site.
     * @param IDActivity is the IDActivity of the Planned Activity.
     * @param activityName is the name of the Planned Activity.
     * @param timeNeeded is the time needed for the Planned Activity.
     * @param remainingTime is the time remained for the completition of the Activity.
     * @param interruptible is the type of the Planned Activity.
     * @param typology is the typology of the Planned Activity.
     * @param activityDescription is the activity description of the Planned Activity.
     * @param week is the week dedicated to the Planned Activity.
     * @param brachOffice is the brach office in which the acrivity must be done.
     * @param department is the department in which the acrivity must be done.
     * @param skills is an array of skills needed fot that activity.
     */
    public ExtraActivity(int IDActivity, String activityName, int timeNeeded, int remainingTime, 
            boolean interruptible, Typology typology, String activityDescription, int week, 
            String brachOffice, String department, ArrayList<String> skills)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week, brachOffice, department,skills);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "no";
    }
    
    /**
    * 
    * @return a String corresponding to the attribute planned.
    */
    @Override
    public String isPlanned()
    {
        return this.planned;
    }

    /**
    * 
    * @return a String corresponding to the attribute ewo.
    */
    @Override
    public String isEWO()
    {
        return this.ewo;
    }

    /**
    * 
    * @return a String representing the standard procedure of the maintenance activity.
    */
    @Override
    public String getStandardProcedure()
    {
        return standardProcedure;
    }
    
    /**
     * 
     * @param obj is the object to compare.
     * @return true if the compared objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final ExtraActivity other = (ExtraActivity) obj;
        if (!Objects.equals(this.standardProcedure, other.standardProcedure))
        {
            return false;
        }
        if (!Objects.equals(this.planned, other.planned))
        {
            return false;
        }
        if (!Objects.equals(this.ewo, other.ewo))
        {
            return false;
        }
        if (!super.equals((MaintenanceActivity)obj))
        {
            return false;
        }
        return true;
    }
    
}
