package se.project.storage.models.decorators;

import se.project.storage.models.decorators.abstracts.AbstractWeeklyAvailabilityForAssignment;
import se.project.storage.models.interfaces.RepresentableWeeklyAvailability;

/**
 * A decorator for post-processing of WeeklyAvailability data model.
 * 
 */
public class WeeklyAvailabilityForAssignment extends AbstractWeeklyAvailabilityForAssignment
{
    private final int maxSkills;
    
    /**
    * Instantiate the a adapter.
    * @param representableWeeklyAvailabiliy is the model to adapt.
    * @param maxSkills is the number of skills required for the activity.
    */
    public WeeklyAvailabilityForAssignment(RepresentableWeeklyAvailability representableWeeklyAvailabiliy, int maxSkills)
    {
        super(representableWeeklyAvailabiliy);
        this.maxSkills = maxSkills;
    }

    @Override
    public Object[] getPercentageDataModel()
    {
        Object[] dataModel = component.getPercentageDataModel();
        
        if(maxSkills > 0)
        {
            dataModel[1] = dataModel[1] + "/" + maxSkills;
        }
        else
        {
            dataModel[1] = "N.S.R.";
        }
        for(int i = 2; i < dataModel.length; i++)
        {
            dataModel[i] = dataModel[i] + "%";
        }    
        
        return dataModel;
    }

    @Override
    public Object[] getMinutesAvailableDataModel(String day)
    {
        Object[] dataModel = component.getMinutesAvailableDataModel(day);
        
        if(maxSkills > 0)
        {
            dataModel[1] = dataModel[1] + "/" + maxSkills;
        }
        else
        {
            dataModel[1] = "N.S.R.";
        }
        for(int i= 2; i < dataModel.length; i++)
        {
            dataModel[i] = dataModel[i] + " min";  
        }
        
        return dataModel;
    }
}
