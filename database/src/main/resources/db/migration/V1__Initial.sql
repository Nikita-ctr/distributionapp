DROP table if exists public.developers;
DROP table if exists public.project;

create table public.project (
                         id  bigint not null generated always as identity (increment 1 start 1 minvalue 1),
                         name varchar(255) not null ,
                         constraint project_pkey primary key (id)
);

create table public.developers (
                            id  bigint not null generated always as identity (increment 1 start 1 minvalue 1),
                            date_of_birth date not null ,
                            first_name varchar(30) not null,
                            last_name varchar(90) not null,
                            project_hours integer,
                            project_id integer not null,
                            constraint developer_pkey primary key (id),
                            constraint project_id_fk foreign key (project_id)
                        references project (id) MATCH SIMPLE
);

