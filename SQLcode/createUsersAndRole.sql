-- create database gruppo8_se;

-- drop role if exists system_administrator;
-- drop role if exists planner;
-- drop schema if exists maintence_system;

create schema maintenance_system;

-- creating System Administrator role
create role system_administrator;
grant connect on database gruppo8_se to system_administrator;
grant usage on schema maintenance_system to system_administrator;
grant select on all tables in schema maintenance_system to system_administrator;
alter default privileges in schema maintenance_system grant select on tables to system_administrator;

-- creating Planner role
create role planner;
grant connect on database gruppo8_se to planner;
grant usage on schema maintenance_system to planner;
grant select on all tables in schema maintenance_system to planner;
alter default privileges in schema maintenance_system grant select on tables to planner;

-- create users from roles
create user finneas with password 'finneas';
grant system_administrator to finneas;

create user jon with password 'jon';
grant planner to jon;