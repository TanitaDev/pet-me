ALTER TABLE customer
    ADD UNIQUE (email),
    ALTER COLUMN created_at SET DEFAULT now(),
    ALTER COLUMN updated_at SET DEFAULT now();
