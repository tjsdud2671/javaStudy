show tables;

create table insa(
 idx int not null auto_increment primary key,
 name varchar(20) not null,
 age int default 20,
 gender char(2) default '여자',
 ipsail datetime default now() /*가입일*/
);

desc insa;

insert into insa alter (name) values ('홍길동');

select * from insa;