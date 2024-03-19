create table "User"
(
    id       bigserial    not null
        constraint "User_pk"
            primary key,
    username varchar(225) not null,
    email    varchar(255) not null,
    "create" timestamp
);

create table security
(
    id       bigserial   not null
        constraint security_pk
            primary key,
    login    varchar(50) not null,
    password varchar(50) not null,
    user_id  integer     not null
        constraint security_user_id_fk
            references "User"
            on update cascade on delete cascade
);

create table role
(
    id          bigserial   not null
        constraint role_pk
            primary key,
    role_name   varchar(50) not null,
    security_id integer     not null
        constraint role_security_id_fk
            references security
            on update cascade on delete cascade
);