package se.project.storage.models.interfaces;

/**
 * A model to represent informations about a Weekly Availability.
 */
public interface RepresentableWeeklyAvailability
{
    /***
     * Get the data model in percentages of availability.
     * @return an array of percentages capable of being configured on a JTable.
     */    
    Object[] getPercentageDataModel();
    
    /***
     * Get the data model in pminutes of availability.
     * @param day is the day to check the minutes available.
     * @return an array of percentages capable of being configured on a JTable.
     */    
    Object[] getMinutesAvailableDataModel(String day);
}
