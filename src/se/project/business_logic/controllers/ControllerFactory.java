package se.project.business_logic.controllers;

import se.project.business_logic.controllers.activities_management.*;
import se.project.business_logic.controllers.activities_assignment.*;
import se.project.business_logic.controllers.user_management.*;


/**
 * A factory object capable of creating a selected controller.
 */
public interface ControllerFactory
{
    /***
     * enumerate all the controller types.
     */
    enum ControllerType
    {
        // Main pages
        LOGIN,
        PLANNER_HOMEPAGE,
        SAHOMEPAGE,
        // Accesses
        USER_ACCESSES,
        // Maintenance Activity CRUD
        ADD_MAINTENANCE_ACTIVITY,
        MAINTENANCE_ACTIVITY,
        UPDATE_MAINTENANCE_ACTIVITY,
        VIEW_MAINTENANCE_ACTIVITY,
        // User CRUD
        ADD_USER,
        UPDATE_USER,
        USER_INFO,
        VIEW_USERS,
        // Activity planning
        ACTIVITY_ASSIGNMENT,
        ACTIVITY_FORWARDING,
        MAINTENANCE_ACTIVITY_INFO,
        SELECT_MAINTENANCE_ACTIVITY            
    }
    
    /***
     * Creates an instance of the specified type of controller.
     * @param type is the type of controller to return
     * @return the selected controller
     */
    static Controller createController(ControllerType type)
    {
        switch(type)
        {
            case LOGIN:
                return new LoginController();
            case PLANNER_HOMEPAGE:
                return new PlannerHomepageController();
            case SAHOMEPAGE:
                return new SAHomepageController();
            case USER_ACCESSES:
                return new UserAccessesController();
            case ADD_MAINTENANCE_ACTIVITY:
                return new AddMaintenanceActivityController();
            case MAINTENANCE_ACTIVITY:
                return new MaintenanceActivityController();
            case UPDATE_MAINTENANCE_ACTIVITY:
                return new UpdateMaintenanceActivityController();
            case VIEW_MAINTENANCE_ACTIVITY:
                return new ViewMaintenanceActivityController();
            case ADD_USER:
                return new AddUserController();
            case UPDATE_USER:
                return new UpdateUserController();
            case USER_INFO:
                return new UserInfoController();
            case VIEW_USERS:
                return new ViewUsersController();
            case ACTIVITY_ASSIGNMENT:
                return new ActivityAssignmentController();
            case ACTIVITY_FORWARDING:
                return new ActivityForwardingController();
            case MAINTENANCE_ACTIVITY_INFO:
                return new MaintenanceActivityInfoController();
            case SELECT_MAINTENANCE_ACTIVITY:
                return new SelectMaintenanceActivityController();
            default:
                return null;
        }
    }            
}
