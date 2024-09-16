create table user (
    id serial primary key,
    username text unique not null,
    password text not null,
    first_name text not null,
    last_name text not null,
    email text unique not null,
    age int,
    gender text,
    avatar bytea,
    phone_number int,
    last_online_timestamp timestamp
);