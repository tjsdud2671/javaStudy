show tables;

create table hoiwon (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default '여자'
);

desc hoiwon;

insert into hoiwon values (default, '가가가', 40, '경주','남자');
insert into hoiwon values (default, '나나나', 20, '청주','여자');
insert into hoiwon values (default, '다다다', 15, '서울','남자');
insert into hoiwon values (default, '라라라', 37, '진천','여자');
insert into hoiwon values (default, '마마마', 43, '나주','남자');
insert into hoiwon values (default, '바바바', 6, '무주','여자');
insert into hoiwon values (default, '사사사', 13, '서울','남자');
insert into hoiwon values (default, '아아아', 25, '청주','여자');
insert into hoiwon values (default, '자자자', 27, '경주','남자');
insert into hoiwon values (default, '차차차', 27, '경주','여자');
insert into hoiwon values (default, '타타타', 29, '청주','남자');

select * from hoiwon;






