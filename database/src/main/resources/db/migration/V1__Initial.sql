DROP table if exists developers;
DROP table if exists project;

create table developers (
                            id  bigserial not null,
                            date_of_birth timestamp,
                            first_name varchar(30),
                            last_name varchar(90),
                            project_hours int4,
                            project_id int8 not null,
                            primary key (id)
);


create table project (
                         id  bigserial not null,
                         name varchar(255),
                         primary key (id)
);


alter table developers
    add constraint project_dev_id
        foreign key (project_id)
            references project