CREATE SEQUENCE "user".USER_PAYMENT_SEQUENCE
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE "user".user_payment (
     id int8 not null,
     user_id int8 not null,
     name varchar(255) not null,
     credit_number int8 not null,
     expiration_month varchar(2) not null,
     expiration_year varchar(4) not null,
     cvv varchar(3) not null,
     primary key (id),
     CONSTRAINT user_fk FOREIGN KEY (user_id)
     REFERENCES "user".user(id)
);