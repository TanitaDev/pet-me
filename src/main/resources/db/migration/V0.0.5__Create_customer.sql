CREATE TABLE customer
(
    id         bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp,
    email      text      not null,
    password   text      not null,
    role       text      not null
);

INSERT INTO customer (created_at, updated_at, email, password, role)
values (now(), now(), 'tanita@mail.com', '{noop}8CjC@@aRAZeZ3j7', 'admin'),
       (now(), now(), 'narim@mail.com', '{noop}8CjC@@aRAZeZ3j7', 'user')