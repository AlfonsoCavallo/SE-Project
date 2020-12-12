
select *
from maintenance_system.maintenance_activity
where week = week_param and planned = 'yes' and remaining_time > 0