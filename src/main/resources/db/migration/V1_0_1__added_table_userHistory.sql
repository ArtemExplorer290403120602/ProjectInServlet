create table UserHistory
(
    id               bigserial
        constraint UserHistory_pk
            primary key,
    username         varchar(50) not null,
    email            varchar     not null,
    action_type      varchar(50) not null,
    action_timestamp timestamp   not null
);