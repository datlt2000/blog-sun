create database if not exists blog;
create table if not exists user (
	id int primary key auto_increment not null,
    email varchar(50),
    pass varchar(50),
    name varchar(50),
    role varchar(50),
    signature varchar(255)
);
create table if not exists post (
	id int auto_increment primary key not null,
    title varchar(50),
    subtitle text,
    content text,
    arthur varchar(50),
    category varchar(50),
    date_post date,
    img varchar(50)
);