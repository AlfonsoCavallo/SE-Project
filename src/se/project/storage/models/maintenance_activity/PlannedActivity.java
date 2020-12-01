package se.project.storage.models.maintenance_activity;

import java.util.Objects;


public class PlannedActivity extends MaintenanceActivity
{
    
    private String standardProcedure;
    private String planned;
    private String ewo;
    
    /**
     * 
     * Creates a new PlannedActivity
     * @param IDActivity is the IDActivity of the Planned Activity
     * @param activityName is the name of the Planned Activity
     * @param timeNeeded is the time needed for the Planned Activity
     * @param interruptible is the type of the Planned Activity
     * @param typology is the typology of the Planned Activity
     * @param activityDescription is the activity description of the Planned Activity
     * @param week is the week dedicated to the Planned Activity
     * @param standardProcedure is the standard procedure
     */
    public PlannedActivity(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week, String standardProcedure)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = standardProcedure;
        this.planned = "yes";
        this.ewo = "no";
    }
    
    /**
     * 
     * Creates a new PlannedActivity without considering the ID
     * @param activityName is the name of the Planned Activity
     * @param timeNeeded is the time needed for the Planned Activity
     * @param interruptible is the type of the Planned Activity
     * @param typology is the typology of the Planned Activity
     * @param activityDescription is the activity description of the Planned Activity
     * @param week is the week dedicated to the Planned Activity
     * @param standardProcedure is the standard procedure
     */
    public PlannedActivity(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week, String standardProcedure)
    {
        super(activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = standardProcedure;
        this.planned = "yes";
        this.ewo = "no";
    }

    /**
     * 
     * @return a String containing the standard procedure
     */
    @Override
    public String getStandardProcedure()
    {
        return standardProcedure;
    }
    
    /**
     * 
     * @return the data model of the Planned Activity
     */
    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(),
            isInterruptible(), getTypology().getValue(), getActivityDescription(), getWeek(), isPlanned(), isEWO(), getStandardProcedure()};
    }

    /**
     * 
     * @return a String corresponding to the attribute planned
     */
    @Override
    public String isPlanned()
    {
        return this.planned;
    }

    /**
     * 
     * @return a String correspoding to the attribute ewo
     */
    @Override
    public String isEWO()
    {
        return this.ewo;
    }

    /**
     * 
     * @param obj is the object to compare
     * @return true if the compared objects are equals, otherwise false
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
        final PlannedActivity other = (PlannedActivity) obj;
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
