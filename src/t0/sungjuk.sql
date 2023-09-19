show tables;

create table sungjuk (
 idx int not null auto_increment primary key,
	name varchar(20) not null,
	kor int default 0,
	eng int default 0,
	mat int default 0
);

desc sungjuk;

insert into sungjuk values (default,'홍길동',100,90,80);

select * from sungjuk;