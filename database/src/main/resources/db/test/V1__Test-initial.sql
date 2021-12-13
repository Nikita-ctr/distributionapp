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
            references project;

    insert into project (id,name) values (1,'DevTools');

insert into developers (id,first_name,last_name,date_of_birth,project_hours,project_id) values (1,'Vlad','Vladov','2004-10-19','60',1);

insert into project (id,name) values (2,'DevTools2');

insert into developers (id,first_name,last_name,date_of_birth,project_hours,project_id) values (2,'Dima','Dimov','2004-10-19','60',2);
