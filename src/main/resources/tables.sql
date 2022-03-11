create table product
(
    id     serial primary key,
    name   varchar(20),
    cost   integer,
    amount integer check (cost > 0),
    id_customer integer,
    id_seller integer,
    foreign key (id_customer) references customer (id)
);
create table customer
(
    id          serial primary key,
    first_name  varchar(255),
    last_name varchar(255),
    phone varchar(255),
    email varchar(255),
    adress varchar(255)
);
create table seller
(
    id     serial primary key,
    entity varchar(255),
    phone varchar(255),
    email varchar(255),
    adress varchar(255)
);
create table review
(
    id     serial primary key,
    name    varchar(255),
    review varchar(255),
    id_product integer,
    foreign key (id_product) references product (id)
);


