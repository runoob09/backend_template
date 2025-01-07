drop database if exists template;
create database template;
use template;
CREATE TABLE sys_user
(
    id            INT PRIMARY KEY,
    nick_name     VARCHAR(50)  NOT NULL,
    user_account  VARCHAR(20)  NOT NULL UNIQUE,
    user_password VARCHAR(100) NOT NULL,
    user_email    VARCHAR(100) UNIQUE,
    user_avatar   VARCHAR(100),
    user_status   tinyint      not null default 0,
    created_time  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_time  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);