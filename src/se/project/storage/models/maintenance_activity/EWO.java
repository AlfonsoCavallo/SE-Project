package se.project.storage.models.maintenance_activity;

import java.util.Objects;


public class EWO extends UnplannedActivity
{
    private String standardProcedure;
    private String planned;
    private String ewo;
    
    /**
     * 
     * Creates a new EWO
     * @param IDActivity is the IDActivity of the EWO
     * @param activityName is the name of the EWO
     * @param timeNeeded is the time needed for the EWO
     * @param interruptible is the type of the EWO
     * @param typology is the typology of the EWO
     * @param activityDescription is the activity description of the EWO
     * @param week is the week dedicated to the EWO
     */
    public EWO(int IDActivity, String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "yes";
    }
    
    /**
     * 
     * Creates a new EWO  without considering the ID
     * @param activityName is the name of the EWO
     * @param timeNeeded is the time needed for the EWO
     * @param interruptible is the type of the EWO
     * @param typology is the typology of the EWO
     * @param activityDescription is the activity description of the EWO
     * @param week is the week dedicated to the EWO
     */
    public EWO(String activityName, int timeNeeded, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "yes";
    }

    /**
     * 
     * @return an Object array representing the data model of the maintenance activity
     */
    @Override
    public Object[] getDataModel()
    {
        return new Object[]{getIdActivity(), getActivityName(), getTimeNeeded(), 
            isInterruptible(), getTypology().getValue(), getActivityDescription(), 
            getWeek(), isPlanned(), isEWO(), getStandardProcedure()};
    }

    /**
     * 
     * @return a String corrisponding to the attribute planned
     */
    @Override
    public String isPlanned()
    {
        return this.planned;
    }

    /**
     * 
     * @return a String corrisponding to the attribute EWO
     */
    @Override
    public String isEWO()
    {
        return this.ewo;
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
        final EWO other = (EWO) obj;
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
