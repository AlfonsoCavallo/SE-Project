
drop table if exists UserAccess cascade;

create table UserAccess(
	IDAccess integer primary key,
	login varchar(30) references UserData(username),
	accessTime timestamp not null
);
