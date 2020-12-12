
insert into maintenance_system.assignment(assignment_id_activity, assignment_username, assignment_day, assignment_time)
values(id_param, 'assignment_username_param', 'assignment_day_param', 'assignment_time_param');

UPDATE maintenance_system.workshift
SET turn_param = new_turn_value_param
WHERE week_workshift = week_param and worker_username = 'assignment_username_param' and day_of_week = 'assignment_day_param'; 

UPDATE maintenance_system.maintenance_activity
SET remaining_time = new_remaining_time_param
WHERE id_activity = id_param; 