create table dating_place_image
(
    id              bigserial primary key,
    file_key       text,
    bucket_name     text,
    dating_place_id bigint references dating_place (id),
    created_at      timestamp not null,
    updated_at      timestamp
);