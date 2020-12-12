package se.project.business_logic.controllers.activities_assignment;

import se.project.business_logic.controllers.AbstractController;
import se.project.presentation.views.activities_assignment.ActivityForwardingView;
import se.project.storage.models.maintenance_activity.PlannedActivity;


public class ActivityForwardingController extends AbstractController
{
    private final ActivityForwardingView activityForwardingView;
    private PlannedActivity plannedActivity = null;
    
    public ActivityForwardingController(PlannedActivity plannedActivity)
    {
        this.activityForwardingView = new ActivityForwardingView();
        this.plannedActivity = plannedActivity;
    }        
    
}
