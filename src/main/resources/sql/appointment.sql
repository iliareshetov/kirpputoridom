create table appointment
(
	appointment_id text not null
		constraint appointment_pk
			primary key,
	appointment_ref text not null,
	first_name text not null,
	last_name text not null,
	email text not null,
	phone_number text not null,
	number_of_weeks smallint not null,
	start_date date not null,
	amount real not null,
	create_time timestamp default LOCALTIMESTAMP not null,
	revision_time timestamp not null,
	status smallint not null,
	active_flag boolean not null
);

-- check that user name is correct
-- alter table appointment owner to uxzaupesynjrvs;

create unique index appointment_appointment_id_uindex
	on appointment (appointment_id);

