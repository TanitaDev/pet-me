create table image
(
    id              bigserial primary key,
    image_url       text,
    dating_place_id bigint references dating_place (id),
    created_at      timestamp not null,
    updated_at      timestamp
);