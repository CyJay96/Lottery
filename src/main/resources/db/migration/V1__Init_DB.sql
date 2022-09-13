create sequence hibernate_sequence start 1 increment 1;

create table participant (
    id int8 not null,
    name varchar(255) not null,
    age int4 not null not null,
    city varchar(255) not null,
    primary key (id)
);

create table winner (
    id int8 not null,
    name varchar(255) not null,
    age int4 not null,
    city varchar(255) not null,
    winning_amount int4 not null,
    primary key (id)
);
