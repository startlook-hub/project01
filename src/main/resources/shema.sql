DROP TABLE IF EXISTS person CASCADE;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 1;
CREATE TABLE device(
                       id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
                       name        VARCHAR         NOT NULL,
                       department       VARCHAR         NOT NULL,
                       brand       VARCHAR        NOT NULL,
                       address    VARCHAR         NOT NULL
);