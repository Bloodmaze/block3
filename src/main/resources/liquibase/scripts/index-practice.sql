-- liquibase formatted sql

-- changeset pavelkrivokorytov:1

CREATE INDEX student_name_index ON student (name);

-- changeset pavelkrivokorytov:2

CREATE INDEX faculty_nc_index ON faculty (name, color);