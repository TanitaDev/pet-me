create table user
(
    id                    bigserial primary key,
    username              text unique not null,
    password              text        not null,
    first_name            text        not null,
    last_name             text        not null,
    email                 text unique not null,
    age                   int,
    gender                text,
    avatar                bytea,
    phone_number          bigint,
    last_online_timestamp timestamp
);


create table role
(
    id         bigserial primary key,
    code       text unique not null,
    name       text        not null,
    created_at timestamp   not null,
    updated_at timestamp
);


create table user_to_role
(
    user_id bigint not null references user (id),
    role    text   not null,
    role_id bigint not null references role (id)
);


create table dating_place
(
    id          bigserial primary key,
    created_at  timestamp not null,
    updated_at  timestamp,
    name        text,
    description text
);


create table invitation
(
    id         bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp,
    sender_id  bigint    not null references user (id),
    receiver_id          not null references user (id),
    dating_place_id      not null references dating_place (id)
);


create table chat
(
    id         bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp,
    user_id    biging references user (id),
    chat_type  text,
)


create table message
(
    id           bigserial primary key,
    created_at   timestamp not null,
    updated_at   timestamp,
    chat_id      bigint    not null references chat (id),
    sender_id    bigint    not null references user (id),
    receiver_id            not null references user (id),
    content      text,
    date_written timestamp,
    red          timestamp
)