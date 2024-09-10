-- add columns to tables
ALTER TABLE states
    ADD COLUMN code VARCHAR(2) NOT NULL,
    ADD COLUMN population BIGINT NOT NULL;

ALTER TABLE cities
    ADD COLUMN population BIGINT NOT NULL;
