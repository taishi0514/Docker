create table user_info(
    user_id int auto_increment primary key, 
    book_name varchar(100) not null, 
    contents varchar(255) not null, 
    created_at varchar(25) not null, 
    updated_at varchar(25)
) engine = InnoDB;

create table book_info(
    book_id int auto_increment primary key,
    book_name varchar(100) not null,
    contents varchar(255) not null,
    registered_at varchar(25) not null,
    updated_time varchar(25),
    user_id int not null
) engine = InnoDB;