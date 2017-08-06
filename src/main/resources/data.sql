create table if  not exists htudata (
  id int primary key,
  Name varchar(255),
  Age varchar(255),
  Message varchar(255)
);

INSERT INTO htudata(ID,Name, Age, Message) VALUES(1,'Akira', '28', '今日食べた定食は、ラーメンチャーハン餃子セット');
INSERT INTO htudata(ID,Name, Age, Message) VALUES(2,'BBB', '26', '今日食べた定食は、ステーキセット');