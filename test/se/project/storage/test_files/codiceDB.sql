-- create user test_admin with password 'test_admin';
-- grant postgres to test_admin;

drop table if exists maintenance_system.user_access cascade;
drop table if exists maintenance_system.afferent cascade;
drop table if exists maintenance_system.competence cascade;
drop table if exists maintenance_system.competence_needed cascade;
drop table if exists maintenance_system.maintenance_activity cascade;
drop table if exists maintenance_system.material_needed cascade;
drop table if exists maintenance_system.materials cascade;
drop table if exists maintenance_system.site cascade;
drop table if exists maintenance_system.user_competence cascade;
drop table if exists maintenance_system.user_data cascade;
drop table if exists maintenance_system.workshift cascade;
drop table if exists maintenance_system.assignment cascade;

/*==============================================================*/
/* table: assignment                                            */
/*==============================================================*/
create table maintenance_system.assignment (
   assignment_id_activity    int                  not null,
   assignment_username       varchar(30)          not null,
   assignment_day            varchar(10)          not null,
   assignment_time           varchar(10)          not null,
   constraint pk_assignment primary key (assignment_id_activity, assignment_username, assignment_day, assignment_time)
);


/*==============================================================*/
/* table: user_access                                           */
/*==============================================================*/
create table maintenance_system.user_access (
   id_access             serial               not null,
   username_access_ref   varchar(30)          not null,
   access_time           timestamp            not null,
   constraint pk_access primary key (id_access)
);


/*==============================================================*/
/* table: competence                                            */
/*==============================================================*/
create table maintenance_system.competence (
   competence_name       varchar(30)          not null,
   constraint pk_competence primary key (competence_name)
);


/*==============================================================*/
/* table: competence_needed                                      */
/*==============================================================*/
create table maintenance_system.competence_needed (
   id_activity_competence_needed_ref   int                  not null,
   competence_name_needed_ref          varchar(30)          not null,
   constraint pk_competence_needed primary key (id_activity_competence_needed_ref, competence_name_needed_ref)
);


/*==============================================================*/
/* table: maintenance_activity                                   */
/*==============================================================*/
create table maintenance_system.maintenance_activity (
   id_activity           serial               not null,
   activity_name         varchar(30)          not null,
   time_needed           int                  not null,
   remaining_time        int                  not null,
   interruptible         varchar(3)           not null,
   typology              varchar(30)          not null,
   activity_description  varchar(200)         not null,
   week                  int                  not null,
   planned               varchar(3)           not null,
   -- if ewo is 'yes', tha maintenance activity is an EWO, else if it's 'no', it's an extra activity
   ewo                   varchar(3)           null,
   standard_procedure    varchar(100)         null,
   activity_branch_office         varchar(30)          not null,
   activity_department            varchar(30)          not null,
   check (planned in ('yes','no')),
   check (interruptible in ('yes','no')),
   check (typology in ('electrical','electronic', 'hydraulic', 'mechanical')),
   check ((planned='no' and standard_procedure = '-' and ewo is not null) or
          (planned='yes' and standard_procedure is not null and ewo = 'no')),
   check (ewo in ('yes','no')),
   check ((week >= 1) and (week <= 52)),
   check (remaining_time <= time_needed),
   constraint pk_maintenance_activity primary key (id_activity),
   constraint ak_activity_name_maintena unique (activity_name)
);


/*==============================================================*/
/* table: material_needed                                        */
/*==============================================================*/
create table maintenance_system.material_needed (
   material_name_ref     varchar(30)          not null,
   id_activity_ref       int                  not null,
   constraint pk_material_needed primary key (material_name_ref, id_activity_ref)
);


/*==============================================================*/
/* table: materials                                             */
/*==============================================================*/
create table maintenance_system.materials (
   material_name         varchar(30)          not null,
   constraint pk_materials primary key (material_name)
);


/*==============================================================*/
/* table: site                                                  */
/*==============================================================*/
create table maintenance_system.site (
   branch_office         varchar(30)          not null,
   department            varchar(30)          not null,
   constraint pk_site primary key (branch_office, department)
);


/*==============================================================*/
/* table: user_competence                                        */
/*==============================================================*/
create table maintenance_system.user_competence (
   competence_name_ref      varchar(30)          not null,
   username_ref             varchar(30)          not null,
   constraint pk_user_competence primary key (competence_name_ref, username_ref)
);


/*==============================================================*/
/* table: user_data                                              */
/*==============================================================*/
create table maintenance_system.user_data (
   username             varchar(30)          not null,
   email                varchar(50)          not null,
   pass                 varchar(200)         not null,
   name_user            varchar(20)          not null,
   surname              varchar(20)          not null,
   user_role            varchar(30)          not null,
   check (user_role in ('system_administrator','planner', 'maintainer')),
   check ((username <> '') and (email <> '') and (pass <> '') and (name_user <> '') and (surname <> '')),
   constraint pk_user_data primary key (username),
   constraint ak_email_user_data unique (email)
);

/*==============================================================*/
/* table: workshift                                             */
/*==============================================================*/
create table maintenance_system.workshift (
   worker_username      varchar(30)          not null,
   day_of_week          varchar(10)          not null,
   week_workshift        int                  not null,	
   "8_9"                smallint             not null,
   "9_10"               smallint             not null,
   "10_11"              smallint             not null,
   "11_12"              smallint             not null,
   "14_15"              smallint             not null,
   "15_16"              smallint             not null,
   "16_17"              smallint             not null,
   check (day_of_week in ('Monday','Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')),
   check ((("8_9" <= 60)  and ("8_9" >= 0)) and (("9_10" <= 60) and ("9_10" >= 0 )) and (("10_11" <= 60) and ("10_11" >= 0))
		  and (("11_12" <= 60) and ("11_12" >= 0)) and (("14_15" <= 60) and ("14_15" >= 0)) and (("15_16" <= 60) and ("15_16" >= 0)) 
		  and (("16_17" <= 60) and ("16_17" >= 0))),
   check ((week_workshift >= 1) and (week_workshift <= 52)),
   constraint pk_workshift primary key (worker_username, day_of_week, week_workshift)
);

alter table maintenance_system.assignment
   add constraint fk_assignme_assignmen_userdata foreign key (assignment_username)
      references maintenance_system.user_data (username)
      on delete cascade on update cascade;

alter table maintenance_system.assignment
   add constraint fk_assignme_assignmen_maintena foreign key (assignment_id_activity)
      references maintenance_system.maintenance_activity (id_activity)
      on delete cascade on update cascade;
	  
alter table maintenance_system.user_access
   add constraint fk_access_login_user_data foreign key (username_access_ref)
      references maintenance_system.user_data (username)
      on delete cascade on update cascade;

alter table maintenance_system.competence_needed
   add constraint fk_competen_competenc_maintena foreign key (id_activity_competence_needed_ref)
      references maintenance_system.maintenance_activity (id_activity)
      on delete cascade on update cascade;

alter table maintenance_system.competence_needed
   add constraint fk_competen_competenc_competen foreign key (competence_name_needed_ref)
      references maintenance_system.competence (competence_name)
      on delete cascade on update cascade;

alter table maintenance_system.material_needed
   add constraint fk_material_materialn_material foreign key (material_name_ref)
      references maintenance_system.materials (material_name)
      on delete restrict on update restrict;

alter table maintenance_system.material_needed
   add constraint fk_material_materialn_maintena foreign key (id_activity_ref)
      references maintenance_system.maintenance_activity (id_activity)
      on delete restrict on update restrict;

alter table maintenance_system.user_competence
   add constraint fk_usercomp_usercompe_competen foreign key (competence_name_ref)
      references maintenance_system.competence (competence_name)
      on delete cascade on update cascade;

alter table maintenance_system.user_competence
   add constraint fk_usercomp_usercompe_user_data foreign key (username_ref)
      references maintenance_system.user_data (username)
      on delete cascade on update cascade;

alter table maintenance_system.workshift
   add constraint fk_workshif_work_userdata foreign key (worker_username)
      references maintenance_system.user_data (username)
      on delete cascade on update cascade;
	  
alter table maintenance_system.maintenance_activity
   add constraint fk_maintena_afferent_site foreign key (activity_branch_office, activity_department)
      references maintenance_system.site (branch_office, department)
      on delete cascade on update cascade;

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('finneas','finneas@finneas.it','finneas','fin','neas','system_administrator');

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('jon','jon@jon.it','jon','jon','athan','planner');

insert into maintenance_system.user_access(username_access_ref, access_time)
values('finneas', '2020-11-26 15:30:02');

insert into maintenance_system.user_access(username_access_ref, access_time)
values('jon', '2020-11-25 15:00:00');

grant all privileges on all tables in schema maintenance_system to finneas;
grant usage, select on sequence maintenance_system.user_access_id_access_seq to finneas;

grant all privileges on all tables in schema maintenance_system to jon;
grant usage, select on sequence maintenance_system.user_access_id_access_seq to jon;
grant usage, select on sequence maintenance_system.maintenance_activity_id_activity_seq to jon;

-- creating some maintainers
insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('gio','gruppo8se@gmail.com','gio','gio','fal','maintainer');

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('phil','phil@phil.com','phil','phil','lips','maintainer');

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('donald','don@ald.com','donald','donald','McDonald','maintainer');


-- creating all weekly workshifts
do $$
begin
for r in 1..52 loop
insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('donald', 'Monday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('donald', 'Tuesday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('donald', 'Wednesday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('donald', 'Thursday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('donald', 'Friday', r, 60, 60, 60, 60, 60, 60, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Monday', r, 0, 0, 0, 0, 0, 0, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Tuesday', r, 0, 0, 60, 10, 30, 50, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Wednesday', r, 0, 0, 0, 0, 0, 0, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Thursday', r, 0, 0, 0, 0, 0, 0, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Friday', r, 0, 0, 60, 30, 20, 50, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Saturday', r, 40, 0, 20, 40, 30, 50, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('phil', 'Sunday', r, 0, 0, 0, 0, 0, 0, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Monday', r, 15, 0, 60, 30, 30, 50, 10);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Tuesday', r, 0, 0, 60, 10, 30, 50, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Wednesday', r, 25, 0, 60, 0, 30, 50, 15);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Thursday', r, 15, 0, 60, 30, 0, 50, 15);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Friday', r, 0, 0, 60, 30, 20, 50, 0);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Saturday', r, 40, 0, 20, 40, 30, 50, 60);

insert into maintenance_system.workshift(worker_username, day_of_week, week_workshift, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
values ('gio', 'Sunday', r, 25, 0, 60, 30, 45, 0, 60);
end loop;
end;
$$;


-- creating some competences
insert into maintenance_system.competence(competence_name)
values ('PAV Certification'),
	('Electrical Maintenance'),
	('Knowledge of Cable Types'),
	('Xyz-Type Robot Knowledge'),
	('Knowledge of Workstation 23'),
	('Knowledge of Workstation 09'),
	('Knowledge of Workstation 35'),
	('Knowledge of Hydraulic Tools'),
	('English Knowledge'),
	('German Knowledge');

-- creating some sites
insert into maintenance_system.site(branch_office, department)
values ('Fisciano', 'Printing'),
       ('Fisciano', 'Molding'),
       ('Fisciano', 'Painting'),
       ('Fisciano', 'Carpentry'),
       ('Fisciano', 'Cleaning'),
       ('Nusco', 'Printing'),
       ('Nusco', 'Molding'),
       ('Nusco', 'Painting'),
       ('Nusco', 'Carpentry'),
       ('Nusco', 'Cleaning'),
       ('Lauria', 'Printing'),
       ('Lauria', 'Molding'),
       ('Lauria', 'Painting'),
       ('Lauria', 'Carpentry'),
       ('Lauria', 'Cleaning'),
       ('Morra', 'Printing'),
       ('Morra', 'Molding'),
       ('Morra', 'Painting'),
       ('Morra', 'Carpentry'),
       ('Morra', 'Cleaning'),
       ('Montella', 'Printing'),
       ('Montella', 'Molding'),
       ('Torrione', 'Painting'),
       ('Montella', 'Carpentry'),
       ('Torrione', 'Cleaning'),
       ('Montella', 'Cleaning'),
       ('Montella', 'Painting'),
       ('Montecorvino Rovella', 'Printing'),
       ('Montecorvino Rovella', 'Molding'),
       ('Montecorvino Rovella', 'Cleaning'),
       ('Montecorvino Rovella', 'Painting'),
       ('Montecorvino Rovella', 'Carpentry');

-- assigning competences to the maintainers
insert into maintenance_system.user_competence (competence_name_ref, username_ref)
values ('Knowledge of Cable Types', 'gio'),
       ('Xyz-Type Robot Knowledge', 'gio'),
       ('English Knowledge', 'gio'),
       ('German Knowledge', 'gio'),
       ('German Knowledge', 'phil'),
       ('PAV Certification', 'phil'),
       ('Electrical Maintenance', 'phil'),
       ('Electrical Maintenance', 'donald'),
       ('Knowledge of Workstation 09', 'donald'),
       ('Knowledge of Workstation 35', 'donald');


insert into maintenance_system.maintenance_activity(activity_name, time_needed, remaining_time, interruptible, typology, activity_description, week, planned, ewo, activity_branch_office, activity_department, standard_procedure)
values('activity1', 45, 45, 'yes', 'electrical', 'riparazione turbina 3', 2, 'yes', null, 'Fisciano', 'Printing', '1... 2... 3...');

insert into maintenance_system.maintenance_activity(activity_name, time_needed, remaining_time, interruptible, typology, activity_description, week, planned, ewo, activity_branch_office, activity_department, standard_procedure)
values('activity2', 30, 30, 'yes', 'hydraulic', 'riparazione turbina 5', 3, 'yes', null, 'Lauria', 'Molding', '4... 5... 6...');


insert into maintenance_system.competence_needed (id_activity_competence_needed_ref, competence_name_needed_ref)
values (1, 'Electrical Maintenance'),
       (1, 'Knowledge of Workstation 23'),
       (1, 'Knowledge of Workstation 35'),
       (1, 'English Knowledge'),
       (2, 'Electrical Maintenance'),
       (2, 'Knowledge of Workstation 09'),
       (2, 'Knowledge of Workstation 35'),
       (2, 'English Knowledge');
	
insert into maintenance_system.assignment (assignment_id_activity, assignment_username, assignment_day, assignment_time)
values (2, 'phil', 'Friday', '11_12');

-- select * from maintenance_system.user_data;
-- select * from maintenance_system.user_access;
-- select * from maintenance_system.workshift;
-- select * from maintenance_system.site;
-- select * from maintenance_system.competence;
-- select * from maintenance_system.user_competence;
-- select * from maintenance_system.afferent;
-- select * from maintenance_system.competence_needed;
-- select * from maintenance_system.workshift;
-- select * from maintenance_system.maintenance_activity;

/* testing maintenance_activity */

-- the following three queries don't generate errors
--insert into maintenance_system.maintenance_activity(activity_name, time_needed, interruptible, typology, activity_description, week, planned, ewo, standard_procedure)
--values ('attività', 45, 'yes', 'electrical', 'riparazione turbina 3', 2, 'yes', null, '1... 2... 3...');

--insert into maintenance_system.maintenance_activity(activity_name, time_needed, interruptible, typology, activity_description, week, planned, ewo, standard_procedure)
--values ('attività3', 45, 'yes', 'hydraulic', 'riparazione turbina 1', 2, 'no', 'no', null);

--insert into maintenance_system.maintenance_activity(activity_name, time_needed, interruptible, typology, activity_description, week, planned, ewo, standard_procedure)
--values ('attività4', 45, 'yes', 'hydraulic', 'riparazione turbina 1', 2, 'no', 'yes', null);


-- the following two queries generate errors
--insert into maintenance_system.maintenance_activity(activity_name, time_needed, interruptible, typology, activity_description, week, planned, ewo, standard_procedure)
--values ('attività5', 45, 'yes', 'hydraulic', 'riparazione turbina 1', 2, 'no', 'yes', '1.. 2... 3...');

--insert into maintenance_system.maintenance_activity(activity_name, time_needed, interruptible, typology, activity_description, week, planned, ewo, standard_procedure)
--values ('attività2', 45, 'yes', 'electrical', 'riparazione turbina 2', 2, 'yes', 'yes', '1... 2... 3...');


/* testing workshift */

-- raise an error because the primary key already exists
--insert into maintenance_system.workshift(worker_username, day_of_week, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
--values ('gio', 'Sunday', 25, 0, 60, 30, 45, 0, 60);

-- raise an error because the value March is not acceptable
--insert into maintenance_system.workshift(worker_username, day_of_week, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
--values ('gio', 'March', 25, 0, 60, 30, 45, 0, 60);

-- raise an error because the value 75 is not acceptable
--insert into maintenance_system.workshift(worker_username, day_of_week, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
--values ('gio', 'Saturday', 25, 0, 60, 30, 75, 0, 60);

-- raise an error because the value -10 is not acceptable
--insert into maintenance_system.workshift(worker_username, day_of_week, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
--values ('gio', 'Saturday', 25, 0, 60, 30, -10, 0, 60);

-- raise an error because the foreign key Luca doesn't exists
--insert into maintenance_system.workshift(worker_username, day_of_week, "8_9", "9_10", "10_11", "11_12", "14_15", "15_16", "16_17")
--values ('Luca', 'Saturday', 25, 0, 60, 30, 10, 0, 60);