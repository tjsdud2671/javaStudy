select * from test1;
show tables;

--필드를 적어줌(타입) , 자동번호증가, 기본키(중복허용않겠다)
create table test1 (
  idx int not null auto_increment primary key, 
  name varchar(20) not null
);

desc test1;
select * from test1;

insert into test1 values (default, '오소정');
insert into test1 values (default, '오혁',);
insert into test1 values (default, '임선영');
insert into test1 values (default, '김한빈');
insert into test1 values (default, '밤양갱',30);
insert into test1 values (default, '고구마양갱',40,'경주','남자');
insert into test1 values (default, '녹차양갱',10,'서울','여자');
insert into test1 values (default, '가가가',5,'경주','남자');
insert into test1 values (default, '나나나',18,'광주','여자');
insert into test1 values (default, '다다',10,'완도','여자');
insert into test1 values (default, '라라',8,'전주','남자');
insert into test1 values (default, '지존',50,'창원','여자');

drop table test1;-- 테이블의 구조까지 완전히 삭제한다.(데이터를 포함, 복구 안 됨)

-- 컬럼추가 (add column)
-- test1테이블에 age컬럼을 추가 (int, default 15)
alter table test1 add column age int default 15; -- 테이블에 필드 추가 (add column)

-- test1테이블에 address컬럼을 추가(varchar(50))
alter table test1 add column addr varchar(50);

--test1테이블의 addr컬럼을 address로 변경(change / modify)하시오.  
alter table test1 change column addr address varchar(50); --column이름 바꿀 때

--test1테이블의 address컬럼의 varchar(50)을 30byte로 변경(change / modify)하시오. 
alter table test1 modify column address varchar(30); --속성 바꿀 때

--컬럼 삭제 (drop column)
alter table test1 drop column address;

--address컬럼을 추가(varchar(30) default '청주')
alter table test1 add column address varchar(30) default '청주';

--성별(gender)필드 추가(add column)
alter table test1 add column gender char(2) default '여자';

--test1 테이블을 exam 테이블로 이름변경(rename)
alter table test1 rename exam;

--exam테이블을 삭제하시오(구조를 완전삭제)
drop table exam;
drop table aaa;

--------------------------------------------------------------------------------
--DML(데이터 조작어)


desc test1;
-- test1 테이블 내용보기
select * from test1;

insert into test1 values(default, '가나다',55,'제주');

-- test1테이블의 '성명/나이' 정보의 모든 레코드를 보여주시오.
select name,age from test1;

-- 오소정의 나이를 25세로 변경(update 테이블명 set 필드명 = '변경내용' where 조건;)
update test1 set age=25 where name='오소정';
 
--오소정의 성별을 남자로 변경
update test1 set gender='여자' where name='오소정';
ㅣ

-- 오혁의 성별을 남자로 변경 ( *** where 조건을 안 주면 모든 레코드에 적용됨;;;*** 롤백해야됨)
update test1 set gender='남자' where name='오혁';

-- '임선영/가가가/녹차양갱'의 성별을 '여자'로 변경 (or)
update test1 set gender='여자' where name='임선영' or name='가가가' or name='녹차양갱';

-- '다다/라라'의 성별을 '여자'로 묶어서 한 번에 변경 (in)
update test1 set gender='여자' where name in ('다다','라라');

-- 정렬 : order by 필드명 (옵션) : 옵션생략시는 오름차순(asc), 내림차순(desc)
-- 성명 오름차순으로 출력
select * from test1 order by name;
select * from test1 order by name desc;

-- 나이 내림차순
select * from test1 order by age desc;

-- 성별 오름차순
select * from test1 order by gender;

-- 성별 오름차순 그런데, 성별이 같으면 두번째 키는 성명 내림차순 출력
select * from test1 order by gender, name desc;

-- 성별 내림차순 그런데, 같은 성별이면 나이가 적은 사람이 우선 (오름차순, 생략가능) 출력
select * from test1 order by gender desc, age;

-- 1차 성별 내림차순, 2차 주소 오름차순, 3차 나이 내림차순, 4차 idx내림차순 출력
select * from test1 order by gender desc, address, age desc, idx desc;

-- 나이가 30대만 출력하시오(30~39) : 필드명 between _ and _
select * from test1 where age>=30 and age<40;
select * from test1 where age between 30 and 39;

-- 나이가 30대이면서 남자만 출력
select * from test1 where age>=30 and age<40 and gender='남자';

-- 나이가 30대이면서 남자만 이름 내림차순 출력
select * from test1 where age>=30 and age<40 and gender='남자' order by name desc;

-- 나이가 30대 이거나 50대인 자료만 출력
select * from test1 where (age>=30 and age<40) and (age>=50 and age<60);

-- 서울에 살거나 청주에 사는 사람을 출력
select * from test1 where address='서울' or address='청주';
select * from test1 where address in ('서울','청주');

-- 서울에 살거나 청주에 사는 사람중에서 나이가 20대 이하만 출력
select * from test1 where (address='서울' or address='청주') and age<=20;
select * from test1 where address in ('서울','청주') and age<=20;

-- 서울에 살거나 나이가 20대인 여자만 출력
select * from test1 where address='서울' and (age between 20 and 29) and gender='여자';

-- '성'이 '가'씨만 출력 (like 연산자 : %(복수개의 와일드카드), _(단수개의 와일드카드))
select * from test1 where name like'가%';

-- 주소 마지막 글자가 '주'인 자료 출력
select * from test1 where address like '%주';

-- 이름 중에서 '나'자를 포함한 모든 자료 출력
select * from test1 where name like '%나%';

-- 이름 중에서 두번쨰 글자가 '나'자를 포함한 자료 출력
select * from test1 where name like '_나%'; -- 앞에 한 글자만 온다는 것임

-- 이름 중에서 두번쨰 글자가 '나'자를 포함한 자료의 '성명/주소'를 출력
select name, address from test1 where name like '_나%';

-- 자료를 10개만 출력하시오(제한 : limit)
select * from test1 limit 10;

-- 인덱스번호 4부터 5개 출력
select * from test1 limit 4,5;

-- 주소의 마지막 글자가 '주'로 끝나는 자료의 나이를 1살씩 추가해 주시오
update test1 set age=age+1 where address like'%주';

-- 서울에 사는 여자
select * from test1 where address='서울' and gender='여자';
-- 서울에 사는 여자 삭제
delete * from test1 where address='서울' and gender='여자';

--나이가 많은 사람 5명만 출력 (내림차순)
select * from test1 order by age desc limit 5;
