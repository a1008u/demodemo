create table if  not exists htudata (
  id int primary key,
  Name varchar(255),
  Age varchar(255),
  Message varchar(255),
  categorycode INT
);

INSERT INTO htudata(ID,Name, Age, Message, categorycode) VALUES(1,'Akira', '28', '今日食べた定食は、ラーメンチャーハン餃子セット',1);
INSERT INTO htudata(ID,Name, Age, Message, categorycode) VALUES(2,'BBB', '26', '今日食べた定食は、ステーキセット',1);


create table if  not exists category (
  code int primary key,
  name varchar(255)
);
INSERT INTO category(code, name) VALUES(1,'test');
