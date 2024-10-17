create table image
(
    id              bigserial primary key,
    file_name       text,
    bucket_name     text,
    dating_place_id bigint references dating_place (id),
    created_at      timestamp not null,
    updated_at      timestamp
);