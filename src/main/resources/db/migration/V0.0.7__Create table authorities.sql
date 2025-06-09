CREATE TABLE authority
(
    id          bigserial PRIMARY KEY,
    customer_id bigint REFERENCES customer (id),
    name        text,
    created_at  timestamp NOT NULL,
    updated_at  timestamp
);


INSERT INTO authority (customer_id, name, created_at, updated_at)
SELECT id, 'ROLE_USER', now(), now()
FROM customer c
WHERE c.role = 'admin';

INSERT INTO authority (customer_id, name, created_at, updated_at)
SELECT id, 'ROLE_ADMIN', now(), now()
FROM customer c
WHERE c.role = 'admin';
