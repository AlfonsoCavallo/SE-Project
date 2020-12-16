package se.project.business_logic.controllers;


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
    Controller createController(ControllerType type);
}
