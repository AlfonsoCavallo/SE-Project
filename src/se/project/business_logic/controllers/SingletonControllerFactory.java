/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.project.business_logic.controllers;

import se.project.business_logic.controllers.activities_assignment.ActivityAssignmentController;
import se.project.business_logic.controllers.activities_assignment.ActivityForwardingController;
import se.project.business_logic.controllers.activities_assignment.MaintenanceActivityInfoController;
import se.project.business_logic.controllers.activities_assignment.SelectMaintenanceActivityController;
import se.project.business_logic.controllers.activities_management.AddMaintenanceActivityController;
import se.project.business_logic.controllers.activities_management.MaintenanceActivityController;
import se.project.business_logic.controllers.activities_management.UpdateMaintenanceActivityController;
import se.project.business_logic.controllers.activities_management.ViewMaintenanceActivityController;
import se.project.business_logic.controllers.user_management.AddUserController;
import se.project.business_logic.controllers.user_management.UpdateUserController;
import se.project.business_logic.controllers.user_management.UserInfoController;
import se.project.business_logic.controllers.user_management.ViewUsersController;

/**
 * Is a singleton for a Controller Factory.
 * 
 */
public class SingletonControllerFactory implements ControllerFactory
{
    private static  SingletonControllerFactory instance = null;

    /**
     * Creates a singleton instance of a controller factory.
     */
    private SingletonControllerFactory()
    {
    }
    
    /**
     * 
     * @return the common Controller factory. 
     */
    public static SingletonControllerFactory getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonControllerFactory();
        }
        return instance;
    }
    
    @Override
    public Controller createController(ControllerType type)
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
