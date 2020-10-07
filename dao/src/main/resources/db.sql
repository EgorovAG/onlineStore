#drop database onlineStore;
#drop database onlineStoreTest;
#create database onlineStoreTest;
#create database onlineStore;

create table IF NOT EXISTS user
(
    id        bigint auto_increment PRIMARY KEY,
    firstName varchar(50) not null,
    lastName  varchar(50) not null,
    email     varchar(100),
    phone     varchar(50)
);

# insert into user (firstName, secondName, email, phone, user_id)
# VALUES ('User', 'User', 'user@google.com', '55555', 2);
# ----------------------------------------


create table IF NOT EXISTS authUser
(
    id       bigint auto_increment PRIMARY KEY,
    login    varchar(50) not null,
    password varchar(50) not null,
    role     varchar(50) not null,
    user_id  bigint      not null,
    constraint authUser_user_id_FK foreign key (user_id) references user (id)
#     role     enum ('ADMIN', 'USER') default 'USER' not null
#     constraint authUser_login_unique unique (login)
);

# insert into authUser (login, password, role)
# VALUES ('admin', 'admin', 'ADMIN');
#        ('user', 'user', 'USER');
# ----------------------------------------


create table IF NOT EXISTS product
(
    id          bigint auto_increment PRIMARY KEY,
    name        varchar(150) not null,
    description varchar(150) not null,
    price       int          not null,
    quantity    int          not null
);

# ----------------------------------------


create table IF NOT EXISTS orderOfGoods
(
    id              bigint auto_increment PRIMARY KEY,
    user_id         bigint       not null,
    product_id      bigint       not null,
    dateOrder       DATE         not null,
    priceOrder      int          not null,
    quantityOrder   int          not null,
    orderStatus     int,
    deliveryAddress varchar(250) not null,
    deliveryDate    DATE         not null
);

# ----------------------------------------