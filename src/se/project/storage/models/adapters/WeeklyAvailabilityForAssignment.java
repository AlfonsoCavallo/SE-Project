package se.project.storage.models.adapters;

import se.project.storage.models.interfaces.RepresentableWeeklyAvailability;


public class WeeklyAvailabilityForAssignment implements RepresentableWeeklyAvailability
{
    private RepresentableWeeklyAvailability adaptee;
    private int maxSkills;
    
    public WeeklyAvailabilityForAssignment(RepresentableWeeklyAvailability representableWeeklyAvailabiliy, int maxSkills)
    {
        this.adaptee = representableWeeklyAvailabiliy;
        this.maxSkills = maxSkills;
    }

    @Override
    public Object[] getPercentageDataModel()
    {
        Object[] dataModel = adaptee.getPercentageDataModel();
        
        dataModel[1] = dataModel[1] + "/" + maxSkills;
        for(int i = 2; i < dataModel.length; i++)
        {
            dataModel[i] = dataModel[i] + "%";
        }    
        
        return dataModel;
    }

    @Override
    public Object[] getMinutesAvailableDataModel(String day)
    {
        Object[] dataModel = adaptee.getMinutesAvailableDataModel(day);
         
        dataModel[1] = dataModel[1] + "/" + maxSkills;
        for(int i= 2; i < dataModel.length; i++)
        {
            dataModel[i] = dataModel[i] + " min";  
        }
        
        return dataModel;
    }
}
