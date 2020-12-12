update maintenance_system.maintenance_activity
set activity_name = 'activity_name_param', time_needed = time_needed_param, interruptible = 'interruptible_param', 
    typology = 'typology_param', activity_description = 'activity_description_param', week = week_param, 
    planned = 'planned_param', ewo = 'ewo_param', activity_branch_office = 'office_param', activity_department = 'department_param',
    standard_procedure = 'standard_param'
where activity_name = 'activity_param';