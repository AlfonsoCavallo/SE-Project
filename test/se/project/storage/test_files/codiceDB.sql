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

/*==============================================================*/
/* table: user_access                                           */
/*==============================================================*/
create table maintenance_system.user_access (
   id_access             serial               not null,
   username_access_ref   varchar(30)          not null,
   access_time           timestamp          not null,
   constraint pk_access primary key (id_access)
);


/*==============================================================*/
/* table: afferent                                              */
/*==============================================================*/
create table maintenance_system.afferent (
   id_activity_afferent_ref    int                  not null,
   branch_office_ref           varchar(30)          not null,
   department_ref              varchar(30)          not null,
   constraint pk_afferent primary key (id_activity_afferent_ref, branch_office_ref, department_ref)
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
   interruptible         varchar(3)           not null,
   typology              varchar(30)          not null,
   activity_description  varchar(200)         not null,
   week                  int                  not null,
   planned               varchar(3)           not null,
   -- if ewo is 'yes', tha maintenance activity is an EWO, else if it's 'no', it's an extra activity
   ewo                   varchar(3)           null,
   standard_procedure    varchar(100)         null,
   check (planned in ('yes','no')),
   check (interruptible in ('yes','no')),
   check (typology in ('electrical','electronic', 'hydraulic', 'mechanical')),
   check ((planned='no' and standard_procedure is null and ewo is not null) or
          (planned='yes' and standard_procedure is not null and ewo is null)),
   check (ewo in ('yes','no')),
   check ((week >= 1) and (week <= 52)),
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
   username_ref          varchar(30)          not null,
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
   constraint pk_user_data primary key (username),
   constraint ak_email_user_data unique (email)
);


alter table maintenance_system.user_access
   add constraint fk_access_login_user_data foreign key (username_access_ref)
      references maintenance_system.user_data (username)
      on delete restrict on update restrict;

alter table maintenance_system.afferent
   add constraint fk_afferent_afferent_maintena foreign key (id_activity_afferent_ref)
      references maintenance_system.maintenance_activity (id_activity)
      on delete restrict on update restrict;

alter table maintenance_system.afferent
   add constraint fk_afferent_afferent2_site foreign key (branch_office_ref, department_ref)
      references maintenance_system.site (branch_office, department)
      on delete restrict on update restrict;

alter table maintenance_system.competence_needed
   add constraint fk_competen_competenc_maintena foreign key (id_activity_competence_needed_ref)
      references maintenance_system.maintenance_activity (id_activity)
      on delete restrict on update restrict;

alter table maintenance_system.competence_needed
   add constraint fk_competen_competenc_competen foreign key (competence_name_needed_ref)
      references maintenance_system.competence (competence_name)
      on delete restrict on update restrict;

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
      on delete restrict on update restrict;

alter table maintenance_system.user_competence
   add constraint fk_usercomp_usercompe_user_data foreign key (username_ref)
      references maintenance_system.user_data (username)
      on delete restrict on update restrict;

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('finneas','finneas@finneas.it','finneas','fin','neas','system_administrator');

insert into maintenance_system.user_data(username, email, pass, name_user, surname, user_role)
values('jon','jon@jon.it','jon','jon','athan','planner');

insert into maintenance_system.user_access(username_access_ref, access_time)
values('finneas', '2020-11-26 15:30:02');

insert into maintenance_system.user_access(username_access_ref, access_time)
values('jon', '2020-11-25 15:00:00');

-- select * from maintenance_system.user_data;
-- select * from maintenance_system.user_access;

-- create user test_admin with password 'test_admin';
-- grant postgres to test_admin;

/* testing maintenance_activity*/
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