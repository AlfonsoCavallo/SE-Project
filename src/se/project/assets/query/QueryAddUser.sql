insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('username_param','email_param','password_param','name_param','surname_param','role_param');

do $$
begin
if 'role_param' = 'maintainer'
then

insert into maintenance_system.user_competence(competence_name_ref, username_ref) values ('English Knowledge', 'username_param');

for r in 1..52 loop
insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('username_param', 'Monday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('username_param', 'Tuesday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('username_param', 'Wednesday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('username_param', 'Thursday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('username_param', 'Friday', r, 60, 60, 60, 60, 60, 60, 60);

end loop;

end if;

end;
$$;