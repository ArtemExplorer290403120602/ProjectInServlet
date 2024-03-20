create table userhistory
(
    id               bigserial
        constraint userhistory_pk
            primary key,
    username         varchar(50) not null,
    email            varchar     not null,
    action_type      varchar(50) not null,
    action_timestamp timestamp   not null
);