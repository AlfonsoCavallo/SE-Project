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
    @Override
    public abstract Object[] getPercentageDataModel();

    @Override
    public abstract Object[] getMinutesAvailableDataModel(String day);
}
