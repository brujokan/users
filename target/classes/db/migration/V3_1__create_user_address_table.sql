CREATE SEQUENCE "user".USER_ADDRESS_SEQUENCE
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE "user".user_address (
     id int8 not null,
     user_id int8 not null,
     name varchar(500) not null,
     number int not null,
     other_data varchar(100),
     postal_code varchar(5) not null,
     province_code varchar(2) not null,
     country_code varchar(2) not null,
     primary key (id),
     CONSTRAINT user_fk FOREIGN KEY (user_id)
     REFERENCES "user".user(id)
);