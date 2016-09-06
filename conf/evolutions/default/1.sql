# Users schema

# --- !Ups

CREATE TABLE Team (
    id serial NOT NULL,
    name varchar(50) NOT NULL,
    about text NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Team;
