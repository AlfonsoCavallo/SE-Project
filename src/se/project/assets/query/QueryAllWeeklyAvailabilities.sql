select worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17", count(*) as competencies
from maintenance_system.workshift as w, maintenance_system.user_competence as u 
where w.worker_username = u.username_ref condition_param
group by worker_username, day_of_week, week_workshift
union
select worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17", 0 as competencies
from maintenance_system.workshift as w, maintenance_system.user_competence as u 
where w.worker_username = u.username_ref and week_workshift = week_param and w.worker_username not in
(
	select worker_username
	from maintenance_system.workshift as w, maintenance_system.user_competence as u 
	where w.worker_username = u.username_ref condition_param and week_workshift = week_param
	group by worker_username, day_of_week, week_workshift
)
group by worker_username, day_of_week, week_workshift
order by competencies desc, worker_username