-- DDL Data Definition Language

-- 데이터 type
-- char(max2000) , varchar2(4000) : 문자형
-- char, varchar2의 차이점
-- char(10) 의 경우는 10칸의 공간을 고정적으로 차지한다.
-- varchar2(10) : 최대 10의 공간을 가변적으로 차지한다. 
-- char 의 장점 : 고정적인 공간을 가지기 때문에 데이터가 자주 변경될 때 이점이 있다.
-- 하지만 빈공간도 포함하기 때문에 비교가 잘 안된다.
-- long : 2gb 가변 문자 데이터, 속도문제때문에 잘 이용되지 않는다
  
-- 한글의 종류
-- 완성형, 조합형
-- euc-kr : 한글만 가능 한글은 2byte
-- utf-8 : 전세계 모든 언어가 가능, 한글 3byte

-- blob : 바이너리 데이터 저장
-- clob : character 데이터 저장

-- 제약조건
-- not null : null 을 허용하지 않음
-- unique key : 유일성을 가져야함, null은 가능
-- primary key : null이 안되며 유일성
-- foreign key : 다른 테이블의 열을 참조
-- 제약조건의 삭제
-- alter table 테이블명 drop constraint 제약명 [cascade];
-- cascade 는 강제삭제 명령어


-- 회원(필수)    member
-- 이름            name           varchar2(32)
-- 아이디          id               varchar2(16)
-- 비밀번호       pass           varchar2(16)
-- 나이            age              number(3)
-- 이메일아이디 email            varchar2(32)
-- 이메일도메인 emaildomain   varchar2(32)
-- 가입일          joindate        date

-- 회원 상세정보 member_detail
-- 아이디       id                 varchar2(32)
-- 우편번호    zipcode         varchar2(5) -> 숫자로 잡으면 맨앞이 0인경우 다른 결과가 나온다
-- 일반번호    address         varchar2(128)
-- 상세주소    adress_detail   varchar2(128)
-- 전화번호1   tel1               varchar2(3)
-- 전화번호2   tel2               varchar2(4)
-- 전화번호3   tel3               varchar2(4)


drop table member;
drop table member_detail;

create table member
(
    name varchar2(32) not null
    , id varchar2(16)
    , pass varchar2(16) not null
    , age number(3) check( age < 150 and age > 0  )
    , email varchar2(32)
    , emaildomain varchar2(32)
    , joindate date default sysdate
    , constraint member_id_pk primary key (id)
)
;

create table member_detail
(
    id varchar2(32)
    , zipcode varchar2(5)
    , address varchar2(128)
    , adress_detail varchar2(128)
    , tel1 varchar2(3)
    , tel2 varchar2(4)
    , tel3 varchar2(4)
    , constraint member_detaill_id_fk foreign key(id) references member(id)
)
;

create table emp_all
as 
select * from employees
;
create table emp_blank
as 
select * from employees
where 1=0
;

select *


drop table emp_50
;


create table emp_50
as 
select emp.employee_id eid
    , emp.first_name name
    , emp.salary sal
    , dep.department_name dname
from employees emp, departments dep
where emp.department_id = 50
and emp.department_id = dep.department_id
;

-- DML Data 
-- insert

insert into member
values (
    '안병욱'  -- name varchar2(32) not null
    ,'calubang' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    ,32 -- age number(3) check( age < 150 and age > 0  )
    ,'acalubang' -- email varchar2(32)
    ,'gmail.com' -- emaildomain varchar2(32)
    , sysdate -- joindate date default sysdate
)
;

insert into member(
    name
    , id
    , pass
    , age
    , email
    , emaildomain
    , joindate
)
values (
    '이재운'  -- name varchar2(32) not null
    ,'leejw' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    ,32 -- age number(3) check( age < 150 and age > 0  )
    ,'acalubang' -- email varchar2(32)
    ,'gmail.com' -- emaildomain varchar2(32)
    , sysdate -- joindate date default sysdate
)
;

insert into member(
    name
    , id
    , pass
    , joindate
)
values (
    '이재운2'  -- name varchar2(32) not null
    ,'leejw2' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    , sysdate -- joindate date default sysdate
)
;

select  *
from member_detail
;

delete from member;


insert into member_detail(
    id    -- varchar2
    , zipcode -- varchar2
    , address -- varchar2
    , address_detail  -- varchar2
    , tel1 -- varchar2
    , tel2 -- varchar2
    , tel3 -- varchar2
)
values (
    '안병욱'  
    ,'12345' 
    ,'경기도' 
    ,'광명시' 
    ,'010' 
    ,'7163'
    , '3863' 
)
;



insert all
    into member(
        name
        , id
        , pass
        , age
        , email
        , emaildomain
        , joindate
    )
    values (
        '오라클'  -- name varchar2(32) not null
        ,'oracle2' -- id varchar2(16)
        ,'1234' -- pass varchar2(16) not null
        ,25 -- age number(3) check( age < 150 and age > 0  )
        ,'acalubang' -- email varchar2(32)
        ,'gmail.com' -- emaildomain varchar2(32)
        , sysdate -- joindate date default sysdate
    )
     into member_detail(
        id    -- varchar2
        , zipcode -- varchar2
        , address -- varchar2
        , address_detail  -- varchar2
        , tel1 -- varchar2
        , tel2 -- varchar2
        , tel3 -- varchar2
    )
    values (
        null  
        ,'12345' 
        ,'경기도' 
        ,'광명시' 
        ,'010' 
        ,'7163'
        , '3863' 
    )
select * from dual
;



select
    *
from 
    member mem
    , member_detail memd
where
    mem.id = memd.id
;

commit;

purge recyclebin;

select *
from tab;

select 
    *
from
    emp_blank;

-- insert
insert into emp_blank
select
    *
from
    employees emp
where
    department_id = 80
;


insert into emp_blank(
    employee_id
    , first_name
    , last_name
    , job_id
    , department_id
    , email
    , hire_date
)
select
    employee_id
    , first_name
    , last_name
    , job_id
    , department_id
    , email
    , hire_date
from
    employees
where
    employee_id = 100
;

-- update
commit;

rollback;

select
    *
from
    member
;

update member
set
    pass = '5678'
    , age = (
                select age
                from member
                where id = 'oracle'
            )
where
    id = 'oracle2'
;

-- delete
commit;

rollback;

select
    *
from member_detail
;
select
    *
from member
;

delete member_detail
where id = 'oracle'
;

delete member
where id = 'oracle'
;

-- merge
drop table product;

create table product
(
    pid number
    , pname varchar2(10)
    , cnt number
    , price number
    , constraint product_pid_pk primary key (pid)
)
;
insert all
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        100
        , '새우깡'
        , 100
        , 1500
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        200
        , '꼬북칩'
        , 80
        , 2700
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        300
        , '빼빼로'
        , 120
        , 1000
    )
select *
from dual
;

select
    *
from member_detail
;

-- 중간 on () 가 필수이다
merge into member mem
using member_detail memd
on (mem.id = memd.id
and memd.zipcode = '12345')
when matched then
update set pass = '4444'
when not matched then
insert(
    id
    , pass
    , name
)
values(
    'java'
    , '3333'
    , '자바'
)
;

select
*
from
    member
;



merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt + 150
when not matched then
insert 
    (pid, pname, cnt, price)
    values(
        400
        , '자갈치'
        , 150
        , 1200
    )
;

commit;
--------------------------------------------------------------------------------------------
select
    *
from 
    product
;

update product
set cnt = 400
where  pid = 100
;

-- transection : 작업의 단위
-- commmit : 작업을 레코드에 반영
-- rollback : 작업을 취소
-- DML 에서만 가능한 단위이다
commit;

insert all
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        101
        , '깡우새'
        , 101
        , 1501
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        102
        , '칩북꼬'
        , 82
        , 2702
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        103
        , '로빼빼'
        , 123
        , 1003
    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        104
--        , '우새깡'
--        , 124
--        , 1004
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        105
--        , '칩꼬북'
--        , 125
--        , 1005
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        106
--        , '빼로빼'
--        , 126
--        , 1006
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        107
--        , '우깡새'
--        , 127
--        , 1007
--    )
select *
from dual
;
insert all
--   into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        101
--        , '깡우새'
--        , 101
--        , 1501
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        102
--        , '칩북꼬'
--        , 82
--        , 2702
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        103
--        , '로빼빼'
--        , 123
--        , 1003
--    ) 
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        104
--        , '우새깡'
--        , 124
--        , 1004
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        105
--        , '칩꼬북'
--        , 125
--        , 1005
--    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        106
        , '빼로빼'
        , 126
        , 1006
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        107
        , '우깡새'
        , 127
        , 1007
    )
select *
from dual
;

-- 이 지점까지 transection의 포인트를 설정
savepoint b;

select *
from product;

rollback to b;

commit to b;

-- sequence 
-- 1부터시작하고 1씩 증가
-- SEQUENCE_NAME.nextval 을 통해 증가시킨다.
-- SEQUENCE_NAME.currval 을 통해 현재수치를 뽑는다.
-- 하나의 쿼리문에서 여러번 증가시킬 수 없다.
create sequence product_seq
start with 1 increment by 1;

delete product;

commit;

insert into product(
    pid
    , pname
    , cnt
    , price
)
values(
    product_seq.nextval
    , '으엉'
    , 10
    , 1000
)
;

select * from product;

select product_seq.currval, product_seq.nextval
from dual
;

commit;

