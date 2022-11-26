CREATE SEQUENCE "user".USER_SEQUENCE
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE "user".user (
    id int8 not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    second_surname varchar(255),
    email varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);