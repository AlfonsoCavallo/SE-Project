select * 
from maintenance_system.afferent join maintenance_system.maintenance_activity
on id_activity_afferent_ref = id_activity
where week = week_param and planned = 'yes';