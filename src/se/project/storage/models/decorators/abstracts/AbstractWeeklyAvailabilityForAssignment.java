/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.storage.models.decorators.abstracts;

import se.project.storage.models.interfaces.RepresentableWeeklyAvailability;

/**
 * A decorator for post-processing of WeeklyAvailability data model.
 * 
 */
public abstract class AbstractWeeklyAvailabilityForAssignment implements RepresentableWeeklyAvailability
{
    
    private final RepresentableWeeklyAvailability component;
    
    /**
    * Instantiate the a adapter.
    * @param component is the model to adapt.
    */
    public AbstractWeeklyAvailabilityForAssignment(RepresentableWeeklyAvailability component)
    {
        this.component = component;
    }
    
    @Override
    public Object[] getPercentageDataModel()
    {
        return component.getPercentageDataModel();
    }

    @Override
    public Object[] getMinutesAvailableDataModel(String day)
    {
        return component.getMinutesAvailableDataModel(day);
    }
}
