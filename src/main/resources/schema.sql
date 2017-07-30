create table if  not exists users (
  id int primary key,
  name varchar(255),
  age int,
  sex tinyint
);

insert into users VALUES( 1 , 'John' , 26 , 1);
insert into users VALUES( 2 , 'Bob' , 40 , 1);
insert into users VALUES( 3 , 'Michael' , 20 , 1);
insert into users VALUES( 4 , 'Mary' , 30 , 0);