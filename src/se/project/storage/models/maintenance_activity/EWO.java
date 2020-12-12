package se.project.storage.models.maintenance_activity;

import java.util.ArrayList;
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
     * @param remainingTime is the time remained for the completition of the Activity
     * @param interruptible is the type of the EWO
     * @param typology is the typology of the EWO
     * @param activityDescription is the activity description of the EWO
     * @param week is the week dedicated to the EWO
     */
    public EWO(int IDActivity, String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "yes";
    }
    
    /**
     * 
     * Creates a new EWO  without considering the ID
     * @param activityName is the name of the EWO
     * @param timeNeeded is the time needed for the EWO
     * @param remainingTime is the time remained for the completition of the Activity
     * @param interruptible is the type of the EWO
     * @param typology is the typology of the EWO
     * @param activityDescription is the activity description of the EWO
     * @param week is the week dedicated to the EWO
     */
    public EWO(String activityName, int timeNeeded, int remainingTime, boolean interruptible, 
            Typology typology, String activityDescription, int week)
    {
        super(activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week);
        this.standardProcedure = "-";
        this.planned = "no";
        this.ewo = "yes";
    }

    /**
     * 
     * Creates a new EWO with with the skills needed and the afferent site
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
    public EWO(int IDActivity, String activityName, int timeNeeded, int remainingTime,
            boolean interruptible, Typology typology, String activityDescription, int week, 
            String brachOffice, String department, ArrayList<String> skills)
    {
        super(IDActivity, activityName, timeNeeded, remainingTime, interruptible, typology, activityDescription, week, brachOffice, department, skills);
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
        return super.getDataModel();
    }

    /**
    * 
    * @return an Object array representing the data model of the maintenance activity
    * with util info for the assignment (must be implemented in the sub-classes) 
    */
    @Override
    public Object[] getDataForAssignment()
    {
        return new Object[]{getIdActivity(), getBrachOffice() + " " + getDepartment(), getTypology().getValue(), getTimeNeeded()};
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
     * @return a String corresponding to the attribute EWO
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
