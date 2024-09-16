create table role (
    id serial primary key,
    created_at timestamp not null default now(),
    updated_at timestamp,
    name text
);