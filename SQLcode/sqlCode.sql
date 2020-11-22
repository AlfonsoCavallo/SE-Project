-- create database gruppo8_se;

-- drop role if exists "SystemAdministrator";
-- drop role if exists "Planner";

create schema maintenance_system;

-- create System Administrator role
create role "SystemAdministrator";
grant connect on database gruppo8_se to "SystemAdministrator";
grant usage on schema maintenance_system to "SystemAdministrator";
grant select on all tables in schema maintenance_system to "SystemAdministrator";
alter default privileges in schema maintenance_system grant select on tables to "SystemAdministrator";

-- create Planner role
create role "Planner";
grant connect on database gruppo8_se to "Planner";
grant usage on schema maintenance_system to "Planner";
grant select on all tables in schema maintenance_system to "Planner";
alter default privileges in schema maintenance_system grant select on tables to "Planner";

-- create users from roles
create user finneas with password 'finneas';
grant "SystemAdministrator" to finneas;

create user jon with password 'jon';
grant "Planner" to jon;