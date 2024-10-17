create table user_gallery
(
    id          bigserial primary key,
    file_key   text,
    bucket_name text,
    user_id     bigint references users (id),
    created_at  timestamp not null,
    updated_at  timestamp
);