create table IF NOT EXISTS authUser
(
    id       int(64) auto_increment PRIMARY KEY,
    login    varchar(50) not null,
    password varchar(50) not null,
    role     varchar(50) not null
#     role     enum ('ADMIN', 'USER') default 'USER' not null
#     constraint authUser_login_unique unique (login)
);