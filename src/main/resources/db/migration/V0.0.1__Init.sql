create table users
(
    id                    bigserial primary key,
    username              text unique not null,
    password              text        not null,
    first_name            text        not null,
    last_name             text        not null,
    email                 text unique not null,
    age                   int,
    gender                text,
    avatar                text,
    phone_number          text,
    last_online_timestamp timestamp,
    created_at            timestamp   not null,
    updated_at            timestamp
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
    user_id bigint not null references users (id),
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
    id              bigserial primary key,
    created_at      timestamp not null,
    updated_at      timestamp,
    sender_id       bigint    not null references users (id),
    receiver_id     bigint    not null references users (id),
    dating_place_id bigint    not null references dating_place (id)
);


create table chat
(
    id         bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp,
    user_id    bigint references users (id),
    chat_type  text
);


create table message
(
    id           bigserial primary key,
    created_at   timestamp not null,
    updated_at   timestamp,
    chat_id      bigint    not null references chat (id),
    sender_id    bigint    not null references users (id),
    receiver_id  bigint    not null references users (id),
    content      text,
    date_written timestamp,
    red          timestamp
)